package com.company;

/**
 * Created by sterlinggerritz on 6/20/16.
 */
public class PonyHousehold extends Household {

    public PonyHousehold() {
        super(new Pony());
    }

    @Override
    public void earnMoney() {
        System.out.println("We are the pony family!");
        System.out.println("************************");
        System.out.println("How we earn money: Charge neighborhood children for pony rides");
        this.earnings += 10;
        System.out.println("How we earn money: Win prize at horseshow");
        this.earnings += 1000;
    }

    @Override
    public void garden() {
        System.out.println("Do some gardening, the pony helped mow the lawn by eating grass.");
        this.earnings += 30; //saved $30 because we did not have to hire a gardener thanks to the pony

}

}
