package com.example.jeanweatherwax.screen_rotation_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    static final String MY_ADDRESS = "address";
    static final String MY_NAME = "name";

    static String address;
    static String name;

    TextView addressView;
    TextView nameView;
    EditText addressEdit;
    EditText nameEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView addressView = (TextView) findViewById(R.id.my_address);
        final TextView nameView = (TextView) findViewById(R.id.my_name);

        final EditText addressEdit = (EditText) findViewById(R.id.address_edit);
        final EditText nameEdit = (EditText) findViewById(R.id.name_edit);

        final Button button = (Button) findViewById(R.id.save_button);

        if(savedInstanceState != null) {
            name = savedInstanceState.getString(MY_NAME);
            address = savedInstanceState.getString(MY_ADDRESS);
        }


        if (address != null && name != null) {
            addressView.setText("Your Address: " + address);
            nameView.setText("Your Name: " + name);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address = addressEdit.getText().toString();
                name = nameEdit.getText().toString();

                addressView.setText("Your Address: " + address);
                nameView.setText("Your Name: " + name);


                addressEdit.getText().clear();
                nameEdit.getText().clear();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle
        savedInstanceState.putString(MY_ADDRESS, address);
        savedInstanceState.putString(MY_NAME, name);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
        Toast.makeText(MainActivity.this,
                "onSaveInstanceState:\n" +
                        "saved_state = " + name + " " + address,
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance
        address = savedInstanceState.getString(MY_ADDRESS);
        name = savedInstanceState.getString(MY_NAME);

        String stateSaved = savedInstanceState.getString("saved_state");
        savedInstanceState.putString("saved_state", stateSaved);

            Toast.makeText(MainActivity.this,
                    "onRestoreInstanceState",
                    Toast.LENGTH_LONG).show();

    }

}
