package com.company;

import java.util.ArrayList;


public class Main {
    ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] unsorted = {10, 15, 1, 3, 14, 2, 17, 9, 51, 6, 16, 22, 8};
        bubbleSort(unsorted);

        for (int i = 0; i < unsorted.length; i++) {
            System.out.println(unsorted[i]);
        }
    }

    private static void bubbleSort(int[] unsorted) {
        int temp;

        for (int i = 0; i < unsorted.length; i++) {
            for (int j = 0; j < (unsorted.length - 1); i++){
                if (unsorted[j] > unsorted[j + 1]) {
                    temp = unsorted[j + 1];
                    unsorted[j + 1] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }
    }
}

