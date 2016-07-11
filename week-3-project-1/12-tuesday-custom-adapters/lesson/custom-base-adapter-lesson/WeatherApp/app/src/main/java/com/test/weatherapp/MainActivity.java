package com.test.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Weather> weatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        weatherList = new ArrayList<>();
        weatherList.add(new Weather("Monday", 100, 50, 70));
        weatherList.add(new Weather("Tuesday", 120, 55, 90));
        weatherList.add(new Weather("Wednesday", 90, 45, 77));
        weatherList.add(new Weather("Thursday", 80, 40, 75));
        weatherList.add(new Weather("Friday",77 ,77 ,77));
        weatherList.add(new Weather("Saturday", 77,77, 77));
        weatherList.add(new Weather("Sunday", 77,77, 77));

        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(MainActivity.this, weatherList);

        listView.setAdapter(customBaseAdapter);

    }
}
