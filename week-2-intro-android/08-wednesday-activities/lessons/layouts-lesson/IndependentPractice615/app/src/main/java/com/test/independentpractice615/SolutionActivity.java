package com.test.independentpractice615;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SolutionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

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
