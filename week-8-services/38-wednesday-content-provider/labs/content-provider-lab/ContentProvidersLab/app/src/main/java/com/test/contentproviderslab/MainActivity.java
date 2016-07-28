package com.test.contentproviderslab;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    Button buttonNextActivity;
    public static final Uri CONTENT_URI = MyContentProvider.CONTENT_URI;
    ListView mStockListView;
    CursorAdapter mCursorAdapter;
    String baseUrl = "http://dev.markitondemand.com/MODApis/Api/v2/";
    StockInterface stockInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mStockListView = (ListView) findViewById(R.id.portfolio_list);
        button = (Button) findViewById(R.id.next_act);
        setSupportActionBar(toolbar);
        setUpStock();
        Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, null);

        buttonNextActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                startActivity(intent);

            }

        });
    }

    stockInterface.getQuote("symbol").

    enqueue(new retrofit2.Callback<Stock>() {
        @Override
        public void onResponse
        (retrofit2.Call < Stock > call, retrofit2.Response < Stock > response){

            Stock stock = response.body();
            mCursorAdapter = new CursorAdapter(MainActivity.this, (Cursor) Arrays.asList(stockInterface.getQuote("symbol"))) {
                @Override
                public View newView(Context context, Cursor cursor, ViewGroup parent) {
                    return LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
                }

                @Override
                public void bindView(View view, Context context, Cursor cursor) {
                    textView1 = (TextView) view.findViewById(R.id.text1);
                    String name = cursor.getString(cursor.getColumnIndex("stockname"));
                    textView1.setText(name);

                    textView2 = (TextView) view.findViewById(R.id.text2);
                    String symbol = cursor.getColumnName(cursor.getColumnIndex("symbol"));
                    textView2.setText(symbol);

                    textView3 = (TextView) view.findViewById(R.id.text3);
                    String quantity = cursor.getColumnName(cursor.getColumnIndex("quantity"));
                    textView3.setText(quantity);
                }
            };
            mCursorAdapter.notifyDataSetChanged();
            //change adapter to list
            mStockListView.setAdapter(mCursorAdapter);
            //set up adapter here
        }

        @Override
        public void onFailure (retrofit2.Call < Stock > call, Throwable t){
            t.printStackTrace();
            Toast.makeText(MainActivity.this, "No WIFI", Toast.LENGTH_LONG).show();

        }

    }

    );
}

    private void setUpStock() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        stockInterface = retrofit.create(StockInterface.class);
    }

}
