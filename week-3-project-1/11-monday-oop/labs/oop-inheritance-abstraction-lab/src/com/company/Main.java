package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //created dogs and cats for households
        Dog rex = new Dog();
        Dog mo = new Dog();
        Cat youngFluffs = new Cat();
        //created Households objects and started them off with income and a pet
        HouseHolds jones = new HouseHolds(90000.00, rex);

        HouseHolds smith = new HouseHolds(75000.00, youngFluffs);

        HouseHolds reynolds = new HouseHolds(150000.00, mo);
        //created an arrayList to hold the HouseHolds objects, and added the objects to the ArrayList
        ArrayList<HouseHolds> myHouseHolds= new ArrayList<>();
        myHouseHolds.add(jones);
        myHouseHolds.add(smith);
        myHouseHolds.add(reynolds);

        //for loop to print out the households taxes paid and their pets, fed(), groomed(), and playedWith()
        for (HouseHolds houseHolds:myHouseHolds){
            houseHolds.getHousePet();
            houseHolds.getHousePet().fed();
            houseHolds.getHousePet().groomed();
            houseHolds.getHousePet().playedWith();
            System.out.println("Taxes: "+ houseHolds.taxes(houseHolds.getIncome()));

        }


    }
    }


