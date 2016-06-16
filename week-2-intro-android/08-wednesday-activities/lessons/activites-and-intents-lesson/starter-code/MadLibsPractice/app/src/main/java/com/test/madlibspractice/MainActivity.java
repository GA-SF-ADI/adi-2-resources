package com.test.madlibspractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    //use the EditTexts globally

    private EditText adjective1EditTextl;
    private EditText adjective2EditText;
    private EditText noun1EditText;
    private EditText noun2EditText;
    private EditText animalsEditText;
    private EditText gameEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adjective1EditTextl = (EditText) findViewById(R.id.adjective1_edittext);
        adjective2EditText = (EditText) findViewById(R.id.adjective2_edittext);
        noun1EditText = (EditText) findViewById(R.id.noun1_edittext);
        noun2EditText = (EditText) findViewById(R.id.noun2_edittext);
        animalsEditText = (EditText) findViewById(R.id.animals_edittext);
        gameEditText = (EditText) findViewById(R.id.game_edittext);
        submitButton = (Button) findViewById(R.id.submit_button);


        View.OnClickListener onSubmitClick = new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                if(allWordsAreFilledOut()) {
                   startResultsActivity();
                }else {
                    Toast.makeText(MainActivity.this , "Fill all in!", Toast.LENGTH_SHORT).show();
                }
            }

        };

        submitButton.setOnClickListener(onSubmitClick);

    }

    private boolean allWordsAreFilledOut() {
        boolean wordsFilledOut;

        wordsFilledOut = isEditTextValid(adjective1EditTextl);
        wordsFilledOut &= isEditTextValid(adjective2EditText);
        wordsFilledOut &= isEditTextValid (noun1EditText);
        wordsFilledOut &= isEditTextValid (noun2EditText);
        wordsFilledOut &= isEditTextValid (animalsEditText);
        wordsFilledOut &= isEditTextValid (gameEditText);


        return wordsFilledOut;
    }

    private boolean isEditTextValid(EditText editText) {
        boolean isValid = true;
        String text = editText.getText().toString();

        if (text.isEmpty()) {
            editText.setError("Fill out!");
            isValid = false;
        }

        return isValid;
    }

    private void startResultsActivity() {

        Intent intent = new Intent(MainActivity.this,ResultActivity.class);

        Bundle bundle = new Bundle ();
        bundle.putString(ResultActivity.adjective1, adjective1EditTextl.getText().toString());
        bundle.putString(ResultActivity.adjective2, adjective2EditText.getText().toString());
        bundle.putString(ResultActivity.NOUN1, noun1EditText.getText().toString());
        bundle.putString(ResultActivity.NOUN2, noun2EditText.getText().toString());
        bundle.putString(ResultActivity.ANIMALS, animalsEditText.getText().toString());
        bundle.putString(ResultActivity.GAME, gameEditText.getText().toString());

        intent.putExtras(bundle);

        startActivity(intent);
    }

};