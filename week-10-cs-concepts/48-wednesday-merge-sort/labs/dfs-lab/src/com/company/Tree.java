package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by nolbertoarroyo on 8/10/16.
 */
public class Tree {
    private Node root;

    public Tree() {
        this.root = createTree();
    }

    public Node findValueByBfs(Character seekValue) {
        if (seekValue == null || root == null) {
            return null;
        }
        Queue<Node> treeQueue = new LinkedList<>();

        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {
            Node node = treeQueue.poll();
            if (node == null || node.character == seekValue) {
                return node;
            }
            if (!node.getChildren().isEmpty()) {
                addChildrenToQueue(treeQueue, node);
            }

        }
        return null;
    }

    public Node createTree() {
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

        nodeA.addChildren(nodeB);
        nodeA.addChildren(nodeC);
        nodeA.addChildren(nodeD);

        nodeB.addChildren(nodeE);
        nodeB.addChildren(nodeF);
        nodeB.addChildren(nodeG);

        nodeF.addChildren(nodeM);

        nodeC.addChildren(nodeH);

        nodeH.addChildren(nodeN);
        nodeH.addChildren(nodeO);
        nodeH.addChildren(nodeP);
        nodeH.addChildren(nodeQ);

        nodeD.addChildren(nodeI);
        nodeD.addChildren(nodeJ);
        nodeD.addChildren(nodeK);
        nodeD.addChildren(nodeL);

        nodeL.addChildren(nodeR);
        nodeL.addChildren(nodeS);
        nodeL.addChildren(nodeT);
        nodeL.addChildren(nodeU);
        nodeL.addChildren(nodeV);
        nodeL.addChildren(nodeW);
        nodeL.addChildren(nodeX);
        nodeL.addChildren(nodeY);

        return nodeA;
    }

    private void addChildrenToQueue(Queue<Node> queue, Node parent) {
        if (queue.isEmpty() || parent.getChildren() == null) {
            return;
        }
        for (Node node : parent.getChildren()) {
            queue.add(node);
        }
    }
    public Boolean findValueByDfsIteratively(Character seekValue){

        Stack<Node> treeStack = new Stack<>();
        if (root.character!= seekValue){
            treeStack.push(root);
        }
        while (!treeStack.isEmpty()){
            Node curNode = treeStack.pop();
            if (curNode.character==seekValue){
                return true;
            }else{
                if (curNode.getChildren()!=null);{
                    addChildrenToStack(treeStack,curNode);
                }
            }
        }

      return false;

    }
    public Boolean findValueByDfsRecursively(Character seekValue){
        

    return false;
    }


    public void addChildrenToStack(Stack<Node> stack,Node node){
        if (node.getChildren()!= null){

            for (int i = 0; i < node.getChildren().size(); i++) {
                stack.push(node.getChildren().get(i));


            }
        }

    }
}
