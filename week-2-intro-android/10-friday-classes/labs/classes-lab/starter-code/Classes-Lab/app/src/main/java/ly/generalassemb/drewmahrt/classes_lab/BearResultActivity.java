package ly.generalassemb.drewmahrt.classes_lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kitty on 6/17/16.
 */
public class BearResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bear);

        //link XML to JAVA
        final EditText nameEdit = (EditText) findViewById(R.id.input_name);
        final EditText speedEdit = (EditText) findViewById(R.id.input_speed);
        final EditText endangeredEdit = (EditText) findViewById(R.id.input_is_endangered);
        final EditText colorEdit = (EditText) findViewById(R.id.input_color);
        final EditText carnivorousEdit = (EditText) findViewById(R.id.input_is_carnivorous);
        final EditText biteEdit = (EditText) findViewById(R.id.input_bite_force);

        Button submitButton = (Button) findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", nameEdit.getText().toString());
                resultIntent.putExtra("top speed", Integer.parseInt(speedEdit.getText().toString()));
                resultIntent.putExtra("is endangered", endangeredEdit.getText().toString());
                resultIntent.putExtra("color", colorEdit.getText().toString());
                resultIntent.putExtra("carnivorous", carnivorousEdit.getText().toString());
                resultIntent.putExtra("bite force", Integer.parseInt(biteEdit.getText().toString()));
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }

}
