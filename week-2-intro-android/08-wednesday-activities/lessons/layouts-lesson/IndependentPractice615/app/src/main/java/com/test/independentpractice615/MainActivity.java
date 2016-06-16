package com.test.independentpractice615;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button myAddButton = (Button) findViewById(R.id.addButton);

        myAddButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editText = (EditText) findViewById(R.id.editText1);
                String texttoSend = editText.getText().toString();
                int firstnumber = Integer.parseInt(texttoSend);
                Intent intent = new Intent(MainActivity.this, SolutionActivity.class);
                intent.putExtra("edit text 1", texttoSend);
                startActivity(intent);


                editText2 = (EditText) findViewById(R.id.editText2);
                String texttoSend2 = editText2.getText().toString();
                int secondnumber = Integer.parseInt(texttoSend2);
                Intent intent2 = new Intent(MainActivity.this, SolutionActivity.class);
                intent.putExtra("edit text 2", texttoSend2);
                startActivity(intent2);

                int sum = firstnumber + secondnumber;
                //myIntent.putExtra("firstnumber" , firstNumber);
                //myIntent.putExtra("secondnumer", secondNumber);


            }
        });


        Button mySubtractButton = (Button) findViewById(R.id.minusButton);

        mySubtractButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                editText = (EditText) findViewById(R.id.editText1);
                editText2 = (EditText) findViewById(R.id.editText2);
                String texttoSend = editText.getText().toString();
                String texttoSend2 = editText2.getText().toString();
                int firstnumber = Integer.parseInt(texttoSend);
                int secondnumber = Integer.parseInt(texttoSend2);
                Intent intent = new Intent(MainActivity.this, SolutionActivity.class);

                intent.putExtra("edit text 1", texttoSend);

                intent.putExtra("edit text 2", texttoSend2);

                int sum = firstnumber + secondnumber;

                setResult(RESULT_OK, intent);

                finish();
            }

        });

    }

}