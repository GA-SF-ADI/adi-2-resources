package com.test.madlibsthird;

//import what I need

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    //initialize edittexts and buttons

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText favoriteColor;
    private EditText favoriteFood;
    private EditText favoriteGame;
    private Button submitButton;

    //link java to XML

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view by id

        firstName = (EditText) findViewById(R.id.firstName_EditText);
        lastName = (EditText) findViewById(R.id.lastName_EditText);
        email = (EditText) findViewById(R.id.email_EditText);
        favoriteColor= (EditText) findViewById(R.id.favoriteColor_EditText);
        favoriteGame= (EditText) findViewById(R.id.favoriteGame_EditText);
        submitButton = (Button) findViewById(R.id.submit_button);

        //View on click....

        View.OnClickListener onSubmitClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(allWordsAreFilledOut()) {
                    startResultsActivity();
                } else {
                    Toast.makeText(MainActivity.this, "Not all filled out",Toast.LENGTH_SHORT).show();
                }

            }
        };

        submitButton.setOnClickListener(onSubmitClick);
    }

    private boolean allWordsAreFilledOut() {
        boolean wordsFilledOut;

        wordsFilledOut = isEditTextValid(firstName);
        wordsFilledOut &= isEditTextValid(lastName);
        wordsFilledOut &= isEditTextValid(email);
        wordsFilledOut &= isEditTextValid(favoriteColor);
        wordsFilledOut &= isEditTextValid(favoriteFood);
        wordsFilledOut &= isEditTextValid(favoriteGame);

        return wordsFilledOut;

    }

    private boolean isEditTextValid(EditText editText) {
        boolean isValid = true;
        String text = editText.getText().toString();

        if(text.isEmpty()) {
            editText.setError("Fill it out!");
            isValid = false;
        }
        return isValid;
    }

    private void startResultsActivity () {

        Intent intent = new Intent(MainActivity. this, ResultsActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString(ResultsActivity. firstName , firstName.getText().toString());
        bundle.putString(ResultsActivity. lastName, lastName.getText().toString());
        bundle.putString(ResultsActivity. email, email.getText().toString());
        bundle.putString(ResultsActivity. favoriteColor, favoriteColor.getText().toString());
        bundle.putString(ResultsActivity.favoriteFood, favoriteFood.getText().toString());
        bundle.putString(ResultsActivity.favoriteGame, favoriteGame.getText().toString);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
