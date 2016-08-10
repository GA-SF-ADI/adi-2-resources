package com.company.alex;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int seekValue = 8;
        // Create a new BinaryTree object that we defined in BinaryTree class
        BinaryTree tree = new BinaryTree();

        // Run BFS on the tree. Node the tree has a helper method to run the BFS on itself!
        Node nodeWithValue = tree.findValueUsingBfs(seekValue);
        if (nodeWithValue != null){
            System.out.println("Found node with seekValue " + seekValue);
        } else {
            System.out.println("Failed to find node with seekValue");
        }
    }

}
