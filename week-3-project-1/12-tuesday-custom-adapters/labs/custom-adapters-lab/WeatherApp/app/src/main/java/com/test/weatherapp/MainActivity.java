package com.test.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Day> daysList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.weather_list);
        daysList = new ArrayList<>();
        daysList.add(new Day("Monday","80","50"));
        daysList.add(new Day("Tuesday","100","80"));
        daysList.add(new Day("Wednesday","85","70"));
        daysList.add(new Day("Thursday","50","20"));
        daysList.add(new Day("Friday","150","140"));


        CustomAdapter myAdapter = new CustomAdapter(MainActivity.this,daysList);
        listView.setAdapter(myAdapter);

    }
}
