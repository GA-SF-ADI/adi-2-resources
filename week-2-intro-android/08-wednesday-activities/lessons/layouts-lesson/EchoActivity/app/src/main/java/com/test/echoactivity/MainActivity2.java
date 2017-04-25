package com.test.echoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                int number1=Integer.parseInt(editText1.getText().toString());
                int number2=Integer.parseInt(editText2.getText().toString());
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("number1", number1);
                intent.putExtra("number2", number2);
                setResult(RESULT_OK,intent);
                finish();
            }
        });






        /*setContentView(R.layout.activity_main2);
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        int number1=Integer.parseInt(editText1.getText().toString());
        int number2=Integer.parseInt(editText2.getText().toString());
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        int sum=number1+number2;
        intent.putExtra("sum", sum);



        //Intent addIntent = getIntent();




    }
}
