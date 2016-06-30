package com.test.bostoncompaniesandmore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddingCustomDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_custom_data);

        EditText ssnText = (EditText) findViewById(R.id.editText_ssn);
        EditText firstNameText = (EditText) findViewById(R.id.editText_first_name);
        EditText lastNameText = (EditText) findViewById(R.id.editText_last_name);
        EditText yearOfBirthText = (EditText) findViewById(R.id.editText_year_of_birth);
        EditText cityText = (EditText) findViewById(R.id.editText_city);

        Intent receivedIntent = getIntent();


    }
}
