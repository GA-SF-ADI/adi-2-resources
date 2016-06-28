package com.example.jeanweatherwax.sqliteandroidpractice;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // getting an instance here
        DatabaseHelper db = new DatabaseHelper(this);

        //insert some stuff for the table
        db.insert(1, "Super Mario", "1998");
        db.insert(2, "Pokemon", "1995");
        db.insert(3, "Game", "2000");

        //setUpDB();

        //set up listview from XML
        ListView listView = (ListView) findViewById(R.id.list_view);

        //create cursor and a method to get all the games
        Cursor cursor = db.getAllGames();

        //need to make a string array (for the 4th argument) and use column names
        String[] columns = {DatabaseHelper.COL_GAME_NAME, DatabaseHelper.COL_GAME_YEAR}; //you can put more than 1 here

        //need an array of ints and look at XML file for the id that android already gave us

        //command click on simple_list_item_1 to find the id that you need

        int[] ids = {R.id.text_view_1,R.id.text_view_2};

        //create cursor adapter... SimpleCursorAdapter and 6 "things
        CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.customlayout, cursor, columns,ids, 0);

        //setAdapter
        listView.setAdapter(cursorAdapter);


        Game retrievedGame = db.getGame(2);
    }
}
