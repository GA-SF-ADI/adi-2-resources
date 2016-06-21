package com.company;

/**
 * Created by NehaRege on 6/20/16.
 */
public class Cat implements Pet {
    @Override
    public void feed() {
        System.out.println("Cat fed");
    }

    @Override
    public void groom() {
        System.out.println("cat groomed");
    }

    @Override
    public void playWith() {
        System.out.println("played with cat");
    }
}
