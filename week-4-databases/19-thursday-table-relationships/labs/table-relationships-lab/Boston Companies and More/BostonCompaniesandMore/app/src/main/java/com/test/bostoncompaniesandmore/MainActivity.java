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
        listViewOfButtonResults.setAdapter(cursorAdapter);


        ArrayList<String> myList = new ArrayList<String>();

        SQLOpenHelper.JOB_TABLE_COLUMNS.getClass();

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                db.getAllTitles(),
                new String[]{},
                new int[]{android.R.id.text1}, 0);
        ;


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

                Cursor companyCursor = db.query(,null, null, null, null, null, null);

                CursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(MainActivity.this, android.R.layout.simple_list_item_1, Cursor c, columns, viewNames, 0);

                TextView text = (TextView) findViewById(R.id.textView_company_with_highest_salary);
                text.setText("test");


            }
        });

    }


}
