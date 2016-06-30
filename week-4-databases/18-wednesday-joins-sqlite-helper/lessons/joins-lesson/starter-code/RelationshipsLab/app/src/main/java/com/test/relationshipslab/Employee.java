package com.test.relationshipslab;

/**
 * Created by Jon Kim on 6/30/16.
 */
public class Employee {
    private String firstName;
    private String lastName;
    private int birthYear;
    private String city;
    private String ssn;

    public Employee(String firstName, String lastName, int birthYear, String city, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.city = city;
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getCity() {
        return city;
    }

    public String getSsn() {
        return ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
