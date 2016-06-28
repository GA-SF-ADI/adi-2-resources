package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        db.insert(1, "Samsung", "60\"", 2499);
        db.insert(2, "LG", "42\"", 899);
        db.insert(3, "Sony", "52\"", 1499);
        db.insert(4, "Samsung", "52\"", 1799);
        db.insert(5, "Vizio", "60\"", 1399);

        db.delete(4);
        db.delete(5);
    }
}
