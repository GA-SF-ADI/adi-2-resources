package com.test.myapplication;

/**
 * Created by NehaRege on 6/30/16.
 */
public class Employee {

    String ssn;
    String firstName;
    String lastName;
    String birthYear;
    String city;

    public Employee(String ssn, String firstName, String lastName, String birthYear, String city) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.city = city;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
