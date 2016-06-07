public class Main{
	public static void main(String[] args){

	}

	  public static boolean hasAnL(String str){
        if(str.indexOf('l') == -1){ //Can you think of a way to get this done in just 2 if else bits instead of 3 
            return false;
        }else if(str.indexOf('L') == -1){
            return false;
        }else{
            return true;
        }
    }

	//I am being lazy and not checking if the string is less than length 2. How would you go about checking that condition?
    public static String echo(String str){
        String lastChars = str.substring(str.length()-2);
        return str + lastChars + lastChars + lastChars;
    }

       public static int millisecondsToDays(int milliseconds){
        int seconds = milliseconds/1000;
        int minutes = seconds/60;
        int hours = minutes/60;
        int days = hours/24;
        return days;
        // how would you write this function in just one line of code?
    }
}