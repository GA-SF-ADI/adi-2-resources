package com.company;

/**
 * Created by nolbertoarroyo on 6/20/16.
 */
public class Cat extends Pet {

    public Cat() {
    super();
    }

    @Override
    public void fed() {
        System.out.println("The cat ate");

    }

    @Override
    public void groomed() {
        System.out.println("The Cat is groomed");
    }

    @Override
    public void playedWith() {
        System.out.println("The Cat played");

    }
}
