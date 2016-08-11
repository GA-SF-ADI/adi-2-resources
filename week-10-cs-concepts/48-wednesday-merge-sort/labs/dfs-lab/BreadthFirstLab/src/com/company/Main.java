package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Tree tree = new Tree();
        Character seekValue = 'B';

        Node searchNode = tree.findValueByBfs(seekValue);
        if (searchNode == null) {
            System.out.println("Node not found.");
        } else {
            System.out.println("Found " + seekValue);
        }


        Tree dfsTree = new Tree();
        boolean dfsFound = dfsTree.findValueByDfsIterivtely(seekValue);
        if (dfsFound) {
            System.out.println("Dfs found " + seekValue);
        } else {
            System.out.println("Dfs Node not found.");
        }

        Tree recursTree = new Tree();
        boolean dfsFoundRecursively = recursTree.findValueByDfsRecursively(recursTree.root,seekValue);
        if(dfsFoundRecursively){
            System.out.println("Dfs recursively found "+ seekValue);
        }else{
            System.out.println("Dfs recursive Node not found.");
        }

    }

}

