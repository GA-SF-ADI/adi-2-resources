package com.example.kitty.weatherforecastlab;

import java.util.ArrayList;

/**
 * Created by kitty on 6/21/16.
 */
public class Forecast {

    private static Forecast forecast = null;
    private static ArrayList<Weather> days;

    public Forecast() {
        days = new ArrayList<>();

    }

    public static Forecast getInstance() {
        if(forecast == null) {
            forecast = new Forecast();
        }
        return forecast;
    }

    public ArrayList<Weather> getDays() {
        return days;
    }

    public void addDay(Weather weather) {
        days.add(weather);
    }

}
