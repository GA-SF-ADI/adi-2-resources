package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) {

//created a zoo array
        List<String> zoo = new ArrayList<String>();
        zoo.add("giraffe");  //added animals to the array
        zoo.add("monkey");
        zoo.add("lions");
        zoo.add("birds");
        zoo.add("tigers");
//for loop to iterate trough the array list and print out the animals
        for (String unSorted : zoo) {
            System.out.println(unSorted); //printing out animals from array before sort
        }


        Collections.sort(zoo);//sort zoo

        for (String sorted : zoo) {

            System.out.println(sorted); //printing sorted list

        }

        int [] nums = new int[10];

        for (int i = 1; i < nums.length; i++) {
            nums[i] = (i)

        }

    }



}



