package com.company;

/**
 * Created by audreyeso on 8/8/16.
 */
public class CustomBinaryTree {
    Node root;

    //public CustomBinaryTree() {}

    public CustomBinaryTree(int value) {
        root = new Node(value);
    }

    public class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;

        }
    }

    public void inOrderTraversal(Node node) {
        if( node.left != null) {
            inOrderTraversal(node.left);
        } System.out.println(node.value);

        if(node.right != null) {
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(Node node) {
        System.out.println(node.value);
        if( node.left != null) {
            inOrderTraversal(node.left);
        }

        if(node.right != null) {
            inOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {

        if( node.left != null) {
            inOrderTraversal(node.left);
        }

        if(node.right != null) {
            inOrderTraversal(node.right);
        }
        System.out.println(node.value);
    }

    public void insert(int value) {
        Node curNode = root;
        boolean done = false;
        //compare the value we're inserting to the current node
        while (!done) {
            if (curNode.value == value) {
                done = true;
            }//check if the value is bigger or less than the current Node
            else if (value > curNode.value) {
                //check if there already is a right child
                if (curNode.right == null) {
                    //set the right node to the new value
                    curNode.right = new Node(value);
                    done = true;
                } else {
                    curNode = curNode.right;
                }
            } else if (value < curNode.value) {
                //check if there already is a left child
                if (curNode.left == null) {
                    //set the left node to the new value
                    curNode.left = new Node(value);
                    done = true;
                } else {
                    curNode = curNode.left;
                }
            }
        }

    }
}