package com.company;



public class CustomBinaryTree<T> {
    private Node root;




    public class Node {
        private T valDuck;
        private Node right;
        private Node left;

        public Node(T valDuck, Node right, Node left) {
            this.valDuck = valDuck;
            this.right = right;
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }
    }

    public

}

