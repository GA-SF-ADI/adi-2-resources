

/**
 * Created by sterlinggerritz on 6/20/16.
 */
package com.company;

/**
 * Created by sterlinggerritz on 6/20/16.
 */


public abstract class Household {



    protected double earnings = 0; //default value is zero, then this amount is added to depending on the household object

    private PetInterface animal;

    public Household(PetInterface animal) {
        this.animal = animal;
    }

    public abstract void earnMoney();
    public abstract void garden();

    public void payTaxes() {
        double taxesPaid = .2 * earnings;
        System.out.println("The total amount of money our holdhold earned is " + earnings);
        System.out.println("We had to pay this much in taxes to the IRS :(  " + taxesPaid);
        System.out.println("______________________________________________________");
    }

    public void careForPet() {
        animal.feed();
        animal.play();
        animal.groom();
    }
}