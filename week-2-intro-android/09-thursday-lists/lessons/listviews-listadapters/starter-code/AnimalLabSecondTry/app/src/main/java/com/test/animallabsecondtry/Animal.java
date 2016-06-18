package com.test.animallabsecondtry;
import java.lang.StringBuilder;
import java.util.ArrayList;

/**
 * Created by audreyeso on 6/18/16.
 */
public class Animal {

    String animalName;
    ArrayList<String> myArray = new ArrayList<String>();


    public Animal(String animalName) {

        this.animalName = animalName;
        this.myArray = myArray;
        myArray.add("bear");
        myArray.add("cow");
    }

    public String getAnimalName(String name) {
        //myArray.add("koala");
        //myArray.add("bear");
        String notName = "That's not correct!";
        String goodTry = "Good try";

        for (int x = 0; x <= myArray.size(); x++) {

            if (myArray.contains(animalName)) {
                return name;
            } else {
                return notName;
            }
        }
        return goodTry;
    }
}



