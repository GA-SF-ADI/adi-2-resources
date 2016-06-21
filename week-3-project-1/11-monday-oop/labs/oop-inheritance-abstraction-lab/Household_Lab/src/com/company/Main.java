package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Pet dog = new Dog();
        Pet cat = new Cat();

        Household hh1 = new Household(4, dog, 0);
        Household hh2 = new Household(3, cat, 0);
        Household hh3 = new Household(5, dog, 0);

        Household[] mCommunity = new Household[3];

        mCommunity[0] = hh1;
        mCommunity[1] = hh2;
        mCommunity[2] = hh3;

        for (int i = 0; i < mCommunity.length; i++) {
            int tempIncome = (int) (Math.random()*100000);
            mCommunity[i].setIncome(tempIncome);
            mCommunity[i].getIncome();
            mCommunity[i].payTax();
            mCommunity[i].getPet().feeding();
            mCommunity[i].getPet().grooming();
            mCommunity[i].getPet().playing();
        }

        Arrays.sort(mCommunity);

        System.out.println("after sorting:");

        for (int i = 0; i < mCommunity.length; i++) {
            mCommunity[i].getIncome();
            mCommunity[i].payTax();
            mCommunity[i].getPet().feeding();
            mCommunity[i].getPet().grooming();
            mCommunity[i].getPet().playing();
        }

    }
}
