package com.company;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;


public class Main {



    public static void main(String[] args) {
	// write your code here

        /*
1. Declare an ArrayList "zoo" and populate it with at least 5 animals.
Iterate over the ArrayList and print out each animal.
Next, use the appropriate Collections method(s) to sort the list alphabetically,
and print out the sorted zoo animals (feel free to use Google and Oracle docs if you aren't sure how!)
*/
        ArrayList<String>zoo = new ArrayList();
        zoo.add("koala");
        zoo.add("zebra");
        zoo.add("snake");
        zoo.add("penguin");
        zoo.add("wolf");
        Collections.sort(zoo); //Used for sorting

        for(int i = 4; i < zoo.size(); i++) {
            System.out.println(zoo);

            /*
            http://stackoverflow.com/questions/708698/how-can-i-sort-a-list-alphabetically
            I found this resource to help sort the animals.
            */

            /*

            2. Declare an array of numbers called nums (type int) with 10 elements.
            Using a loop, populate this array with the first 10 multiples of 17.
            Print the result. Now initialze a new Object called multsOfThree, and populate it
            programmatically with only the multiples from nums that are divisible by 3.
            Print the result. Finally, what if we happened to need very high precision
            for the multsOfThree values? Convert each element in multsOfThree from an int to a
            more appropriate data type given this scenario.
            You may use an Array or ArrayList for the last part.

        */

            int [] nums;
            nums = new int [10];

            nums[0] = 17;
            nums[1] = 17 * 2;
            nums[3] = 17 * 3;
            nums[4] = 17 * 4;
            nums[5] = 17 * 5;
            nums[6] = 17 * 6;
            nums[7] = 17 * 7;
            nums[8] = 17 * 8;
            nums[9] = 17 * 9;

            System.out.println(nums[0]);
            System.out.println(nums[1]);
            System.out.println(nums[2]);
            System.out.println(nums[3]);
            System.out.println(nums[4]);
            System.out.println(nums[5]);
            System.out.println(nums[6]);
            System.out.println(nums[7]);
            System.out.println(nums[8]);
            System.out.println(nums[9]);



            ArrayList<Integer>multsOfThree = new ArrayList();
            multsOfThree.add(17);
            multsOfThree.add(17 *2);
            multsOfThree.add(17 *3);
            multsOfThree.add(17 *4);
            multsOfThree.add(17 *5);
            multsOfThree.add(17 *6);
            multsOfThree.add(17 *7);
            multsOfThree.add(17 *8);
            multsOfThree.add(17 *9);

/*
            if ((multsOfThree) % 3 == 0)) {
                System.out.println(multsOfThree);
                //hmm how do I get this to work?
                //Can't get the double to work or
                // the if statement?

                ArrayList<Double>multsOfThreeAgain = new ArrayList();
                multsOfThreeAgain.add(17);
                multsOfThreeAgain.add(17 *2);
                multsOfThreeAgain.add(17 *3);
                multsOfThreeAgain.add(17 *4);
                multsOfThreeAgain.add(17 *5);
                multsOfThreeAgain.add(17 *6);
                multsOfThreeAgain.add(17 *7);
                multsOfThreeAgain.add(17 *8);
                multsOfThreeAgain.add(17 *9);
*/
                /*
                3. In Android and in Java, we often have Objects that are lists within lists,
                or arrays within arrays. For this last exercise, create an ArrayList of ArrayLists
                to represent 5 categories of groceries (for example, fruits or dairy) and a list of items
                for each category. Populate your ArrayList of ArrayLists with items,
                and print an 'inventory report' of each category and its items using print commands.
            */

                ArrayList<String> groceries = new ArrayList();
                groceries.add("fruit");
                groceries.add("dairy");
                groceries.add("desserts");
                groceries.add("drinks");
                groceries.add("meat");

            ArrayList<String> fruit = new ArrayList();
            fruit.add("watermelon");
            fruit.add("apples");

            ArrayList<String> dairy = new ArrayList();
            dairy.add("milk");
            dairy.add("yogurt");

            ArrayList<String> desserts = new ArrayList();
            desserts.add("chocolate");
            desserts.add("ice cream");

            ArrayList<String> drinks = new ArrayList();
            drinks.add("iced tea");
            drinks.add("lemonade");

            ArrayList<String> meat = new ArrayList();
            meat.add("chicken");
            meat.add("beef");

            System.out.println("Inventory Report");
            System.out.println("fruit:" + fruit);
            System.out.println("dairy:" + dairy);
            System.out.println("desserts:" + desserts);
            System.out.println("drinks:" + drinks);
            System.out.println("meat:" + meat);
            }
        }

    }

