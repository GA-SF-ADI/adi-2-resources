package com.company;

import java.util.Stack;

/**
 * Created by sterlinggerritz on 8/10/16.
 */
public class BinaryTree {
    private Node root;

    public BinaryTree(int value){
        root = new Node(value);
    }


    public class Node{
        int value;
        Node left, right;

        public Node(int value){
            this.value = value;
        }
    }


  //created to populate the tree based on the inserted keys in the main method , inserts in the correct order
    //
    public void insert(int value){
        Node curNode = root;
        boolean done = false;

        //compare the value we're inserting to the current node
        while(!done){
            int leftOrRight =(int) Math.random() * 10;
            if (leftOrRight%2==0) {
                //check if there already is a right child
                if (curNode.right == null) {
                    //set the right node to the new value
                    curNode.right = new Node(value);
                    done = true;
                } else {
                    curNode = curNode.right;
                }
            }else{
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



        public  boolean depthFirstIterative(int key) {
            if(root == null){
                return false;
            }
            Stack<Node> stack = new Stack();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node current = stack.pop();

                if(current.value == key){ //'value' characteristic of Node passed in from Main
                    return true;
                }
                if (current.right != null ) {
                    stack.push(current.right);
                }
                if (current.left != null ) {
                    stack.push(current.left);
                }
            }
            return false;
        }





}