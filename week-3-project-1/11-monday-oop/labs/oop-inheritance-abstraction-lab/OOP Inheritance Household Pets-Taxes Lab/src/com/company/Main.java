package com.company;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

public class Main {




    public static void main(String[] args) {


//        Declaring class variables for printing below

        DailyPetCare caringForPet = new DailyPetCare();

        PayingTax taxPayment = new PayingTax(.8, 3832);

//        ArrayList<String> household1 =
        String[] houseHold = new String[2];
        houseHold[0] = "McRoberts";
        houseHold[1] = "Kayahara";


//        Printing out lines

        for (int i = 0; i < houseHold.length; i++) {

            System.out.println(caringForPet.totalPetCareTrifecta()
                    + " have all been done in the " + houseHold[i] + " household!"
                    + " " + taxPayment.payTax());

            System.out.println("");
            System.out.println("");

        }

    }

}