package com.company;

/**
 * Created by NehaRege on 6/20/16.
 */
public class Dog implements Pet {


    @Override
    public void feed() {
        System.out.println("Dog fed");
    }

    @Override
    public void groom() {
        System.out.println("Dog groomed");
    }

    @Override
    public void playWith() {
        System.out.println("played with dog");
    }
}
