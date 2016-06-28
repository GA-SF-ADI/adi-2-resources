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

        //create db helper
        DatabaseHelper db = new DatabaseHelper(this);

        db.insert(1, "Dota", "1998");
        db.insert(2, "Mario", "1989");
        db.insert(3, "CounterStrike", "2000");

        String [] columns = {DatabaseHelper.COL_GAME_NAME,DatabaseHelper.COL_GAME_YEAR};
        int[] ids = {R.id.text_name, R.id.text_year};


        ListView listView = (ListView)findViewById(R.id.list_view);
        Cursor cursor = db.getAllGames();
        CursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
                R.layout.custom_layout,
                cursor,
                columns,
                ids,
                0);

        listView.setAdapter(cursorAdapter);

    }
}
