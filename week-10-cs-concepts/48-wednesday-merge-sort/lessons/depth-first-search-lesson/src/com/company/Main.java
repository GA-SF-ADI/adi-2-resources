package com.company;

public class Main {

        public static void main(String[] args) {
            // write your code here



            //these are the values that get put into insert function in binary tree.  insert orders them properly
            //by checking left, right , whether there are children, or if its null
            BinaryTree binaryTree = new BinaryTree(5);
            binaryTree.insert(1);
            binaryTree.insert(3);
            binaryTree.insert(12);
            binaryTree.insert(52);
            binaryTree.insert(39);
          ;
            binaryTree.depthFirstIterative(39);
            binaryTree.depthFirstIterative(2);
            binaryTree.depthFirstIterative(41);

            //now i am going to send in some numbers that are / are not inserted above and see if the
            //depth first search function in binary tree returns "true/false" accurately like its supposed to
            System.out.println("I put 1 in the tree, do you see it ?"+ " " + binaryTree.depthFirstIterative(1));
            System.out.println("I put 52 in the tree, do you see it ?"+ " " +  binaryTree.depthFirstIterative(52));

            System.out.println(" 100 should not be in any leaves of the tree!  Do you see 100?"+ " " + binaryTree.depthFirstIterative(100));
            System.out.println("13 should not be in any leaves of the tree!  Do you see 13 "+ " " + binaryTree.depthFirstIterative(13));

            //YAY the test above indicates that my deep first search is functioning properly!!

        }
    }