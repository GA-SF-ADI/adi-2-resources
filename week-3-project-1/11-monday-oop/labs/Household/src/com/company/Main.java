package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Home[] homes = new Home [2];
        homes[0] = new Apartment(2, 50000, "Dog");
        homes[1] = new House (3, 45000, "Cat");


        for (int i = 0; i < homes.length; i++) {
            homes [i].location();
            homes[i].climate();
            homes[i].getIncome();
            homes[i].payTaxes();
        }

        Pet [] pets = new Pet [2];
        pets[0] = new Bird ();
        pets [1] = new Cat();

        for (int i = 0; i <pets.length; i++) {
            pets[i].speak();
        }

        CareForPet [] petActivities = new CareForPet[2];
        petActivities [0] = new Apartment(2, 50000, "Dog");
        petActivities[0].feedPet(true);
        petActivities[0].groomPet(true);
        petActivities[0].playPet(true);
        petActivities [1] = new House (3, 45000, "Cat");
        petActivities[1].feedPet(true);
        petActivities[1].groomPet(true);
        petActivities[1].playPet(true);

       //hmm why isn't this printing out 6 times... just 3 times
    }





}

