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
public class SnakeResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_snake);

        //link XML to JAVA
        final EditText nameEdit = (EditText) findViewById(R.id.input_name);
        final EditText speedEdit = (EditText) findViewById(R.id.input_speed);
        final EditText endangeredEdit = (EditText) findViewById(R.id.input_is_endangered);
        final EditText uglyEdit = (EditText) findViewById(R.id.input_ugly);
        final EditText venomEdit = (EditText) findViewById(R.id.input_venom);
        final EditText killEdit = (EditText) findViewById(R.id.input_kill);

        Button submitButton = (Button) findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", nameEdit.getText().toString());
                resultIntent.putExtra("top speed", Integer.parseInt(speedEdit.getText().toString()));
                resultIntent.putExtra("is endangered", endangeredEdit.getText().toString());
                resultIntent.putExtra("ugly", uglyEdit.getText().toString());
                resultIntent.putExtra("venom", venomEdit.getText().toString());
                resultIntent.putExtra("kill", killEdit.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }

}
