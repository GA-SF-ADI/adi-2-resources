package com.company;

/**
 * Created by audreyeso on 6/19/16.
 */

/*
 * EXCERSICE 3: See the AlternateTester to see how you should write this class
 *
 * An alternator alternates returning two values everytime it is called.
 * When the alternator is created it is supplied two values
 *
 * What data does it need to remember? These are the fields.
 */


public class Alternator {
    int a;
    int b;
    int previous;

    public Alternator(int a, int b) {
        this.a = a;
        this.b = b;
        previous = b;
    }

    public int alternate() {
        if (previous == a) {
            previous = b;
        } else {
            previous = a;
        }
        return previous;
    }

}

