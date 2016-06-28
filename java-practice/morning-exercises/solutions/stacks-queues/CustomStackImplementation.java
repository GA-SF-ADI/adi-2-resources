import java.util.Stack;

/**
 * Created by hollis on 6/14/16.
 */
public class CustomStack<E> {
    public Node head;


    public E push(E item){
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        return item;
    }

    public E pop(){
        if(head == null){
            throw new ArrayIndexOutOfBoundsException();
        }else {
            E value = head.value;
            head = head.next;
            return value;
        }
    }

    public E peek(){
        return head.value;
    }

    public class Node{
        E value;
        Node next;

        public Node(E value){
            this.value = value;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }
}
