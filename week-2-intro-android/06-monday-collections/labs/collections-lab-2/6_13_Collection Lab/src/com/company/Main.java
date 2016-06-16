package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Nothing in the main method will be tested
        int[] array1 = {3, 4, 9, 1, 9, 4};
        int[] array2 = {3, 3, 3};
        System.out.println(findLargestAndSmallest(array1)[0]);
        System.out.println(findLargestAndSmallest(array1)[1]);
        System.out.println(findLargestAndSmallest(array2)[0]);
        System.out.println(findLargestAndSmallest(array2)[1]);
        System.out.println(removeDuplicatesFromArray(array1));
        System.out.println(removeDuplicatesFromArray(array2));
        System.out.println(sumOfTwoLargest(array1));
        System.out.println(sumOfTwoLargest(array2));

        int[] arrayA = {1,4,7,9,0,0,0};
        int[] arrayB = {1,5,11};
        mergeSortedArrays(arrayA, arrayB);

    }

    /**
     * Question 1: Find the smallest and largest numbers in an array
     *
     * You are given an array of integers, with at least two values.
     * Find the smallest and largest numbers in the array, and pass them back in an array containing two values,
     * the largest and smallest.
     *
     * You MAY ONLY use arrays, not other collections types (ie Lists).
     *
     * YOU CAN'T USE A SORTING METHOD BUILT INTO JAVA
     *
     * @param array An array of integers with at least two values
     * @return An array of integers with two elements, the largest and smallest from the method parameter
     */
    public static int[] findLargestAndSmallest(int array[]){
        int max = Integer.MIN_VALUE; //to make sure this is smaller than any possible max values
        int min = Integer.MAX_VALUE; //to make sure this is larger than any possible min values
        int[] maxAndMin = new int[2];

        if (array[0] > array[1]){
            max = array[0];
            min = array[1];
        } else {
            max = array[1];
            min = array[0];
        }
        if(array.length>2){
            for (int i = 3; i < array.length; i++) {
                if (array[i]>max) {
                    max = array[i];
                }
                if (array[i]<min) {
                    min = array[i];
                }
            }
        }
        maxAndMin[0] = max;
        maxAndMin[1] = min;
        return maxAndMin;
    }


    /**
     * Question 2: Remove duplicates from an array
     *
     * You are given an array of ints that might have duplicates. You must remove any duplicates from the array,
     * and return an array that doesn't contain duplicates. The order of the elements in the original array
     * does not need to be kept the same.
     *
     * You MAY use any collections types you wish, but the method must return an array.
     *
     * Example: [1,4,3,2,1] would return, in any order, [1,2,3,4]
     *
     * @param array An array of ints that may or may not include duplicates
     * @return An array of ints that doesn't contain duplicates.
     */
    public static ArrayList<Integer> removeDuplicatesFromArray(int[] array){
        ArrayList<Integer> noDup = new ArrayList<>();
        noDup.add(array[0]);
        for(int i = 1; i < array.length; i++){
            if (!noDup.contains(array[i])){
                noDup.add(array[i]);
            }
        }
        return noDup;
    }

    /**
     * Given an array of integers, return the sum of the two largest values.
     *
     * If the array is empty, return 0.
     * If the array has one value, return that value.
     *
     * @param array An array of integers of any size.
     * @return Sum of the two largest values
     */
    public static int sumOfTwoLargest(int[] array){
        if(array==null){
            return 0;
        }
        if(array.length==1){
            return array[0];
        }
        Arrays.sort(array);
        return array[array.length-1]+array[array.length-2];
    }

    //BONUS QUESTION IS BELOW

    /**
     * BONUS:
     *
     * Given two sorted arrays of integers, return a sorted array of the two original arrays merged together.
     * All valid numbers in these arrays are greater than 0.
     *
     * array1 has enough empty space (represented by the value 0) to hold all valid values from the original two arrays
     * combined. The returned array must be array1 with the new values merged in.
     *
     * For example:
     *      array1 = [1,4,7,9,0,0,0]
     *      array2 = [1,5,11]
     *      returned array = [1,1,4,5,7,9,11]
     *
     * No test cases are provided for this method, you will need to test it on your own.
     *
     * @param array1 Array of sorted integers
     * @param array2 Array of sorted integers
     * @return Array of sorted integers, merged from array1 and array2
     */
    public static int[] mergeSortedArrays(int[] array1, int[] array2){
        for(int i = 0; i < array2.length; i++){
            array1[array1.length-array2.length+i] = array2[i];

        }
        Arrays.sort(array1);
        for(int j = 0; j < array1.length; j++){
            System.out.println(array1[j]);
        }
        return array1;
    }
}