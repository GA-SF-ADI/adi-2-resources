package com.company;

/**
 * Created by audreyeso on 6/19/16.
 */
/*
 * EXCERCISE 2: Write this class and then write CounterTester
 *
 * A counter increments its count every time it is clicked
 * The reset button sets the count to 0
 *
 */

public class Counter {

    int x = 0;
    int numOfClicks;

    public Counter() {

    }

    public void numOfClicks() {
        numOfClicks++;
    }

    public int getCount() {
    return numOfClicks;
    }

    public void reset () {
        numOfClicks = 0;
    }
}

