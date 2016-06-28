package com.example.jeanweatherwax.sqliteandroidpractice;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpDB();

        ListView listView = (ListView) findViewById(R.id.list_view);

        //the cursor should include all the data in the database
        Cursor cursor = db.getAllGames();

        String[] columns = {DatabaseHelper.COL_GAME_NAME};

        int[] ids = {android.R.id.text1};

        CursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                cursor,
                columns,
                ids,
                0
                );

        listView.setAdapter(cursorAdapter);

    }


    
//IGNORE THIS CODE SHH
    public void setUpDB(){
        db = new DatabaseHelper(this);
        try{
            db.getGame(1);
        }catch(CursorIndexOutOfBoundsException e ){
            db.insert(1, "Super Mario", "1985");
            db.insert(2, "Legend of Zelda", "1986");

        }

    }
}
