import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by patrickcummins on 6/8/16.
 */
public class Main {
    public static void main(String[]args){


    }
    public static boolean isPalindrome(String word){
        String backwords = "";
        word = word.toLowerCase();
        for (int i = word.length()-1; i >= 0; i--) {
            backwords= backwords + word.charAt(i);


        }
        if (backwords.equals(word)){
            return true;
        }
        else {
            return false;
        }

    }
    public static String everyOther(){
        ArrayList<String> myArrayList = new ArrayList<String>();
        String everyOtherLetter = "";
        for (int i = 1; i < myArrayList.size() ; i+=2) {
            everyOtherLetter += everyOtherLetter.charAt(i);


        }
        return everyOtherLetter;
    }
    public static int maxValue(int[] myArray){
        int largest = myArray[0];
        for (int i = 1; i < myArray.length; i++) {
            if (myArray[i]>largest){
                largest = myArray[i];
            }
            
        }
        return largest;
    }
    public static int daysInMonth(String month){
        month = month.toLowerCase();
        if(month.equals("january") || month.equals("march") || month.equals("may") || month.equals("july") || month.equals("august") || month.equals("october") || month.equals("december")){
            return 31;
        }else if(month.equals("april") || month.equals("june") || month.equals("september") || month.equals("november")){
            return 30;
        }else if(month.equals("february")){
            return 28;
        }else{
            return 0;
        }
    }
    public static int arrayMath(int[] myArray){
        int total=0;
        for (int i = 0; i < myArray.length; i++) {
            if(myArray[i]>1 && myArray[i]<=20){
                total +=myArray[i];
            }else if(myArray[i]>20){
                total-=3;
            }


        }
        return total;
    }
    public static ArrayList<String> noDuplicates(ArrayList<String> listToCheck){
        for (int i = 0; i < listToCheck.size(); i++) {
            for (int j = 0; j < listToCheck.size(); j++) {
                if(listToCheck.get(i).equals(listToCheck.get(j))){
                    listToCheck.remove(j);
                    i-=1;
                }

            }

        }
        return listToCheck;

    }
    public static String noVowels(String word){
        char currentChar;
        String newString = "";
        for (int i = 0; i < word.length(); i++) {
            currentChar = word.charAt(i);
            if (currentChar == 'a'|| currentChar == 'e'|| currentChar == 'i'|| currentChar == 'o'|| currentChar == 'u'){

            }else{
                newString += currentChar;
            }

        }
        return newString;
    }
    public static void switchFirstandLast(ArrayList<String> myList){
        String last = myList.get(myList.size()-1);
        myList.set(myList.size()-1, myList.get(0));
        myList.set(0, last);
        for (int i = 0; i < myList.size()-1; i++) {
            System.out.println(myList.get(i));
        }
    }
    public static int middleNumber(int lengthOfList){
        ArrayList<Integer> myArrayList = new ArrayList<Integer>();
        for (int i = 1; i < lengthOfList; i++) {
            myArrayList.add(i);

        }
        if(lengthOfList%2==0){
            return -1;
        }else{
            return myArrayList.get((lengthOfList/2)+1);
        }

    }
    public static int familyMemberAge(HashMap<String, Integer> map){
        Scanner myScanner = new Scanner(System.in);
        System.out.printf("Enter Family Member Name:");
        String name = myScanner.nextLine();
        int age = map.get(name);
        return age;

    }





}
