package com.company;

/**
 * Created by kitty on 8/8/16.
 */
public class CustomBinarySearchTree {

    Node root;

    public CustomBinarySearchTree(Node root) {
        this.root = root;
    }

    public void add (Node curNode, int newValue) {
        if(newValue<curNode.value) {
            if(curNode.left == null) {
                curNode.left = new Node(null, null, newValue);
            } else {
                add(curNode.left, newValue);
            }
        } else if(newValue>curNode.value) {
            if(curNode.right == null) {
                curNode.right = new Node(null, null, newValue);
            } else {
                add(curNode.right, newValue);
            }
        } else if(newValue==curNode.value) {
            System.out.println("Tree already contain " + newValue);
        }
    }

    public void printInOrder (Node curNode) {
        if(curNode.left != null) {
            printInOrder(curNode.left);
        }
        System.out.println(curNode.value+"");
        if(curNode.right != null) {
            printInOrder(curNode.right);
        }
    }

    public void printPreOrder (Node curNode) {
        System.out.println(curNode.value+"");
        if(curNode.left != null) {
            printPreOrder(curNode.left);
        }
        if(curNode.right != null) {
            printPreOrder(curNode.right);
        }
    }

    public void printPostOrder (Node curNode) {
        if(curNode.left != null) {
            printPostOrder(curNode.left);
        }
        if(curNode.right != null) {
            printPostOrder(curNode.right);
        }
        System.out.println(curNode.value+"");
    }

    public boolean exists(Node curNode, int someValue) {
        boolean contains = false;
        if(someValue == curNode.value) {
            contains = true;
        } else if (someValue < curNode.value && curNode.left != null) {
            contains = exists(curNode.left, someValue);
        } else if (someValue > curNode.value && curNode.right != null) {
            contains = exists(curNode.right, someValue);
        }
        return contains;
    }

}
