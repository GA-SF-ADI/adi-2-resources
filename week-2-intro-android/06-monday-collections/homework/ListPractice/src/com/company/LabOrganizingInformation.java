package com.company;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Collection;

import java.lang.reflect.Array;

/**
 * Created by audreyeso on 6/13/16.
 */
public class LabOrganizingInformation {

    public static void main(String[] args) {
        //Nothing in the main method will be tested

        int[] myArray = {1, 2};



        Integer [] myFavoriteNums = {100, 1, 2, 100};
        Integer [] listOfNums = {90, 20, 30};
        Object [] array2 = new Object [4];

       array2 =removeDuplicates(myFavoriteNums);
        for(int i =0; i<myFavoriteNums.length; i++)
        {
            System.out.println(array2[i]);
        }


            System.out.println(sumOfTwoLargest(listOfNums));


    }

    public static void returnNewArray(int[] array) {

        if (array[0] > array[1]) {
            int max = array[0];
            int min = array[1];
            System.out.println("The max is " + max + "and the min is " + min + ".");

        } else {
            int max = array[1];
            int min = array[0];
            System.out.println("The max is " + max + "and the min is " + min + ".");

        }

    }

    public static Object[] removeDuplicates (Integer [] anArray) {

        Arrays.sort(anArray);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Collections.addAll(arrayList,anArray);

        for( int i = 0; i <=anArray.length; i++) {

            if(i == i+1) {
                arrayList.remove(i+1);
            }

        }
        return arrayList.toArray();

        //Do sets have duplicates?
    }

    public static int sumOfTwoLargest (Integer[] myCoolArray) {

        ArrayList<Integer> myArrayList = new ArrayList<Integer>();
        Collections.addAll(myArrayList, myCoolArray);
        Integer maxOne = Collections.max(myArrayList);
        myArrayList.remove(maxOne);
        Integer maxTwo = Collections.max(myArrayList);
        int sum = maxOne + maxTwo;

        return sum;
    }

}


