package com.company;

/*
 * EXERCISE 1: complete the LightSwitch so that the LightSwitch
 * behaviors match the comment in main() below
 *
 * Program to test the LightSwitch object methods
 */
public class Main {

    public static void main(String[] args) {

        // create a LightSwitch object
        LightSwitch wallSwitch = new LightSwitch();

        wallSwitch.flip();
        boolean turnedOn = wallSwitch.isOn();
        System.out.println("The wall switch is on. " +turnedOn);  // prints true

        wallSwitch.flip();
        System.out.println("The wall switch is on. " + wallSwitch.isOn());  // prints false

        wallSwitch.flip();
        System.out.println("The wall switch is on. " + wallSwitch.isOn());  // prints true

        wallSwitch.flip();
        System.out.println("The wall switch is on. "  + wallSwitch.isOn());  // prints false

        wallSwitch.colorFlip();
        boolean colorOn = wallSwitch.isColorOn();

        wallSwitch.colorFlip();
        wallSwitch.isColorOn();
        wallSwitch.colorFlip();
        wallSwitch.isColorOn();


    }

}
