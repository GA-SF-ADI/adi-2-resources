package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Tree tree = new Tree();
        Character seekValue = 'Z';

        Node searchNode = tree.findValueByBfs(seekValue);
        if(searchNode == null){
            System.out.println("Node not found.");
        } else {
            System.out.println("Found "+seekValue);
        }
    }
}
