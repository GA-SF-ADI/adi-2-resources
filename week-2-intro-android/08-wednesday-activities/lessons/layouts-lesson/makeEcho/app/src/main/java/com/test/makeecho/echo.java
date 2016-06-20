package com.test.makeecho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class echo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);

        TextView textView = (TextView) findViewById(R.id.edittextxml);
        Intent recievedIntent = getIntent();
        String recievedText = recievedIntent.getStringExtra("text");
        textView.setText(recievedText);
    }
}
