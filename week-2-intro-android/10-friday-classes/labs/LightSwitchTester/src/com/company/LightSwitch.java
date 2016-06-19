package com.company;

/**
 * Created by audreyeso on 6/19/16.
 */
public class LightSwitch {

    boolean turnedOn;
    boolean colorOn;

    public LightSwitch() {
        turnedOn = false;
        colorOn = false;
    }

    public void flip () {
        turnedOn = !turnedOn;
    }

    public boolean isOn() {
        return turnedOn;
    }

    public void colorFlip () {
        colorOn =! colorOn;
        System.out.println("The color is blue.");
    }

    public boolean isColorOn () {
        System.out.println("The color is red.");
        return colorOn;

    }

}