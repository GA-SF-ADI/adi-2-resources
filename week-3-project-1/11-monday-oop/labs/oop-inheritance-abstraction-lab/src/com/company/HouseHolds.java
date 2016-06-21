package com.company;

/**
 * Created by nolbertoarroyo on 6/20/16.
 */
public class HouseHolds implements Taxes{
    private Pet housePet;
    private double income;

    public HouseHolds(double income, Pet housePet) {
        this.income= income;
        this.housePet= housePet;
    }


    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public double taxes(double income) {
        double taxes = this.income * .2;
        return taxes;
    }

    public Pet getHousePet() {
        return housePet;
    }

    public void setHousePet(Pet housePet) {
        this.housePet = housePet;
    }
}
