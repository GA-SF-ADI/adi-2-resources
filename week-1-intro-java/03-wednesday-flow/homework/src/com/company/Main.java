package com.company;

// FYI: I alphebitized the animals by looking a at a similar example on stack overload

import java.util.ArrayList;
import java.util.Collections;

//1) Declare an ArrayList "zoo" and populate it with at least 5 animals. Iterate over the ArrayList and print out each animal.
       // Next, use the appropriate Collections method(s) to sort the list alphabetically, and print out the sorted zoo animals
public class Main {

            public static void main(String[]args){

                String temp;
                ArrayList<String> animalArray= new ArrayList<String>();

                animalArray.add("Coatimundi");
                animalArray.add("Wallabe");
                animalArray.add("Cobra");
                animalArray.add("Wooley Mammoth");
                animalArray.add("Hippo");
                animalArray.add("Panda Bear");
                animalArray.add("Goat");
                animalArray.add("Tucan");

                for(int i=0;i<animalArray.size();i++) {

                    for (int j = i + 1; j < animalArray.size(); j++) {

                        if (animalArray.get(i).compareTo(animalArray.get(j)) < 0) {

                            temp = animalArray.get(i);
                            animalArray.set(i, animalArray.get(j));
                            animalArray.set(j, temp);

                        }
                    }
                }
                Collections.reverse(animalArray); //Im not sure why but my zoo list was printing backwords, so I added this line to reverse it
                System.out.println(animalArray);



                //2) Declare an array of numbers called nums (type int) with 10 elements. Using a loop, populate this array with the first 10 multiples of 17.
                // Print the result. Now initialze a new Object called multsOfThree, and populate it programmatically with only the multiples from nums that are divisible by 3.
                // Print the result. Finally, what if we happened to need very high precision
                // for the multsOfThree values? Convert each element in multsOfThree from an int to a more appropriate data type given this scenario.


               int[] nums = new int[10];
              for (int i = 0; i < nums.length ; i++) {
                    nums[i] = (i+1)*17;
                }
                System.out.println(nums); //***not sure why my nums array is not printing properly- need to investigate.***


                ArrayList<Integer> multsOfThree = new ArrayList<>();
                for(int i=0; i<nums.length; i++){
                    if(nums[i]%3==0){  //modulus, (if remainder is zero its divisible by 3)
                        multsOfThree.add(nums[i]);
                }
                System.out.println(multsOfThree);  //***I cant make this one work, please help me!***

           }

                //in Android and in Java, we often have Objects that are lists within lists, or arrays within arrays. For this last exercise,
                //create an ArrayList of ArrayLists to represent 5 categories of groceries (for example, fruits or dairy) and a list of items for each category.
               // Populate your ArrayList of ArrayLists with items, and print an 'inventory report' of each category and its items using print commands.

                ArrayList<String> veggies = new ArrayList<String>();
                ArrayList<String> cleaningSupplies = new ArrayList<String>();
                ArrayList<String> junkFood = new ArrayList<String>();
                ArrayList<String> alcohol = new ArrayList<String>();

                veggies.add("cucumber");
                veggies.add("tomato");
                veggies.add("squash");

                cleaningSupplies.add("clorox wipes");
                cleaningSupplies.add("sponge");
                cleaningSupplies.add("paper towels");

                alcohol.add("whiskey");
                alcohol.add("beer");
                alcohol.add("vodka");

                junkFood.add("gold fish");
                junkFood.add("twinkies");
                junkFood.add("skittles");

                System.out.println("Inventory of vegetables is as follows: ");
                System.out.println(veggies);

                System.out.println("Inventory of cleaning supplies is as follows: ");
                System.out.println(cleaningSupplies);

                System.out.println("Inventory of junk food is as follows: ");
                System.out.println(junkFood);

                System.out.println("Inventory of alcohol is as follows: ");
                System.out.println(alcohol);



                        }
                    }


