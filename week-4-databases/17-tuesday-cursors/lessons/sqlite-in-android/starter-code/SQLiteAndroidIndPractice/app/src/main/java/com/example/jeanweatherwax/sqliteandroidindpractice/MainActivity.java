package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        db.insert(1, "Samsung", "60\"", 2499);
        db.insert(2, "LG", "42\"", 899);
        db.insert(3, "Sony", "52\"", 1499);
        db.insert(4, "Samsung", "52\"", 1799);
        db.insert(5, "Vizio", "60\"", 1399);

        //db.delete(4);
        //db.delete(5);

        ListView listView = (ListView) findViewById(R.id.list_view);
        Cursor cursor = db.getAllTVs();

        // For simple cursor adapter
        //String[] columns = {DatabaseHelper.COLUMN_BRAND};
        //int[] ids = {android.R.id.text1};

        // Simple Cursor Adapter
        //CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, columns, ids, 0);

        CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView brand = (TextView) view.findViewById(R.id.brand);
                TextView size = (TextView) view.findViewById(R.id.size);
                TextView price = (TextView) view.findViewById(R.id.price);

                brand.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_BRAND)));
                size.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_SIZE)));
                price.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_PRICE))));
            }
        };

        listView.setAdapter(cursorAdapter);
    }
}
