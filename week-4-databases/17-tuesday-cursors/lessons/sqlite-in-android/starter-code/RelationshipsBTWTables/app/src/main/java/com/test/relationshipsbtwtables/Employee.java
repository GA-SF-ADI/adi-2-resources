package com.test.relationshipsbtwtables;

/**
 * Created by audreyeso on 6/30/16.
 */
public class Employee {

    private String SSN;
    private String first_name;
    private String last_name;
    private String birth_Year;
    private String city;


    public Employee (String SSN, String first_name, String last_name, String birth_Year,String city){
        this.SSN = SSN;
        this.first_name= first_name;
        this.last_name=last_name;
        this.birth_Year= birth_Year;
        this.city=city;
    }


    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirth_Year() {
        return birth_Year;
    }

    public void setBirth_Year(String birth_Year) {
        this.birth_Year = birth_Year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
