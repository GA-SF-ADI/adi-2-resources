package com.example.jeanweatherwax.scratchpad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by NehaRege on 6/15/16.
 */
public class ThirdActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent=getIntent();
        int birth=intent.getIntExtra("birthday",-1);

        TextView textView=(TextView) findViewById(R.id.txt3);
        textView.setText(birth+"");
    }
}
