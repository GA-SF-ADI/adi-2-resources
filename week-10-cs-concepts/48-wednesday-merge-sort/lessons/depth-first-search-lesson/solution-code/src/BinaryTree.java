import java.util.Stack;

/**
 * Created by hollis on 8/8/16.
 */
public class BinaryTree {
    private Node root;

    public BinaryTree(int value){
        root = new Node(value);
    }


    public class Node{
        int value;
        Node left, right;

        public Node(int value){
            this.value = value;
        }
    }


    //NO NEED TO CHANGE THIS
    //IT RANDOMLY DECIDES TO INSERT ON THE LEFT OR RIGHT
    //
    public void insert(int value){
        Node curNode = root;
        boolean done = false;

        //compare the value we're inserting to the current node
        while(!done){
            int leftOrRight =(int) Math.random() * 10;
             if (leftOrRight%2==0) {
                //check if there already is a right child
                if (curNode.right == null) {
                    //set the right node to the new value
                    curNode.right = new Node(value);
                    done = true;
                } else {
                    curNode = curNode.right;
                }
            }else{
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


    public boolean depthFirstIterative(int key){
        Stack<Node> dfsStack = new Stack<>();
        if(root!= null){
            dfsStack.push(root);
        }
        while(!dfsStack.isEmpty()){
            Node curNode = dfsStack.pop();
            if(curNode.value == key){
                return true;
            }else{
                if(curNode.left!= null){
                    dfsStack.push(curNode.left);
                }if(curNode.right!=null){
                    dfsStack.push(curNode.right);
                }
            }
        }
        return false;
    };

}
