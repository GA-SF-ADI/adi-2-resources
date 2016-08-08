package com.company;

import javax.xml.soap.Node;

/**
 * Created by audreyeso on 8/8/16.
 */
public class TreeClass {
    private Node root;
    private Node node;
    private Node addNode;
    private Node insertNode;

    public TreeClass(Node node) {

    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node getAddNode() {
        return addNode;
    }

    public void setAddNode(Node addNode) {
        this.addNode = addNode;
    }

    public Node getInsertNode() {
        return insertNode;
    }

    public void setInsertNode(Node insertNode) {
        this.insertNode = insertNode;
    }
}
