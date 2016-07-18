package com.example.hollis.gson_example;

/**
 * Created by audreyeso on 7/18/16.
 */
public class Location {

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    private String city;
    private String country;
    private String region;
}
