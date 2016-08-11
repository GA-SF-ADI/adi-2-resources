package com.company;

/**
 * Created by kitty on 8/11/16.
 */
public class BinarySearchTree {

    protected Node root;

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public void insert(Node n, int value) {
        if (n==null || n.value == value) {
            return;
        } else if (value > n.value) {
            if (n.right == null) {
                n.right = new Node(value);
            } else {
                insert(n.right, value);
            }
        } else if (value < n.value) {
            if (n.left == null) {
                n.left = new Node(value);
            } else {
                insert(n.left, value);
            }
        }
    }

    public boolean search(Node n, int value) {
        if (n==null) {
            return false;
        } else if (n.value == value) {
            return true;
        } else if (value > n.value && n.right != null) {
            return search(n.right, value);
        } else if (value < n.value && n.left != null) {
            return search(n.left, value);
        }
        return false;
    }

    public int minValue(Node n) {
        if (n==null) {
            return -1;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n.value;
    }

    public int maxValue(Node n) {
        if (n==null) {
            return -1;
        }
        while (n.right != null) {
            n = n.right;
        }
        return n.value;
    }
}
