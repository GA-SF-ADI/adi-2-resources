public class Solution {

	public int findCount(final List<Integer> A, int B) {
	    int lower, upper;
	    int len = A.size();
	    
	    lower = lowerBound(A, 0, len - 1, B);
	    upper = upperBound(A, 0, len - 1, B);
	    
	    if (lower == -1)
	        return 0;
	        
	    return upper - lower + 1;
	    
	}
	
	public int lowerBound(final List<Integer> A, int start, int end, int num) {
	    
	    int steps = end - start + 1;
	    int mid;
	    int low = -1;
	    int val;
	    
	    while (steps > 0) {
	        
	        mid = (start + end) / 2;
	        val = A.get(mid);
	        
	        if (num < val) {
	            end = mid - 1;
	        } else if (num > val) {
	            start = mid + 1;
	        } else {
	            low = mid;
	            end = mid - 1;
	        }
	        
	        steps /= 2;
	    }
	    
	    return low;
	    
	}
	
	public int upperBound(final List<Integer> A, int start, int end, int num) {
	    
	    int steps = end - start + 1;
	    int mid;
	    int up = end + 1;
	    int val;
	    
	    while (steps > 0) {
	        
	        mid = (start + end) / 2;
	        val = A.get(mid);
	        
	        if (num < val) {
	            end = mid - 1;
	        } else if (num > val) {
	            start = mid + 1;
	        } else {
	            up = mid;
	            start = mid + 1;
	        }
	        
	        steps /= 2;
	    }
	    
	    return up;
	    
	}
}
