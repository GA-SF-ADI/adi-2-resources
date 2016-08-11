package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //testing binary search tree
        Node root = new Node(8);
        BinarySearchTree bst = new BinarySearchTree(root);

        bst.insert(root, 4);
        bst.insert(root, 12);
        bst.insert(root, 6);
        bst.insert(root, 7);

        if(bst.search(root, 6)) {
            System.out.println("found 6");
        }
        if(!bst.search(root, 9)) {
            System.out.println("9 not found");
        }

        //testing linear search
        int[] array = {12, -3, 5, 6, 3, 3, 0, -33, 6, 9, 12, 2};
        System.out.println(linearSearch(array, -33));
        System.out.println(linearSearch(array, 100));

        //testing binary search
        int[] array2 = {-33, -3, 0, 2, 3, 3, 5, 6, 6, 9, 12, 14};
        System.out.println(binarySearch(array2, -0)+"");
        System.out.println(binarySearch(array2, 100)+"");
        System.out.println(binarySearch(array2, 14)+"");
        System.out.println(binarySearch(array2, -33)+"");

        System.out.println(binarySearchRec(array2, -0, 0, array2.length-1));
        System.out.println(binarySearchRec(array2, 100, 0, array2.length-1));
        System.out.println(binarySearchRec(array2, 14, 0, array2.length-1));
        System.out.println(binarySearchRec(array2, -33, 0, array2.length-1));

    }

    //Linear search
    public static int linearSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    //Merge sort
    public static void mergeSort() {

    }

    //Binary search iteratively
    public static int binarySearch(int[] sortedArray, int value) {
        int low = 0;
        int high = sortedArray.length-1;
        while (high - low >= 0) {
            if (value==sortedArray[(high+low)/2]) {
                return (high+low)/2;
            } else if (value>sortedArray[(high+low)/2]) {
                    low = (high+low)/2+1;
            } else if (value<sortedArray[(high+low)/2]) {
                high = (high + low)/2-1;
            }
        }
        return -1;
    }

    public static int binarySearchRec(int[] sortedArray, int value, int low, int high) {
        int mid = (high+low)/2;
        if (sortedArray[mid] == value) {
            return mid;
        } else if (sortedArray[mid] > value && low!=high) {
            return binarySearchRec(sortedArray, value, low, (high+low)/2-1);
        } else if (sortedArray[mid] < value && low!= high) {
            return binarySearchRec(sortedArray, value, (high+low)/2+1, high);
        }
        return -1;
    }
}
