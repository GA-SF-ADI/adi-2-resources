package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText adjective1_edittext;
    EditText adjective2_edittext;
    EditText noun1_edittext;
    EditText noun2_edittext;
    EditText animals_edittext;
    EditText game_edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        adjective1_edittext = (EditText) findViewById(R.id.adjective1_edittext);
        adjective2_edittext = (EditText) findViewById(R.id.adjective2_edittext);
        noun1_edittext = (EditText) findViewById(R.id.noun1_edittext);
        noun2_edittext = (EditText) findViewById(R.id.noun2_edittext);
        animals_edittext = (EditText) findViewById(R.id.animals_edittext);
        game_edittext = (EditText) findViewById(R.id.game_edittext);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(ResultActivity.ADJECTIVE1, adjective1_edittext.getText().toString());
                bundle.putString(ResultActivity.ADJECTIVE2, adjective2_edittext.getText().toString());
                bundle.putString(ResultActivity.NOUN1, noun1_edittext.getText().toString());
                bundle.putString(ResultActivity.NOUN2, noun2_edittext.getText().toString());
                bundle.putString(ResultActivity.ANIMALS, animals_edittext.getText().toString());
                bundle.putString(ResultActivity.GAME, game_edittext.getText().toString());
                intent.putExtras(bundle);
                if(adjective1_edittext.getText().toString().trim().length() == 0 || adjective2_edittext.getText().toString().trim().length() == 0 || noun1_edittext.getText().toString().trim().length() == 0 || noun2_edittext.getText().toString().trim().length() == 0 || animals_edittext.getText().toString().trim().length() == 0 || game_edittext.getText().toString().trim().length() == 0){
                    Toast toast =Toast.makeText(MainActivity.this,"please enter valid information", Toast.LENGTH_SHORT); toast.show();
                }
                startActivity(intent);
            }
        });
    }
}

