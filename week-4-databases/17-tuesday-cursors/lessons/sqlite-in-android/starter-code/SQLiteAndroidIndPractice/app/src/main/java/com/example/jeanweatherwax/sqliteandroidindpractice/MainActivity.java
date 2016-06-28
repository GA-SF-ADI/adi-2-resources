package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting an instance

        DataBaseHelper db = new DataBaseHelper(this);

        //insert stuff for the table

        db.insert(1,"Samsung", 60.0, 200);
        db.insert(2, "LG", 55.0, 150 );
        db.insert(3, "SONY", 25.0, 99);

        Television gotTV = db.getTV(1);
    }
}
