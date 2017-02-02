package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by audreyeso on 8/10/16.
 */
public class Tree {
    private Node root;
    private  Stack<Node> stack;

    public Tree() {
        this.root = createTree();
    }

    public boolean dFSRecursive(int x, Node root) {

        stack = new Stack<>();

        if (root.value == x) {
            return true;
        }
            else if (root.value == null || root.value != x) {
                return false;
            } else if (!stack.isEmpty()) {
            Node node = stack.pop();
            dFSRecursive(x, node);

        }
        return false;
    }


    public boolean findValueByDfs(Character val) {
        Stack<Node> stack = new Stack<>();
        if (val == null || root == null) {
            stack.push(root);
        }

        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node.value == val) {
                return true;
            } else {
                if (node.getChildren() != null) {
                    stack.push(node);
                }
            }
        }
        return false;

    }

    public Node findValueByBfs(Character value) {
        if (value == null || root == null) {
            return null;
        }
        // Create Queue and add root
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Loop over Queue if its not empty
        while (queue.peek() != null) {
            Node parent = queue.remove();
            if (parent == null || parent.value == value) {
                return parent; // Return parent if its null ( queue empty ) or we found a value match
            }
            // Add all children to queue
            addChildrenToQueue(queue, parent);
        }
        return null;
    }

    private void addChildrenToQueue(Queue<Node> queue, Node parent) {
        if (queue == null || parent == null || parent.children == null) {
            return; // Null pointer, exit.
        }
        queue.addAll(parent.children);
    }

    private void addChildrenToStack(Stack<Node> stack, Node node) {
        if (stack == null || node == null || node.children == null) {
            return;
        }
        stack.addAll(node.children);
    }

    /**
     * Creates a tree of nodes with values of the alphabetical letters.
     * <p>
     * We do not insert Z, but A-X is inserted into the tree.
     *
     * @return
     */
    private Node createTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        Node i = new Node('I');
        Node j = new Node('J');
        Node k = new Node('K');
        Node l = new Node('L');
        Node m = new Node('M');
        Node n = new Node('N');
        Node o = new Node('O');
        Node p = new Node('P');
        Node q = new Node('Q');
        Node r = new Node('R');
        Node s = new Node('S');
        Node t = new Node('T');
        Node u = new Node('U');
        Node v = new Node('V');
        Node w = new Node('W');
        Node x = new Node('X');
        Node y = new Node('Y');

        a.addChild(b);
        a.addChild(c);
        a.addChild(d);

        b.addChild(e);
        b.addChild(f);
        b.addChild(g);

        c.addChild(h);

        d.addChild(i);
        d.addChild(j);
        d.addChild(k);
        d.addChild(l);

        f.addChild(m);

        h.addChild(n);
        h.addChild(o);
        h.addChild(p);
        h.addChild(q);

        l.addChild(r);
        l.addChild(s);
        l.addChild(t);
        l.addChild(u);
        l.addChild(v);
        l.addChild(w);
        l.addChild(x);
        l.addChild(y);

        return a;
    }

}