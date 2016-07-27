package com.test.contentproviderslab;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final Uri CONTENT_URI = MyContentProvider.CONTENT_URI;
    ListView mStockListView;
    CursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mStockListView = (ListView) findViewById(R.id.portfolio_list);
        Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, null);
        mCursorAdapter = new CursorAdapter(this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                //set textviews here

                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                String name = cursor.getString(cursor.getColumnIndex("stockname"));
                text1.setText(name);

                TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                String symbol = cursor.getColumnName(cursor.getColumnIndex("symbol"));
                text2.setText(symbol);

                TextView text3 =(TextView) view.findViewById(android.R.id.text3);
                String quantity = cursor.getColumnName(cursor.getColumnIndex("quantity"));
                text3.setText(quantity);
            }

        };

        //set listview to adapter
        mStockListView.setAdapter(mCursorAdapter);
    }
}
