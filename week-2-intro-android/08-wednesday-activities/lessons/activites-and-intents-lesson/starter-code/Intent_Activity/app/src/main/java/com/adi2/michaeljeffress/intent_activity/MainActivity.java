package com.adi2.michaeljeffress.intent_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);

        Button button = (Button) findViewById(R.id.button1);

        EditText.OnClickListener clickText = new EditText().OnClickListener() {

        editText.getText().toString();

        Integer.parseInt(String str);

        Intent intent = new Intent(MainActivity.this, SolutionActivity.class);

        intent.putExtra(str, )

        }

    }
}
