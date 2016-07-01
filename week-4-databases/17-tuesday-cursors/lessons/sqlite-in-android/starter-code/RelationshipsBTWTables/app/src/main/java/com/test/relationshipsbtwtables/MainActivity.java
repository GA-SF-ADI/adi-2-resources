package com.test.relationshipsbtwtables;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button addDataButton;
    Button displayEmployeesButton;
    Button displayBostonOnlyButton;
    Button displaySalary;
    DataBaseHelper db;
    CursorAdapter cursorAdapter;
    ListView listView;

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

        listView = (ListView) findViewById(R.id.list_view);
        setAdapter();

        //Make 3 adapters (one for each button)
        //Set each adapter to the listview when the button is clicked


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, AddDataActivity.class);
                startActivity(intent);
                //is the start activity for result?

            }
        });


        displaySalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        displayBostonOnlyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        displayEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

    private void setAdapter() {
        db = DataBaseHelper.getInstance(MainActivity.this);
        cursorAdapter = new CursorAdapter(MainActivity.this, db.getEmployee(), 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_FIRST_NAME)));
                //may have to change names
            }
        };
        listView.setAdapter(cursorAdapter);

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

    protected void addEmployee(Employee employee) {

        //call in on create, no arguments
        //can do an arraylist and pass it through or like this

        Employee employee1 = new Employee("123-04-5678", "John", "Smith", "1973", "NY");
        Employee employee2 = new Employee("123-04-5679", "David", "McWill", "1982", "Seattle");
        Employee employee3 = new Employee("123-04-5680", "Katrina", "Wise", "1973", "Boston");

        DataBaseHelper helper = DataBaseHelper.getInstance(MainActivity.this);

        helper.insertEmployee(employee1);
        helper.insertEmployee(employee2);
        helper.insertEmployee(employee3);
    }


    protected void addJob(Job job) {
        Job job1 = new Job("123-04-5678", "Fuzz", 60, 1);
        Job job2 = new Job("123-04-5679", "GA", 70, 2);
        Job job3 = new Job("123-04-5680", "Little Place", 120, 5);

        DataBaseHelper helper = DataBaseHelper.getInstance(MainActivity.this);

        helper.insertJob(job1);
        helper.insertJob(job2);
        helper.insertJob(job3);

    }


}


