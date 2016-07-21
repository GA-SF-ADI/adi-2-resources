package drewmahrt.generalassemb.ly.investingportfolio;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static final Uri CONTENT_URI = MyContentProvider.CONTENT_URI;

    ListView mPortfolioListView;
    CursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPortfolioListView = (ListView)findViewById(R.id.portfolio_list);

        Cursor cursor = getContentResolver().query(CONTENT_URI,null,null,null,null);
        //mCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,new String[]{"stockname","quantity"},new int[]{android.R.id.text1,android.R.id.text2},0);
        mCursorAdapter = new CursorAdapter(this,cursor,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);


                String name = cursor.getString(cursor.getColumnIndex("stockname"));
                String symbol = cursor.getString(cursor.getColumnIndex("symbol"));
                String quantity = cursor.getString(cursor.getColumnIndex("quantity"));


                text1.setText(name+" ("+symbol+")");
                text2.setText("Quantity of stocks: "+quantity);
            }
        };

        mPortfolioListView.setAdapter(mCursorAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialog();
            }
        });
    }

    public void retrieveStock(final String symbol, final String quantity){

        RequestQueue queue = Volley.newRequestQueue(this);
        String stockUrl = "http://dev.markitondemand.com/MODApis/Api/v2/Quote/json?symbol="+symbol;

        JsonObjectRequest stockJsonRequest = new JsonObjectRequest
                (Request.Method.GET, stockUrl, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(MainActivity.class.getName(),"Response: "+response.toString());
                        try {
                            if(response.has("Status") && response.getString("Status").equals("SUCCESS")) {
                                retrieveExchange(symbol,quantity,response.getString("Name"));
                            }else{
                                Toast.makeText(MainActivity.this,"The stock you entered is invalid",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d(MainActivity.class.getName(),error.toString());
                    }
                });

        queue.add(stockJsonRequest);

    }

    public void retrieveExchange(final String symbol, final String quantity, final String name){

        RequestQueue queue = Volley.newRequestQueue(this);
        String exchangeUrl = "http://dev.markitondemand.com/MODApis/Api/v2/Lookup/json?input="+symbol;

        Log.d(MainActivity.class.getName(),"Starting exchange request: "+exchangeUrl);
        JsonArrayRequest exchangeJsonRequest = new JsonArrayRequest
                (exchangeUrl, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(MainActivity.class.getName(),"Response2: "+response.toString());
                        try {
                            ContentResolver contentResolver = getContentResolver();
                            String exchange = ((JSONObject)response.get(0)).getString("Exchange");
                            ContentValues values = new ContentValues();
                            values.put("symbol",symbol);
                            values.put("quantity",quantity);
                            values.put("stockname",name);
                            values.put("exchange", exchange);
                            contentResolver.insert(CONTENT_URI, values);
                            Cursor cursor = contentResolver.query(CONTENT_URI,null,null,null,null);
                            mCursorAdapter.swapCursor(cursor);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(MainActivity.class.getName(),"Error occurred");

                    }
                });

        queue.add(exchangeJsonRequest);

    }

    private void createDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.add_stock_dialog, null))
                // Add action buttons
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Boolean isValid = true;
                        EditText symbolText = (EditText)((AlertDialog)dialog).findViewById(R.id.stock_symbol_edittext);
                        EditText quantityText = (EditText)((AlertDialog)dialog).findViewById(R.id.quantity_edittext);
                        if(symbolText.getText().toString().length() == 0 || quantityText.getText().toString().length() == 0){
                            Toast.makeText(MainActivity.this,"You must complete all fields",Toast.LENGTH_LONG).show();
                            isValid = false;
                        }else{
                            symbolText.setError("");
                        }

                        if(isValid){
                            retrieveStock(symbolText.getText().toString(),quantityText.getText().toString());
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
