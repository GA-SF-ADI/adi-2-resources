package ly.generalassemb.alex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by alex on 8/9/16.
 */
public class BinaryTree {
    private Node root;

    public BinaryTree() {
        createTree();
    }

    /**
     * Returns the root of the tree
     *
     * @return
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Find the seekValue using Breadth First Search algorithm on
     * this tree using its root!
     *
     * @param seekValue
     * @return
     */
    public Node findValueUsingBfs(int seekValue){
        // TODO: Create queue
        // TODO: Add root to queue

        // TODO: Remove first node from queue and check value
        // TODO:    if no match add children to queue using helper method below

    }

    /**
     * Helper method to add children of the parent node to the queue if they exist
     *
     * @param queue
     * @param parent
     */
    private void addChildrenToQueue(Queue<Node> queue, Node parent) {
        if (parent.left != null) {
            queue.add(parent.left);
        }
        if (parent.right != null) {
            queue.add(parent.right);
        }
    }

    /**
     * Build the tree, link the nodes and return the root
     * @return
     */
    private void createTree(){
        Node nodeA = new Node(1);
        Node nodeB = new Node(2);
        Node nodeC = new Node(3);
        Node nodeD = new Node(4);
        Node nodeE = new Node(5);
        Node nodeF = new Node(6);
        Node nodeG = new Node(7);
        Node nodeH = new Node(8);

        setChildren(nodeA, nodeB, nodeC);
        setChildren(nodeB, nodeD, nodeE);
        setChildren(nodeC, nodeF, nodeG);
        setChildren(nodeE, nodeH, null);

        root = nodeA;
    }

    /**
     * Helper method that takes root node and its children and
     * assigns them correctly. Handles null pointer exception on root.
     *
     * @param root
     * @param left
     * @param right
     */
    private static void setChildren(Node root, Node left, Node right){
        if (root == null){
            return;
        }
        root.left = left;
        root.right = right;
    }
}
