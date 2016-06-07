import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Max of 1 and 3 is " + maxOfTwoNumbers(1,3));
        System.out.println("Max of 4 and 2 is " + maxOfTwoNumbers(4,2));

        System.out.println("Max of 1 and 2 and 3 is " + maxOfThree(1,2,3));
        System.out.println("Max of 4 and 2 and 1 is " + maxOfThree(4,2,1));
        System.out.println("Max of 4 and 8 and 1 is " + maxOfThree(4,8,1));

        System.out.println("Is 'a' a vowel? " + isCharacterAVowel('a'));
        System.out.println("Is 'b' a vowel? " + isCharacterAVowel('b'));

        System.out.println("Passing in 1,2,3 gives us: " + numArgs(1,2,3));

        System.out.println("Passing in 1,2,3,4,5,6,7 gives us: " + numArgs(1,2,3,4,5,6,7));

        String testString = "onetwothree";
        System.out.println(testString + " " + revString(testString));

        String[] testStringArray = {"a", "it", "car", "dogs", "whomp"};
        System.out.println("Length of Longest word is: " + longestWord(testStringArray));

        System.out.println("First word of length 3 or greater is: " + Arrays.toString(filterLongWords(testStringArray, 3)));

    }
    public static int maxOfTwoNumbers(int num1, int num2){
        // return Math.max(num1, num2); <- simple way using Java's built in code

        if(num1>num2){
            return num1;
        }else{
            return num2;
        }
        //notie that if they are equal it will go to the else case and return num2, which is fine because they are both equal
    }

    public static int maxOfThree(int num1, int num2, int num3){
        // return Math.max(num1, Math.max(num2, num3)) <- again, the straitforward way using Java's internal libraries

        if(num1>=num2 && num1 >= num3){
            return num1;
        }else if(num2>=num1 && num2>=num3){
            return num2;
        }else{
            return num3;
        }
    }

    public static boolean isCharacterAVowel(char c) {
//        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {  fast way of doing it
//            return true;
//        } else {
//            return false;
//        }

        if(c=='a'){ // super long way
            return true;
        }else if(c=='e'){
            return true;
        }else if(c=='i'){
            return true;
        }else if(c=='o'){
            return true;
        }else if(c=='u'){
            return true;
        }else{
            return false;
        }
    }

    public static int numArgs(Integer... args){
        return args.length;
    }

    public static String revString(String str){
        return new StringBuilder(str).reverse().toString();
    }

    //BONUSES
    //USING LOOPS! WOO!

    public static int longestWord(String[] listOfWords){

        int max = 0; //zero is a safe starting point of max because words cannot have negative length. In general that is something to watch for though
        for(int i = 0; i<listOfWords.length; i++){
            if(listOfWords[i].length()>max){
                max = listOfWords[i].length();
            }
        }
        return max;
    }

    public static String[] filterLongWords(String[] startArray, int n){
        List<String> longWordList = new ArrayList<String>();
        for(int i = 0; i<startArray.length; i++){
            if(startArray[i].length()>=n){
                longWordList.add(startArray[i]);
            }
        }
        return longWordList.toArray(new String[0]);//toArray just returns a generic array of objects, we need to specify that these are in fact Strings in the array
    }
}

