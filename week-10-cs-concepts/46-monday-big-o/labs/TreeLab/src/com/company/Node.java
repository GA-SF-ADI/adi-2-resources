package com.company;

/**
 * Created by kitty on 8/8/16.
 */
public class Node {

    Node left, right;
    int value;

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
