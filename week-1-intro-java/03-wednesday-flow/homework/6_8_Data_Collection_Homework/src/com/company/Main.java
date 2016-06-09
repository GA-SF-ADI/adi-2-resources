package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //Question 1
        ArrayList<String> zoo = new ArrayList<>();
        zoo.add("rhino");
        zoo.add("tiger");
        zoo.add("penguin");
        zoo.add("lion");
        zoo.add("lemur");
        System.out.println(zoo);
        Collections.sort(zoo);
        System.out.println(zoo);


        //Question 2
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = 17 * (i + 1);
            System.out.println(nums[i] + "");
        }
        ArrayList<Integer> multsOfThree = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (nums[i] % 3 == 0) {
                multsOfThree.add(nums[i]);
            }
        }
        System.out.println(multsOfThree);
        ArrayList<Double> preciseMultsOfThree = new ArrayList<>();
        for (int i = 0; i < multsOfThree.size(); i++) {
            Double temp = multsOfThree.get(i).doubleValue();
            preciseMultsOfThree.add(temp);
        }
        System.out.println(preciseMultsOfThree);


        //Question 3
        ArrayList<ArrayList<String>> groceryList = new ArrayList<>();
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("mango");
        fruits.add("watermelon");
        ArrayList<String> dairy = new ArrayList<>();
        dairy.add("milk");
        dairy.add("yogurt");
        ArrayList<String> meat = new ArrayList<>();
        meat.add("chicken");
        meat.add("beef");
        ArrayList<String> snacks = new ArrayList<>();
        snacks.add("chips");
        ArrayList<String> condiments = new ArrayList<>();
        condiments.add("mustard");
        groceryList.add(fruits);
        groceryList.add(dairy);
        groceryList.add(meat);
        groceryList.add(snacks);
        groceryList.add(condiments);
        System.out.println("Inventory Report:");
        System.out.println("fruits: "+groceryList.get(0));
        System.out.println("dairy: "+groceryList.get(1));
        System.out.println("meat: "+groceryList.get(0));
        System.out.println("snacks: "+groceryList.get(0));
        System.out.println("condiments: "+groceryList.get(0));
    }
}
