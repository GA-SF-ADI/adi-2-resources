/**
 * Created by hollis on 6/14/16.
 */
public class CustomStack<T> {
    public Node head;

    public void push(T value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public T pop(){
        T value = head.value;
        head = head.next;
        return value;
    }

    public class Node{
        T value;
        Node next;

        public Node(T value){
            this.value = value;
        }
    }
}
