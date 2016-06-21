package com.company;

/**
 * Created by NehaRege on 6/20/16.
 */
public class DogNeighbour extends HouseHold {

    public DogNeighbour() {
        super(new Dog());
    }

    @Override
    public void incomeTax() {
        double taxPaid = income - rate*income;
        System.out.println("Tax paid by Dog Neighbour: "+taxPaid+"");
    }

    @Override
    public void income() {
        income += income;
    }
}
