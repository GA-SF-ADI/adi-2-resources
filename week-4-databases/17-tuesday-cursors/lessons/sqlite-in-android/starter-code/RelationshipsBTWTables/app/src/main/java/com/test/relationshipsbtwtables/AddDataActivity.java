package com.test.relationshipsbtwtables;

import android.database.sqlite.SQLiteCursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;

public class AddDataActivity extends AppCompatActivity {

    DataBaseHelper db;
    EditText SSN;
    EditText firstName;
    EditText lastName;
    EditText yearBorn;
    EditText city;
    Employee newEmployee;
    Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

       final DataBaseHelper db = new DataBaseHelper(this);


        SSN = (EditText) findViewById(R.id.edit_text_SSN);
        firstName = (EditText) findViewById(R.id.edit_text_first_name);
        lastName = (EditText) findViewById(R.id.edit_text_last_name);
        yearBorn = (EditText) findViewById(R.id.edit_text_year_born);
        city = (EditText) findViewById(R.id.edit_text_city);
        saveButton = (Button) findViewById(R.id.save_button);

//TODO MAKE IT SO PERSON IS ONLY ADDED WHEN THE SAVE BUTTON IS CLICKED



        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String SocialSecurity = SSN.getText().toString();
                String firName = firstName.getText().toString();
                String lasName = lastName.getText().toString();
                String year = yearBorn.getText().toString();
                String cityLoc = city.getText().toString();

                newEmployee = new Employee(SocialSecurity,firName, lasName, year, cityLoc);
                db.insertEmployee(newEmployee);

                finish();
            }

        });


//        cursorAdapter.swapCursor(db.getEmployee());
//TODO: FINISH THE ACTIVITY
        //Save button to save

    }
}
