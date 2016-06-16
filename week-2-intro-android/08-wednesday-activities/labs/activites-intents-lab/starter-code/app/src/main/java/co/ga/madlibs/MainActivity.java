package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                words[0] = extras.getString(ADJECTIVE1, "???");
//                words[1] = extras.getString(ADJECTIVE2, "???");
//                words[2] = extras.getString(NOUN1, "???");
//                words[3] = extras.getString(NOUN2, "???");
//                words[4] = extras.getString(ANIMALS, "???");
//                words[5] = extras.getString(GAME, "???");


//                Intent intent = new Intent(this, DisplayMessageActivity.class);
//                EditText editText = (EditText) findViewById(R.id.edit_message);
//                String message = editText.getText().toString();
//                intent.putExtra(EXTRA_MESSAGE, message);

                EditText adjectiveone = (EditText) findViewById(R.id.adjective1_edittext);
                EditText adjectivetwo = (EditText) findViewById(R.id.adjective2_edittext);
                EditText nounone = (EditText) findViewById(R.id.noun1_edittext);
                EditText nountwo = (EditText) findViewById(R.id.noun2_edittext);
                EditText animal = (EditText) findViewById(R.id.animals_edittext);
                EditText choosegame = (EditText) findViewById(R.id.game_edittext);

                String adj1 = adjectiveone.getText().toString();
                String adj2 = adjectivetwo.getText().toString();
                String noun1 = nounone.getText().toString();
                String noun = nountwo.getText().toString();
                String animals = animal.getText().toString();
                String game = choosegame.getText().toString();

                Intent intenttoResult = new Intent(MainActivity.this, ResultActivity.class);

                intenttoResult.putExtra(adj1, -1);
                intenttoResult.putExtra(adj2, -1);
                intenttoResult.putExtra(noun1, -1);
                intenttoResult.putExtra(noun, -1);
                intenttoResult.putExtra(animals, -1);
                intenttoResult.putExtra(game, -1);

                startActivity(intenttoResult);
            }
        });


    }

}
