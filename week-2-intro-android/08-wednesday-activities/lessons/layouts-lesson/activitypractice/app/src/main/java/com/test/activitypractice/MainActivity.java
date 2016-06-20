package com.test.activitypractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
int birthday = 5;
        Intent thirdintent = new Intent(MainActivity.this,thirdactivity.class);
        thirdintent.putExtra("birthday", birthday);
        startActivity(thirdintent);


    }
}
