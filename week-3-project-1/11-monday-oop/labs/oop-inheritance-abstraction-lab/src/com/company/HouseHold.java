package com.company;

/**
 * Created by NehaRege on 6/20/16.
 */
public abstract class HouseHold {

    public final double rate = 0.2;
    public double income = 5000;

    private Pet pet;


    public HouseHold(Pet pet) {
        this.pet = pet;
    }

    public void petCare(){
        pet.feed();
        pet.groom();
        pet.playWith();
    }


    public abstract void incomeTax();
    public abstract void income();





}
