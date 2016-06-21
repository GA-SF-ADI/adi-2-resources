package com.test.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Day> daysList;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.weather_list);
        daysList = new ArrayList<>();
        daysList.add(new Day("Monday",80,50));
        daysList.add(new Day("Monday",100,80));
        daysList.add(new Day("Monday",85,70));
        daysList.add(new Day("Monday",50,20));
        daysList.add(new Day("Monday",150,140));


        CustomAdapter myAdaper = new CustomAdapter(MainActivity.this,daysList);
        listView.setAdapter(myAdaper);
    }
}
