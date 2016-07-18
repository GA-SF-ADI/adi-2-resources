package com.example.hollis.gson_example;

/**
 * Created by hollis on 7/18/16.
 */
public class MarvelCharacter {
    private String name;
    private int Age;
    private String power;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public MarvelCharacter(String name, int age, String power) {
        this.name = name;
        Age = age;
        this.power = power;
    }
}
