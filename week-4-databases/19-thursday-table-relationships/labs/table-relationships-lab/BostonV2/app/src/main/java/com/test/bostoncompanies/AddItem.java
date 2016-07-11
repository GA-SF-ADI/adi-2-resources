package com.test.bostoncompanies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {
    EditText ssn;
    EditText firstName;
    EditText lastName;
    EditText birthYear;
    EditText city;
    Button addButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        ssn = (EditText) findViewById(R.id.ssnEditText);
        firstName = (EditText) findViewById(R.id.firstNameEditText);
        lastName = (EditText) findViewById(R.id.lastNameEditText);
        birthYear = (EditText) findViewById(R.id.birthYearEditText);
        city = (EditText) findViewById(R.id.cityEditText);
        addButton = (Button) findViewById(R.id.addButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper helper = DBHelper.getInstance(AddItem.this);


                    helper.insertEmployeeRow(new Employee(ssn.getText().toString(), firstName.getText().toString(), lastName.getText().toString(), birthYear.getText().toString(), city.getText().toString()));
                    finish();}

        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }





    }
