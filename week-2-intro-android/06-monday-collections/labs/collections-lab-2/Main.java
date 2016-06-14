package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Nothing in the main method will be tested


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
        int[] minMaxArray;
        minMaxArray = new int[2];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <array.length ; i++) {
            if(array[i]>max){
                max = array[i];
            }else if(array[i]<min){
                min = array[i];
            }
            minMaxArray[1]=max;
            minMaxArray[0]=min;
        }

        return minMaxArray;
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

    //-------------->changed to int[] from object[]
    public static int[] removeDuplicatesFromArray(int[] array){
        Arrays.sort(array);
        //List<Integer> arrayList = Arrays.asList(array); ??saw this in the lesson
        //i was trying to sort array, then switch to arraylist, then remove the duplicate, change it back to array then return.
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }

        for (int i = 0; i <arrayList.size();  i++) {
            if(arrayList.indexOf(i) == arrayList.indexOf(i+1)){
                arrayList.remove(i);
            }

        }
        int[]sortedArray = arrayList.toArray(new int[arrayList.size()]);
        return sortedArray;


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
        Arrays.sort(array);
        if(array.length == 0){
            return 0;
        }else if(array.length == 1){
            return array[0];
        }else{
            return array.length-1 + array.length-2;
        }

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
        return null;
    }


}
