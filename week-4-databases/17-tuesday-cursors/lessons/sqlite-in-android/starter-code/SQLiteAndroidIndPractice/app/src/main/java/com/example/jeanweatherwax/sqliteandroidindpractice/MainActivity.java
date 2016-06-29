package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        db.insert(1, "Sony", "50 Inch", 600);
        db.insert(2, "Samsung", "42 Inch", 400);
        db.insert(3, "RCA", "60 Inch", 1000);
        db.insert(4, "Panasonic", "50 Inch", 650);
        db.insert(5, "LG", "42 Inch", 450);

        db.delete(5);
        db.delete(4);

    }



}


