package com.company;

/**
 * Created by kitty on 6/20/16.
 */
public class Dog extends Pet {

    public Dog() {
        super();
    }

    @Override
    public void feeding() {
        System.out.println("You fed your dog. She is now full.");
    }

    @Override
    public void grooming() {
        System.out.println("You brushed your dog. She is now fluffy");
    }

    @Override
    public void playing() {
        System.out.println("You played fetch with your dog. She is now tired");
    }
}
