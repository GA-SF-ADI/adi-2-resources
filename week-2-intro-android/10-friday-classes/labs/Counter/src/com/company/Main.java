package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Counter myCounter = new Counter();
        myCounter.numOfClicks();
        myCounter.numOfClicks();
        myCounter.numOfClicks();
        myCounter.numOfClicks();
        System.out.println (myCounter.getCount());
        myCounter.reset();
        System.out.println (myCounter.getCount());
    }
}
