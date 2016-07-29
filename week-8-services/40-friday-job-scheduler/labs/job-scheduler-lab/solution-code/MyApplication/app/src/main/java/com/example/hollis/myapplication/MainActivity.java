package com.example.hollis.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //initializing button
        Button button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
            Toast.makeText(MainActivity.this, "Poof", Toast.LENGTH_LONG).show();
        }
    });
}}
