package com.company;

import javax.xml.soap.Node;

/**
 * Created by audreyeso on 8/8/16.
 */
public class NodeClass {
    private int value;
    private Node left;
    private Node right;

    public NodeClass(Node node) {

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
