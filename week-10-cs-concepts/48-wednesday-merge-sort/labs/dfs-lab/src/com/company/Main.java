package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Character seekValue = 'F';

        Tree tree = new Tree();

        Node nodeWithValue = tree.findValueByBfs(seekValue);
        if (nodeWithValue != null) {
            System.out.println("Found node with value ");
        } else {
            System.out.println("didn't find node with value");
        }


        Tree interateTree = new Tree();
        boolean hasValue = interateTree.findValueByDfsIteratively(seekValue);
        if (!hasValue) {
            System.out.println("Found node with value iteratively ");
        } else {
            System.out.println("didn't find node with value iteratively");
        }
        Tree recursiveTree = new Tree();
        boolean ifHasValue = recursiveTree.findValueByDfsRecursively(seekValue);
        if (ifHasValue) {
            System.out.println("Found node with value recursive ");
        } else {
            System.out.println("didn't find node with value recursive");
        }
    }
}

