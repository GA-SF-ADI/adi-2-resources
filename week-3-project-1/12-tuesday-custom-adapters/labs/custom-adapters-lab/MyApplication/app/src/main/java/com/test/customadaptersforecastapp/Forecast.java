package com.test.customadaptersforecastapp;

/**
 * Created by audreyeso on 6/21/16.
 */
public class Forecast {
    private String location;
    private String temperature;
    private String dayOfWeek;

    public Forecast(String location, String temperature, String dayOfWeek) {
        this.location = location;
        this.temperature = temperature;
        this.dayOfWeek = dayOfWeek;

    }

    public String getTemperature () {
        return temperature;
    }

    public void setTemperature (String temperature) {
        this.temperature=temperature;
    }

    public String getLocation () {
        return location;
    }

    public void setLocation (String location) {
            this.location=location;
    }

    public String getDayOfWeek () {
        return dayOfWeek;
    }

    public void setDayOfWeek (String dayOfWeek) {
        this.dayOfWeek=dayOfWeek;
    }

}
