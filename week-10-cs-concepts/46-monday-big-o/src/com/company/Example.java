package com.company;

import java.util.ArrayList;

/**
 * Created by michaeljeffress on 8/8/16.
 */
public class Example {
    Node root;
    public Example(int valDuck){
        root = new Node(valDuck);
    }
    public class Node{
        int valDuck;
        Node left, right;
        public Node(int valDuck){
            this.valDuck = valDuck;
        }
    }
    public void insert(int valDuck){
        Node curNode = root;
        boolean done = false;
        //compare the valDuck we're inserting to the current node
        while(!done){
            if (curNode.valDuck == valDuck) {
                done = true;
            }//check if the valDuck is bigger or less than the current Node
            else if (valDuck > curNode.valDuck) {
                //check if there already is a right child
                if (curNode.right == null) {
                    //set the right node to the new valDuck
                    curNode.right = new Node(valDuck);
                    done = true;
                } else {
                    curNode = curNode.right;
                }
            }else if (valDuck < curNode.valDuck) {
                //check if there already is a left child
                if (curNode.left == null) {
                    //set the left node to the new valDuck
                    curNode.left = new Node(valDuck);
                    done = true;
                } else {
                    curNode = curNode.left;
                }
            }
        }
    }

    public void inOrder () {
        ArrayList<Integer> list = new ArrayList<>();
        Node curNode = root;
        if (curNode.left != null){

        }

    }


    public void preOrder() {

    }

    public void postOrder () {

    }
}
