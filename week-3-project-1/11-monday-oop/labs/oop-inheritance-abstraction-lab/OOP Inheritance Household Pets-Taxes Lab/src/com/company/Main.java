package com.company;

import sun.rmi.runtime.Log;

public class Main {

    public static void main(String[] args) {

        DailyPetCare caringForPet = new DailyPetCare();

        PayingTax taxPayment = new PayingTax(.8, 39329);


        System.out.println(caringForPet.playWithPet());

        System.out.println(taxPayment.payTax());

    }


}