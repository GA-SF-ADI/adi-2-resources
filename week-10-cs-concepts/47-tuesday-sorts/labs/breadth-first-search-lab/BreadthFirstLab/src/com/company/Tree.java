package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Kyung on 8/9/16.
 */
public class Tree {
    private Node root;

    public Tree(){
        createTree();
    }

    public Node findValueByBfs(Character seekValue){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node curNode;

        while(!q.isEmpty()){
            curNode = q.poll();
            if(curNode.value==seekValue){
                return curNode;
            }else addChildrenQueue(q,curNode);
        }

        return null;
    }

    private void addChildrenQueue(Queue<Node> q,Node parent){
        if(parent.getChildren().size()>0){
            while(parent.getChildren().size()>0){
                q.add(parent.getChildren().poll());
            }
        }
    }

    private void createTree(){
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

        a.addChildren(b);
        a.addChildren(c);
        a.addChildren(d);

        b.addChildren(e);
        b.addChildren(f);
        b.addChildren(g);

        f.addChildren(m);

        c.addChildren(h);

        h.addChildren(n);
        h.addChildren(o);
        h.addChildren(p);
        h.addChildren(q);

        d.addChildren(i);
        d.addChildren(j);
        d.addChildren(k);
        d.addChildren(l);

        l.addChildren(r);
        l.addChildren(s);
        l.addChildren(t);
        l.addChildren(u);
        l.addChildren(v);
        l.addChildren(w);
        l.addChildren(x);
        l.addChildren(y);

        root = a;
    }

}
