/**
 * Created by hollis on 6/14/16.
 */
public class CustomLinkedList<T> {
    private Node head;

    public void add(T value){
        Node cur = head;
        while(cur.hasNext()){
            cur = cur.next;
        }
        Node nextNode = new Node(value);
        cur.next = nextNode;
    }

    public void remove(int index){
        Node curNode = head;
        for(int i = 0; i<index-1; i++){
            if(curNode.hasNext()) {
                curNode = curNode.next;
            }else{
                throw new IndexOutOfBoundsException();
            }
        }
        if(curNode.next!= null){
            if(curNode.next.next != null){
                curNode.next = curNode.next.next;
            } else{
                curNode.next = null;
            }
        }else{
            throw new IndexOutOfBoundsException();
        }

    }

    public T get(int index){
        Node curNode = head;
        for(int i = 0; i<index; i++){
            if(curNode.hasNext()){
                curNode = curNode.next;
            }else{
                throw new IndexOutOfBoundsException();
            }
        }
        return curNode.getValue();
    }

    public boolean isLoop(){
        Node fastNode = head;
        Node slowNode = head;

        int counter = 1;
        while(fastNode.hasNext()){
            fastNode = fastNode.next;
            if(fastNode==slowNode){
                return false;
            }
            if(counter%2==0){
                slowNode= slowNode.next;
            }
        }
        return true;
    }



    public class Node{
        private T value;
        private Node next;
        public Node(T value){
            this.value = value;
        }

        public Node(){
        }

        public T getValue(){
            return value;
        }

        public boolean hasNext(){
            return next != null;
        }
    }
}
