package com.test.mainactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        Button myAddButton = (Button) findViewById(R.id.addButton);
        myAddButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                editText = (EditText) findViewById(R.id.editText1);
                editText2 = (EditText) findViewById(R.id.editText2);
                String texttoSend = editText.getText().toString();
                String texttoSend2 = editText2.getText().toString();
                int firstnumber = Integer.parseInt(texttoSend);
                int secondnumber = Integer.parseInt(texttoSend2);
                Intent intent = new Intent();

                intent.putExtra("firstnubmer", firstnumber);

                intent.putExtra("secondnumber", firstnumber);

                setResult(RESULT_OK, intent);
                finish();

                //this should be in second activity

            }

        });
    }
}
