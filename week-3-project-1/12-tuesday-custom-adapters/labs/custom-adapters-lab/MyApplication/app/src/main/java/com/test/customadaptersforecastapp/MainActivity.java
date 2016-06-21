package com.test.customadaptersforecastapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Forecast> forecastList;
    private Context context;
    //private ArrayList<DaysOfTheWeek> daysOfTheWeekList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        forecastList= new ArrayList<>();
        forecastList.add(new Forecast("San Francisco", "77 degrees"));
        forecastList.add(new Forecast("San Francisco", "72 degrees"));
        forecastList.add(new Forecast("San Francisco", "67 degrees"));
        forecastList.add(new Forecast("San Francisco", "70 degrees"));
        forecastList.add(new Forecast("San Francisco", "64 degrees"));
        forecastList.add(new Forecast("San Francisco", "60 degrees"));
        forecastList.add(new Forecast("San Francisco", "62 degrees"));

        /*
        daysOfTheWeekList = new ArrayList<>();
        daysOfTheWeekList.add(new DaysOfTheWeek("Sunday"));
        daysOfTheWeekList.add(new DaysOfTheWeek("Monday"));
        daysOfTheWeekList.add(new DaysOfTheWeek("Tuesday"));
        daysOfTheWeekList.add(new DaysOfTheWeek("Wednesday"));
        daysOfTheWeekList.add(new DaysOfTheWeek("Thursday"));
        daysOfTheWeekList.add(new DaysOfTheWeek("Friday"));
        daysOfTheWeekList.add(new DaysOfTheWeek("Saturday"));

        */


        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(MainActivity.this, forecastList);

        listView.setAdapter(customBaseAdapter);

    }
}
