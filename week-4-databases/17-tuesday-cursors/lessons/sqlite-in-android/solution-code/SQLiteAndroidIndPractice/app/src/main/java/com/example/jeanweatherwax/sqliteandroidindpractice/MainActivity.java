package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);
        db.insert(1, "Sony", "40", 300);
        db.insert(2, "Hitachi", "40", 350);
        db.insert(3, "Sony", "80", 500);
        db.insert(4, "Sharp", "29", 150);
        db.insert(5, "LG", "30", 100);

        db.delete(1);
        db.delete(5);
    }
}
