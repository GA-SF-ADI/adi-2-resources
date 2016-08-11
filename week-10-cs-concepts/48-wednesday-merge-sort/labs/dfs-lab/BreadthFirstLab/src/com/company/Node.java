package com.company;

import java.util.LinkedList;

/**
 * Created by Kyung on 8/9/16.
 */
public class Node {
    public Character value;
    public LinkedList<Node> children;

    public Node(Character value) {
        this.value = value;
        children = new LinkedList<>();
    }

    public LinkedList<Node> getChildren() {
        return children;
    }

    public void addChildren(Node child){
        children.add(child);
    }
}
