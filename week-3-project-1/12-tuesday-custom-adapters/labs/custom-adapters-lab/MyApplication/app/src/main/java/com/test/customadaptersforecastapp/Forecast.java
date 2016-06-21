package com.test.customadaptersforecastapp;

/**
 * Created by audreyeso on 6/21/16.
 */
public class Forecast {
    String location;
    String temperature;

    public Forecast(String location, String temperature) {
        this.location = location;
        this.temperature = temperature;

    }

    public String getTemperature () {
        return temperature;
    }

    public void setTemperature (int temperature) {
    }

    public String getLocation () {
        return location;
    }

    public void setLocation (String location) {

    }
}
