package com.company;

/**
 * Created by audreyeso on 8/9/16.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] unsorted = {10, 15, 1, 3, 14, 2, 17, 9, 51, 6, 16, 22, 8};

        bubbleSort(unsorted);

        for (int i = 0; i < unsorted.length; i++) {
            System.out.println(unsorted[i]);

        }
    }


    private static void bubbleSort(int[] unsorted) {
        //Your code here. Include a print statement
        //declaring after which pass (iteration through
        //the outside loop) the algorithm. It should be the 9th.
        int n = unsorted.length;
        int temp;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n-1; j++) {

                if (unsorted[j] > unsorted[j + 1]) {
                    temp = unsorted[j + 1];
                    unsorted[j + 1] = unsorted[j];
                    unsorted[j] = temp;

                }
            }

        }
    }
}

