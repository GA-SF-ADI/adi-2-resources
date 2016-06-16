package com.test.activityandintents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.Manifest;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;


/**
 * Created by audreyeso on 6/15/16.
 */
public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent = getIntent();
        intent.getIntExtra("birthday", -1);
        TextView textView = (TextView) findViewById(R.id.birthday);
        textView.setText(birthday + "");

        // this links the layout file to the activity
        // this was a class first and then when we made it into an activity
        // it did not have a layout and then it had to be linked
        // also there need to be an intent


        Intent thirdIntent = new Intent(ActivityAndIntents.this,ThirdActivity.class);
        startActivity(thirdIntent);
        thirdIntent.putExtra("birthday", birthday);
        startActivity(thirdIntent);





        //you need to pass data between activities! other wise it will just run
    }
}
