package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Pet dog = new Dog();
        Pet cat = new Cat();

        Household hh1 = new Household(4, dog, 0);
        Household hh2 = new Household(3, cat, 0);
        Household hh3 = new Household(5, dog, 0);

        Community mCommunity = new Community(new ArrayList<>());

        mCommunity.addHousehold(hh1);
        mCommunity.addHousehold(hh2);
        mCommunity.addHousehold(hh3);

        for (int i = 0; i < mCommunity.getSize(); i++) {
            int tempIncome = (int) Math.random()*100000;
            mCommunity.getHousehold(i).getIncome(tempIncome);
            mCommunity.getHousehold(i).payTax();
            mCommunity.getHousehold(i).getPet().feeding();
            mCommunity.getHousehold(i).getPet().grooming();
            mCommunity.getHousehold(i).getPet().playing();
        }


    }
}
