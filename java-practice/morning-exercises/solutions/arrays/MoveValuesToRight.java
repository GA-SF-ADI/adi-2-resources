
public class MoveValuesToRight {

    public static void main(String[] args) {
        int[] a = {0, 5, 0, 3, 0, 1, 6, 0, 0};
        System.out.print("Unsorted array: ");
        print(a);

        int valueToMoveRight = 0;
        int[] sorted = moveValuesToRight(a, valueToMoveRight);
        System.out.print("\nSorted array:   ");
        print(sorted);
    }

    /**
     * Moves the specified value to the right of the array and returns
     * the array. Works if there are duplicate values and does not move them
     * if they're in the correct place.
     *
     * @param inputArr
     * @param moveToRight
     * @return
     */
    private static int[] moveValuesToRight(int[] inputArr, int moveToRight) {
        int leftIndex = 0;
        int rightIndex = inputArr.length - 1;

        while (leftIndex < rightIndex) {
            if (inputArr[rightIndex] == moveToRight)
                rightIndex--;
            else {
                if (inputArr[leftIndex] == moveToRight) {
                    swap(inputArr, leftIndex, rightIndex);
                    rightIndex--;
                }
                leftIndex++;
            }
        }
        return inputArr;
    }

    /**
     * Swap to values in an array using a temp variable
     *
     * Note: i and j are indexes.
     *
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Formatted print method to get the [8, 6, 8] array printed exactly
     * like that
     *
     * @param arr
     */
    private static void print(int[] arr){
        System.out.print("[ ");
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            if (i == arr.length - 1){
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print(" ]");
    }
}
