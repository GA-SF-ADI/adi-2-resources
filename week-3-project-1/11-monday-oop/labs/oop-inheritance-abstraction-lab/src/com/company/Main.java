package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Household> households = new ArrayList<Household>();
        households.add(new Household1());
        households.add(new Household2());


        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < households.size(); j++) {
                households.get(j).income();
                households.get(j).taxes();
                households.get(j).incomeAfterTaxes();
            }
        }
    }
}
