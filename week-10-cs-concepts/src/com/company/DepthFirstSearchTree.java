package com.company;

import java.util.Stack;

/**
 * Created by audreyeso on 8/10/16.
 */
public class DepthFirstSearchTree {
    private Node root;

    public DepthFirstSearchTree(int value){
        root = new Node(value);
    }


    public class Node{
        int value;
        Node left, right;

        public Node(int value){
            this.value = value;
        }
    }


    //NO NEED TO CHANGE THIS
    //IT RANDOMLY DECIDES TO INSERT ON THE LEFT OR RIGHT
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


    public boolean depthFirstIterative(int key){

        Stack <Node> mStack = new Stack();

        if(root.value == key) {
            return true;
        } else if (root != null) {
            mStack.push(root);
        }

        while (mStack !=null) {
            Node node = mStack.pop();
            if(node.value == key) {
                return true;
            } else {
                if(node.right != null) {
                    mStack.push(node.right);
                } if (node.left != null) {
                    mStack.push(node.right);
                }
            }
        }
        //TODO: Implement dfs iteratively and return true or false if you found the key
        return false;
    };

}