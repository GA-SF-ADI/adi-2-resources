package com.company;

import java.text.NumberFormat;

/**
 * Created by kitty on 6/20/16.
 */
public class Household implements Comparable<Household> {

    int numMembers;
    Pet pet;
    int income;

    public Household(int numMembers, Pet pet, int income) {
        this.numMembers = numMembers;
        this.pet = pet;
        this.income = income;
    }

    public int getNumMembers() {
        return numMembers;
    }

    public void setNumMembers(int numMembers) {
        this.numMembers = numMembers;
    }

    public Pet getPet() {
        return pet;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int outputIncome() {
        return income;
    }

    public void getIncome() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(this.income);
        System.out.println(String.format("Made %s", moneyString, " in income"));
    }

    public void payTax() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(this.income*0.2);
        System.out.println(String.format("Paid %s", moneyString, " in taxes"));
        int afterTaxIncome = (int) (income * 0.8);
        this.income = afterTaxIncome;
    }

    public int compareTo(Household other) {
        int result = 0;
        if(this.income < other.outputIncome()) {
            result = -1;
        } else if(this.income > other.outputIncome()) {
            result = 1;
        }
        return result;
    }
}
