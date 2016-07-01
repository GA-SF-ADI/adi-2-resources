package com.example.michaeljeffress.relationshipstweentableslab;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView result;
    private SameWorkPlace sameWorkPlace;
    private BostonLocation bostonLocation;
    private CompanyWithHighestSalary companyWithHighestSalary;
    private TextView singleNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        singleNameText = (TextView) findViewById(R.id.result_text);
        result = (ListView) findViewById(R.id.listView_Main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Button sameWorkplace = (Button) findViewById(R.id.button_employeesAtSameCompany);
        Button bostonLocation = (Button) findViewById(R.id.button_companiesInBoston);
        Button bestPaidCity = (Button) findViewById(R.id.button_companyWithHighestSalary);
        Button addData = (Button) findViewById(R.id.button_add);

        fab.setOnClickListener(this);
        sameWorkplace.setOnClickListener(this);
        bostonLocation.setOnClickListener(this);
        bestPaidCity.setOnClickListener(this);
        addData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fab:
                Intent intent = new Intent(this, DetailActivity.class);
                startActivity(intent);
                break;

            case R.id.button_add:
                addDataToDb();
                break;

            case R.id.button_employeesAtSameCompany:
                if (bostonLocation != null) {
                    bostonLocation.cancel(true);
                }

                if (companyWithHighestSalary != null) {
                    companyWithHighestSalary.cancel(true);
                }

                sameWorkPlace = new SameWorkPlace();
                sameWorkPlace.execute();
                break;

            case R.id.button_companiesInBoston:
                if (sameWorkPlace != null) {
                    sameWorkPlace.cancel(true);
                }

                if (companyWithHighestSalary != null) {
                    companyWithHighestSalary.cancel(true);
                }

                bostonLocation = new BostonLocation();
                bostonLocation.execute();
                break;

            case R.id.button_companyWithHighestSalary:
                if (bostonLocation != null) {
                    bostonLocation.cancel(true);
                }

                if (sameWorkPlace != null) {
                    sameWorkPlace.cancel(true);
                }

                companyWithHighestSalary = new CompanyWithHighestSalary();
                companyWithHighestSalary.execute();
                break;
        }
    }

    private void addDataToDb() {
                EmployeeSQLiteOpenHelper helper = EmployeeSQLiteOpenHelper.getInstance(MainActivity.this);
                Employee employee1 = new Employee("123-04-5678", "John", "Smith", 1973, "NY");
                Employee employee2 = new Employee("123-04-5679", "David", "McWill", 1982, "Seattle");
                Employee employee3 = new Employee("123-04-5680", "Katerina", "Wise", 1973, "Boston");
                Employee employee4 = new Employee("123-04-5681", "Donald", "Lee", 1992, "London");
                Employee employee5 = new Employee("123-04-5682", "Gary", "Henwood", 1987, "Las Vegas");
                Employee employee6 = new Employee("123-04-5683", "Anthony", "Bright", 1963, "Seattle");
                Employee employee7 = new Employee("123-04-5684", "William", "Newey", 1995, "Boston");
                Employee employee8 = new Employee("123-04-5685", "Melony", "Smith", 1970, "Chicago");

                helper.addEmployeeInfo(employee1);
                helper.addEmployeeInfo(employee2);
                helper.addEmployeeInfo(employee3);
                helper.addEmployeeInfo(employee4);
                helper.addEmployeeInfo(employee5);
                helper.addEmployeeInfo(employee6);
                helper.addEmployeeInfo(employee7);
                helper.addEmployeeInfo(employee8);

                Job job1 = new Job("123-04-5678", "Fuzz",60, 1);
                Job job2 = new Job("123-04-5679", "GA", 70, 2);
                Job job3 = new Job("123-04-5680", "Little Place", 120, 5);
                Job job4 = new Job("123-04-5681", "Macys", 78, 3);
                Job job5 = new Job("123-04-5682", "New Life", 65, 1);
                Job job6 = new Job("123-04-5683", "Believe", 158, 6);
                Job job7 = new Job("123-04-5684", "Macys", 200, 8);
                Job job8 = new Job("123-04-5685", "Stop", 299, 12);

                helper.addJobInfo(job1);
                helper.addJobInfo(job2);
                helper.addJobInfo(job3);
                helper.addJobInfo(job4);
                helper.addJobInfo(job5);
                helper.addJobInfo(job6);
                helper.addJobInfo(job7);
                helper.addJobInfo(job8);

    }

    private class SameWorkPlace  {

        @Override
        protected List<String> doInBackground() {
            EmployeeSQLiteOpenHelper helper = EmployeeSQLiteOpenHelper.getInstance(MainActivity.this);
            List<String> employees = helper.getEmployeesAtSameCompany();
            return employees;
        }

        @Override
        protected void onPostExecute(List<String> employees) {
            super.onPostExecute(employees);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                    android.R.layout.simple_list_item_1, employees);
            result.setAdapter(adapter);
        }
    }

    private class BostonLocation {

        @Override
        protected List<String> doInBackground() {
            EmployeeSQLiteOpenHelper helper = EmployeeSQLiteOpenHelper.getInstance(MainActivity.this);
            List<String> companies = helper.getCompaniesInBoston();
            return companies;
        }

        @Override
        protected void onPostExecute(List<String> companies) {
            super.onPostExecute(companies);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                    android.R.layout.simple_list_item_1, companies);
            result.setAdapter(adapter);
        }
    }

    private class CompanyWithHighestSalary {

        @Override
        protected String doInBackground() {
            EmployeeSQLiteOpenHelper helper = EmployeeSQLiteOpenHelper.getInstance(MainActivity.this);
            String city = helper.getCompanyWithHighestSalary();
            return city;
        }

        @Override
        protected void onPostExecute(String city) {
            super.onPostExecute(city);
            singleNameText.setText(city);
        }
    }
}
