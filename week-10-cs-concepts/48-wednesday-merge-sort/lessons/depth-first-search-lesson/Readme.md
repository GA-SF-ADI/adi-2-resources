## Depth First Search ( Trees )
#### What is Deapth First Search? ( 10 min )

Depth First Search is another algorithm that searches through (potentially) every node in a graph. Like with Breadth First Search, we can search for many keys, search by criteria that aren't based on keys, keep track of depth. Also like with breadth first, we can use the depth first order to traverse an entire tree even if we aren't searching for something.



#### Definition ( 15 min )
**Depth First Search chooses a start node and "visits" all the nodes in the graph by following each path as far (as deep) as it can before going to the next path.**  In a tree, we pick the root as the start node (surprise!).

Depth First Search follows an "always go left" path like some people use to systematically solve mazes. 

Breadth First Search used a queue (first in is first out) to keep track of which nodes to visit next.  Depth First Search, at least in its iterative form, uses a stack (first in is last out).

Depth First Search can also be done recursively. However, the iterative version translates more easily to graphs that might have loops (after you see both versions, think about why that is).



<img src="https://upload.wikimedia.org/wikipedia/commons/7/7f/Depth-First-Search.gif" alt="depth first search animation for tree" width="300px">

What's happening in that animation?

<details>
<summary>Stack representation of above</summary>
```
node stack starts with just the root:  
  [1]
visit the last node, pushing its children to the stack (added right to left to match gif but either works): 
  [1, 9, 5, 2]  
visit the last node, pushing its children to the stack:
  [1, 9, 5, 2, 3]
visit the last node, pushing its children to the stack:
  [1, 9, 5, 2, 3, 4]
visit the last node, but it has no unvisited children. so pop it out
  [1, 9, 5, 2, 3]   => 4
keep repeating until the stack is empty: 
  [1, 9, 5, 2]      => 3
  [1, 9, 5]       => 2
  [1, 9, 5, 8, 6]
  [1, 9, 5, 8]      => 6
  [1, 9, 5]     => 8
  [1, 9]        => 5
  [1, 9, 10]
  [1, 9]        => 10
  [1]         => 9
  []          => 1
```
 </details>



### Exercises: Depth First Tree Search (45 min )

1. In English, describe how you would use depth first search to determine whether any node in a tree has a given key. Your algorithm should assume you have a tree data structure and that you can access each node's key and its children. You should also assume you're given a target key to match.


2. On the whiteboard, pseudocode a depth first search function. As usual, assume you have a tree data structure with a root Node and a Node class with left and right children. 


3. Copy the starter code into a new IntelliJ project.  You'll see these files now have blanks and informal "tests" for depth first search.  Fill in the depth first search function in one of these files with actual code code. Run your Main.java to see the informal tests work on your file.


## Conclusion ( 5 min )

*Depth First Search* is an alternative way to search over trees for a certain value. You can also run this algorithm over a *Graph*.

* What are the pros of DFS?
* What are the cons of DFS?
* Given the pros and cons, why would you use DFS over BFS?