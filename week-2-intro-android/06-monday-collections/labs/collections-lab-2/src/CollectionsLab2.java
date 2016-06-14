import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by nolbertoarroyo on 6/13/16.
 */
public class CollectionsLab2 {



        public static void main(String[] args) {
            int[] myArray = new int[5];
            myArray[0]= 1;
            myArray[1]= 2;
            myArray[2]= 3;
            myArray[3]= 4;
            myArray[4]= 5;
            findLargestAndSmallest(myArray);
            removeDuplicatesFromArray(myArray);
            System.out.println(sumOfTwoLargest(myArray));
        }

        /*
         * Question 1: Find the smallest and largest numbers in an array
         *
         * You are given an array
         * of integers, with at least two values.
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

            int min = array[0];// created two ints which start on index 0
            int max = array[0];
            int [] nums = new int[2]; // created new int array containing two positions


            for (int i = 0; i <array.length ; i++) {
                if (min > array[i]){
                    min = array[i];

                }
                if (max < array[i]){
                    max = array[i];


                }

            }
            nums[0] = min;
            nums[1] = max;

            return nums;

        }




        /*
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
        public static Object[] removeDuplicatesFromArray(int[] array){

            HashSet<Integer> mySet= new HashSet<Integer>();//converted array to a set because hashsets don't allow duplicates
            for (int i = 0; i <array.length ; i++) {

                mySet.add(array[i]);
            }
            return mySet.toArray(); //changing set back to array after removing duplicates




        }

        /*
         * Given an array of integers, return the sum of the two largest values.
         *
         * If the array is empty, return 0.
         * If the array has one value, return that value.
         *
         * @param array An array of integers of any size.
         * @return Sum of the two largest values
         */
        public static int sumOfTwoLargest(int[] array){
            Arrays.sort(array); // sort array to then get the top two numbers
            if (array.length == 0){
                return 0;
            }else if (array.length == 1) {
                return array[0];
            } else {
                return array[array.length-1] + array[array.length-2];
            }

        }

        //BONUS QUESTION IS BELOW

        /*
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

        public static int[] mergeSortedArrays(int[] array1, int[] array2){
            return null;
        }
        */
    }

