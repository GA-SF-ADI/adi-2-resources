/**
 * Created by hollis on 6/14/16.
 */
public class CustomQueue<T> {
    Node head;
    Node tail;

    public void enqueue(T value){
        Node newNode = new Node(value);
        if(tail!= null){
            tail.next = newNode;
            tail = newNode;
        }else{
            tail = newNode;
            head = newNode;
        }
    }

    public T dequeue(){
        if(head!= null){
            T result = head.value;
            if(head==tail){
                head = tail = null;
            }
            return result;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public class Node{
        T value;
        Node next;

        public Node(T value){
            this.value = value;
        }
    }
}
