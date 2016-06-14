
import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Nothing in the main method will be tested
        int[] array = new int[]{1, 2, 3, 5, 5, 6, 9, 9};
        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 9, 7};

        int[] all = new int[2];

        all = findLargestAndSmallest(array);

        removeDuplicatesFromArray(array);

    }

    /**
     * Question 1: Find the smallest and largest numbers in an array
     * <p>
     * You are given an array of integers, with at least two values.
     * Find the smallest and largest numbers in the array, and pass them back in an array containing two values,
     * the largest and smallest.
     * <p>
     * You MAY ONLY use arrays, not other collections types (ie Lists).
     * <p>
     * YOU CAN'T USE A SORTING METHOD BUILT INTO JAVA
     *
     * @param array An array of integers with at least two values
     * @return An array of integers with two elements, the largest and smallest from the method parameter
     */
    public static int[] findLargestAndSmallest(int array[]) {
//        Integer smallest = Integer.MAX_VALUE;
//        Integer largest = Integer.MIN_VALUE;
        int min = array[0], max = array[0];

        int[] all = new int[2];

        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }
        all[0] = max;
        all[1] = min;
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }
        return all;
    }


    /**
     * Question 2: Remove duplicates from an array
     * <p>
     * You are given an array of ints that might have duplicates. You must remove any duplicates from the array,
     * and return an array that doesn't contain duplicates. The order of the elements in the original array
     * does not need to be kept the same.
     * <p>
     * You MAY use any collections types you wish, but the method must return an array.
     * <p>
     * Example: [1,4,3,2,1] would return, in any order, [1,2,3,4]
     *
     * @param array An array of ints that may or may not include duplicates
     * @return An array of ints that doesn't contain duplicates.
     */
    public static Object[] removeDuplicatesFromArray(int[] array) {

        Arrays.sort(array);
        //int[] newArray = {1,3,5,5,7,9,9};
        Integer[] newArray = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = Integer.valueOf(array[i]);
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(newArray));
        System.out.println(arrayList.get(0) + "\n");

        int j;
        for (int i = 0; i < arrayList.size(); i++) {
            j = i + 1;
            if(j < 8) {
                if (arrayList.get(i) == arrayList.get(j)) {
                    arrayList.remove(j);
                }
            }
        }
        Integer combinedArray[]=arrayList.toArray(new Integer[arrayList.size()]);

        for(int i = 0; i < combinedArray.length; i++) {
            combinedArray[i] = arrayList.get(i);
        }

        for (int i = 0; i < combinedArray.length; i++) {
            System.out.println(combinedArray[i]);
        }
        return combinedArray;
    }

    /**
     * Given an array of integers, return the sum of the two largest values.
     * <p>
     * If the array is empty, return 0.
     * If the array has one value, return that value.
     *
     * @param array An array of integers of any size.
     * @return Sum of the two largest values
     */
    public static int sumOfTwoLargest(int[] array) {
        Arrays.sort(array);

        if(array.length == 0) {
            return 0;
        } else if(array.length == 1) {
            return array[0];
        } else{
            return array[array.length-1] + array[array.length-2];
        }
    }

    //BONUS QUESTION IS BELOW

    /**
     * BONUS:
     * <p>
     * Given two sorted arrays of integers, return a sorted array of the two original arrays merged together.
     * All valid numbers in these arrays are greater than 0.
     * <p>
     * array1 has enough empty space (represented by the value 0) to hold all valid values from the original two arrays
     * combined. The returned array must be array1 with the new values merged in.
     * <p>
     * For example:
     * array1 = [1,4,7,9,0,0,0]
     * array2 = [1,5,11]
     * returned array = [1,1,4,5,7,9,11]
     * <p>
     * No test cases are provided for this method, you will need to test it on your own.
     *
     * @param array1 Array of sorted integers
     * @param array2 Array of sorted integers
     * @return Array of sorted integers, merged from array1 and array2
     */
    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        return null;
    }
}
