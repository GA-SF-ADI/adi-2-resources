package com.company;

import java.text.NumberFormat;

/**
 * Created by audreyeso on 6/20/16.
 */
public class Teacher extends Employee{
    public Teacher() {
    }


    public void gradePapers () {
        System.out.println("Grade papers.");
    }

    @Override
    public void whatIsYourJob () {
        System.out.println("Teacher");
    }

    @Override
    public void primaryResponsibility() {

        System.out.println("I take care of students and ensure their success.");

    }

    @Override
    public  void secondaryResponsibility() {

        System.out.println("I plan lessons for students.");

    }

    @Override
    protected void directDepositCheck(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(amount - 50);
        System.out.println(String.format("Deposited %s", moneyString));
    }
}
