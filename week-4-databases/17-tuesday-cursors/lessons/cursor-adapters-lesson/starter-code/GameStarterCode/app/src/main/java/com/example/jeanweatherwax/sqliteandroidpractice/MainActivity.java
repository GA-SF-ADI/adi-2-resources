package com.example.jeanweatherwax.sqliteandroidpractice;

import android.database.CursorIndexOutOfBoundsException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpDB();

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
