package com.test.myapplication;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
    TextView textView,textView1,textView2;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        DataBaseHelper db = DataBaseHelper.getInstance(CartActivity.this);

        listView = (ListView)findViewById(R.id.cart_list_view);
        Cursor cursor = db.getCartAlcList();

        CursorAdapter cursorAdapter = new CursorAdapter(CartActivity.this,cursor,0){
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.list_cart_item,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                textView = (TextView)view.findViewById(R.id.cart_alc_quantity);
                textView2 = (TextView)view.findViewById(R.id.cart_alc_name);
                textView1 = (TextView)view.findViewById(R.id.cart_alc_price);
                textView2.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_ALC_NAME)));
                textView.setText("Qty: "+String.valueOf(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.CART_COL_QUANTITY))));
                textView1.setText("$"+cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_ALC_PRICE)));

            }
        };
        listView.setAdapter(cursorAdapter);

    }

}

