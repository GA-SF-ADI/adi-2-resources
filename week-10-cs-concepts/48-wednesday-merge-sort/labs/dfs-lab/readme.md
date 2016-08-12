---
title: Depth First Search Lab ( Trees )
type: lab
duration: "1:30"
creator: Jamey Hollis ( SF )
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Depth First Search Lab ( Trees )

## Introduction

In this lab, you will be modifying the tree class that you worked with in the BFS lab and implement depth first search on it. 

## Exercise

You will be creating:

- a public `findValueByDfsIteratively(Character seekValue)` method in the tree to use iterative DFS to find whether or not a value is in the tree
- a public `findValueByDfsRecursively(Character seekValue)` method in the tree that recursively performs DFS to find if the item is in the tree 


#### Starter Code

- Work off of your BFS lab from yesterday
- If you were unable to complete it, work off of the solution code.


#### Requirements

* Include 25 letters of the alphabet from A-Y inside of your tree to match the above image.
* Seeking for value `Z` should return no result or null while seeking for any value `A-Y` should produce a result that find said value.


#### Deliverable

A working IntelliJ project that includes a `Main.java, Node.java, and Tree.java` files.

`Tree.java` file must have both working `findValueByDfs(Character seekValue)` method ( called from Main.java ) that looks for any character inside the tree and accurrately finds if it exists.

