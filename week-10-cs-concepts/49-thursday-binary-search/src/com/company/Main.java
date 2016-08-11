package com.company;

public class Main {

    public static int linearSearch(int[] myArr, int x) {

        for (int i = 0; i < myArr.length - 1; i++) {
            if (myArr[i] == x) {
                return i;
            }
        }
        return -1;

    }

    public static boolean binarySearch(int x, int[] mArray) {

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


    public static void main(String[] args) {

        int[] array = {12, -3, 5, 6, 3, 3, 0, -33, 6, 9, 12, 2};

        linearSearch(array, 5);

        System.out.println(binarySearch(6, array));
    }
}
