package com.example.michaeljeffress.relationshipstweentableslab;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by michaeljeffress on 6/30/16.
 */
public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText ssnEditText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText yobEditText;
    private EditText cityEditText;
    private Button addButton;
    private Button cancelButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ssnEditText = (EditText) findViewById(R.id.editText_SSN);
        firstNameEditText = (EditText) findViewById(R.id.editText_FirstName);
        lastNameEditText = (EditText) findViewById(R.id.editText_LastName);
        yobEditText = (EditText) findViewById(R.id.editText_YearBirth);
        cityEditText = (EditText) findViewById(R.id.editText_City);
        addButton = (Button) findViewById(R.id.button_add);
        cancelButton = (Button) findViewById(R.id.button_cancel);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_add:
                addDataToDb();
                finish();
                break;
            case R.id.button_cancel:
                finish();
                break;
        }

    }

    private void addDataToDb() {
        String ssn = ssnEditText.getText().toString();
        String fistName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        int year = Integer.parseInt(yobEditText.getText().toString());
        String city = cityEditText.getText().toString();

        //Setting Employee object with these variables.
        final Employee employee = new Employee(ssn, fistName, lastName, year, city);
        EmployeeSQLiteOpenHelper helper = EmployeeSQLiteOpenHelper.getInstance(DetailActivity.this);
        helper.addEmployeeInfo(employee);
        Toast.makeText(DetailActivity.this, "Add info to the db.", Toast.LENGTH_LONG).show();
    }
}

