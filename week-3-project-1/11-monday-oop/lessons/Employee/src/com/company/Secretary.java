package com.company;

import java.text.NumberFormat;

/**
 * Created by audreyeso on 6/20/16.
 */
public class Secretary extends Employee {

    public Secretary() {

    }

    public void filePapers () {
        System.out.println("File papers");
    }

    @Override
    public void whatIsYourJob () {
        System.out.println("Secretary");
    }

    @Override
    public void primaryResponsibility() {
        System.out.println("I am a secretary.");
    }

    @Override
    public  void secondaryResponsibility() {
        System.out.println("I am in charge of supplies and meetings");
    }

    @Override
    protected void directDepositCheck(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(amount - 100);
        System.out.println(String.format("Deposited %s", moneyString));
    }
}
