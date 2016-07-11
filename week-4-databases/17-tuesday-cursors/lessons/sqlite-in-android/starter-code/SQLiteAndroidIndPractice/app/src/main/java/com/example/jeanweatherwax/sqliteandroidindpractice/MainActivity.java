package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        db.insert(1, "Sony", "40\"", 300);
        db.insert(2, "Sony", "45\"", 400);
        db.insert(3, "LG", "50\"", 800);
        db.insert(4, "Panasonic", "10\"", 100);
        db.insert(5, "LG", "20\"", 250);



        Television tv = db.getTelevision(2);

        TextView mTextView = (TextView) findViewById(R.id.mTextView);

        mTextView.setText(tv.getBrand() + ", " + tv.getSize() + ", $" + tv.getPrice() );
    }
}
