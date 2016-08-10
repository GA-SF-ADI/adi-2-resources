package com.company;

import sun.rmi.runtime.Log;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Character seekValue = 'T';
        // Create a new BinaryTree object that we defined in BinaryTree class
        Tree tree = new Tree();
        Stump stump = new Stump();
        stump.setBranch(17);

        System.out.println("Branches:" + stump.getBranch());



        // Run BFS on the tree. Node the tree has a helper method to run the BFS on itself!
        Node nodeWithValue = tree.findValueUsingBfs(seekValue);
        if (nodeWithValue != null){
            System.out.println("Found node with seekValue " + seekValue);
        } else {
            System.out.println("Failed to find node with seekValue");
        }


    }

    public static class Stump {
        private int branch;

        public  Stump() {
        }

        public int getBranch() {

            return branch;
        }

        public void setBranch(int branch) {
            this.branch = branch;
        }
    }
}
