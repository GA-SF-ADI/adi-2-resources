/**
 * Created by hollis on 6/21/16.
 */
public class CustomMinStack<Integer> {
    Node head;

    public class Node{
        int value;
        int currentMin;
        Node next;

        public Node(int value){
            this.value = value;
        }
    } ;

    public void push(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        if(value <head.currentMin){
            newNode.currentMin = value;
        }else{
            newNode.currentMin = head.currentMin;
        }
        head = newNode;
    }

    public int pop(){
        int value = head.value;
        head = head.next;
        return value;
    }

    public int peek(){
        if(head == null){
            throw new ArrayIndexOutOfBoundsException();
        }
        return head.value;

    }

    public int getCurrentMin(){

        if(head == null){
            throw new ArrayIndexOutOfBoundsException();
        }
        return head.currentMin;

    }
}
