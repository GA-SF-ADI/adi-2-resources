package com.test.bostoncompaniesandmore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddingCustomDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_custom_data);

        final EditText ssnText = (EditText) findViewById(R.id.editText_ssn);
        final EditText firstNameText = (EditText) findViewById(R.id.editText_first_name);
        final EditText lastNameText = (EditText) findViewById(R.id.editText_last_name);
        final EditText yearOfBirthText = (EditText) findViewById(R.id.editText_year_of_birth);
        final EditText cityText = (EditText) findViewById(R.id.editText_city);
        Button addCustomData = (Button) findViewById(R.id.button_add_custom_data_button);
        Button cancelAndReturnToMainActivity = (Button) findViewById(R.id.button_cancel_and_return_to_main_activity);

        Intent receivedIntent = getIntent();

        addCustomData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newSSN = ssnText.getText().toString();
                String newFirst = firstNameText.getText().toString();
                String newLast = lastNameText.getText().toString();
                String newYear = yearOfBirthText.getText().toString();
                String newCity = cityText.getText().toString();


            }
        });

        cancelAndReturnToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

    }
}
