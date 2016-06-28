package com.example.jeanweatherwax.sqliteandroidpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // created an instance of databasehelper
        DatabaseHelper db = new DatabaseHelper(this);
        //used the insert method from databasehelper to insert values in database
        db.insert(1, "Super Mario", "1988");
        db.insert(2,"Lu", "1986");

        //returning value at id 2
        Game retrievedGame = db.getGame(2);
    }
}
