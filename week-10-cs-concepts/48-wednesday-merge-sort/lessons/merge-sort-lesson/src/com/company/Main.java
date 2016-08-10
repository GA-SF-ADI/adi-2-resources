package com.company;


public class Main {
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

    private static int[] mergeSort(int[] nums){

       //this is the base case check, if its less than one its not going to work. obviously.
        if (nums.length <= 1) {
            return nums;
    }
        //divide in half for the merge sort
        int[] first = new int[nums.length / 2];
        int[] second = new int[nums.length - first.length];
        System.arraycopy(nums, 0, first, 0, first.length);
        System.arraycopy(nums, first.length, second, 0, second.length);

        //merge first and second halves
        mergeSort(first);
        mergeSort(second);


    private static void merge(int[] left, int[] right, int [] arr){
       int leftlength = left.length;
        int rightlength= right.length;
        int i =0, j=0, k=0;
        while(i<leftlength && j <rightlength) {
            if(left[i] <= right [i]) {
                arr [k] =
            }
        }

        }
    }
}
