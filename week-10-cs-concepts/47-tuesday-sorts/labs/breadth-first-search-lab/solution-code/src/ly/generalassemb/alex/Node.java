package ly.generalassemb.alex;

import java.util.ArrayList;

/**
 * Generic node that has 0 or more children
 *
 * Created by alex on 8/9/16.
 */
public class Node {
    public Character value;
    public ArrayList<Node> children;

    public Node(Character value) {
        this.value = value;
        children = new ArrayList<>();
    }

    /**
     * Add child to node. You can add as many as you want, they live inside of a list
     *
     * @param child
     */
    public void addChild(Node child){
        children.add(child);
    }

    /**
     * Get all children for this node
     *
     * @return
     */
    public ArrayList<Node> getChildren(){
        return children;
    }
}
