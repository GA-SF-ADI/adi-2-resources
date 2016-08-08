package com.company;

public class Main {

    private static CustomBinarySearchTree tree;

    public static void main(String[] args) {
	// write your code here
        addNewTree();

    }

    public static void addNewTree() {
        Node node = new Node(null, null, 10);
        tree = new CustomBinarySearchTree(node);

        tree.add(tree.root, 5);
        tree.add(tree.root, 50);
        tree.add(tree.root, 1);
        tree.add(tree.root, 75);
        tree.add(tree.root, 76);
        tree.add(tree.root, 3);
        tree.add(tree.root, 26);
        tree.add(tree.root, 130);
        tree.add(tree.root, 1);

        tree.printInOrder(tree.root);
        tree.printPostOrder(tree.root);
        tree.printPreOrder(tree.root);

        if(tree.exists(tree.root, 75)) {
            System.out.println("Tree contains 75");
        } else {
            System.out.println("Tree does not contain 75");
        }
    }

}
