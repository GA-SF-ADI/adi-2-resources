package com.company;

import java.util.ArrayList;

/**
 * Created by nolbertoarroyo on 8/9/16.
 */
public class Node {
    public char character;
    private ArrayList<Node> children;

    public Node(char character) {
        this.character = character;
        children = new ArrayList<>();

    }
    public void addChildren(Node child){
        children.add(child);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
}
