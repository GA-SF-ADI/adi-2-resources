package com.test.bostoncompanies;

/**
 * Created by sterlinggerritz on 7/1/16.
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

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}