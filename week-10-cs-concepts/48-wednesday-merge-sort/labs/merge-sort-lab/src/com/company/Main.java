package com.company;

import javax.swing.tree.DefaultMutableTreeNode;

public class Main {

    public static void main(String[] args) {

        Tree tt = new Tree();
        tt.buildTree();
        tt.setVisible(true);


        Character seekValue = 'z';

        DefaultMutableTreeNode searchedNode = tt.findValueByBfs(seekValue);


        if (searchedNode == null){
            System.out.println("Could not find value " + seekValue);
        } else {
            System.out.println("Found value " + seekValue);
        }
    }
}
