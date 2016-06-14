package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] array = {20, 500, 30, 10, 2, 1};
        findLargestAndSmallest(array);

        sumOfTwoLargest(array);

        int[] withDuplicates={10,20,20,10,70,30};
        removeDuplicatesFromArray(withDuplicates);

        int[] a1={17,7,9,0,0,0};
        int[] a2= {1,5,11};
        mergeSortedArrays(a1,a2);

    }

    public static int[] findLargestAndSmallest(int array[]) {
        int smallest = smallestNo(array);
        int largest = largestNo(array);
        int[] largestSmallest = {largest, smallest};

        for (int i = 0; i < largestSmallest.length; i++) {
            System.out.println(largestSmallest[i]);
        }
        return largestSmallest;
    }

    public static int largestNo(int[] a) {
        int largest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > largest) {
                largest = a[i];
            }
        }
        return largest;
    }

    public static int smallestNo(int[] a) {
        int smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < smallest) {
                smallest = a[i];
            }
        }
        return smallest;
    }

    public static List<Integer> removeDuplicatesFromArray(int[] array) {

        List<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            intList.add(array[i]);
        }

        int first;
        int second;
//        int[] withDuplicates={10,20,10,20,50,30};
        for(int j=0;j<intList.size();j++) {

            for (int i = 1; i < intList.size(); i++) {
//                first = intList.get(j);
//                second = intList.get(i);
                if (intList.get(j) == intList.get(i)) {
                    intList.remove(i);
                }
            }
        }


//        for(int j=0;j<intList.size();j++) {
//            for (int i = 1; i < intList.size()-1; i++) {
//                if (intList.get(i) == first) {
//                    intList.remove(i);
////                    first = intList.get(i);
//                }
//            }
//        }

        System.out.println("******");
        for(int i=0;i<intList.size();i++){
            System.out.println(intList.get(i));
        }
        return intList;
    }

    public static int sumOfTwoLargest(int[] array){
        int firstLargest=array[0];
        int secondLargest=array[0];
        for(int i=0;i<array.length-2;i++){
            if(array[i+1]>firstLargest ){
                secondLargest=firstLargest;
                firstLargest=array[i+1];
            } else if (array[i+1] > secondLargest){
                secondLargest = array[i+1];
            }
        }
        int sum=firstLargest+secondLargest;
        System.out.println("The sum is: "+sum);
        return sum;
    }

    public static int[] mergeSortedArrays(int[] array1, int[] array2){
        for(int i=(array1.length-array2.length);i<array1.length;i++){
            array1[i]=array1[i]+array2[i-array1.length+array2.length];
        }
        System.out.println("Unsorted array:");
        for(int i=0;i<array1.length;i++) {
            System.out.println(array1[i]);
        }

        int small;
        int large;
        for(int j=0;j<array1.length;j++){
            for(int i=0;i<array1.length-1;i++){
                if(array1[i+1]<array1[i]){
                    small=array1[i+1];
                    large=array1[i];
                    array1[i+1]=large;
                    array1[i]=small;
                }
            }
        }
        System.out.println("sorted array:");
        for(int i=0;i<array1.length;i++) {
            System.out.println(array1[i]);
        }
        return null;
    }
}






