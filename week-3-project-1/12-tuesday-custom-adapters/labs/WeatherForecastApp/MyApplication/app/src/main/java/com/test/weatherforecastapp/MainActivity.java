package com.test.weatherforecastapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<WeatherForecast> mainWeatherForecastList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        //adding data

        mainWeatherForecastList = new ArrayList<>();

        mainWeatherForecastList.add(new WeatherForecast("Monday","80","60"));
        mainWeatherForecastList.add(new WeatherForecast("Tuesday","90","61"));
        mainWeatherForecastList.add(new WeatherForecast("Wednesday","70","65"));
        mainWeatherForecastList.add(new WeatherForecast("Thursday","78","58"));
        mainWeatherForecastList.add(new WeatherForecast("Friday","60","45"));

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,mainWeatherForecastList);

        listView.setAdapter(customAdapter);

//        customAdapter.notifyDataSetChanged();


    }
}
