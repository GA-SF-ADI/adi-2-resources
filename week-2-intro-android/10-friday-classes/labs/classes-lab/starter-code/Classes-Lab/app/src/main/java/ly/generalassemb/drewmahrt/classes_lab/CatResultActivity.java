package ly.generalassemb.drewmahrt.classes_lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by kitty on 6/17/16.
 */
public class CatResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cat);

        //link XML to JAVA
        final EditText nameEdit = (EditText) findViewById(R.id.input_name);
        final EditText speedEdit = (EditText) findViewById(R.id.input_speed);
        final EditText colorEdit = (EditText) findViewById(R.id.input_color);
        final EditText numLivesEdit = (EditText) findViewById(R.id.input_num_lives);

        Button submitButton = (Button) findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", nameEdit.getText().toString());
                resultIntent.putExtra("top speed", Integer.parseInt(speedEdit.getText().toString()));
                resultIntent.putExtra("color", colorEdit.getText().toString());
                resultIntent.putExtra("num lives", Integer.parseInt(numLivesEdit.getText().toString()));

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }

}
