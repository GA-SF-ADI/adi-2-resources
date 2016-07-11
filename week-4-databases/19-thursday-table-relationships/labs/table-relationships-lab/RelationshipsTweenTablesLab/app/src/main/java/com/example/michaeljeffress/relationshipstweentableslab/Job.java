package com.example.michaeljeffress.relationshipstweentableslab;

/**
 * Created by michaeljeffress on 6/30/16.
 */
public class Job {
    private String ssn;
    private String company;
    private int salary;
    private int experience;

    public Job(String ssn, String company, int salary, int experience) {
        this.ssn = ssn;
        this.company = company;
        this.salary = salary;
        this.experience = experience;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
