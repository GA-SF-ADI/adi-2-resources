package com.test.activityandintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class ActivityAndIntents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_and_intents);

        Button button = (Button) findViewById(R.id.button1);
        // I want to grab text, put the text in an intent, send the intent

        button.setOnClickListener(new View.OnClickListener()) {
            @Override
                    public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.edit_text);
                String textToSend  = editText.getText().toString();
                Intent intent  = new Intent(ActivityAndIntents.this, EchoActivity.class);
                intent.putExtra();
                startActivity(intent);
            }
        }
    }
}
