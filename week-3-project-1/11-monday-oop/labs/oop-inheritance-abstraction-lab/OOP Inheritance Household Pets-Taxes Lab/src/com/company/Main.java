package com.company;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {


//        Declaring class variables for printing below

        DailyPetCare caringForPet = new DailyPetCare();

        PayingTax taxPayment = new PayingTax(.8, 3832);

//        Creating households

        String[] houseHold = new String[2];
        houseHold[0] = "McRoberts";
        houseHold[1] = "Kayahara";

//        Creating pets

        String[] petType = new String[2];

        petType[0] = "fox";
        petType[1] = "hamster";

        for (int i = 0; i < petType.length; i++) {

            petType[i] = petType[i].toString();
        }


//        Printing out lines

        for (int i = 0; i < houseHold.length; i++) {

            System.out.println(caringForPet.feedPet() + petType[i] + ", " + caringForPet.playWithPet() + petType[i] +
                    ", and " + caringForPet.groomPet() + petType[i] + " have all been done in the " + houseHold[i] + " household!"
                    + " " + taxPayment.payTax() + " They love their " + petType[i] + " so much, that they often spend " +
                    "an extra couple of hours " + caringForPet.playWithPet() + petType[i] + " on Sundays.") ;//<-- Had issues with figuring out how to cast the taxPayment.payTax() double figure to a float...

            System.out.println("");
            System.out.println("");

        }

    }

}