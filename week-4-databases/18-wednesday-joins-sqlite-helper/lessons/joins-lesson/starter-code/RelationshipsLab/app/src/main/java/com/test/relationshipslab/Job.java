package com.test.relationshipslab;

/**
 * Created by Jon Kim on 6/30/16.
 */
public class Job {
    private String company;
    private int salary;
    private int exp;
    private String ssn;

    public Job(String company, int salary, int exp, String ssn) {
        this.company = company;
        this.salary = salary;
        this.exp = exp;
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

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
