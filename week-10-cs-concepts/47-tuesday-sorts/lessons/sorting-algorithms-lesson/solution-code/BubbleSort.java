package BubbleSort;

public class BubbleSort {

	public static void main(String[] args) {
		int[] unsorted = {10, 15, 1, 3, 14, 2, 17, 9, 51, 6, 16, 22, 8};
		bubbleSort(unsorted);
		
		for(int i = 0; i < unsorted.length; i++) {
			System.out.println(unsorted[i]);
		}
	}
	
	private static void bubbleSort(int[] unsorted) {
		int temp;
		int swaps;
		for(int i = 1; i < unsorted.length; i++) {
			swaps = 0;
			for(int j = 0; j < unsorted.length - i; j++) {
				if(unsorted[j] > unsorted[j + 1]) {
					temp = unsorted[j+1];
					unsorted[j+1] = unsorted[j];
					unsorted[j] = temp;
					swaps++;
				}
			}
			if(swaps == 0) {
				System.out.println("Quit after pass #" + i + " of " + unsorted.length);
				break;
			}
		}
		
	}

}
