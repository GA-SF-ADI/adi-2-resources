package com.example.hollis.activitypractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EchoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = (TextView) findViewById(R.id.recieved_text);
        Intent recievedIntent = getIntent();
        String recievedText = recievedIntent.getStringExtra("text");
        textView.setText(recievedText);
    }
}
