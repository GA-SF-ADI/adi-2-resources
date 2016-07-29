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
	
	
	///alternate
	
	public static int findSquareRoot(int left, int right, int inputNumber){

        // base condition
        if (inputNumber ==0 || inputNumber == 1){
            return inputNumber;
        }

        int mid = (left + right)/2;

        // if square of mid value is less or equal to input value and 
        // square of mid+1 is less than input value. We found the answer. 
        if (mid*mid <= inputNumber && (mid+1)*(mid+1) > inputNumber){
            return mid;
        }

        // if input number is greater than square of mid, we need 
        // to find in right hand side of mid else in left hand side.
        if (mid*mid < inputNumber){
            return findSquareRoot(mid+1, right, inputNumber);
        }
        else{
            return findSquareRoot(left, mid-1, inputNumber);
        }

    }

