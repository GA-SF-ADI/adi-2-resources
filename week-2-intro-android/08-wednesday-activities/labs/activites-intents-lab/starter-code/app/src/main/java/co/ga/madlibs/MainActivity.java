package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText adj1EditText;
    EditText adj2EditText;
    EditText noun1EditText;
    EditText noun2EditText;
    EditText animals;
    EditText games;
    Button submitButton;


    String adjective1 = adj1EditText.getText().toString();
    String adjective2 = adj2EditText.getText().toString();
    String noun1 = noun1EditText.getText().toString();
    String noun2 = noun2EditText.getText().toString();
    String animalString = animals.getText().toString();
    String gameString = games.getText().toString();
    String all = adjective1 + adjective2 + noun1 + noun2 + animalString + gameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submit_button);
        adj1EditText = (EditText) findViewById(R.id.adjective1_EditText);
        adj2EditText = (EditText) findViewById(R.id.adjective2_EditText);
        noun1EditText = (EditText) findViewById(R.id.noun1_EditText);
        noun2EditText = (EditText) findViewById(R.id.noun2_EditText);
        animals = (EditText) findViewById(R.id.animals_EditText);
        games = (EditText) findViewById(R.id.game_EditText);

        View.OnClickListener Submit = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if complete... user submit
                //if not say error

                if (all.length() != 0) {
                    startResultsActivity();

                } else
                    System.out.println("Error!");
            }

        };

        submitButton.setOnClickListener(Submit);

    }

    public static boolean completeOrIncomplete() {


    }


 public void startResultsActivity () {

     Intent intent = new Intent(MainActivity.this, ResultActivity.class);


//not sure what else to put here...

     startActivity(intent);

}
}
