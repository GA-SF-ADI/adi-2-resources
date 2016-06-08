package com.company;

public class Homework2 {

    public static String maxOfTwoNumbers (int a, int b) {


        if (a > b)
        {
            return String.format ("" +"The greater value is " + a + ".");
        }
        if (b > a)
        {
            return String.format ("" +"The greater value is " + b + ".");
        }

        else
        {
            return String.format ("" + "Error! " + a + " and " + b + " are equal.");

        }
    }

    public static String maxOfThreeNumbers (int c, int d, int e) {

        if (c > d && c > e)
        {
            return String.format ("" +"The greatest value is " + c + ".");
        }
        if (d > e && d > c)
        {
            return String.format ("" +"The greatest value is " + d + ".");
        }

        if (e > d && e > c)
        {
            return String.format ("" +"The greatest value is " + e + ".");

        }

        else {
            return String.format ("Error! Either there is a tie or all the numbers are equal!");
        }
    }


    public static boolean isCharacterAVowel(char character1) {
        //hmmm there must be a shorter way to do this...

        if (character1 == 'a' || character1 == 'e'|| character1 == 'i' || character1 == 'o' || character1 == 'u')
        {
            return true;
        }

        if (character1 == 'A' || character1 == 'E'|| character1 == 'I' || character1 == 'O' || character1 == 'U')
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    public static int numberOfArguments (int arguments)
    {
        return arguments;
        //returns the number of arguments passed to a function when called
    }


    public static String reverseString (String reverseString) {
        int i, len = reverseString.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--) {
            dest.append(reverseString.charAt(i));
        }
        return dest.toString();
    }

    // got help from http://stackoverflow.com/questions/7569335/reverse-a-string-in-java

    public static void main(String[] args) {
        // write your code here
        System.out.println(maxOfTwoNumbers(9,10));
        System.out.println(maxOfTwoNumbers(0,0));
        System.out.println(maxOfTwoNumbers(100,1000));
        System.out.println(maxOfThreeNumbers(9, 10, 11));
        System.out.println(maxOfThreeNumbers(190, 12, 12));
        System.out.println(maxOfThreeNumbers(0, 120, 120));
        System.out.println(isCharacterAVowel('j'));
        System.out.println(isCharacterAVowel('A'));
        System.out.println(numberOfArguments(12));
        System.out.println(reverseString("Audrey"));
        System.out.println(reverseString("June is the month."));


    }
}