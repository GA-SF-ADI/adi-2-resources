package com.test.activity1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int birthday = 5;
        Intent secondIntent = new Intent(MainActivity.this, ThirdActivity.class);
        secondIntent.putExtra("birthday", birthday);
        startActivity(secondIntent);

    }
}
