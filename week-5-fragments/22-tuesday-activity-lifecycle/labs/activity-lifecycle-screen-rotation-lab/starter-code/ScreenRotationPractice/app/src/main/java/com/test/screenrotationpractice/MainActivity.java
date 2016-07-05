package com.test.screenrotationpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String MY_NAME = "name";
    static final String MY_ANIMAL = "animal";

    static String name;
    static String animal;

    TextView nameTextView;
    TextView animalTextView;
    EditText nameEditText;
    EditText animalEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize views

        final TextView nameTextView = (TextView) findViewById(R.id.my_name);
        final TextView animalTextView = (TextView) findViewById(R.id.my_animal);

        final EditText nameEditText = (EditText) findViewById(R.id.name_edit);
        final EditText animalEditText = (EditText) findViewById(R.id.animal_edit);

        final Button button = (Button) findViewById(R.id.save_button);

        //Retrieve name and animal from savedInstanceState with getString() method
//
        if (savedInstanceState != null) {
            name = savedInstanceState.getString(MY_NAME);
            animal = savedInstanceState.getString(MY_ANIMAL);
            Toast.makeText(MainActivity.this, "Saving Name and Animal", Toast.LENGTH_SHORT).show();
        } else {
            name = null;
            animal = null;
            Toast.makeText(MainActivity.this, "Type in name and animal, please.", Toast.LENGTH_SHORT).show();
        }

        if (animal != null && name != null) {
            nameTextView.setText("Your Name: " + name);
            animalTextView.setText("Your Animal: " + animal);

        }

        //Set the two TextViews with EditText inputs on button click.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set TextViews with EditText inputs here.
                name = nameEditText.getText().toString();
                animal = animalEditText.getText().toString();

                if(name.equals("") || animal.equals("")){
                    Toast.makeText(MainActivity.this, "Type in your name and favorite animal", Toast.LENGTH_SHORT).show();
                }

                nameTextView.setText("Your name is " + name + " and your favorite animal is " + animal + ".");
                Toast.makeText(MainActivity.this, "Saving Name " + name + " and Animal " + animal, Toast.LENGTH_SHORT).show();
                //Clear the EditTexts for new inputs.
                animalEditText.getText().clear();
                nameEditText.getText().clear();
            }
        });
    }

    //in onSaveInstanceState, use put string method to save animal and name
    //also, make a toast to display saved state

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save custom values into the bundle
        // Always call the superclass so it can save the view hierarchy state
        savedInstanceState.putString(MY_NAME, name);
        savedInstanceState.putString(MY_ANIMAL, animal);
        super.onSaveInstanceState(savedInstanceState);
        Toast.makeText(MainActivity.this, "Saving onSaveInstanceState ", Toast.LENGTH_SHORT).show();
    }

    //In onRestoreInstanceState, use getString to retrieve the address and name.
    //Also show a Toast to display the restored state.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        // Restore state members from saved instance
        savedInstanceState.putString(MY_NAME, name);
        savedInstanceState.putString(MY_ANIMAL, animal);
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(MainActivity.this, "Saving onRestoreInstanceState ", Toast.LENGTH_SHORT).show();
    }
}
