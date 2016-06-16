package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText adj1 = (EditText) findViewById(R.id.adjective1_edittext);
                EditText adj2 = (EditText) findViewById(R.id.adjective2_edittext);
                EditText noun1 = (EditText) findViewById(R.id.noun1_edittext);
                EditText noun2 = (EditText) findViewById(R.id.noun2_edittext);
                EditText animal = (EditText) findViewById(R.id.animals_edittext);
                EditText game = (EditText) findViewById(R.id.game_edittext);

                String adj1Input = adj1.getText().toString();
                String adj2Input = adj2.getText().toString();
                String noun1Input = noun1.getText().toString();
                String noun2Input = noun2.getText().toString();
                String animalInput = animal.getText().toString();
                String gameInput = game.getText().toString();

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                intent.putExtra("adj1", adj1Input);
                intent.putExtra("adj2", adj2Input);
                intent.putExtra("noun1", noun1Input);
                intent.putExtra(ResultActivity.NOUN2, noun2Input);
                intent.putExtra(ResultActivity.ANIMALS, animalInput);
                intent.putExtra("game", gameInput);
                startActivity(intent);
            }
        });

    }
}
