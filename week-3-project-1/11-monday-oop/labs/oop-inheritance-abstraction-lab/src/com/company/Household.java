package com.company;

import java.text.NumberFormat;

/**
 * Created by michaeljeffress on 6/20/16.
 */
public abstract class Household {

    public double hoursPlayed = 0;

    protected double income = 30;
    protected double taxes = .2 * income;

    Household_Iface pet;

    public Household(Household_Iface pet) {
        this.pet = pet;
    }

    public abstract void income();

    public abstract void taxes();

    public void incomeAfterTaxes() {
        double salary = this.income - this.taxes;
        directDepositCheck(salary);
    }

    public void directDepositCheck(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(amount);
        System.out.println(String.format("Deposited %s in total.", moneyString));
    }


}
