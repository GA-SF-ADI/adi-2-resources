import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by patrickcummins on 8/10/16.
 */
public class Node  {
    Character value;
    ArrayList<Node> children;

    public Node(Character value) {
        this.value = value;
        children = new ArrayList<Node>();
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public Character getValue() {
        return value;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
    public void addChild(Node node){
        this.children.add(node);
    }

}