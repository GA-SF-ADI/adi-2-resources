package com.test.bostoncompanies;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private DBHelper helper;
    private Button addButton;
    private Button topPayerButton;
    private Button bostonButton;
    private Button sameCompanyButton;
    ListView mListView;
     TextView topPayerText;

    private FloatingActionButton fab;
    private CursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = DBHelper.getInstance(MainActivity.this);



        setUpViews();
        setOnClickListeners();}


    private void setOnClickListeners() {

        //When they click Fab button it launches the add item screen
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateDataBase();  //when you click add it populates the database
               cursorAdapter.changeCursor(helper.insertEmployeeRow());
            }
        });


        topPayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setJobAdapter(helper.topPayer());
            }
        });
        bostonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setJobAdapter(helper.getCompaniesInBoston());
            }
        });


        sameCompanyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setEmployeeAdapter(helper.getSameCompany());
            }
        });
    }
    private void setEmployeeAdapter(Cursor cursor) {
        helper = DBHelper.getInstance(this);
        cursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(cursor.getString(cursor.getColumnIndex(DBHelper.DataEntryEmployee.FIRST_NAME)));
            }
        };
        mListView.setAdapter(cursorAdapter);
    }

    private void setJobAdapter(Cursor cursor) {
        helper = DBHelper.getInstance(this);
        cursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                textView.setText(cursor.getString(cursor.getColumnIndex(DBHelper.DataEntryJob.COMPANY)));
            }
        };
        mListView.setAdapter(cursorAdapter);
    }

    private void setUpViews() {
        mListView = (ListView) findViewById(R.id.myListView);
        addButton = (Button) findViewById(R.id.addDataButton);
        topPayerButton = (Button) findViewById(R.id.topPayer);
        bostonButton = (Button) findViewById(R.id.bostonButton);
        sameCompanyButton = (Button) findViewById(R.id.sameCompanyButton);
        topPayerText = (TextView) findViewById(R.id.topPayerTextView);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void populateDataBase() {
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
