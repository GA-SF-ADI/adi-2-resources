package com.test.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper;

    Button addButton;
    Button plusButton;
    Button sameCompanyEmployeeButton;
    Button bostonCompaniesButton;
    Button companyHighestSalaryButton;
    ListView listView;

    ArrayList<String> employeeNames;   //this is for samecompany listener
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.add_to_database_button);
        plusButton = (Button) findViewById(R.id.plus_button);
        sameCompanyEmployeeButton = (Button) findViewById(R.id.employees_same_company_button);
        bostonCompaniesButton = (Button) findViewById(R.id.boston_companies_button);
        companyHighestSalaryButton = (Button) findViewById(R.id.company_highest_salary);

        listView = (ListView) findViewById(R.id.list_view);




//        CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this,helper.getAllEmployees(),0) {
//            @Override
//            public View newView(Context context, Cursor cursor, ViewGroup parent) {
//                return LayoutInflater.from(context).inflate(R.layout.list_view_layout_cursor_adapter,parent,false);
//            }
//
//            @Override
//            public void bindView(View view, Context context, Cursor cursor) {
//                TextView txt = (TextView) findViewById(R.id.txt1);
//                txt.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_FIRST_EMPLOYEE)));
//            }
//        };
//
//        listView.setAdapter(cursorAdapter);





        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper = DatabaseHelper.getInstance(MainActivity.this);

                Employee employee1 = new Employee("123-04-5678","John","Smith","1973","NY");
                Employee employee2 = new Employee("123-04-5679","David","McWill","1982","Seattle");
                Employee employee3 = new Employee("123-04-5680","Katherine","Wise","1973","Boston");
                Employee employee4 = new Employee("123-04-5681","Donald","Lee","1992","London");
                Employee employee5 = new Employee("123-04-5682","Geary","Henwood","1981","Vegas");
                Employee employee6 = new Employee("123-04-5683","Anthony","Bright","1963","Seattle");
                Employee employee7 = new Employee("123-04-5684","William","Newey","1995","Boston");
                Employee employee8 = new Employee("123-04-5685","Melony","Smith","1970","Chicago");

                helper.insertRowEmployee(employee1);
                helper.insertRowEmployee(employee2);
                helper.insertRowEmployee(employee3);
                helper.insertRowEmployee(employee4);
                helper.insertRowEmployee(employee5);
                helper.insertRowEmployee(employee6);
                helper.insertRowEmployee(employee7);
                helper.insertRowEmployee(employee8);

                Job job1 = new Job("123-04-5678","Fuzz","60","1");
                Job job2 = new Job("123-04-5679","GA","70","2");
                Job job3 = new Job("123-04-5680","Little Place","120","5");
                Job job4 = new Job("123-04-5681","Macy's","78","3");
                Job job5 = new Job("123-04-5682","New Life","65","1");
                Job job6 = new Job("123-04-5683","Believe","158","6");
                Job job7 = new Job("123-04-5684","Macy's","200","8");
                Job job8 = new Job("123-04-5685","Stop","299","12");

                helper.insertRowJob(job1);
                helper.insertRowJob(job2);
                helper.insertRowJob(job3);
                helper.insertRowJob(job4);
                helper.insertRowJob(job5);
                helper.insertRowJob(job6);
                helper.insertRowJob(job7);
                helper.insertRowJob(job8);

            }
        });

        sameCompanyEmployeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeeNames = new ArrayList<String>(helper.employeesAtSameCompany());
                arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,employeeNames);
                


            }
        });


        assert plusButton != null;
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UserInputActivity.class);
                startActivity(intent);
            }
        });

    }

}
