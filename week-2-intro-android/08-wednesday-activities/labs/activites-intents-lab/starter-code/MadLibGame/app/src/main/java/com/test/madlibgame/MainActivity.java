package com.test.madlibgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Button getMadLib;
    Intent sendToResultActivity;
    private EditText adjective1MainEditText;
    private EditText adjective2MainEditText;
    private EditText noun1MainEditText;
    private EditText noun2MainEditText;
    private EditText animalsMainEditText;
    private EditText gameMainEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMadLib = (Button) findViewById(R.id.finished_button);
        adjective1MainEditText = (EditText) findViewById(R.id.adjective1_xml);
        adjective2MainEditText = (EditText) findViewById(R.id.adjective2_xml);
        noun1MainEditText = (EditText) findViewById(R.id.noun1_xml);
        noun2MainEditText = (EditText) findViewById(R.id.noun2_xml);
        animalsMainEditText = (EditText) findViewById(R.id.animals_xml);
        gameMainEditText = (EditText) findViewById(R.id.game_xml);

        sendToResultActivity = new Intent(this, ResultActivity.class);

        getMadLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (adjective1MainEditText.getText().toString().equals("") ||
                        adjective2MainEditText.getText().toString().equals("") ||
                        noun1MainEditText.getText().toString().equals("") ||
                        noun2MainEditText.getText().toString().equals("") ||
                        animalsMainEditText.getText().toString().equals("") ||
                        gameMainEditText.getText().toString().equals("")) {
                    adjective1MainEditText.setError("Please enter an adj");
                    adjective2MainEditText.setError("Please enter an adj");
                    noun1MainEditText.setError("Please enter a noun");
                    noun2MainEditText.setError("Please enter a noun");
                    animalsMainEditText.setError("Please enter an animal");
                    gameMainEditText.setError("Please enter a game");

                } else {

                    Bundle bundle = new Bundle();
                    bundle.putString(ResultActivity.ADJECTIVE1, adjective1MainEditText.getText().toString());
                    bundle.putString(ResultActivity.ADJECTIVE2, adjective2MainEditText.getText().toString());
                    bundle.putString(ResultActivity.NOUN1, noun1MainEditText.getText().toString());
                    bundle.putString(ResultActivity.NOUN2, noun2MainEditText.getText().toString());
                    bundle.putString(ResultActivity.ANIMALS, animalsMainEditText.getText().toString());
                    bundle.putString(ResultActivity.GAME, gameMainEditText.getText().toString());


                    sendToResultActivity.putExtras(bundle);

                    startActivity(sendToResultActivity);
                }
            }
        });


    }
}
