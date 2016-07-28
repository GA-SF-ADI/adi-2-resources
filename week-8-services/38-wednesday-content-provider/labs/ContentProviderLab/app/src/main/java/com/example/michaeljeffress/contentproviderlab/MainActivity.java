package com.example.michaeljeffress.contentproviderlab;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    public static final Uri CONTENT_URI = Uri.parse("http://dev.markitondemand.com/Api/v2");

    private ListView mResultListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = (Button) findViewById(R.id.buttonAddMain);

        add.setOnClickListener(this);

        mResultListView = (ListView)findViewById(R.id.listViewMain);
    }

    public void addProduct () {
        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        values.put("productname", mInputCompany.getText().toString());
        values.put("quantity", mInputStockQuantity.getText().toString());
        Uri uri = cr.insert(CONTENT_URI,values);
        Log.d(MainActivity.class.getName(),uri.toString());
        mResultListView.setText(mInputCompany.getText().toString()+ " has been added!");
    }

    public void lookupProduct () {
        final String name = mInputCompany.getText().toString();
        int quantity = getProductCount(name);

        if (quantity == 0) {
            mResultListView.setText("That product cannot be found");
        } else {
            mResultListView.setText(name+ " count: "+quantity);
        }
    }

    public int getProductCount(String name){
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(CONTENT_URI,null,"productname = '"+name+"'",null,null);
        int quantity = 0;
        if(cursor.moveToFirst()){
            quantity = cursor.getInt(cursor.getColumnIndex("quantity"));
        }
        return quantity;
    }

    public void removeProduct () {
        String name = mInputCompany.getText().toString();
        ContentResolver cr = getContentResolver();
        int rowsDeleted = cr.delete(CONTENT_URI,"productname = '"+name+"'",null);
        if (rowsDeleted > 0) {
            mResultListView.setText("Product deleted");
        } else
            mResultListView.setText("That product cannot be found");
    }

    public void updateProduct(){
        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        values.put("quantity", mInputStockQuantity.getText().toString());
        int rowsUpdated = cr.update(CONTENT_URI,values,"productname = '"+ mInputCompany.getText().toString()+"'",null);

        if(rowsUpdated > 0)
            mResultListView.setText(mInputCompany.getText().toString()+ " has been updated!");
        else
            mResultListView.setText("That product cannot be found");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAddMain:
                addProduct();
                break;
            default:
                break;
        }
    }
}
