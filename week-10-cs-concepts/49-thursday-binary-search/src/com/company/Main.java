package com.company;

import java.util.Arrays;

public class Main {

    int[] array = {1, 2, 3, 4, 5, 6}; //global variable

    public static int linearSearch(int[] myArr, int x) {

        for (int i = 0; i < myArr.length - 1; i++) {
            if (myArr[i] == x) {
                return i;
            }
        }
        return -1;

    }

    public static boolean binarySearch(int x, int[] mArray) {

        Arrays.sort(mArray); //now mArray is sorted

        int low = 0;
        int high = mArray.length - 1;

        while (high > low) {
            int middle = (low + high) / 2;

            if (mArray[middle] < x) {
                low = middle + 1;
            }
            if (mArray[middle] > x) {
                high = middle - 1;
            }
        }
        return false;
    }


    public  boolean binaryRecursion (int low, int high, int target) {

        int middle = (low + high) / 2;

        if (array[middle] == target) {
            return true;
        }
        if (array[middle] < target) {
            low = middle + 1;
        }
        if (array[middle] > target) {
            high = middle - 1;
        }

        binaryRecursion(low, high, target);
        return false;
    }




    public static void main(String[] args) {

        int[] array = {12, -3, 5, 6, 3, 3, 0, -33, 6, 9, 12, 2};

        linearSearch(array, 5);

        System.out.println(binarySearch(6, array));

    }
}
