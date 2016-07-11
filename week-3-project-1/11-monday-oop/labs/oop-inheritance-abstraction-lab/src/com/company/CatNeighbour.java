package com.company;

/**
 * Created by NehaRege on 6/20/16.
 */
public class CatNeighbour extends HouseHold {

    public CatNeighbour() {
        super(new Cat());
    }

    @Override
    public void incomeTax() {
        double taxPaid = income - rate*income;
        System.out.println("Tax paid by Cat Neighbour: "+taxPaid+"");
    }

    @Override
    public void income() {
        System.out.println("Total income by Cat Neighbour: "+income+"");

        income += income;
    }
}
