import java.util.*;

public class Main {
  public static void main(String[] args) {

    int[] testArray1 = new int[]{1, 2, 3, 4, 8, 12};
    int[] testArray2 = new int[]{1, 1, 6, 0, 2};
    int[] testArray3 = new int[]{4, 17, 9, 17, 9};
    System.out.println("Testing findLargestAndSmallest");
    System.out.println("smallest: " + findLargestAndSmallest(testArray1)[0] + " largest: " + findLargestAndSmallest(testArray1)[1]);
    System.out.println("smallest: " + findLargestAndSmallest(testArray2)[0] + " largest: " + findLargestAndSmallest(testArray2)[1]);
    System.out.println("smallest: " + findLargestAndSmallest(testArray3)[0] + " largest: " + findLargestAndSmallest(testArray3)[1]);

    System.out.println("Testing removeDuplicatesFromArray case 1");
    int[] dups1 = removeDuplicatesFromArray(testArray2);
    for(int i = 0; i < dups1.length; i++) {
      System.out.println(dups1[i]);
    }

    System.out.println("Testing removeDuplicatesFromArray case 2");
    int[] dups2 = removeDuplicatesFromArray(testArray3);
    for(int i = 0; i < dups2.length; i++) {
      System.out.println(dups2[i]);
    }


    System.out.println("Testing sumOfTwoLargest");
    System.out.println(sumOfTwoLargest(testArray1));
    System.out.println(sumOfTwoLargest(testArray2));
    System.out.println(sumOfTwoLargest(testArray3));

    System.out.println("Testing mergeSortedArrays case 1");
    int[] result1 = mergeSortedArrays(testArray1,testArray2);
    for(int i = 0; i < result1.length; i++) {
      System.out.println(result1[i]);
    }

    System.out.println("Testing mergeSortedArrays case 2");
    int[] result2 = mergeSortedArrays(testArray2,testArray3);
    for(int i = 0; i < result2.length; i++) {
      System.out.println(result2[i]);
    }


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
    int largest = Integer.MIN_VALUE;
    int smallest = Integer.MAX_VALUE;

    for (int i=0; i<array.length; i++) {
      if (array[i] > largest) {
        largest = array[i];
      }

      if (array[i] < smallest) {
        smallest = array[i];
      }
    }

    return new int[]{smallest,largest};
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
  public static int[] removeDuplicatesFromArray(int[] array){

    if (array.length < 2)
      return array;

    int j = 0;
    int i = 1;

    while (i < array.length) {
      if (array[i] == array[j]) {
        i++;
      } else {
        j++;
        array[j] = array[i];
        i++;
      }
    }

    int[] result = Arrays.copyOf(array, j + 1);

    return result;
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

    if(array.length == 0) {
      return 0;
    } else if(array.length == 1) {
      return array[0];
    } else{
      return array[array.length-1] + array[array.length-2];
    }
  }

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
  public static int[] mergeSortedArrays(int[] a, int[] b)
  {

    int[] answer = new int[a.length + b.length];
    int i = 0, j = 0, k = 0;

    while (i < a.length && j < b.length)
    {
      if (a[i] < b[j])
        answer[k++] = a[i++];

      else
        answer[k++] = b[j++];
    }

    while (i < a.length)
      answer[k++] = a[i++];


    while (j < b.length)
      answer[k++] = b[j++];

    return answer;
  }
}
