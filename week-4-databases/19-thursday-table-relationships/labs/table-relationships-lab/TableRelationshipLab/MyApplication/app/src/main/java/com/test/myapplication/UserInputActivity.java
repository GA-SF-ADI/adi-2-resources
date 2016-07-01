package com.test.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by NehaRege on 6/30/16.
 */
public class UserInputActivity extends AppCompatActivity {

    Employee employee;
    EditText editTextSSN;
    EditText editTextFirstName;
    EditText editTextLastName;
    EditText editTextBirthYear;
    EditText editTextCity;

    DatabaseHelper helper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setResult(R.layout.acitivity_user_input);

        editTextSSN = (EditText) findViewById(R.id.ssn_edit_text);
        editTextFirstName = (EditText) findViewById(R.id.first_name_edit_text);
        editTextLastName = (EditText) findViewById(R.id.last_name_edit_text);
        editTextBirthYear = (EditText) findViewById(R.id.year_edit_text);
        editTextCity = (EditText) findViewById(R.id.city_edit_text);

        Button addUserInputButton = (Button) findViewById(R.id.add_user_input_and_go_back);
        Button cancelButton = (Button) findViewById(R.id.cancel_user_activity_button);

        assert addUserInputButton != null;
        addUserInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ssn = editTextSSN.getText().toString();
                String firstName = editTextFirstName.getText().toString();
                String lastName = editTextLastName.getText().toString();
                String birthYear = editTextBirthYear.getText().toString();
                String city = editTextCity.getText().toString();

                employee = new Employee(ssn,firstName,lastName,birthYear,city);   // this will create a new employee

                helper = DatabaseHelper.getInstance(UserInputActivity.this);
                helper.insertRowEmployee(employee);

                Toast.makeText(UserInputActivity.this, "The employee data has been added !", Toast.LENGTH_SHORT).show();

                Intent intent = getIntent();
                setResult(RESULT_OK,intent);      // .................?????????? is this right ????????????..................
                finish();

            }
        });




    }
}
