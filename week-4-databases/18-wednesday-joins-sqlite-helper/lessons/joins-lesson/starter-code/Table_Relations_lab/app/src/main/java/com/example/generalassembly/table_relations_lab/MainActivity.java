package com.example.generalassembly.table_relations_lab;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView text;
    private TextView singleNameText;
    private CompanyWithTheHighestSalary companyWithTheHighestSalary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.Text_display);

        new AsyncTask<Employee, Void, String>(){
            @Override
            protected String doInBackground(Employee...employees) {

            Employee employee = new Employee("123-04-5678","John","Smith",1973, "NY");
            Employee employee1 = new Employee("123-04-5679","David","McWill",1982,"Seattle");
            Employee employee2 = new Employee( "123-04-5680","Katerina","Wise",1973, "Boston");
            Employee employee3 = new Employee( "123-04-5682","Donald","Lee",1992,"London");
            Employee employee4 = new Employee( "123-04-5683","Gary","Henwood",1987,"Las Vegas");
            Employee employee5 = new Employee( "123-04-5684","Anthony","Bright",1963, "Seattle");
            Employee employee6 = new Employee("123-04-5685","William", "Newey",1995,"Boston");
            Employee employee7 = new Employee("123-04-5686", "Meloney","Smith",1970, "Chicago");

            Job job = new Job("123-04-5678",",Fuzz",60,1);
            Job job1 = new Job("123-04-5679","GA",70, 2);
            Job job2 = new Job("123-04-5680","Little Place",120,5);
            Job job3 = new Job("123-04-5681","Macy's",78,3);
            Job job4 = new Job("123-04-5682","New Life",65,1);
            Job job5 = new Job("123-04-5683","Believe",158,6);
            Job job6 = new Job("123-04-5684","Macy's",200,8);
            Job job7 = new Job("123-04-5685","Stop",299,12);

            Helper helper = Helper.getINSTANCE(MainActivity.this);
            helper.

                return null;
            }
        };


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
