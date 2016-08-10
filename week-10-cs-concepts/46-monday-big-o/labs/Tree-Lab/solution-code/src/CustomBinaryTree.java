/**
 * Created by hollis on 8/8/16.
 */
public class CustomBinaryTree {
    private Node root;

    public CustomBinaryTree(int value){
        root = new Node(value);
    }


    public class Node{
        int value;
        Node left, right;

        public Node(int value){
            this.value = value;
        }
    }

    public void insert(int value){
        Node curNode = root;
        boolean done = false;
        //compare the value we're inserting to the current node
        while(!done){
            if (curNode.value == value) {
                done = true;
            }//check if the value is bigger or less than the current Node
            else if (value > curNode.value) {
                //check if there already is a right child
                if (curNode.right == null) {
                    //set the right node to the new value
                    curNode.right = new Node(value);
                    done = true;
                } else {
                    curNode = curNode.right;
                }
            }else if (value < curNode.value) {
                //check if there already is a left child
                if (curNode.left == null) {
                    //set the left node to the new value
                    curNode.left = new Node(value);
                    done = true;
                } else {
                    curNode = curNode.left;
                }
            }
        }
    }
    //method to print out an inorder traversal
    public void printInOrder(){
        printInOrder(root);
    }

    //helper method for printInOrder that uses Nodes
    private void printInOrder(Node node){
        if(node==null){
            return;
        }

        //Could check if node.left is null
        //print the left subtree
        printInOrder(node.left);
        //print the current node
        System.out.println(node.value);
        //could check if node.right is nul
        //print the right subtree
        printInOrder(node.right);
    }

    public void printPreOrder(){
        printPreOrder(root);
    }
    private void printPreOrder(Node node){
        if(node==null){
            return;
        }
        //print the current node
        System.out.println(node.value);

        //Could check if node.left is null
        //print the left subtree
        printInOrder(node.left);
        //could check if node.right is nul
        //print the right subtree
        printInOrder(node.right);
    }
}
