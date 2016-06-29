package com.example.jeanweatherwax.sqliteandroidpractice;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        db.insert(1, "Super Mario", "1985");
        db.insert(2, "Legend of Zelda", "1986");


        String[] columns = {"name", "year"};
        int [] ids = {R.id.textView1, R.id.textView2};

        ListView listView = (ListView)findViewById(R.id.listView);
        Cursor cursor = db.getAllGames();
        CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.new_layout, cursor, columns, ids, 0);

        listView.setAdapter(cursorAdapter);


    }
}
