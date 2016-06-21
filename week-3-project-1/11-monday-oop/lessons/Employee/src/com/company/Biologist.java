package com.company;

import java.text.NumberFormat;

/**
 * Created by audreyeso on 6/20/16.
 */
public class Biologist extends Employee{
    public Biologist() {

    }

    public void research() {
        System.out.println("Study cells.");
    }

    @Override
    public void whatIsYourJob () {
        System.out.println("Biologist");
    }

    @Override
    public void primaryResponsibility() {
        System.out.println("I study life and cells.");

    }

    @Override
    public  void secondaryResponsibility() {
        System.out.println("I write about my research.");

    }

    @Override
    protected void directDepositCheck(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(amount + 100);
        System.out.println(String.format("Deposited %s", moneyString));
    }
}
