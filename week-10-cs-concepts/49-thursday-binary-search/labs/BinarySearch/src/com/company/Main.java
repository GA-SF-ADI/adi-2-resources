package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[]list={0,2,4,5,6,2,10,12,15,24,28};
        System.out.println(binarySearch(list,15));
        System.out.println(binarySearchRecurs(list,15,10,0));

    }

    public static int binarySearch(int[]array, int value){
        Arrays.sort(array);
        int low = 0;
        int high = array.length-1;

        while(low<high){
            int mid = (high+low)/2;

            if(array[mid]==value){
                return mid;
            }else if(array[mid]>value){
                high = mid-1;
            }else if(array[mid]<value){
                low = mid+1;
            }
        }
        return -1;
    }

    public static int binarySearchRecurs(int[]array, int value, int high, int low){
        int mid = (low+high)/2;
        Arrays.sort(array);
        if(low==high){
            if(array[mid]==value){
                return mid;
            }else{
                return -1;
            }
        }
        if(array[mid]==value){
            return mid;
        }else if(value<array[mid]){
            high = mid-1;
        }else if(value>array[mid]){
            low = mid+1;
        }

        return binarySearchRecurs(array,value,high,low);
    }


}
