package com.example.jeanweatherwax.sqliteandroidpractice;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.list_view);



        // created an instance of databasehelper
        DatabaseHelper db = new DatabaseHelper(this);
        //used the insert method from databasehelper to insert values in database
        db.insert(1, "Super Mario", "1988");
        db.insert(2,"Lu", "1986");

        //returning value at id 2
        Game retrievedGame = db.getGame(2);


    }
}
