package com.test.relationshipslab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DialogActivity extends AppCompatActivity {
    EditText editTextSsn, editTextFirst, editTextLast, editTextDob, editTextCity;
    Button add;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        db = new DataBaseHelper(DialogActivity.this);


        setEditTexts();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = editTextFirst.getText().toString();
                String lastName = editTextLast.getText().toString();
                String birthYear = editTextDob.getText().toString();
                String city = editTextCity.getText().toString();
                String ssn = editTextSsn.getText().toString();

                Employee employee = new Employee(firstName, lastName, birthYear, city, ssn);
                db.addEmployee(employee);
                finish();
            }
        });


    }

    protected void setEditTexts(){
        editTextSsn = (EditText)findViewById(R.id.ssn_edit);
        editTextFirst = (EditText)findViewById(R.id.firstname_edit);
        editTextLast = (EditText)findViewById(R.id.lastname_edit);
        editTextDob = (EditText)findViewById(R.id.dob_edit);
        editTextCity = (EditText)findViewById(R.id.city_edit);
        add = (Button)findViewById(R.id.add_data_button);
    }
}
