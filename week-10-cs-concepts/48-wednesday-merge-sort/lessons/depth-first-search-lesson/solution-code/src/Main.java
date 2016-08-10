public class Main {

    public static void main(String[] args) {
	// write your code here
        BinaryTree binaryTree = new BinaryTree(5);
        binaryTree.insert(1);
        binaryTree.insert(3);
        binaryTree.insert(12);
        binaryTree.insert(52);
        binaryTree.insert(39);

        System.out.println("should be true" + binaryTree.depthFirstIterative(1));
        System.out.println("should be true" + binaryTree.depthFirstIterative(39));
        System.out.println("should be false" + binaryTree.depthFirstIterative(2));
        System.out.println("should be false" + binaryTree.depthFirstIterative(41));

    }
}
