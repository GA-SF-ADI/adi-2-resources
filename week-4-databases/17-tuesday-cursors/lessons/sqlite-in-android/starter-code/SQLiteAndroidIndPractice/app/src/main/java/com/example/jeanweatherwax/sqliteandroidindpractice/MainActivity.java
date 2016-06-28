package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHelper db = new DataBaseHelper(this);

        db.insert(1, "Samsung",70,1800);
        db.insert(2, "LG",60,1500);
        db.insert(3, "Sony",40,700);
        db.insert(4, "Sony",42,850);
        db.insert(5, "Samsung",55,600);

        db.delete(3);
        db.delete(4);

    }
}
