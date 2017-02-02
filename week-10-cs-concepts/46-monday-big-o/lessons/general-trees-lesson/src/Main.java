/**
 * Created by patrickcummins on 8/8/16.
 */
public class Main {


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(new Node(null, null, 5));
        binaryTree.addNode(new Node(null, null, 6));
        binaryTree.addNode(new Node(null, null, 7));
        binaryTree.addNode(new Node(null, null, 2));
        binaryTree.addNode(new Node(null, null, 1));
        binaryTree.addNode(new Node(null, null, 4));
        binaryTree.addNode(new Node(null, null, 3));

        System.out.println(binaryTree.findNode(3));

        System.out.println("In Order:");
        binaryTree.inOrder(binaryTree.getRoot());
        System.out.println("Pre Order:");
        binaryTree.preOrder(binaryTree.getRoot());
        System.out.println("Post Order:");
        binaryTree.postOrder(binaryTree.getRoot());

    }


}
