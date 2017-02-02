package com.example.kitty.treelab;

/**
 * Created by kitty on 8/8/16.
 */
public class CustomBinarySearchTree {

    private Node root;

    public CustomBinarySearchTree(Node root) {
        this.root = root;
    }

    public void add (Node curNode, Node newNode) {
        if(newNode.value<curNode.value) {
            if(curNode.left == null) {
                curNode.left = newNode;
            } else {
                add(curNode.left, newNode);
            }
        } else if(newNode.value>curNode.value) {
            if(curNode.right == null) {
                curNode.right = newNode;
            } else {
                add(curNode.right, newNode);
            }
        } else if(newNode.value==curNode.value) {
            System.out.println("Tree already contain " + newNode.value);
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
        if(someValue == curNode.value) {
            return true;
        } else if (someValue < curNode.value && curNode.left != null) {
            exists(curNode.left, someValue);
        } else if (someValue > curNode.value && curNode.right != null) {
            exists(curNode.right, someValue);
        }
        return false;
    }

}
