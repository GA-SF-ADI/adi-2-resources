import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by patrickcummins on 8/10/16.
 */
public class Tree {
    Node root;

    public Tree() {
        Node a = new Node('A');
        this.root = a;
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
    }


    public boolean findValueByBfs(Character seekValue) {
        if (seekValue == null || root == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node current;
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current.value.equals(seekValue)) {
                return true;
            } else {
                for (int i = 0; i < current.getChildren().size(); i++) {
                    queue.add(current.getChildren().get(i));
                }
            }

        }
        return false;

    }

    public boolean findValueByDfsIteratively(Character seekValue) {
        if (seekValue == null || root == null) {
            return false;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node current;
        while (!stack.isEmpty()){
            current = stack.pop();
            if (current.value.equals(seekValue)){
                return true;
            }else {
                for (int i = 0; i < current.getChildren().size(); i++) {
                    stack.push(current.getChildren().get(i));
                }
            }
        }
        return false;
    }

    public boolean findValueByDfsRecursively(Character seekValue) {
        if (seekValue == null || root == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        return findValueByDfsRecursively(seekValue, stack);

    }

    private boolean findValueByDfsRecursively(Character seekValue,  Stack<Node> stack) {
        if (stack.isEmpty()){
            return false;
        }
        Node current = stack.pop();
        if (current.getValue().equals(seekValue)){
            return true;
        }
        else {
            for (int i = 0; i < current.getChildren().size(); i++) {
                stack.push(current.getChildren().get(i));
            }
        }
        return findValueByDfsRecursively(seekValue, stack);

    }
}
