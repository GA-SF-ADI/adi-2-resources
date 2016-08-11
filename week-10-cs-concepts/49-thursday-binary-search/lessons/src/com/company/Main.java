package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] alexArray = {12, -3, 5, 6, 3, 3, 0, -33, 6, 9, 12, 2};
        Arrays.sort(alexArray);

        int upperbound =12;
        int lowerbound =0;
        int key=9;

        binarySearch(alexArray, lowerbound,upperbound,key);
    }

        public static void binarySearch(int[ ] array, int lowerbound, int upperbound, int key)
        {
            int position;


            // find index of middle position
            position = ( lowerbound + upperbound) / 2;

            while((array[position] != key) && (lowerbound <= upperbound))
            {

                if (array[position] > key)             // If the number is > 9, ..
                {                                              // decrease position by one.
                    upperbound = position - 1;
                }
                else
                {
                    lowerbound = position + 1;    // Else, increase position by one.
                }
                position = (lowerbound + upperbound) / 2;
            }
            if (lowerbound <= upperbound)
            {
                System.out.println("The number was found in array subscript " + position);


            }
            else
                System.out.println("Sorry, the number is not in this array. " );


    }}

