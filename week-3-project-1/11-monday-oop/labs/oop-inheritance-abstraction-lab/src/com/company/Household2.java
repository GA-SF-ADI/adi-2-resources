package com.company;

/**
 * Created by michaeljeffress on 6/20/16.
 */
public class Household2 extends Household {


    public Household2() {
        super(new Cat());
    }



    @Override
    public void income() {
        hoursPlayed += 40;
        income = 30 * hoursPlayed;
        taxes = income * .2;
        System.out.println();
        System.out.println("Household 2 has made this much " + income + " in total.");


    }

    @Override
    public void taxes() {
        System.out.println("Household 2 has paid this much " + taxes + " in taxes in total.");


    }

}

