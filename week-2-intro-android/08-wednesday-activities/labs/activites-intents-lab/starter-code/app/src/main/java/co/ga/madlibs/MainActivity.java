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

        final EditText adj1 = (EditText) findViewById(R.id.adjective1_edittext);
        final EditText adj2 = (EditText) findViewById(R.id.adjective2_edittext);
        final EditText noun1 = (EditText) findViewById(R.id.noun1_edittext);
        final EditText noun2 = (EditText) findViewById(R.id.noun2_edittext);
        final EditText animal = (EditText) findViewById(R.id.animals_edittext);
        final EditText game = (EditText) findViewById(R.id.game_edittext);



        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b = new Bundle();
                b.putString(ResultActivity.ADJECTIVE1, adj1.getText().toString());
                b.putString(ResultActivity.ADJECTIVE2, adj2.getText().toString());
                b.putString(ResultActivity.NOUN1, noun1.getText().toString());
                b.putString(ResultActivity.NOUN2, noun2.getText().toString());
                b.putString(ResultActivity.ANIMALS, animal.getText().toString());
                b.putString(ResultActivity.GAME, game.getText().toString());

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtras(b);
                startActivity(intent);


            }
        });




    }
}
