	public int sqrt(int a) {
	    
	    long low = 0;
	    long high = a;
	    while(low <= high) {
	        long mid = (high + low)/2;
	        long square = mid*mid;
	        if(square == a) {
	            return (int)mid;
	        } else if (square < a) {
	            low = mid + 1 ;
	        } else {
	            high = mid - 1;
	        }
	    }
        
        return (int)high;	    

	}

