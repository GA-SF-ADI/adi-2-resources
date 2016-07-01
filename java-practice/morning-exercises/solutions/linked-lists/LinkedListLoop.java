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
        if(first == null) // list does not exist..so no loop either.
        return false;

        Node slow, fast; // create two references.

        slow = fast = first; // make both refer to the start of the list.

        while(true) {

            slow = slow.next;          // 1 hop.

            if(fast.next != null)
                fast = fast.next.next; // 2 hops.
            else
                return false;          // next node null => no loop.

            if(slow == null || fast == null) // if either hits null..no loop.
                return false;

            if(slow == fast) // if the two ever meet...we must have a loop.
                return true;
                
        }
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
