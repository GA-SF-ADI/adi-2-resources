package InsertionSort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] unsorted = {7, 3, 2, 4, 9, 1, 14, 12};
		int[] sorted = doInsertionSort(unsorted);
		
		for(int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i]);
		}
		
	}

	private static int[] doInsertionSort(int[] input) {
		//Your code here
		int temp;
		for (int i = 1; i <input.length ; i++) {
			for (int j = i; j > 0; j--) {
				if(input[j]<input[j-1]){
					temp = input[j];
					input[j] = input[j-1];
					input[j-1] = temp;
					System.out.println("Swapped " + j + " with " + temp);
				}
			}

		}
		
        return input;
	}
}
