package com.company;

/**
 * Created by audreyeso on 6/20/16.
 */

public abstract class Home {

    int numberOfAdults;
    int income;
    String pet;



    public Home(int numberOfAdults, int income, String pet) {

        this.numberOfAdults = numberOfAdults;
        this.income = income;
        this.pet = pet;

    }

    public abstract void location();
    public abstract void  climate();


    public void getIncome () {
        int x =income * numberOfAdults;
        System.out.println("Your income is " + x + " .");
    }

    public void payTaxes () {
        int y = (income * 20) /100;
        System.out.println("You paid " + y + " in taxes.");
    }
}

