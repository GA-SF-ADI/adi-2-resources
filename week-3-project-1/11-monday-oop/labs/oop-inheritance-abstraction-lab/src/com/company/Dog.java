package com.company;

/**
 * Created by nolbertoarroyo on 6/20/16.
 */

//created a class for Dogs which extends the Pet class
public class Dog extends Pet{
    public Dog() {
        super();
    }
    //override methods inherited from the abstract class Pet
    @Override
    public void fed() {
        System.out.println("The Dog ate");

    }

    @Override
    public void groomed() {
        System.out.println("The Dog is groomed");
    }

    @Override
    public void playedWith() {
        System.out.println("The Dog played");


    }


}
