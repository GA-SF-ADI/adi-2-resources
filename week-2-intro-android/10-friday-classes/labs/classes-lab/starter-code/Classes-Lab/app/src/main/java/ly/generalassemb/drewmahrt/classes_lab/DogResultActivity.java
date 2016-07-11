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
public class DogResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dog);

        //link XML to JAVA
        final EditText nameEdit = (EditText) findViewById(R.id.input_name);
        final EditText speedEdit = (EditText) findViewById(R.id.input_speed);
        final EditText colorEdit = (EditText) findViewById(R.id.input_color);
        final EditText guardEdit = (EditText) findViewById(R.id.input_guard);
        final EditText sizeEdit = (EditText) findViewById(R.id.input_size);
        final EditText fetchEdit = (EditText) findViewById(R.id.input_fetch);

        Button submitButton = (Button) findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", nameEdit.getText().toString());
                resultIntent.putExtra("top speed", Integer.parseInt(speedEdit.getText().toString()));
                resultIntent.putExtra("color", colorEdit.getText().toString());
                resultIntent.putExtra("guard", guardEdit.getText().toString());
                resultIntent.putExtra("size", sizeEdit.getText().toString());
                resultIntent.putExtra("fetch", fetchEdit.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }

}
