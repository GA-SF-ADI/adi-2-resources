package com.example.hollis.activitypractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by hollis on 6/15/16.
 */
public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        int birthday = intent.getIntExtra("birthday", -1);
        TextView textView = (TextView) findViewById(R.id.birthday);
        textView.setText(birthday + "");
    }
}
