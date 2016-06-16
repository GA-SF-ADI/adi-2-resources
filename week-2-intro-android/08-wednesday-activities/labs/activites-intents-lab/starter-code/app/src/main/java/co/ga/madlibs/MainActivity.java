package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText adjectiveone = (EditText) findViewById(R.id.adjective1_edittext);
        EditText adjectivetwo = (EditText) findViewById(R.id.adjective2_edittext);
        EditText nounone = (EditText) findViewById(R.id.noun1_edittext);
        EditText nountwo = (EditText) findViewById(R.id.noun2_edittext);
        EditText animal = (EditText) findViewById(R.id.animals_edittext);
        EditText choosegame = (EditText) findViewById(R.id.game_edittext);
        Button submitButton = (Button) findViewById(R.id.submit_button);


        String adj1 = adjectiveone.getText().toString();
        String adj2 = adjectivetwo.getText().toString();
        String noun1 = nounone.getText().toString();
        String noun = nountwo.getText().toString();
        String animals = animal.getText().toString();
        String game = choosegame.getText().toString();


        findViewById(R.id.submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(this, DisplayMessageActivity.class);
//                EditText editText = (EditText) findViewById(R.id.edit_message);
//                String message = editText.getText().toString();
//                intent.putExtra("String message", actual data);

            }


//                public void btnClick(View v)
//                {
//                    if(editText.getText().length()==0)
//                    {
//                        editText.setError("Field cannot be left blank.");
//                    }
//                }



            }



            private void sendIntentAndData() {

                Intent intenttoResult = new Intent(MainActivity.this, ResultActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString(ResultActivity.ADJECTIVE1, adjectiveone.getText().toString());
                bundle.putString(ResultActivity.ADJECTIVE2, adjectivetwo.getText().toString());
                bundle.putString(ResultActivity.NOUN1, nounone.getText().toString());
                bundle.putString(ResultActivity.NOUN2, nountwo.getText().toString());
                bundle.putString(ResultActivity.ANIMALS, animal.getText().toString());
                bundle.putString(ResultActivity.GAME, choosegame.getText().toString());

                intenttoResult.putExtras(bundle);
                startActivity(intenttoResult);

            }
        });

    }

}

}
