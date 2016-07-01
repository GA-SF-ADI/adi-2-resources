package com.test.myapplication;

/**
 * Created by NehaRege on 6/30/16.
 */
public class Job {

    String ssn;
    String company;
    String salary;
    String experience;

    public Job(String ssn, String company, String salary, String experience) {
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
