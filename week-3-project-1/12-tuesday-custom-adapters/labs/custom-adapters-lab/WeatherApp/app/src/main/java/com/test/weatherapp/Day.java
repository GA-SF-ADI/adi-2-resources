package com.test.weatherapp;

/**
 * Created by nolbertoarroyo on 6/21/16.
 */
public class Day {
    private String day;
    private String temperatureHigh;
    private String temperatureLow;

    public Day(String day, String temperatureHigh, String temperatureLow) {
        this.day = day;
        this.temperatureHigh=temperatureHigh;
        this.temperatureLow=temperatureLow;
    }

    public String getDay() {
        return day;
    }

    public String getTemperatureHigh() {
        return temperatureHigh;
    }


    public String getTemperatureLow() {

        return temperatureLow;
    }

}

