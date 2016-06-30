package gg.patrickcummins.relationshiplab;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import static android.R.attr.inset;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper;
    Button addButton, highestSalaryButton, companiesInBostonButton, sameCompanyButton;
    ListView mListView;
    TextView highestSalaryText;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = DatabaseHelper.getInstance(MainActivity.this);



        setUpViews();
        setOnClickListeners();



    }

    private void setOnClickListeners() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivity(intent);
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertRows();
            }
        });
        highestSalaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highestSalaryText.setText(helper.getHighestSalary());

            }
        });
        companiesInBostonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter companiesInBostonAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, helper.getCompaniesInBoston());
                mListView.setAdapter(companiesInBostonAdapter);

            }
        });
        sameCompanyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter sameCompanyAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, helper.getEmployeesAtSameCompany());
                mListView.setAdapter(sameCompanyAdapter);

            }
        });
    }

    private void setUpViews() {
        mListView = (ListView) findViewById(R.id.myListView);
        addButton = (Button) findViewById(R.id.addDataButton);
        highestSalaryButton = (Button) findViewById(R.id.highestSalary);
        companiesInBostonButton = (Button) findViewById(R.id.bostonCompaniesButton);
        sameCompanyButton = (Button) findViewById(R.id.sameCompanyButton);
        highestSalaryText = (TextView) findViewById(R.id.highestSalaryTextView);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void insertRows() {
        helper.insertEmployeeRow(new Employee("123-04-5678", "John", "Smith", "1973", "NY"));
        helper.insertEmployeeRow(new Employee("123-04-5679", "David", "McWill", "1982", "Seattle"));
        helper.insertEmployeeRow(new Employee("123-04-5680", "Katerina", "Wise", "1973", "Boston"));
        helper.insertEmployeeRow(new Employee("123-04-5681", "Donald", "Lee", "1992", "London"));
        helper.insertEmployeeRow(new Employee("123-04-5682", "Gary", "Henwood", "1987", "Las Vegas"));
        helper.insertEmployeeRow(new Employee("123-04-5683", "Anthony", "Bright", "1963", "Seattle"));
        helper.insertEmployeeRow(new Employee("123-04-5684", "William", "Newey", "1995", "Boston"));
        helper.insertEmployeeRow(new Employee("123-04-5685", "Melony", "Smith", "1970", "Chicago"));

        helper.insertJobRow(new Job("123-04-5678", "Fuzz", 60, 1));
        helper.insertJobRow(new Job("123-04-5679", "GA", 70, 2));
        helper.insertJobRow(new Job("123-04-5680", "Little Place", 120, 5));
        helper.insertJobRow(new Job("123-04-5681", "Macys", 78, 3));
        helper.insertJobRow(new Job("123-04-5682", "New Life", 65, 1));
        helper.insertJobRow(new Job("123-04-5683", "Believe", 158, 6));
        helper.insertJobRow(new Job("123-04-5684", "Macys", 200, 8));
        helper.insertJobRow(new Job("123-04-5685", "Stop", 299, 12));
    }
}
