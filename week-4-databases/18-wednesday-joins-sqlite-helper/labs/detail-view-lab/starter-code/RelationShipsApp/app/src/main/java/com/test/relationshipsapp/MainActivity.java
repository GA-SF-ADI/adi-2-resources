package com.test.relationshipsapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView displayListView;
    private CursorAdapter madapter;
    private DatabaseHelper mHelper;
    TextView macys;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        displayListView = (ListView) findViewById(R.id.display_lv);
       mHelper = DatabaseHelper.getInstance(MainActivity.this);


        macys = (TextView)findViewById(R.id.result_tv);
        Button sameCompany = (Button)findViewById(R.id.emp_same_co_button);
        Button companyInBoston = (Button)findViewById(R.id.co_in_boston_button);
        Button highestSalary = (Button)findViewById(R.id.highest_salary_button);
        Button addData = (Button)findViewById(R.id.add_data_button);
        //String result = mHelper.getMacyWorkers();
        //macys.setText(result);

        sameCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sameCursorAdapter();


            }
        });
        companyInBoston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        highestSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertDatabaseValues();

            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, DialogActivity.class);
                startActivity(intent);
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

    public void insertDatabaseValues(){
        Employee employee1 = new Employee("123-04-5678","John","Smith",1973,"NY");
        Employee employee2= new Employee("123-04-5679","David","McWill",1982,"Seattle");
        Employee employee3 = new Employee("123-04-5680","Katerina","Wise",1973,"Boston");
        Employee employee4 = new Employee("123-04-5681","Donald","Lee",1992,"London");
        Employee employee5 = new Employee("123-04-5682","Gary","Henwood",1987,"Las Vegas");
        Employee employee6 = new Employee("123-04-5683","Anthony","Bright",1963,"Seattle");
        Employee employee7 = new Employee("123-04-5684","William","Newey",1996,"Boston");
        Employee employee8 = new Employee("123-04-5685","Melony","Smith",1970,"Chicago");

        DatabaseHelper dp = DatabaseHelper.getInstance(MainActivity.this);
        dp.addEmployeeItem(employee1.getSsn(),employee1.getFirstName(),employee1.getLastName(),employee1.getYearOfBirth(),employee2.getCity());
        dp.addEmployeeItem(employee2.getSsn(),employee2.getFirstName(),employee2.getLastName(),employee2.getYearOfBirth(),employee2.getCity());
        dp.addEmployeeItem(employee3.getSsn(),employee3.getFirstName(),employee3.getLastName(),employee3.getYearOfBirth(),employee3.getCity());
        dp.addEmployeeItem(employee4.getSsn(),employee4.getFirstName(),employee4.getLastName(),employee4.getYearOfBirth(),employee4.getCity());
        dp.addEmployeeItem(employee5.getSsn(),employee5.getFirstName(),employee5.getLastName(),employee5.getYearOfBirth(),employee5.getCity());
        dp.addEmployeeItem(employee6.getSsn(),employee6.getFirstName(),employee6.getLastName(),employee6.getYearOfBirth(),employee6.getCity());
        dp.addEmployeeItem(employee7.getSsn(),employee7.getFirstName(),employee7.getLastName(),employee7.getYearOfBirth(),employee7.getCity());
        dp.addEmployeeItem(employee8.getSsn(),employee8.getFirstName(),employee8.getLastName(),employee8.getYearOfBirth(),employee8.getCity());

        Job job1 = new Job("123-04-5678","Fuzz", 60,1);
        Job job2 = new Job("123-04-5679","GA", 70,2);
        Job job3 = new Job("123-04-5680","Little Place", 120,5);
        Job job4 = new Job("123-04-5681","Macys", 78,3);
        Job job5 = new Job("123-04-5682","New Life", 65,1);
        Job job6 = new Job("123-04-5683","Believe", 158,6);
        Job job7 = new Job("123-04-5684","Macys", 200,8);
        Job job8 = new Job("123-04-5685","Stop", 299,12);

        dp.addJobItem(job1.getSsn(),job1.getCompany(),job1.getSalary(),job1.getExperience());
        dp.addJobItem(job2.getSsn(),job2.getCompany(),job2.getSalary(),job2.getExperience());
        dp.addJobItem(job3.getSsn(),job3.getCompany(),job3.getSalary(),job3.getExperience());
        dp.addJobItem(job4.getSsn(),job4.getCompany(),job4.getSalary(),job4.getExperience());
        dp.addJobItem(job5.getSsn(),job5.getCompany(),job5.getSalary(),job5.getExperience());
        dp.addJobItem(job6.getSsn(),job6.getCompany(),job6.getSalary(),job6.getExperience());
        dp.addJobItem(job7.getSsn(),job7.getCompany(),job7.getSalary(),job7.getExperience());
        dp.addJobItem(job8.getSsn(),job8.getCompany(),job8.getSalary(),job8.getExperience());





    }
    public void sameCursorAdapter(){
        final Cursor cursor1 = mHelper.getEmployeeTable();
        CursorAdapter macyAdapter = new CursorAdapter(MainActivity.this,cursor1,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {

                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                macys.setText(cursor1.getString(cursor1.getColumnIndex(mHelper.getMacyWorkers())));
            }
        };displayListView.setAdapter(macyAdapter);


        }


}
