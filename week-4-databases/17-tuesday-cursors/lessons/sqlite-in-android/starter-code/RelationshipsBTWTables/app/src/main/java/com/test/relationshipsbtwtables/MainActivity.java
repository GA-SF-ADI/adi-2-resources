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
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    Button displayEmployeesButton;
    Button displayBostonOnlyButton;
    Button displaySalary;
    DataBaseHelper db;
    CursorAdapter cursorAdapterEmployee;
    CursorAdapter cursorAdapterJob;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        displaySalary = (Button) findViewById(R.id.salary_button);
        displayBostonOnlyButton = (Button) findViewById(R.id.companies_boston_button);
        displayEmployeesButton = (Button) findViewById(R.id.employees_button);
        listView = (ListView) findViewById(R.id.list_view);
        setAdapterJob(cursorAdapterJob);
        setAdapterEmployee(cursorAdapterEmployee);
        addEmployee();
        addJob();


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

       displayEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.getEmployee();
                cursorAdapterEmployee = new SimpleCursorAdapter(MainActivity.this,android.R.layout.simple_list_item_1,cursor,new String[]{DataBaseHelper.COL_FIRST_NAME},new int[]{android.R.id.text1},0);
                listView.setAdapter(cursorAdapterEmployee);
            }
        });

        displayBostonOnlyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.getJob();
                cursorAdapterJob = new SimpleCursorAdapter(MainActivity.this,android.R.layout.simple_list_item_1,cursor,new String[]{DataBaseHelper.COL_COMPANY_NAME},new int[]{android.R.id.text1},0);
                listView.setAdapter(cursorAdapterJob);
            }
        });

        displaySalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void setAdapterEmployee(CursorAdapter cursorAdapterEmployee) {
        db = DataBaseHelper.getInstance(MainActivity.this);
        this.cursorAdapterEmployee = new CursorAdapter(MainActivity.this, db.getEmployee(), 0) {
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
        listView.setAdapter(cursorAdapterEmployee);
    }

    private void setAdapterJob(CursorAdapter cursorAdapterJob) {
        db = DataBaseHelper.getInstance(MainActivity.this);
        this.cursorAdapterJob = new CursorAdapter(MainActivity.this, db.getJob(), 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_COMPANY_NAME)));
            }

        };
        listView.setAdapter(cursorAdapterJob);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void addEmployee() {

        Employee employee1 = new Employee("123-04-5678", "John", "Smith", "1973", "NY");
        Employee employee2 = new Employee("123-04-5679", "David", "McWill", "1982", "Seattle");
        Employee employee3 = new Employee("123-04-5680", "Katrina", "Wise", "1973", "Boston");
        Employee employee4 = new Employee("123-04-5681", "Donald", "Lee", "1992", "London");
        Employee employee5 = new Employee("123-04-5682", "Gary", "Henwood", "1987", "Las Vegas");
        Employee employee6 = new Employee("123-04-5683", "Anthony", "Bright", "1963", "Seattle");
        Employee employee7 = new Employee("123-04-5684", "William", "Newey", "1995", "Boston");
        Employee employee8 = new Employee("123-04-5685", "Melony", "Smith", "1970", "Chicago");

        DataBaseHelper helper = DataBaseHelper.getInstance(MainActivity.this);

        helper.insertEmployee(employee1);
        helper.insertEmployee(employee2);
        helper.insertEmployee(employee3);
        helper.insertEmployee(employee4);
        helper.insertEmployee(employee5);
        helper.insertEmployee(employee6);
        helper.insertEmployee(employee7);
        helper.insertEmployee(employee8);
    }

    protected void addJob() {
        Job job1 = new Job("123-04-5678", "Fuzz", 60, 1);
        Job job2 = new Job("123-04-5679", "GA", 70, 2);
        Job job3 = new Job("123-04-5680", "Little Place", 120, 5);
        Job job4 = new Job("123-04-5681", "Macy's", 78, 3);
        Job job5 = new Job("123-04-5682", "New Life", 65, 1);
        Job job6 = new Job("123-04-5683", "Believe", 158, 6);
        Job job7 = new Job("123-04-5684", "Macy's", 200, 8);
        Job job8 = new Job("123-04-5685", "Stop", 299, 12);

        DataBaseHelper helper = DataBaseHelper.getInstance(MainActivity.this);

        helper.insertJob(job1);
        helper.insertJob(job2);
        helper.insertJob(job3);
        helper.insertJob(job4);
        helper.insertJob(job5);
        helper.insertJob(job6);
        helper.insertJob(job7);
        helper.insertJob(job8);

    }

    /*
    public String getNameJoins() {

        String result = "default name";
        SQLiteDatabase db = getWritableDatabase();
        // Building query using INNER JOIN keyword.
        String query = "SELECT FIRST_NAME FROM EMPLOYEE INNER JOIN JOB ON EMPLOYEE._ID = JOB._ID";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            result = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_COMPANY_NAME));
        }
        cursor.close();

        //we are returning the person that matches the criteria... their company id has to match employee id
        return result;
    }

    */

}



