package com.company;

import java.util.ArrayList;

/**
 * Created by michaeljeffress on 8/9/16.
 */
public class Node {
    public Character value;
    public ArrayList<Node>children;

    public Node(Character value) {
        this.value = value;
        children = new ArrayList<>();
    }

}
