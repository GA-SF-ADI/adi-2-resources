package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText adj1, adj2, noun1, noun2, animals, game;
    String adj1String, adj2String, noun1String, noun2String, animalsString, gameString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adj1= (EditText) findViewById(R.id.adjective1_edittext);
        adj2= (EditText) findViewById(R.id.adjective2_edittext);
        noun1 = (EditText) findViewById(R.id.noun1_edittext);
        noun2 = (EditText) findViewById(R.id.noun2_edittext);
        animals = (EditText) findViewById(R.id.animals_edittext);
        game = (EditText) findViewById(R.id.game_edittext);

        findViewById(R.id.submitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adj1String = adj1.getText().toString();
                adj2String = adj2.getText().toString();
                noun1String = noun1.getText().toString();
                noun2String = noun2.getText().toString();
                animalsString = animals.getText().toString();
                gameString = game.getText().toString();
                if(adj1String.equals("") || adj2String.equals("") ||noun1String.equals("")||noun2String.equals("")||animalsString.equals("")||gameString.equals("")) {
                    if (adj1String.equals("")) {
                        adj1.setError("!");

                    }
                    if (adj2String.equals("")) {
                        adj2.setError("!");
                    }
                    if (noun1String.equals("")) {
                        noun1.setError("!");
                    }
                    if (noun2String.equals("")) {
                        noun2.setError("!");
                    }
                    if (animalsString.equals("")) {
                        animals.setError("!");
                    }
                    if (gameString.equals("")) {
                        game.setError("!");
                    }
                }else{
                Bundle myBundle = new Bundle();
                myBundle.putString(ResultActivity.ADJECTIVE1, adj1String);
                myBundle.putString(ResultActivity.ADJECTIVE2, adj2String);
                myBundle.putString(ResultActivity.NOUN1, noun1String);
                myBundle.putString(ResultActivity.NOUN2, noun2String);
                myBundle.putString(ResultActivity.GAME, gameString);
                myBundle.putString(ResultActivity.ANIMALS, animalsString);
                    Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                    myIntent.putExtras(myBundle);
                    startActivity(myIntent);
            }
            }

        });
    }
}
