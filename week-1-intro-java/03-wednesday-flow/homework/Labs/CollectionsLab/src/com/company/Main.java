package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

    palindrome("");
        //System.out.println(palindrome("dad"));
    maxArray();
    daysOfMonth();
    sumIntegers();
//    omitVowels("apple");
        System.out.println(omitVowels("apple"));
    }

    public static boolean palindrome(String word){
        if (word.equals(new StringBuilder(word).reverse().toString())){
            return true;
        }
        else{
            return false;
        }
    }

    public static String everyOther(){
        ArrayList<Character> cList = new ArrayList<>();
        cList.add('a');
        cList.add('b');
        cList.add('c');
        cList.add('d');
        return "" + cList.get(1) + cList.get(1);
    }

    public static int maxArray(){
        int[] anArray;
        int maxValue = 0;
        anArray = new int[10];
        anArray[0] = 1;
        anArray[1] = 2;
        anArray[2] = 3;
        anArray[3] = 4;
        for (int i = 0; i < anArray.length; i++){
            if (maxValue < anArray[i]){
                maxValue = anArray[i];
            }
        }
        return maxValue;
    }

    public static void daysOfMonth(){
        String month = "April";

        switch(month) {
            case "January":
                System.out.println(month + " has 30 days");
                break;
            case "February":
                System.out.println(month + " has 28 days");
                break;
            case "March":
                System.out.println(month + " has 31 days");
                break;
            case "April":
                System.out.println(month + " has 30 days");
                break;
            case "May":
                System.out.println(month + " has 31 days");
                break;
            case "June":
                System.out.println(month + " has 30 days");
                break;
            case "July":
                System.out.println(month + " has 31 days");
                break;
            case "August":
                System.out.println(month + " has 31 days");
                break;
            case "September":
                System.out.println(month + " has 30 days");
                break;
            case "October":
                System.out.println(month + " has 31 days");
                break;
            case "November":
                System.out.println(month + " has 30 days");
                break;
            case "December":
                System.out.println(month + " has 31 days");
                break;
            default:
                System.out.println("0");
        }
    }


    public static int sumIntegers(){
        int[] anSumArray;
        int sum = 0;
        anSumArray = new int[10];
        anSumArray[0] = 10;
        anSumArray[1] = 20;
        anSumArray[2] = 33;
        anSumArray[3] = 43;
        for (int i = 0; i < anSumArray.length; i++){
            if (1 < anSumArray[i]){
                sum = sum + anSumArray[i];
            }
            if (20 < anSumArray[i]){
                sum = sum - 3;
            }
        }
        return sum;
    }

    public static ArrayList<String> duplicates(ArrayList<String> dupeList){
        ArrayList<String> noDupeList = new ArrayList<>();
        for (String nameToCheck : dupeList){
            if (!noDupeList.contains(nameToCheck)){
                noDupeList.add(nameToCheck);
            }
        }
        return noDupeList;
    }
// Write a function that takes in a string, omits all vowels and returns
// a new string that contains only consonants. Make sure to catch the edge cases
// (e.g. empty string, upper/lower case).

    public static String omitVowels(String word){
        String newWord = "";
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            switch(c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    break;
                default:
                    newWord = newWord + c;
            }
        }
        return newWord;
    }

}
