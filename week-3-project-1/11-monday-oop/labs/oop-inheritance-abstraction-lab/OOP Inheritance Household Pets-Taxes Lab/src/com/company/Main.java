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
        String[] houseHold  = new String[3];
        houseHold[0] = "McDaniels";
        houseHold[1] = "Kayahara";


//        Printing out lines

for(int i = 0; i < ___.length; i++){

    System.out.println("In the " house, " + caringForPet.totalPetCareTrifecta()
    + " " + taxPayment.payTax());

}



        System.out.println(caringForPet.totalPetCareTrifecta());

        System.out.println(taxPayment.payTax());

    }


}