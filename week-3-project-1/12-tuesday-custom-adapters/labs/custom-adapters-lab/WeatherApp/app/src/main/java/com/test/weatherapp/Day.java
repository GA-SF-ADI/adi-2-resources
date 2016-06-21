package com.test.weatherapp;

/**
 * Created by nolbertoarroyo on 6/21/16.
 */
public class Day {
    private String day;
    private int temperatureHigh;
    private int temperatureLow;

    public Day(String day, int temperatureHigh, int temperatureLow) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getTemperatureHigh() {
        return temperatureHigh;
    }

    public void setTemperatureHigh(int temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    public int getTemperatureLow() {
        return temperatureLow;
    }

    public void setTemperatureLow(int temperatureLow) {
        this.temperatureLow = temperatureLow;
    }
}

