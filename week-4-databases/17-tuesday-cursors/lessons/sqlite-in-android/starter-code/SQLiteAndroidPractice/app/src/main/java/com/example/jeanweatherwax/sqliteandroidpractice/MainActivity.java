package com.example.jeanweatherwax.sqliteandroidpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseHelper db = new DatabaseHelper(this);
        db.insert(1,"Super Mario","1998");
        db.insert(2,"rock paper","1992");

        Game retrievedGame = db.getGame(2);
//        Log.v("my game", retrievedGame.getName());
    }
}
