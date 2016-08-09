package com.test.bookscanner2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            public void run() {
                // TODO Auto-generated method stub
                finish();
                Intent intent = new Intent(getBaseContext(), SelectClassroomActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }
}