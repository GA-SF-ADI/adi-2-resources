package com.example.hollis.sharedpreferenceexample;

/**
 * Created by hollis on 6/30/16.
 */
public class Weather {
    private String day;

    private int celsius, fahrenheit, kelvin;
    public Weather(String day, int celsius, int fahrenheit, int kelvin) {
        this.day = day;
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
        this.kelvin = kelvin;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getCelsius() {
        return celsius;
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }

    public int getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public int getKelvin() {
        return kelvin;
    }

    public void setKelvin(int kelvin) {
        this.kelvin = kelvin;
    }
}
