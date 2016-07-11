package com.example.kitty.tableslab;

import android.content.Context;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addObjectFButton;
    Button addDataButton;
    Button eeAtSameCompanyButton;
    Button companyInBostonButton;
    Button companyHighestSalaryButton;
    ListView resultListView;
    Helper helper;
    CursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = Helper.getInstance(MainActivity.this);

        setViews();

        setEEAdapter(helper.getEmployees());

        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAllData();
                cursorAdapter.changeCursor(helper.getEmployees());
            }
        });

        companyInBostonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setJobAdapter(helper.getCompaniesInBoston());
                //cursorAdapter.changeCursor(helper.getCompaniesInBoston());
            }
        });

        eeAtSameCompanyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEEAdapter(helper.getEEAtSameCompany());
            }
        });

        companyHighestSalaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setJobAdapter(helper.getHighestSalary());
            }
        });
    }

    private void setViews() {
        addObjectFButton = (FloatingActionButton) findViewById(R.id.add_new_object);
        addDataButton = (Button) findViewById(R.id.add_all_data_button);
        eeAtSameCompanyButton = (Button) findViewById(R.id.ees_at_same_company_button);
        companyInBostonButton = (Button) findViewById(R.id.companies_boston_button);
        companyHighestSalaryButton = (Button) findViewById(R.id.company_highest_salary_button);
        resultListView = (ListView) findViewById(R.id.result_list_view);
    }

    private void setEEAdapter(Cursor cursor) {
        helper = Helper.getInstance(this);
        cursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(cursor.getString(cursor.getColumnIndex(Helper.DataEntryEmployee.COLUMN_FIRST_NAME)));
            }
        };
        resultListView.setAdapter(cursorAdapter);
    }

    private void setJobAdapter(Cursor cursor) {
        helper = Helper.getInstance(this);
        cursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(cursor.getString(cursor.getColumnIndex(Helper.DataEntryJob.COLUMN_COMPANY)));
            }
        };
        resultListView.setAdapter(cursorAdapter);
    }

    public void addAllData() {

        helper = Helper.getInstance(this);

        Employee employee1 = new Employee("123-04-5678", "John", "Smith", 1973, "NY");
        Employee employee2 = new Employee("123-04-5679", "David", "McWill", 1982, "Seattle");
        Employee employee3 = new Employee("123-04-5680", "Katerina", "Wise", 1973, "Boston");
        Employee employee4 = new Employee("123-04-5681", "Donald", "Lee", 1992, "London");
        Employee employee5 = new Employee("123-04-5682", "Gary", "Henwood", 1987, "Las Vegas");
        Employee employee6 = new Employee("123-04-5683", "Anthony", "Bright", 1963, "Seattle");
        Employee employee7 = new Employee("123-04-5684", "William", "Newey", 1995, "Boston");
        Employee employee8 = new Employee("123-04-5685", "Melony", "Smith", 1970, "Chicago");

        Job job1 = new Job("123-04-5678", "Fuzz", 60, 1);
        Job job2 = new Job("123-04-5679", "GA", 70, 2);
        Job job3 = new Job("123-04-5680", "Little Place", 120, 5);
        Job job4 = new Job("123-04-5681", "Macys", 78, 3);
        Job job5 = new Job("123-04-5682", "New Life", 65, 1);
        Job job6 = new Job("123-04-5683", "Believe", 158, 6);
        Job job7 = new Job("123-04-5684", "Macys", 200, 8);
        Job job8 = new Job("123-04-5685", "Stop", 299, 12);

        helper.addEmployee(employee1);
        helper.addEmployee(employee2);
        helper.addEmployee(employee3);
        helper.addEmployee(employee4);
        helper.addEmployee(employee5);
        helper.addEmployee(employee6);
        helper.addEmployee(employee7);
        helper.addEmployee(employee8);

        helper.addJob(job1);
        helper.addJob(job2);
        helper.addJob(job3);
        helper.addJob(job4);
        helper.addJob(job5);
        helper.addJob(job6);
        helper.addJob(job7);
        helper.addJob(job8);
    }
}
