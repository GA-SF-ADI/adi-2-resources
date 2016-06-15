package com.example.hollis.activitypractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        int birthday = 5;
//        Intent thirdIntent = new Intent(MainActivity.this, ThirdActivity.class);
//        thirdIntent.putExtra("birthday", birthday);
//        startActivity(thirdIntent);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.edit_text);
                String textToSend = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, EchoActivity.class);
                intent.putExtra("text", textToSend);
                startActivity(intent);
            }
        });
    }


}
