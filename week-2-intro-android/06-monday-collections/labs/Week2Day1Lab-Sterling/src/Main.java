

    import java.util.Arrays;
    import java.util.LinkedHashSet;
    import java.util.Set;

    public class Main {


        public static void main(String[] args) {
            //Nothing in the main method will be tested
            int[] sendArray1 = {2, 9, 8, 47, 9};


            Object[] output1 = new Object[4]; //tweak to test various functions
            output1 = removeDuplicatesFromArray(sendArray1); //tweak to test various functions




            for (int i = 0; i < output1.length; i++) {
                System.out.println(output1[i]);
            }


        }


        public static int[] findLargestAndSmallest(int array[]) {

            int minimum = array[0];
            int maximum = array[0];
            int[] outputArray = new int[2];

            for (int i = 0; i < array.length; i++) {

                if (minimum > array[i]) {
                    minimum = array[i];
                }
                if (maximum < array[i]) {
                    maximum = array[i];
                }
                outputArray[0] = minimum;
                outputArray[1] = maximum;

            }
            return outputArray;
        }


        public static Object[] removeDuplicatesFromArray(int[] array) {


            Set<Integer> set = new LinkedHashSet<Integer>();
            for (int i = 0; i < array.length; i++) {
                set.add(array[i]);
            }

            return set.toArray();
        }


        public static int sumOfTwoLargest(int[] array) {

            if (array.length == 0) {
                return 0;
            }
            if (array.length == 1) {
                return array[0];
            }


            Arrays.sort(array);
            int sum = (array[array.length - 1]) + (array[array.length - 2]);
            return sum;
        }
    }






