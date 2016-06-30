package com.test.relationshipsbtwtables;

import android.database.sqlite.SQLiteCursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class AddDataActivity extends AppCompatActivity {

    EditText SSN;
    EditText firstName;
    EditText lastName;
    EditText yearBorn;
    EditText city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        //add database
        //DataBaseHelper db = new DataBaseHelper(this, "Adding Data", " ",1);


        SSN = (EditText) findViewById(R.id.edit_text_SSN);
        firstName = (EditText) findViewById(R.id.edit_text_first_name);
        lastName = (EditText) findViewById(R.id.edit_text_last_name);
        yearBorn = (EditText) findViewById(R.id.edit_text_year_born);
        city = (EditText) findViewById(R.id.edit_text_city);

        String SocialSecurity = SSN.getText().toString();
        String firName = firstName.getText().toString();
        String lasName = lastName.getText().toString();
        String year = yearBorn.getText().toString();
        String cityLoc = city.getText().toString();


        //update db so that it stores information
/*
        db.add(SocialSecurity);
        db.add(firName);
        db.add(lasName);
        db.add(year);
        db.add(cityLoc);
*/


    }
}
