## Breadth First Search ( Trees )

#### What is Breadth First Search? ( 10 min )

Breadth First Search (BFS) is a way to search for a value in a Tree or Graph.

Imagine you have 8 nodes. Each of these 8 nodes has a value and each may or may not have some children ( remember that a tree node may have many children. If each root node only has 2 children, then the tree is a *binary tree*). 

Suppose this is true of the 8 nodes:
- Node H exists with value 8. It has no children.
- Node G exists with value 7. It has no children.
- Node F exists with value 6. It has no children.
- Node E exists with value 5. It has one child, left Node H.
- Node D exists with value 4. It has no children.
- Node C exists with value 3. It has two children, left Node F and right Node G.
- Node B exists with value 2. It has two children, left Node D and right Node E.
- Node A exists with value 1. It has two children, left Node B and right Node C. This node is the **root** of the tree.

> Check: Take 5 minutes and draw this tree structure out using whiteboards, paper, visual diagrams or text editors.

<details>
   <summary>Take a peek at the solution here</summary>
   ![](tree_solution.jpg)   
</details>

What if we want to find the Node that holds the value of 8? It's easy for us, we just look at the image we sketched and know that is Node H. But, before we drew the sketch out do you think you would have known it was Node H? Sure, because you had the information about all 8 nodes and their values. 

What if the only information you had to go off of was that Node A has a value of 1 and it has two children. Now the problem is much harder. In order to look for the Node with value of 8, we have to first look at the value of Node A. If we don't find a match, we look at Node A's children and their values, and when we don't find a match, we look at the grand-children of Node A and their values and so on. This is *Breadth First Search*. 

#### Definition ( 15 min )

"Breadth First Search (BFS) searches breadth-wise in the problem space. Breadth-First search is like traversing a tree where each node is a state which may a be a potential candidate for solution. It expands nodes from the root of the tree and then generates one level of the tree at a time until a solution is found. It is very easily implemented by maintaining a queue of nodes. Initially the queue contains just the root. In each iteration, the node at the head of the queue is removed and then expanded. The generated child nodes are then added to the tail of the queue." [1](http://intelligence.worldofcomputing.net/ai-search/breadth-first-search.html#.V6kLjpMrJXg)

Below, you see an illustration of *Breadth First Search* algorithm on a tree that is *4 levels* deep.
* A node turns gray when we first discover that the node exists and **add it to the queue**.
* A node turns black when we **remove it from the queue**. 

![](https://camo.githubusercontent.com/2f57e6239884a1a03402912f13c49555dec76d06/68747470733a2f2f75706c6f61642e77696b696d656469612e6f72672f77696b6970656469612f636f6d6d6f6e732f342f34362f416e696d617465645f4246532e676966)

## Exercises: Breadth First Tree Search ( 30 min )

1. In English, describe how you would use breadth first search to find any node with a given value. Your algorithm should assume you have a tree data structure and that you can access each node's value and its array of children (do not assume it's a binary tree which has only 2 children). You can assume you're given a target value to find.

2. On the whiteboard, pseudocode a breadth first search method. Assume you have a tree data structure that allows the following operations on all nodes:
      * `node.getValue()` returns the value of the node
      * `node.getChildren()` returns an `ArrayList<Node>` of size zero or more ( if size is always 2, then its a binary tree ).
      * You are given the tree root node as `Node root` parameter into your search method.

3. In English, describe how you would modify your breadth first search function to work on a binary search tree. Remember, a *Binary Search Tree* is a tree where all the children to the left of the parent hold a lower value than the parent while all the children to the right hold a greater value. See the illustration below, where the root node has a value of 4.
```
      4
     / \
   2     6
  / \   / \
 1   3 5   7
```
