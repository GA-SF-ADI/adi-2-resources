package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by michaeljeffress on 8/9/16.
 */
public class Tree {
    private Node root;


    public Tree() {
        createTree();
    }




    /**
     * Find the seekValue using Breadth First Search algorithm on
     * this tree using its root!
     *
     * @param seekValue
     * @return
     */
    public Node findValueUsingBfs(Character seekValue){
        if (root == null){
            return null;
        }
        // Create queue and add root to queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(queue.peek() != null){
            // Node poll() returns null when queue empty where as remove() throws an exception
            Node node = queue.poll();
            if (node == null || node.value == seekValue){
                return node; // Either node was null or we found the value. Either way, we stop looking.
            }

            // We did not find a match for seekValue, add all children to queue if they exist
            addChildrenToQueue(queue, node);
        }
        return null;
    }

    /**
     * Helper method to add children of the parent node to the queue if they exist
     *
     * @param queue
     * @param parent
     */
    private void addChildrenToQueue(Queue<Node> queue, Node parent) {
        if (queue == null || parent == null || parent.children == null){
            return;
        }
        for (Node node : parent.children){
            queue.add(node);
        }
    }

    /**
     * Build the tree, link the nodes and return the root
     * @return
     */
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


        nodeA.children.add(nodeB);
        nodeA.children.add(nodeC);
        nodeA.children.add(nodeD);

        nodeB.children.add(nodeE);
        nodeB.children.add(nodeF);
        nodeB.children.add(nodeG);

        nodeC.children.add(nodeH);

        nodeD.children.add(nodeI);
        nodeD.children.add(nodeJ);
        nodeD.children.add(nodeK);
        nodeD.children.add(nodeL);

        nodeF.children.add(nodeM);

        nodeH.children.add(nodeN);
        nodeH.children.add(nodeO);
        nodeH.children.add(nodeP);
        nodeH.children.add(nodeQ);

        nodeL.children.add(nodeR);
        nodeL.children.add(nodeS);
        nodeL.children.add(nodeT);
        nodeL.children.add(nodeU);
        nodeL.children.add(nodeV);
        nodeL.children.add(nodeW);
        nodeL.children.add(nodeX);
        nodeL.children.add(nodeY);

        root = nodeA;
    }
}
