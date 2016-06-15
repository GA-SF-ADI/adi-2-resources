package co.ga.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText adjective1EditText;
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

        adjective1EditText = (EditText) findViewById(R.id.adjective1_edittext);
        adjective2EditText = (EditText) findViewById(R.id.adjective2_edittext);
        noun1EditText = (EditText) findViewById(R.id.noun1_edittext);
        noun2EditText = (EditText) findViewById(R.id.noun2_edittext);
        animalsEditText = (EditText) findViewById(R.id.animals_edittext);
        gameEditText = (EditText) findViewById(R.id.game_edittext);
        submitButton = (Button) findViewById(R.id.submit_button);

        View.OnClickListener onSubmitClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allWordsAreFilledOut()){
                    startResultsActivity();
                } else {
                    Toast.makeText(MainActivity.this, "Please fix the errors", Toast.LENGTH_SHORT).show();
                }
            }
        };

        submitButton.setOnClickListener(onSubmitClick);
    }

    /**
     * @return true, if all of the app's edit texts have a value. false otherwise.
     */
    private boolean allWordsAreFilledOut() {
        boolean wordsFilledOut;

        // Logic: If all of the edit texts have values, then this method will return true
        // The following code is saying "If edit text 1 is valid && edit text 2 is valid && edit
        // text 3 is valid && etc". This can also be done with 6 if-else conditional statements.
        wordsFilledOut = isEditTextValid(adjective1EditText);
        wordsFilledOut &= isEditTextValid(adjective2EditText);
        wordsFilledOut &= isEditTextValid(noun1EditText);
        wordsFilledOut &= isEditTextValid(noun2EditText);
        wordsFilledOut &= isEditTextValid(animalsEditText);
        wordsFilledOut &= isEditTextValid(gameEditText);

        return wordsFilledOut;
    }

    /**
     * This method checks if the given edit text has a value associated with it. If it does not, the
     * edit text will show an error.
     *
     * @param editText The edit text to check
     * @return true, if the edit text has a value. false otherwise.
     */
    private boolean isEditTextValid(EditText editText) {
        boolean isValid = true;
        String text = editText.getText().toString();

        if (text.isEmpty()){
            editText.setError("Please fill out!");
            isValid = false;
        }

        return isValid;
    }

    private void startResultsActivity(){
        // start new intent
        Intent intent = new Intent(this, ResultActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString(ResultActivity.ADJECTIVE1, adjective1EditText.getText().toString());
        bundle.putString(ResultActivity.ADJECTIVE2, adjective2EditText.getText().toString());
        bundle.putString(ResultActivity.NOUN1, noun1EditText.getText().toString());
        bundle.putString(ResultActivity.NOUN2, noun2EditText.getText().toString());
        bundle.putString(ResultActivity.ANIMALS, animalsEditText.getText().toString());
        bundle.putString(ResultActivity.GAME, gameEditText.getText().toString());

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
