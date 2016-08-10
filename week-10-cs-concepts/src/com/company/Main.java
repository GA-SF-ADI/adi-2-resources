package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        DepthFirstSearchTree binaryTree = new DepthFirstSearchTree(5);

        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(12);
        binaryTree.insert(52);
        binaryTree.insert(39);

        binaryTree.depthFirstIterative(1);
        binaryTree.depthFirstIterative(39);
        binaryTree.depthFirstIterative(2);
        binaryTree.depthFirstIterative(41);

        Tree tree = new Tree();
        Character seekValue = 'Z';

        Node searchedNode = tree.findValueByBfs(seekValue);
        if (searchedNode == null) {
            System.out.println("Could not find value " + seekValue);
        } else {
            System.out.println("Found value " + seekValue);
        }
    }
}

