package com.test.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        //get the Intent
        // get the Extra
        //set the text

        Intent intent =getIntent();
        int firstnumber = intent.getIntExtra("firstnumber", -1);
        int secondnumber = intent.getIntExtra("secondnumber", -1);
        TextView myText= (TextView) findViewById(R.id.myText);
        myText.setText(firstnumber + secondnumber + "");
    }

}
