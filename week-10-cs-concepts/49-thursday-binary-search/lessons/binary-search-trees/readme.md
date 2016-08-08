---
title: Binary Search Tree
type: lesson
duration: "1:00"
creator:
    name: Jean Weatherwax
    city: San Francisco
---

---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Binary Search Tree

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Explain what a Binary Search Tree is
- Know how a Binary Search Tree may be implemented in Java

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Understand basic Binary Search
- Know what a Tree is and how it is commonly used in Java

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Review lesson and code samples

---

### LESSON GUIDE


## Opening (10 mins)

We've already learned a bit about Trees and how they are used, and we also know the usefulness of binary search in both algorithms and practice.

A __Binary Tree__ is a specific tree data structure in which each node has at most 2 child nodes. These are commonly referred to as "left" and "right" nodes. A __Binary Search Tree__ additionally has a special property. This is that the key in each node must be greater than all keys stored in the left sub-tree, and smaller than all keys in the right sub-tree.

Here's a visual example:

[![Binary Search Tree](https://encrypt3d.files.wordpress.com/2010/09/nodes-in-binary-search-tree.png)](https://encrypt3d.files.wordpress.com/2010/09/nodes-in-binary-search-tree.png)

> Check: Can you draw another example of a BST? 

## Guided Practice: Implementing a BST in Java (40 mins)

So how would we make this data structure?

We'll need to implement a BST, which will have these properties:
* The Left subtree contains the nodes with keys less than the node's key.
* The Right subtree contains the nodes with keys greater than the node's key.
* Both the right and left subtree should also be binary search tree.
* There should not be any duplicate nodes.

We will want to implement the following methods:

* Searching
* Insert Node
* MinValue
* MaxValue

First, we know that our data structure will be made of nodes. We can assume that this looks like this:

```java
public class Node {

    protected Node left;
    protected Node right;
    protected int value;
    
    public Node(int value){
        this.value=value;
    }
}
```

This is pretty standard. Now, for our methods:

**Searching:** 

If we want to search for a node that matches a given key:

  1. We start at the root node as current node.
  2. If the search key’s value matches the current node’s key, then we have matched.
 3. If search key’s value is greater than current node’s:
    i. If the current node has a right child, search right
    ii. else, no matching node in the tree
4. If search key is less than the current node’s
    i. If the current node has a left child, search left
    ii. Else, no matching node in the tree

```java
    public void search(Node n, int value){
        if(n.value == value || n==null){
            System.out.println("\nFound Value: " + n.value);
        }else if(value<n.value){
            search(n.left,value);
        }else {
            search(n.right,value);
        }
    }
```

**Insertion:**

We want to always insert a new load as a leaf node. Here's the basic process:
1. Start at the root node.
2. If the new node's key is less than the current key:
	i. if the current node has a left child, search left.
	ii. else add the node as the current node's left child.
3. If the new node's key is greater than the current key:
	i. if the current node has a right child, search right.
	ii. else add the new node as the current node's right child.

```java
    public void insert(Node n, int value){
        if(value < n.value){
            if(n.left != null){
                insert(n.left,value);
            }else{
                n.left=new Node(value);
            }
        }
        if(value > n.value){
            if(n.right != null){
                insert(n.right,value);
            }else{
                n.right=new Node(value);
            }
        }
    }
```

**Min and Max Value:**

We know how to get to the min and max, because we just need to get to the left and right-most nodes, respectively:


```java
    public int minValue(Node n){
        while(n.left!=null){
            n=n.left;
        }
        return n.value;
    }
    
    public int maxValue(Node n){
        while(n.right!=null){
            n=n.right;
        }
        return n.value;
    }
```

## Conclusion (10 mins)

Binary Search Trees are a popular algorithm subject, and further Binary Search is a core concept in many built-in Java and Android processes. While you might not have to implement it when writing apps, it's important to understand so you have a good grasp of how things work under the hood.


> Check: What Android or Java methods/functions/processes might use BST's?

## Reference:

[tutorial] (http://www.code2learn.com/2013/02/binary-search-tree-bst-algorithm.html)



