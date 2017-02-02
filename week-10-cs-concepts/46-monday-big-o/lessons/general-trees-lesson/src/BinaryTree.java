/**
 * Created by patrickcummins on 8/8/16.
 */
public class BinaryTree {
    public static Node root;

    public static Node getRoot() {
        return root;
    }

    public static void setRoot(Node root) {
        BinaryTree.root = root;
    }

    public static void addNode(Node newNode) {
        if (root == null) {
            root = newNode;
        } else {
            Node currentNode = root;
            Node parent;
            while (currentNode != null) {
                parent = currentNode;
                if (newNode.getValue() < currentNode.getValue()) {
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parent.setLeft(newNode);
                    }

                } else {
                    currentNode = currentNode.getRight();
                    if (currentNode == null) {
                        parent.setRight(newNode);
                    }

                }
            }
        }

    }

    public static boolean findNode(int i) {
        Node currentNode = root;
        while (currentNode != null) {
            if (i < currentNode.getValue()) {
                currentNode = currentNode.getLeft();

            } else if (i > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else if (i == currentNode.getValue()) {
                return true;
            }
        }
        return false;
    }

    public static void inOrder(Node currentNode){
        if (currentNode != null){
            inOrder(currentNode.getLeft());
            System.out.println(currentNode.getValue());
            inOrder(currentNode.getRight());
        }
    }
    public static void preOrder (Node currentNode){
        if (currentNode != null){
            System.out.println(currentNode.getValue());
            preOrder(currentNode.getLeft());
            preOrder(currentNode.getRight());
        }

    }
    public static void postOrder (Node currentNode){
        if (currentNode != null){
            postOrder(currentNode.getLeft());
            postOrder(currentNode.getRight());
            System.out.println(currentNode.getValue());
        }

    }
}
