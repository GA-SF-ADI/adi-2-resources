public class Main {

    public static void main(String[] args) {
	// write your code here
        CustomBinaryTree customBinaryTree = new CustomBinaryTree(5);
        customBinaryTree.insert(3);
        customBinaryTree.insert(7);
        customBinaryTree.insert(8);
        customBinaryTree.insert(4);
        customBinaryTree.printInOrder();
        customBinaryTree.printPreOrder();

    }
}
