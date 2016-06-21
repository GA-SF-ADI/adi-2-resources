package com.test.weatherapp;

/**
 * Created by Jon Kim on 6/21/16.
 */
public class Weather {
    private int high;
    private int low;
    private int day;
    private String dayWeek;


    public Weather(String dayWeek, int high, int low, int day) {
        this.high = high;
        this.low = low;
        this.day = day;
        this.dayWeek = dayWeek;
    }

    public int getHigh() {
        return high;
    }

    public int getDay() {
        return day;
    }

    public int getLow() {
        return low;
    }

    public String getDayWeek() {
        return dayWeek;
    }
}
