package com.company;

class Node {

    int clorophyl;
    Node leftLeaf;
    Node rightLeaf;

    //Step 1: Create node and tree classes and Step 2: create a constructor for each

    public Node(int chlorophyl) {
        this.clorophyl = clorophyl;
        leftLeaf =null;
        rightLeaf=null;
    }
}

class Tree {
    Node root;
    public Tree(){
        Node current = root;


    }
    public void growNewLeaf(int newClorophylAmount){
        Node newLeaf = new Node(newClorophylAmount);

        if(root==null) {
            root = newLeaf;
            return;
        }

        Node current = root;
        Node parent = null; //designed tree class so that root will not be null

        while(true) {
            parent = current;
            if(newClorophylAmount<current.clorophyl) {
                current = current.leftLeaf;  //leaves with less clorophyl go on the left side of the tree
            }
            if (current == null) {
                parent.leftLeaf = newLeaf;
                return;
            }

            else{
                current = current.rightLeaf;

                if(current==null){
                    parent.rightLeaf=newLeaf;
                    return;
                }

            }}}

//    public boolean cutOffLeaf(int newClorophylAmount){
//        //apparently deleting leaves is not actualy a requirement of the lab so I am not going to finish this function
//    }
//
//        //Situation 1, there are no children. I look at
//        //the amount of clorophyl in the parent node and then figure out of the leaf is on the left or right.
//        //i cut off the leaf by doing either parent.left= null or parent.right = null
//
//        Node parent = root;
//        Node current = root;
//        boolean isOnLeft=false;
//
//        while(current.clorophyl!=newClorophylAmount){
//            parent = current;
//
//            if(current.clorophyl>newClorophylAmount){
//            isOnLeft=true;
//                current=current.leftLeaf;
//            } else{
//                isOnLeft=false;
//                current = current.rightLeaf;
//            }
//        if(current==null) { //on no!  what if there is not a leaf?!
//            return false;
//        }
//        }
//    // the second case is if the node is not symetrical , there is only a child on one of the sides.
//        //i would check the amount of clorophyl in the parent and figure out if the node to be deleted is left or right of the tree
//        //then i would check to see which child is null (does not exist)
//        // when the node is deleted then i have to move all the subsequent offspring leaves
//        //up the the place wehre the node used to be before it was deleted
//

public boolean findLeaf(int newClorophylAmount){

    //I start at the top of the tree and go down, comparing the input
    //clorophyl amount with what each leaf in the tree already has.
    //if head root node is bigger than the new clorophyl amount, I look on the left of the treee
    //if head root is smaller than new clorophyl amount I look on the right of the tree
    //if at any point the clorophyl amount is the same as I go down the tree, then I have found the leaf in question
    //if i find it i return true
    //if i dont find it yet i return false


    Node current = root;
    while(current!=null){
        if(current.clorophyl==newClorophylAmount){
            return true;
        }
        else if (current.clorophyl>newClorophylAmount){
            current = current.leftLeaf;
        }
        else{
            current = current.rightLeaf;
        }
    }
    return false;
}

    public void traverseTreeInPreOrder(Node root) {
        //starting at head node, work down right side of the tree but display left most children leaves if a node has children before going to the next leaf down
    if(root!=null){
        System.out.println(""+ root.clorophyl);
        traverseTreeInPreOrder(root.leftLeaf);
        traverseTreeInPreOrder(root.rightLeaf);

    }}
public void traverseTreeInPostOrder(Node root){
    //climb down left side of tree
    //climb down right side of tree
    //stop at each leaf
    if(root!=null){
        traverseTreeInPostOrder(root.leftLeaf);
        traverseTreeInPostOrder(root.rightLeaf);

        //i visit each leaf and then print out its clorophyl
        System.out.println(""+root.clorophyl);
    }
}
    public void traverseTreeInOrder(Node root){
        //climb down the left side of the tree.  print each leaf.
        //climb down teh right side of the tree.  print each leaf.

        if(root!=null){
            traverseTreeInOrder(root.leftLeaf);
            System.out.println(""+root.clorophyl);
            traverseTreeInOrder(root.rightLeaf);
        }

    }
public static void main(String args[]){

    Tree tree = new Tree();

    //populating my tree with leaves and branches
    tree.growNewLeaf(5);
    tree.growNewLeaf(90);
    tree.growNewLeaf(31);
    tree.growNewLeaf(8);
    tree.growNewLeaf(11);
    tree.growNewLeaf(1);
    tree.growNewLeaf(2);

    System.out.println("This is the unaltered tree traversed in order");
    tree.traverseTreeInOrder(tree.root);
    System.out.println("");
    System.out.println("unaltered in pre-order");
    tree.traverseTreeInPreOrder(tree.root);
    System.out.println("tree in post-order");
    tree.traverseTreeInPostOrder(tree.root);



    System.out.println("Does a leaf containing 8 clorophyl exist?");
    tree.findLeaf(8);

    System.out.println("I want to grow a new leaf which contains 7 clorophyl");
    tree.growNewLeaf(7);
    System.out.println("This is what my tree looks like now that its grown the new leaf");
    System.out.println("in order");
    tree.traverseTreeInOrder(tree.root);
    System.out.println("post order");
    tree.traverseTreeInPostOrder(tree.root);
    System.out.println("pre order");
    tree.traverseTreeInPreOrder(tree.root);

}
}


