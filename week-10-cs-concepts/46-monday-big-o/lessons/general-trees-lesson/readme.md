---
title: General Trees
duration: "1:25"
creator:
    name: Jamey Holli/Brianna Veenstra
    city: SF
---


---
# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Trees
Week 10 | Lesson 2

### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
- Describe the structure of trees
- Implement traversal algorithms of a tree
- Implement a tree in java


---
<a name="opening"></a>
## Opening (5 mins)

You have seen the LinkedList data structure, which is made up of nodes. Each Node has a next property, which holds the next node in the list. But what if we are in a scenario where we want each node to hold on to multiple pieces of data? Trees are essentially LinkedLists with multiple children and have 
incredibly useful applications both theoreticlly and practically. 
***

<a name="introduction"></a>
## Introduction: Trees (20 mins)


Trees are a special kind of graph with some extra rules about their nodes and edges. First, every tree has a unique, special start node called the "root" node. (We usually draw trees vertically with the "root" node at the top of the tree.)Second, each node in a tree can only ever have one "parent". This means there's only ever one direct path from any node to the root of the tree. One classic example of a tree is a file system, where directories contain other directories and/or files. The / directory is called the "root" directory because it's literally the root of the computer's directory tree. 

<details>
  <summary>Click here see more examples of trees</summary>
- XML tree
- comment trees
- data compression algorithm trees
- single-elimination tournaments
- calculator's order of operations
</details>


#### Properties of Trees

![Tree](http://holowczak.com/wp-content/uploads/tree_example.gif)

As mentioned earlier, trees are made up of nodes and paths. As you can see above, there is some vocabulary that is used in reference with trees. 

- Root:  This is the first node of a tree. Similar to the HEAD of a LinkedList. The only property a tree needs to function
- Parent/Children/Child: Intuitively, the node directly above another node is its parent. A parent can have many children, a child has only one parent. The same as real life
- Branches: The edge of trees. When drawn out, they are the lines. In code, they are the the references from a parent to a child. Branches will almost always be one-directional, meaning if there is a line from a parent to a child it means that the parent is referencing the child, not the child referencing the parent. 
- Leaves: Nodes with no branches leading off of them, no children. 
- Height: The height of the tree is the longest distance from the root to a leaf. 
- Descendant/Ancestors: Exactly the same as a  family tree, Node A is an ancestor of Node B if there is a branch from Node A to Node B, and Node B is a descendant of Node A for the same reason. 
- A subtree is any tree with a root that is also a node inside of the main tree. 

***



<a name="Binary Search Tree"></a>
## Binary Search Tree (10 mins)

Those were all properties that are shared among ALL trees. However, there are more specific types of trees than just the general tree. A common one seen in interviews is the Binary Search Tree. There are two parts to making a tree a BST. 

### Binary

 Binary means that each node can have at MOST two children. The tree shown in the above picture is binary, because there is no node with more than two children. It is possible to have any number of children coming off of a node, but to be binary, there must be at most two. Binary trees always have a left and right child, meaning that their node class looks something like this

 ```java

 public class Node<T>{
  Node left, right;
  T value;
 }
```
If you want to access the children inside of a binary tree, you do so through node.left and node.right. 

### Search

The Search aspect of a BST has implications that we will be getting into later, but for now it only means that any left child will have a smaller value than the parent and any right child will have a greater value than the parent. It does not need to be balanced, but that simple rule MUST be observed for a tree to be a binary search tree. 
***

<a name="guided-practice: Traversals"></a>
## Guided Practice: Traversal (15 mins)

We've talked about this subject before, but there are three different types of tree traversals. In Order, Post Order, and Pre Order Traversals. 

Each follows a different set of rules

- In Order: All of the nodes to the left of a node must be accessed before it itself is accessed
- Pre-Order: All of a nodes parents must be accessed before the node itself is accessed. 
- Post-Order: All of the nodes children must be accessed before the node itself is accessed. 

Lets take a look at that example tree again.

![Tree](http://holowczak.com/wp-content/uploads/tree_example.gif)

 What would the in-order, pre-order, and post-order traversals of that node look like if we just wanted to print out the values of each node?

<details>
  <summary>In-Order</summary>
    1 3 4 5 7 8 10

    NOTE: Notice that on a binary search tree the in order traversal gives us the numbers actually in order. 
</details>

<details>
  <summary>Pre-Order</summary>
    5 3 1 4 8 7 10
</details>

<details>
  <summary>In-Order</summary>
    10 7 8 1 4 3 5 
</details>


***

<a name="ind-practice"></a>
## Independent Practice: Trees/Lab (1000 minutess)

For the rest of the afternoon, I want you to work on implementing a binary search tree in java. You don't need to worry about it being balanced, it could end up looking like a linked list if you add values incorrectly, but I want you to implement a CustomBinarySearchTree class that you can add nodes to, do in order, pre-order, and post-order traversals on, and can check if a value is in the tree. 


***

<a name="conclusion"></a>
## Conclusion (# mins)

Trees, specifically binary trees while practically useful, are incredibly important to know for interview questions. But most importantly, they are fun!

***
