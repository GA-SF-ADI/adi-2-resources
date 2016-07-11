package com.company;

/**
 * Created by kitty on 6/20/16.
 */
public class Cat extends Pet {

    public Cat() {
        super();
    }

    @Override
    public void feeding() {
        System.out.println("You fed your cat. She is now full.");
    }

    @Override
    public void grooming() {
        System.out.println("You brushed your cat. She is now fluffy");
    }

    @Override
    public void playing() {
        System.out.println("You rubbed your cat's belly. She is now happy");
    }

}
