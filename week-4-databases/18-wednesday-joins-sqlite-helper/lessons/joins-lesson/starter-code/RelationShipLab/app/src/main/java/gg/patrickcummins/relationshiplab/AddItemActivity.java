package gg.patrickcummins.relationshiplab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    EditText ssn, firstName, lastName, yearOfBirth, city;
    Button add, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        setUpViews();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper helper = DatabaseHelper.getInstance(AddItemActivity.this);
                if (ssn.getText().toString().equals("") || firstName.getText().toString().equals("") || lastName.getText().toString().equals("") || yearOfBirth.getText().toString().equals("") || city.getText().toString().equals("")){
                   if (ssn.getText().toString().equals("")){
                       ssn.setError("Please Enter");
                   }
                    if (firstName.getText().toString().equals("")){
                        firstName.setError("Please Enter");
                    }
                    if (lastName.getText().toString().equals("")){
                        lastName.setError("Please Enter");
                    }
                    if (yearOfBirth.getText().toString().equals("")){
                        yearOfBirth.setError("Please Enter");
                    }
                    if (city.getText().toString().equals("")){
                        city.setError("Please Enter");
                    }
                }else{


                helper.insertEmployeeRow(new Employee(ssn.getText().toString(), firstName.getText().toString(), lastName.getText().toString(), yearOfBirth.getText().toString(), city.getText().toString()));
                finish();}
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setUpViews() {
        ssn = (EditText) findViewById(R.id.ssnEditText);
        firstName = (EditText) findViewById(R.id.firstNameEditText);
        lastName = (EditText) findViewById(R.id.lastNameEditText);
        yearOfBirth = (EditText) findViewById(R.id.birthYearEditText);
        city = (EditText) findViewById(R.id.cityEditText);
        add = (Button) findViewById(R.id.addButton);
        cancel = (Button) findViewById(R.id.cancelButton);


    }
}
