package com.test.activitypractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by sterlinggerritz on 6/15/16.
 */
public class thirdactivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third.xml);
        Intent intent= getIntent();
        int birthday = intent.getIntExtra("birthday",-1);
        TextView textView = (TextView) findViewById(R.id.birthday);
        textView.setText(birthdayxml + "");
    }
}
