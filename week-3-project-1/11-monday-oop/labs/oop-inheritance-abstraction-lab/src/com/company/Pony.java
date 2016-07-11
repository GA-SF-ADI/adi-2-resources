package com.company;

/**
 * Created by sterlinggerritz on 6/20/16.
 */



public class Pony implements PetInterface {

    @Override
    public void feed() {
        System.out.println("We fed the pony some carrots and apples");
    }

    @Override
    public void play() {
        System.out.println("We play by galloping around the backyard");
    }

    @Override
    public void groom() {
        System.out.println("When we groom we pick out the pony's hooves");
    }

}