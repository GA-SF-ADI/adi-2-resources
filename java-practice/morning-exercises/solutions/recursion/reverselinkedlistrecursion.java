public class Solution {
	public ListNode reverseList(ListNode A) {
	    
	    ListNode node;
	    
	    if (A == null)
	        return A;
	    
	    node = recurse(A.next, A);
	    A.next = null;
	    
	    return node;
	    
	}
	
	public ListNode recurse(ListNode node, ListNode prev) {
	    
	    if (node == null)
	        return prev;
	    
	    ListNode temp = node.next;
	    node.next = prev;
	    
	    return recurse(temp, node);
	}
	
}
