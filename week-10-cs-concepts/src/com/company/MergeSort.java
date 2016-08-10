package com.company;

import com.sun.tools.javac.util.ArrayUtils;

/**
 * Created by audreyeso on 8/10/16.
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] numbers  = new int[]{5,12,2,32,-2,-10,-1,100,16,101};


        System.out.println("Unsorted numbers:");
        for (int i=0;i<numbers.length;i++) {
            System.out.println(String.valueOf(numbers[i]));
        }

        numbers = mergeSort(numbers);

        System.out.println("Sorted numbers:");
        for (int i=0;i<numbers.length;i++) {
            System.out.println(String.valueOf(numbers[i]));
        }
    }


    private static int[] mergeSort(int[] nums) {
        //Complete this method first

        int [] arr1 = {0, 1, 2, 3,4};
        int [] arr2 = {6, 7, 8, 9, 10, 11};

        int n = nums.length;
        if (n == 1) {
            return nums;


        }
        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);


        return merge(arr1,arr2);
    }

    private static void merge(int[] first, int[] second){
        //Complete this method second
        int [] result = {};

        while (first.length != 0 && second.length != 0) {
            if(first [0] > second [0]) {
                result.add(second [0]);
                second[0].remove (second[0]);

            } else {
                result.add(first[0]);
                first.remove(first[0]);
            }

            while (first.length != 0) {
                merge(first, second);
            }

            while (second.length != 0) {
                merge(first, second);
            }
            System.out.println(result);
        }

    }

}