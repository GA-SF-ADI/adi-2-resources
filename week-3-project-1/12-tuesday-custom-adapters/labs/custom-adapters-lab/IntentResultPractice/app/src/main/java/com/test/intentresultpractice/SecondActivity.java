package com.test.intentresultpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        final TextView textView = (TextView) findViewById(R.id.textView);

        Button goBacktoMain = (Button) findViewById(R.id.go_back_to_first_activity_button);

        Intent receivedIntent = getIntent();
        final String myName = receivedIntent.getStringExtra("myKey");

        goBacktoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult = new Intent (SecondActivity.this, MainActivity.class);
                intentResult.putExtra("myKey", intentResult);

                setResult(RESULT_OK, intentResult);

                finish();

            }
        });


    }

}
