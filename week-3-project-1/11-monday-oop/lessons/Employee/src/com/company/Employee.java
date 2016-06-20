package com.company;


import java.text.NumberFormat;

/**
 * Created by audreyeso on 6/20/16.
 */
public abstract class Employee {

    private double hourlyWage;
    protected double hoursWorked;

    public Employee() {

    }

    public void getPaid(int daysWorked) {
        System.out.println("You get paid for " + daysWorked + " days worked.");
    }

    public void sickDays () {
        System.out.println("You have 10 sick days");
    }

    public void bonus (int extraDaysWorked) {
        System.out.println("You worked" + extraDaysWorked + " so you get a bonus");
    }

    public void whatIsYourJob (){
        System.out.println("Job");
    }

    public Employee(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public abstract void primaryResponsibility();
    public abstract void secondaryResponsibility();

    public void getPaid() {
        double pay = this.hoursWorked * this.hourlyWage;
        directDepositCheck(pay);
    }

    protected void directDepositCheck(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(amount);
        System.out.println(String.format("Deposited %s", moneyString));
    }

}
