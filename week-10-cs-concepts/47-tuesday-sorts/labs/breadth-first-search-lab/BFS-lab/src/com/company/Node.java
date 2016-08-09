package com.company;

import java.util.LinkedList;

/**
 * Created by kitty on 8/9/16.
 */
public class Node {

    public char value;
    public LinkedList<Node> children;

    public Node(char value) {
        this.value = value;
    }
}
