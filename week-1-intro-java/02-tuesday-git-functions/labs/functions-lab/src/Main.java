import java.util.ArrayList;

/**
 * Created by patrickcummins on 6/7/16.
 */
public class Main {
    public static void main (String [] args){

    }
    public static double maxOfTwoNumbers(double firstNumber, double secondNumber){
        if (firstNumber>secondNumber){
            return firstNumber;
        }
        else{
            return secondNumber;
        }
    }
    public static double maxOfThree(double firstNumber, double secondNumber, double thirdNumber){
        if(firstNumber>secondNumber && firstNumber >thirdNumber){
            return firstNumber;
        }else if(secondNumber>firstNumber && secondNumber>thirdNumber){
            return secondNumber;
        }else{
            return thirdNumber;
        }
    }
    public static boolean isCharachterAVowel(char myChar) {
        myChar = Character.toLowerCase(myChar);
        if (myChar == 'a' || myChar == 'e' || myChar == 'i' || myChar == 'o' || myChar == 'u') {
            return true;
        } else {
            return false;
        }
    }
    public  static int reutrnArgs(double[] a){
        return a.length;
    }
     public static String reverseString(String myString){
        String myReverseString = "";
        for (int i = myString.length()-1; i>=0; i--){
        myReverseString = myReverseString + myReverseString.charAt(i);

        }
        return myReverseString;
    }
    public static int findLongestWord(String [] words){
        String longestWord = words[words.length-1];
        String currentWord;
        for (int i =words.length-2; i>=0; i--){
            currentWord = words[i];
            if(currentWord.length()>longestWord.length()){
                longestWord = currentWord;
            }
        }
        return longestWord.length();
    }
    public static ArrayList<String> filterLongWords(String[] allWords, int wordLength){
        ArrayList<String> longWords = new ArrayList<String>();
        for (int i=0; i>allWords.length; i++){
            if (allWords[i].length() > wordLength ){
                longWords.add(allWords[i]);
            }
        }
        return longWords;
    }


    }

