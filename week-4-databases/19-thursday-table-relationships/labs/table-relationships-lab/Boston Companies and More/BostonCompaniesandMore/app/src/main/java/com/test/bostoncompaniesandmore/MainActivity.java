package com.test.bostoncompaniesandmore;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button addDataButton = (Button) findViewById(R.id.button_add_company_and_employee_info);
        final Button sameCompanyEmployeesButton = (Button) findViewById(R.id.button_employees_working_at_the_same_company);
        Button bostonCompaniesButton = (Button) findViewById(R.id.button_companies_in_Boston);
        Button highestSalaryButton = (Button) findViewById(R.id.button_companies_with_the_highest_salary);

        ListView listViewOfButtonResults = (ListView) findViewById(R.id.listView_results_of_button_click_on_main_activity);


        ArrayList<String> myList = new ArrayList<String>();

        SQLOpenHelper.JOB_TABLE_COLUMNS.getClass();

//        TODO: Finish SimpleCustomAdapter below

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                db.getAllTitles(),
                new String[]{},
                new int[]{android.R.id.text1}, 0);
        ;

        listViewOfButtonResults.setAdapter(cursorAdapter);

        final NewEmployee newEmployee = new NewEmployee();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, AddingCustomDataActivity.class);
                startActivity(intent);


            }


        });

        listViewOfButtonResults.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;


            }
        });


        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLOpenHelper helper = new SQLOpenHelper(MainActivity.this);

                NewEmployee employee1 = new NewEmployee("123-04-5678", "John", "Smith", 1973, "NY");
                NewEmployee employee2 = new NewEmployee("123-04-5679", "David", "McWill", 1982, "Seattle");
                NewEmployee employee3 = new NewEmployee("123-04-5680", "Katerina", "Wise", 1973, "Boston");
                NewEmployee employee4 = new NewEmployee("123-04-5681", "Donald", "Lee", 1992, "London");
                NewEmployee employee5 = new NewEmployee("123-04-5682", "Gary", "Henwood", 1987, "Las Vegas");
                NewEmployee employee6 = new NewEmployee("123-04-5683", "Anthony", "Bright", 1963, "Seattle");
                NewEmployee employee7 = new NewEmployee("123-04-5684", "William", "Newey", 1995, "Boston");
                NewEmployee employee8 = new NewEmployee("123-04-5685", "Melony", "Smith", 1970, "Chicago");

                helper.insertRowIntoEmployeeTable(employee1);
                helper.insertRowIntoEmployeeTable(employee2);
                helper.insertRowIntoEmployeeTable(employee3);
                helper.insertRowIntoEmployeeTable(employee4);
                helper.insertRowIntoEmployeeTable(employee5);
                helper.insertRowIntoEmployeeTable(employee6);
                helper.insertRowIntoEmployeeTable(employee7);
                helper.insertRowIntoEmployeeTable(employee8);

                Job job1 = new Job("123-04-5678", "Fuzz",60, 1);
                Job job2 = new Job("123-04-5679", "GA", 70, 2);
                Job job3 = new Job("123-04-5680", "Little Place", 120, 5);
                Job job4 = new Job("123-04-5681", "Macy's", 78, 3);
                Job job5 = new Job("123-04-5682", "New Life", 65, 1);
                Job job6 = new Job("123-04-5683", "Believe", 158, 6);
                Job job7 = new Job("123-04-5684", "Macy's", 200, 8);
                Job job8 = new Job("123-04-5685", "Stop", 299, 12);

                SQLOpenHelper.insertRowIntoJobTable(job1);
                SQLOpenHelper.(job2);
                SQLOpenHelper.insertRowJob(job3);
                SQLOpenHelper.insertRowJob(job4);
                SQLOpenHelper.insertRowJob(job5);
                SQLOpenHelper.insertRowJob(job6);
                SQLOpenHelper.insertRowJob(job7);
                SQLOpenHelper.insertRowJob(job8);
                return null;


            }
        });

        sameCompanyEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        bostonCompaniesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        highestSalaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db;


                String[] columns = new String[]{SQLOpenHelper.COL_COMPANY_NAME};

                int[] viewNames = new int[]{android.R.id.text1};

                Cursor companyCursor = db.query("",null, null, null, null, null, null);

                CursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(MainActivity.this, android.R.layout.simple_list_item_1, Cursor c, columns, viewNames, 0);

                TextView text = (TextView) findViewById(R.id.textView_company_with_highest_salary);
                text.setText("test");


            }
        });

    }


}
