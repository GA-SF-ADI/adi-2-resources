package com.test.relationshipsbtwtables;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.os.AsyncTask;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button addDataButton;
    Button displayEmployeesButton;
    Button displayBostonOnlyButton;
    Button displaySalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addDataButton = (Button) findViewById(R.id.add_data_button);
        displaySalary = (Button) findViewById(R.id.salary_button);
        displayBostonOnlyButton = (Button) findViewById(R.id.companies_boston_button);
        displayEmployeesButton = (Button) findViewById(R.id.employees_button);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
                //is the start activity for result?

            }
        });


        displaySalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent displaySalary = new Intent(MainActivity.this, DisplaySalary.class);
                startActivity(displaySalary);
            }
        });


        displayBostonOnlyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent displayBostonOnly = new Intent(MainActivity.this, DisplayBostonOnlyActivity.class);
                startActivity(displayBostonOnly);
            }
        });



        displayEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent displayEmployeesIntent = new Intent(MainActivity.this, DisplayEmployeesActivity.class);
                startActivity(displayEmployeesIntent);
            }
        });


        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addDataIntent = new Intent(MainActivity.this, AddDataActivity.class);
                startActivity(addDataIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //uncomment

    /*

    new AsyncTask<Employee, Void, String>()

    {
        @Override
        protected String doInBackground (Employee...params){

        Employee employee1 = new Employee("123-04-5678", "John", "Smith", 1973, "NY");
        Employee employee2 = new Employee("123-04-5679", "David", "McWill", 1982, "Seattle");
        Employee employee3 = new Employee("123-04-5680", "Katrina", "Wise", 1973, "Boston");

        Job job1 = new Job("123-04-5678", "Fuzz", 60, 1);
        Job job2 = new Job("123-04-5679", "GA", 70, 2);
        Job job3 = new Job("123-04-5680", "Little Place", 120, 5);


        DataBaseHelper helper = DataBaseHelper.getInstance(MainActivity.this);
        helper.insertEmployee(employee1);
        helper.insertEmployee(employee2);
        helper.insertEmployee(employee3);

        helper.insertJob(job1);
        helper.insertJob(job2);
        helper.insertJob(job3);


    }


    }

    */
}
