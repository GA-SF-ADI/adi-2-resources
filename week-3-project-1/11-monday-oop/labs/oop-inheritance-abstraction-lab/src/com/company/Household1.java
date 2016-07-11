package com.company;

/**
 * Created by michaeljeffress on 6/20/16.
 */
public class Household1 extends Household {


    public Household1() {
        super(new Cat());
    }



    @Override
    public void income() {
        hoursPlayed += 40;
        income = 30 * hoursPlayed;
        taxes = income * .2;
        System.out.println();
        System.out.println("Household 1 has made this much " + income + " in total.");



    }

    @Override
    public void taxes() {
        System.out.println("Household 1 has paid this much " + taxes + " in taxes in total.");


    }

}

