package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Character seekValue = 'K';

        Tree tree = new Tree();

        Node nodeWithValue = tree.findValueByBfs(seekValue);
        if (nodeWithValue != null) {
            System.out.println("Found node with value ");
        } else {
            System.out.println("didn't find node with value");
        }
    }
}

