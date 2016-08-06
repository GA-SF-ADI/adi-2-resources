package com.test.bookscanner2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//
//            public void run() {
//                // TODO Auto-generated method stub
//                finish();
//                Intent intent = new Intent(getBaseContext(), MainActivity.class);
//                startActivity(intent);
//            }
//        }, 1000);
//
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}