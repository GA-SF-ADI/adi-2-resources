package com.example.kitty.tableslab;

/**
 * Created by kitty on 6/30/16.
 */
public class Employee {

    private String ssn;
    private String first;
    private String last;
    private int yearOfBirth;
    private String city;

    public Employee(String ssn, String first, String last, int yearOfBirth, String city) {
        this.ssn = ssn;
        this.first = first;
        this.last = last;
        this.yearOfBirth = yearOfBirth;
        this.city = city;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
