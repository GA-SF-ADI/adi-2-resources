package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code

        char seekValue = 'Z';

        Tree tree = new Tree();

        // Run BFS on the tree. Node the tree has a helper method to run the BFS on itself!
        Node nodeWithValue = tree.findValueUsingBfs(seekValue);
        if (nodeWithValue != null){
            System.out.println("Found node with seekValue " + seekValue);
        } else {
            System.out.println("Failed to find node with seekValue");
        }
    }
}
