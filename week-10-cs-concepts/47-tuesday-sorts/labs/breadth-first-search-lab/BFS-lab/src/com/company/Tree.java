package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kitty on 8/9/16.
 */
public class Tree {

    private Node root;

    public Tree() {
        createTree();
    }

    public Node getRoot() {
        return root;
    }

    public Node findValueUsingBfs(char seekValue){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        Node curNode;
        while (queue.size()>0) {
            curNode = queue.poll();
            if (curNode.value == seekValue) {
                return curNode;
            } else {
                addChildrenToQueue(queue, curNode);
            }
        }
        return null;
    }

    private void addChildrenToQueue(LinkedList<Node> queue, Node parent) {
        if (parent.children != null) {
            while(parent.children.size()!=0) {
                queue.add(parent.children.poll());
            }
        }
    }

    private void createTree(){
        Node nodeA = new Node('A');
        Node nodeB = new Node('B');
        Node nodeC = new Node('C');
        Node nodeD = new Node('D');
        Node nodeE = new Node('E');
        Node nodeF = new Node('F');
        Node nodeG = new Node('G');
        Node nodeH = new Node('H');
        Node nodeI = new Node('I');
        Node nodeJ = new Node('J');
        Node nodeK = new Node('K');
        Node nodeL = new Node('L');
        Node nodeM = new Node('M');
        Node nodeN = new Node('N');
        Node nodeO = new Node('O');
        Node nodeP = new Node('P');
        Node nodeQ = new Node('Q');
        Node nodeR = new Node('R');
        Node nodeS = new Node('S');
        Node nodeT = new Node('T');
        Node nodeU = new Node('U');
        Node nodeV = new Node('V');
        Node nodeW = new Node('W');
        Node nodeX = new Node('X');
        Node nodeY = new Node('Y');

        //Create/set children for A
        LinkedList<Node> childrenForA = new LinkedList<>();
        childrenForA.add(nodeB);
        childrenForA.add(nodeC);
        childrenForA.add(nodeD);
        setChildren(nodeA, childrenForA);

        //Create/set children for B
        LinkedList<Node> childrenForB = new LinkedList<>();
        childrenForB.add(nodeE);
        childrenForB.add(nodeF);
        childrenForB.add(nodeG);
        setChildren(nodeB, childrenForB);

        //Create/set children for C
        LinkedList<Node> childrenForC = new LinkedList<>();
        childrenForC.add(nodeH);
        setChildren(nodeC, childrenForC);

        //Create/set children for D
        LinkedList<Node> childrenForD = new LinkedList<>();
        childrenForD.add(nodeI);
        childrenForD.add(nodeJ);
        childrenForD.add(nodeK);
        childrenForD.add(nodeL);
        setChildren(nodeD, childrenForD);

        //Create/set children for F
        LinkedList<Node> childrenForF = new LinkedList<>();
        childrenForF.add(nodeM);
        setChildren(nodeF, childrenForF);

        //Create/set children for H
        LinkedList<Node> childrenForH = new LinkedList<>();
        childrenForH.add(nodeN);
        childrenForH.add(nodeO);
        childrenForH.add(nodeP);
        childrenForH.add(nodeQ);
        setChildren(nodeH, childrenForH);

        //Create/set children for L
        LinkedList<Node> childrenForL = new LinkedList<>();
        childrenForL.add(nodeR);
        childrenForL.add(nodeS);
        childrenForL.add(nodeT);
        childrenForL.add(nodeU);
        childrenForL.add(nodeV);
        childrenForL.add(nodeW);
        childrenForL.add(nodeX);
        childrenForL.add(nodeY);
        setChildren(nodeL, childrenForL);

        root = nodeA;
    }

    private static void setChildren(Node root, LinkedList<Node> children){
        if (root == null){
            return;
        }
        root.children = children;
    }

}
