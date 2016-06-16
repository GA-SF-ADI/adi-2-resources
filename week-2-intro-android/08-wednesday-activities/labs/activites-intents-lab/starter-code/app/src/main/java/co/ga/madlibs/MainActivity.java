package co.ga.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText adj1;
    private EditText adj2;
    private EditText noun1;
    private EditText noun2;
    private EditText animal;
    private EditText game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adj1 = (EditText) findViewById(R.id.adjective1_edittext);
        adj2 = (EditText) findViewById(R.id.adjective2_edittext);
        noun1 = (EditText) findViewById(R.id.noun1_edittext);
        noun2 = (EditText) findViewById(R.id.noun2_edittext);
        animal = (EditText) findViewById(R.id.animals_edittext);
        game = (EditText) findViewById(R.id.game_edittext);


        Button button = (Button) findViewById(R.id.b1);


        View.OnClickListener buttonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(ResultActivity.ADJECTIVE1,adj1.getText().toString());
                bundle.putString(ResultActivity.ADJECTIVE2,adj2.getText().toString());
                bundle.putString(ResultActivity.NOUN1,noun1.getText().toString());
                bundle.putString(ResultActivity.NOUN2,noun2.getText().toString());
                bundle.putString(ResultActivity.ANIMALS,animal.getText().toString());
                bundle.putString(ResultActivity.GAME,game.getText().toString());

                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };

        button.setOnClickListener(buttonOnClickListener);


    }
}
