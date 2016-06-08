import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    System.out.println("hello android");
    
    // System.out.println("This should be a Palindrome and return true: " +checkPalindrome("radar"));
    
    // System.out.println("This shouldn't be a Palindrome and should return false: " +checkPalindrome("shouldn't"));
    
    // System.out.println(everyOther());
    
    int[] testArray =  {1,7,12,3,21,1};
    
    // System.out.println("What is the largest of the test array? " + maxValue(testArray));
    
    // System.out.println("The number of days in April is: " +daysInMonth("april"));
    
    // System.out.println("The number of days in May is: " +daysInMonth("mAy"));
    
    // System.out.println("The funny value return from funnyMath is: " + funnyMath(testArray));
    
    ArrayList<String> nameList = new ArrayList<String>();
    
    nameList.add("Brendan");
    nameList.add("Micah");
    nameList.add("Sukhi");
    nameList.add("Aaron");
    nameList.add("Sam");
    nameList.add("Paul");
    nameList.add("Patrick");
    nameList.add("Darran");
    nameList.add("Micah");
    nameList.add("Aaron");
    
    System.out.println("This is our name list: "+ nameList);
    
    System.out.println("This is our name list without duplicates: " + removeDuplicates(nameList));
    
    String testString = "androidimmersive";
    
    System.out.println("Where did my vowels go? " + removeVowels(testString));
    
  }
  
  
  public static boolean checkPalindrome(String isThisAPalindrome) {
  	
  	String reverse = new String();
  	
  	int length = isThisAPalindrome.length();
 
      for ( int i = length - 1; i >= 0; i-- )
      {
         reverse = reverse + isThisAPalindrome.charAt(i);
      }
 
      if (isThisAPalindrome.equals(reverse)){
         return true;
      }
      else{
         return false;
      }
  }
  
  public static String everyOther() {
  	
  	String everyOtherElement = new String();
  	
  	ArrayList<Character> characterList = new ArrayList<>();
  	
  	characterList.add('a');
  	characterList.add('b');
  	characterList.add('c');
  	characterList.add('d');
  	characterList.add('e');
  	
  	for (int i = 1; i < characterList.size(); i+=2) {
  		everyOtherElement = everyOtherElement + characterList.get(i);
  	}
  	
  	return everyOtherElement;
  	
  }
  
  public static int maxValue(int[] incomingArray) {
  	
  	int maxValue = incomingArray[0];
  	
  	for (int currentValue : incomingArray) {
  		if (currentValue > maxValue) {
  			maxValue = currentValue;
  		}
  	}
  	
  	return maxValue;
  	
  }
  
  public static int daysInMonth(String month) {
  	
  	int daysInMonth;
  	
  	month = month.toUpperCase();
  	
  	switch (month) {
  		case "JANUARY":
  			daysInMonth = 31;
  			break;
  		case "FEBRUARY":
  			daysInMonth = 28;
  			break;
  		case "MARCH":
  			daysInMonth = 31;
  			break;
  		case "APRIL":
  			daysInMonth = 30;
  			break;
  		case "MAY":
  			daysInMonth = 31;
  			break;
  		case "JUNE":
  			daysInMonth = 30;
  			break;
  		case "JULY":
  			daysInMonth = 31;
  			break;
  		case "AUGUST":
  			daysInMonth = 31;
  			break;
  		case "SEPTEMBER":
  			daysInMonth = 30;
  			break;
  		case "OCTOBER":
  			daysInMonth = 31;
  			break;
  		case "NOVEMBER":
  			daysInMonth = 30;
  			break;
  		case "DECEMBER":
  			daysInMonth = 31;
  			break;
  		default:
  			daysInMonth = 0;
  			break;
  		}
  	
  	return daysInMonth;
  	
  	
  }
  
  public static int funnyMath(int[] incomingArray) {
  	
  	int returnSum = 0;
  	
  	for (int currentValue : incomingArray) {
  		if (currentValue > 20) {
  			returnSum = returnSum - 3;
  		} else if (currentValue > 1) {
  			returnSum = returnSum + 1;
  		}
  	}
  	
  	return returnSum;
  	
  }
  
 public static ArrayList<String> removeDuplicates(ArrayList<String> array) {
 	
 	// Declare and initialize ArrayList
    ArrayList<String> noDuplicates = new ArrayList<>();
    for (String nameToCheck : array) {
        if (!noDuplicates.contains(nameToCheck)) {
            noDuplicates.add(nameToCheck);
        }
    }
    return noDuplicates;
}

public static String removeVowels(String incomingString) {
	
     if (incomingString.isEmpty()) {
     	return "";
     }
	
     String returnString = "";

     for (int i = 0; i < incomingString.length(); i++)
     {
       if (!isVowel
           (Character.toLowerCase
               (incomingString.charAt(i))))
       {
         returnString += incomingString.charAt(i);
       }
     }
     return returnString;
	
	
}

public static boolean isVowel(Character character) {
	
	switch (character) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		default:
			return false;
			
	}
	
}


}
