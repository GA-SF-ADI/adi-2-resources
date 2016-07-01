package com.example.generalassembly.table_relations_lab;

/**
 * Created by generalassembly on 6/30/16.
 */
public class Employee {

    private String snn;
    private String FN;
    private String LN;
    private int YOB;
    private String city;
    private int salary;
    private int experience;
    private String company;

    public Employee( String snn, String FN, String LN, int YOB, String city) {
        this.snn = snn;
        this.FN = FN;
        this.LN = LN;
        this.YOB = YOB;
        this.city = city;
    }

    public String getSnn() {
        return snn;
    }

    public void setSnn(String snn) {
        this.snn = snn;
    }

    public String getFN() {
        return getFN();
    }

    public void setFN(String fn) {
        this.FN= FN;
    }

    public String getLN() {
        return getLN();
    }

    public void setLN(String LN) {
        this.LN = LN;
    }

    public int getYOB() {
        return getYOB();
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getCity() {
        return getCity();
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public int getSalary(){
        return salary;
    }
    public int getExperience(){
        return experience;
    }
    public void setExperience(int experience){
        this.experience = experience;
    }
}
