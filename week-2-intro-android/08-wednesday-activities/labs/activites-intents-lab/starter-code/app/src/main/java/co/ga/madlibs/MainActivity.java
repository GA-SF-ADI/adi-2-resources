package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText adjective1; // setup elements
    private EditText adjective2;
    private EditText noun1;
    private EditText noun2;
    private EditText animals;
    private EditText game;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adjective1 = (EditText)findViewById(R.id.adjective1); // attach elements to fields/button
        adjective2 = (EditText)findViewById(R.id.adjective2);
        noun1 = (EditText)findViewById(R.id.noun1);
        noun2 = (EditText)findViewById(R.id.noun2);
        animals = (EditText)findViewById(R.id.animals);
        game = (EditText)findViewById(R.id.game);
        button1 = (Button)findViewById(R.id.button1);


        button1.setOnClickListener(new View.OnClickListener() { //type new V in () - for listener
            @Override
            public void onClick(View v) {
                Log.d("Main", "onClick: clicked");
                
                Intent intentSend = new Intent(MainActivity.this, ResultActivity.class);

                Bundle bundle = new Bundle(); //Bundle up strings
                bundle.putString(ResultActivity.ADJECTIVE1, adjective1.getText().toString()); // Get Strings from EditText fields
                bundle.putString(ResultActivity.ADJECTIVE2, adjective2.getText().toString());
                bundle.putString(ResultActivity.NOUN1, noun1.getText().toString());
                bundle.putString(ResultActivity.NOUN2, noun2.getText().toString());
                bundle.putString(ResultActivity.ANIMALS, animals.getText().toString());
                bundle.putString(ResultActivity.GAME, game.getText().toString());

                intentSend.putExtras(bundle); // put bundle into Intent
                startActivity(intentSend); // start activity
            }


        });



    }
}
