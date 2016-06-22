package com.example.kitty.weatherforecastlab;

/**
 * Created by kitty on 6/21/16.
 */
public class Weather {
    private int day;
    private String weather;
    private int dayWeather;
    private int dayHigh;
    private int dayLow;

    public Weather(int day, String weather, int dayWeather) {
        this.day = day;
        this.weather = weather;
        this.dayWeather = dayWeather;
        this.dayHigh = dayWeather+5;
        this.dayLow = dayWeather-5;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getDayWeather() {
        return dayWeather;
    }

    public void setDayWeather(int dayWeather) {
        this.dayWeather = dayWeather;
    }

    public int getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(int dayHigh) {
        this.dayHigh = dayHigh;
    }

    public int getDayLow() {
        return dayLow;
    }

    public void setDayLow(int dayLow) {
        this.dayLow = dayLow;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
