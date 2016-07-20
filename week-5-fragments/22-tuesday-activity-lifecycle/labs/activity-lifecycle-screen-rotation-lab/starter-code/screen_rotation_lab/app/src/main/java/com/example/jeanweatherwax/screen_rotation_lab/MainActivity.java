package com.example.jeanweatherwax.screen_rotation_lab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        //initialize views
        final TextView addressView = (TextView) findViewById(R.id.my_address);
        final TextView nameView = (TextView) findViewById(R.id.my_name);

        final EditText addressEdit = (EditText) findViewById(R.id.address_edit);
        final EditText nameEdit = (EditText) findViewById(R.id.name_edit);

        final Button button = (Button) findViewById(R.id.save_button);


        //Retrieve name and address from savedInstanceState with getString() method.


        if (address != null && name != null) {
            addressView.setText("Your Address: " + address);
            nameView.setText("Your Name: " + name);
        }

        //Set the two TextViews with EditText inputs on button click.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set TextViews with EditText inputs here.



                address = addressEdit.getText().toString();
                name = nameEdit.getText().toString();

                addressView.setText(address);
                nameView.setText(name);



                //Clear the EditTexts for new inputs.
                addressEdit.getText().clear();
                nameEdit.getText().clear();
            }
        });
    }

    //in onSaveInstanceState, use putString method to save address and name.
    //Also, make a Toast to display the saved state.
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) { //the bundle is right here
        //To save additional state information for this activity
        //I have to implement onSaveInstanceState() and add key-value pairs to the
        //Bundle object.
        // ToDo:Save custom values into the bundle

        savedInstanceState.putString("name", MY_NAME);
        savedInstanceState.putString("address", MY_ADDRESS);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    //In onRestoreInstanceState, use getString to retrieve the address and name.
    //Also show a Toast to display the restored state.
    //Will restore the state after the activity has been destroyed
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
        // Restore state members from saved instance

        name = savedInstanceState.getString(MY_NAME);
        address = savedInstanceState.getString(MY_ADDRESS);

        Toast.makeText(MainActivity.this, "You have restored the name and address", Toast.LENGTH_LONG);
    }

}
