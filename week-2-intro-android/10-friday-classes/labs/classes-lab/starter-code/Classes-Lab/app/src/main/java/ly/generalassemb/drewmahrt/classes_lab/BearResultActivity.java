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

    Bear bear;

    private  int mRequestCode;
    public static final String BEAR_SERIALIZABLE_KEY = "myBearKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bear);

        //link XML to JAVA
        EditText nameEdit = (EditText) findViewById(R.id.input_name);
        EditText speedEdit = (EditText) findViewById(R.id.input_speed);
        EditText endangeredEdit = (EditText) findViewById(R.id.input_is_endangered);
        EditText colorEdit = (EditText) findViewById(R.id.input_color);
        EditText carnivorousEdit = (EditText) findViewById(R.id.input_is_carnivorous);
        EditText biteEdit = (EditText) findViewById(R.id.input_bite_force);

        Button submitButton = (Button) findViewById(R.id.submit);

        //int speed = Integer.parseInt(speedEdit.getText().toString());

        bear.setName(nameEdit.getText().toString());
        bear.setTopSpeed(Integer.parseInt(speedEdit.getText().toString()));
        if(endangeredEdit.getText().toString().equals("Y")){
            bear.setIsEndangered(true);
        } else bear.setIsEndangered(false);
        bear.setCoatColor(colorEdit.getText().toString());
        if(carnivorousEdit.getText().toString().equals("Y")){
            bear.setCarnivorous(true);
        } else bear.setCarnivorous(false);
        bear.setBiteForce(Integer.parseInt(biteEdit.getText().toString()));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(BEAR_SERIALIZABLE_KEY, );
            }
        });



}
