package com.test.weatherforecastapp;

/**
 * Created by NehaRege on 6/21/16.
 */
public class WeatherForecast {
    private String day;
    private String high;
    private String low;

    public WeatherForecast(String day, String high, String low){
        this.day = day;
        this.high = high;
        this.low = low;
    }

    public String getDay() {
        return day;
    }

    public String getLow() {
        return low;
    }

    public String getHigh() {
        return high;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setLow(String low) {
        this.low = low;
    }
}
