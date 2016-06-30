package com.test.relationshipsbtwtables;

/**
 * Created by audreyeso on 6/30/16.
 */
public class Job {

    private String SSN;
    private String companyName;
    private int salary;
    private int experience;

    public Job (String SSN, String companyName, int salary, int experience ){
        this.SSN=SSN;
        this.companyName=companyName;
        this.salary=salary;
        this.experience=experience;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
