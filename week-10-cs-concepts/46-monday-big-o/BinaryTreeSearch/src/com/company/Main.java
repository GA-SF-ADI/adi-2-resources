package com.company;

import sun.tools.tree.Node;

public class Main {

    public static void main(String[] args) {

        CustomBinaryTree customBinaryTree = new CustomBinaryTree(9);
        customBinaryTree.insert(3);
        customBinaryTree.insert(7);
        customBinaryTree.insert(8);
        customBinaryTree.insert(4);

        System.out.println("In Order Traversal");
        customBinaryTree.inOrderTraversal(customBinaryTree.root);

        System.out.println("Pre Order Traversal");
        customBinaryTree.preOrderTraversal(customBinaryTree.root);

        System.out.println("Post Order Traversal");
        customBinaryTree.postOrderTraversal(customBinaryTree.root);

        CustomBinaryTree customBinaryTree2 = new CustomBinaryTree(100);
        customBinaryTree2.insert(5);
        customBinaryTree2.insert(3);
        customBinaryTree2.insert(4);
        customBinaryTree2.insert(10);
        customBinaryTree2.insert(7);
        customBinaryTree2.insert(8);

        System.out.println("In Order Traversal");
        customBinaryTree2.inOrderTraversal(customBinaryTree2.root);

        System.out.println("Pre Order Traversal");
        customBinaryTree2.preOrderTraversal(customBinaryTree2.root);

        System.out.println("Post Order Traversal");
        customBinaryTree2.postOrderTraversal(customBinaryTree2.root);
    }
}
