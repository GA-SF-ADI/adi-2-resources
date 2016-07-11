package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<HouseHold> houseHoldsList = new ArrayList<>();
        houseHoldsList.add(new CatNeighbour());
        houseHoldsList.add(new DogNeighbour());


        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < houseHoldsList.size(); i++) {
                System.out.println("Iteration " + i);
                houseHoldsList.get(i).incomeTax();
                houseHoldsList.get(i).petCare();
                houseHoldsList.get(i).income();
                System.out.println("");

            }
        }

    }
}
