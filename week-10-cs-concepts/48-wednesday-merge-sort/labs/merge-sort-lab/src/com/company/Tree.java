package com.company;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.Enumeration;


/**
 * Created by sterlinggerritz on 8/10/16.
 */



    public class Tree extends JFrame {

        JTree tree;
        DefaultTreeModel treeModel;
    DefaultMutableTreeNode root;

        public Tree() {

            super("Tree Test Example");
            this.root=buildTree();

            setSize(400, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }





    public DefaultMutableTreeNode findValueByBfs( Character value ) {
        Enumeration nodeEnumeration = root.breadthFirstEnumeration();
        while( nodeEnumeration.hasMoreElements() ) {
            DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode)nodeEnumeration.nextElement();
            Character found = (Character) node.getUserObject();
            if( value.equals( found ) ) {
                return node;
            }
        }
        return null;
    }




    public DefaultMutableTreeNode buildTree() {
       //level 1, root


        DefaultMutableTreeNode root = new DefaultMutableTreeNode('A');

        //level 2
        DefaultMutableTreeNode b = new DefaultMutableTreeNode('B');
      DefaultMutableTreeNode c = new DefaultMutableTreeNode('C');
        DefaultMutableTreeNode d = new DefaultMutableTreeNode('D');
        DefaultMutableTreeNode e = new DefaultMutableTreeNode('E');
        DefaultMutableTreeNode f = new DefaultMutableTreeNode('F');
        DefaultMutableTreeNode g = new DefaultMutableTreeNode('G');
        DefaultMutableTreeNode h = new DefaultMutableTreeNode('H');
        DefaultMutableTreeNode i = new DefaultMutableTreeNode('I');
        DefaultMutableTreeNode j = new DefaultMutableTreeNode('J');
      DefaultMutableTreeNode k = new DefaultMutableTreeNode('K');
        DefaultMutableTreeNode l = new DefaultMutableTreeNode('L');
        DefaultMutableTreeNode m = new DefaultMutableTreeNode('M');
        DefaultMutableTreeNode n = new DefaultMutableTreeNode('N');
        DefaultMutableTreeNode o = new DefaultMutableTreeNode('O');
        DefaultMutableTreeNode p = new DefaultMutableTreeNode('P');
        DefaultMutableTreeNode q = new DefaultMutableTreeNode('Q');
        DefaultMutableTreeNode r = new DefaultMutableTreeNode('R');
        DefaultMutableTreeNode s = new DefaultMutableTreeNode('S');
        DefaultMutableTreeNode t = new DefaultMutableTreeNode('T');
      DefaultMutableTreeNode u = new DefaultMutableTreeNode('U');
        DefaultMutableTreeNode v = new DefaultMutableTreeNode('V');
        DefaultMutableTreeNode w = new DefaultMutableTreeNode('W');
        DefaultMutableTreeNode x = new DefaultMutableTreeNode('X');
        DefaultMutableTreeNode y = new DefaultMutableTreeNode('Y');



        // Build our tree model starting at the root node, and then make a JTree
        // out
        // of that.
        treeModel = new DefaultTreeModel(root);
       tree = new JTree(treeModel);

        DefaultMutableTreeNode m_rootNode = new DefaultMutableTreeNode("AA");

         DefaultTreeModel m_model = new DefaultTreeModel(m_rootNode);

        //populate Level 2 off root
        root.add(b);
        root.add(c);
        root.add(d);
        m_rootNode.add(root);

        //populate level 3

        //off b
        b.add(e);
        b.add(f);
        b.add(g);
        m_rootNode.add(b);
//off c
        c.add(h);
        m_rootNode.add(c);

        //off d
        d.add(i);
        d.add(j);
        d.add(k);
        d.add(l);
m_rootNode.add(d);
        //populate level 4 - nodes not mentioned have no children on level 4.
        //off f
        f.add(m);
        m_rootNode.add(f);
        //off h
        h.add(n);
        h.add(o);
        h.add(p);
        h.add(q);
        m_rootNode.add(h);
//off l
        l.add(r);
        l.add(s);
        l.add(t);
        l.add(u);
        l.add(v);
        l.add(w);
        l.add(x);
        l.add(y);
        m_rootNode.add(l);

return root;






    }}
