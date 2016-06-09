package com.company;
import java.util.ArrayList;

public class Main {


    /* 1. Write a function that takes in a word.
    This function should return true if the word is a palindrome and false if it is not.
    A string is considered a palindrome if it remains unchanged when reversed.
    For example, "dad" is a palindrome as reverse of "dad" is "dad", whereas "program" is not a palindrome.
    Note: palindromes are case insensitive ("Dad" and "dad" are both palindromes).
     */

    public static boolean takeInAWord (String word) {
       String reverse = new String ();
        int length = word.length();

        for (int i = length - 1; i >= 0; i--)
        {
            reverse = reverse +word.charAt(i);
        }

        if (word.equals(reverse)) {
            return true;
        }
        else {
            return false;
        }

    }


    /*
    2. Write a function that accepts no parameters and creates a list of any characters
    and returns a string, which contains every other element in the list.
    Thus, if the list has 'a', 'b', 'c', 'd', the output should be "bd".
     */

    public static String listOfCharacters (){
    String listOfCharactersOther = new String();
        ArrayList<Character> characterList = new ArrayList<>();

        characterList.add('a');
        characterList.add('b');
        characterList.add('c');
        characterList.add('d');
        characterList.add('e');

        for (int i = 1; i <= characterList.size(); i+=2) {
            listOfCharactersOther = listOfCharactersOther + characterList.get(i);

        }
        return listOfCharactersOther;
    }


/*
    public static String listOfCharacters (){
        String listOfCharactersOther = new String();
        ArrayList<Character> characterList = new ArrayList<>();

        characterList.add('a');
        characterList.add('b');
        characterList.add('c');
        characterList.add('d');
        characterList.add('e');
        String error = "Error";
        String characters = "Characters are" + characterList;

        int anArray = characterList.size();

      if (anArray % 2!= 0) {
          return characters;
//hmmm stuck here! I tried to solve this problem # 2 in another way
        }
      else {
          return error;
      }
    }
    */

    /*
    3. Write a function that takes in an array of integers
    and returns the max value in that array.
    Please do not sort the array.
     */

    public static int returnsMaxArrayValue (int [] anArray) {

       int returnsMaxValue = anArray[0];
        for (int currentValue : anArray) {
            if (currentValue > returnsMaxValue) {
                returnsMaxValue = currentValue;
            }
        }
        return returnsMaxValue;
        //Do I need to print something out for this method?
    }

    /*
    4. Write a function that takes in a month of the year
    and returns the number of days in this month.
    If the input is not a valid month, return 0.
     */

    public static int returnsNumberOfDays(String month) {
        int returnsNumberOfDays;

        month = month.toUpperCase();

        switch (month) {
            case "JANUARY":
                returnsNumberOfDays = 31;
                break;
            case "FEBRUARY":
                returnsNumberOfDays = 28;
                break;
            case "MARCH":
                returnsNumberOfDays = 31;
                break;
            case "APRIL":
                returnsNumberOfDays = 30;
                break;
            case "MAY":
                returnsNumberOfDays = 31;
                break;
            case "JUNE":
                returnsNumberOfDays = 30;
                break;
            case "JULY":
                returnsNumberOfDays = 31;
                break;
            case "AUGUST":
                returnsNumberOfDays = 31;
                break;
            case "SEPTEMBER":
                returnsNumberOfDays = 30;
                break;
            case "OCTOBER":
                returnsNumberOfDays = 31;
                break;
            case "NOVEMBER":
                returnsNumberOfDays = 30;
                break;
            case "DECEMBER":
                returnsNumberOfDays = 31;
                break;
            default:
                returnsNumberOfDays = 0;
        }
        return returnsNumberOfDays;
    }
        /*
        Write a function that takes in an array of integers,
        sums the integers that are greater than 1, and subtracts 3
        if the number is greater than 20. The function returns
        the result of the operations on the array.
         */

public static int arrayPractice (int [] firstArray){
    int returnSum = 0;

    for (int value1 : firstArray) {

        if (value1 > 20) {
            value1 = value1 - 3;
            return value1;
        } else if (value1 > 1) {
            returnSum = returnSum + 1;
        }
    }
        return returnSum;
//How do I print this out?
}



    public static void main(String[] args) {
	// write your code here

        System.out.println(takeInAWord("pop")); //prints true
        System.out.println(takeInAWord("leap")); // prints false
       //System.out.println(listOfCharacters()); Do I need to print something out?

    }
}
