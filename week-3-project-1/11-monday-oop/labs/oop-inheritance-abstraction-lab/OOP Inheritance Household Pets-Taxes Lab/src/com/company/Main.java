package com.company;

import sun.rmi.runtime.Log;

public class Main {

    public static void main(String[] args) {

//        Declaring class variables for printing below

        DailyPetCare caringForPet = new DailyPetCare();

        PayingTax taxPayment = new PayingTax(.8, 39329);


//        Printing out lines


        System.out.println(caringForPet.playWithPet());

        System.out.println(taxPayment.payTax());

    }


}