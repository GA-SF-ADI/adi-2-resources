package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(maxOfTwoNumbers(1, 2) + "");
        System.out.println(maxOfThree(3, 4, 3) + "");
        System.out.println(isCharacterAVowel("p") + "");
        System.out.println(reverseString("jag testar"));
        System.out.println(echo("Hello"));
        System.out.println(hasL("what L"));
        System.out.println(millisecondsToDays(1000000000l));
    }

    //Lab methods
    public static int maxOfTwoNumbers(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }

    }

    public static int maxOfThree(int num1, int num2, int num3) {
        if (maxOfTwoNumbers(num1, num2) > num3) {
            return maxOfTwoNumbers(num1, num2);
        } else return num3;

    }

    /* less retarded way of doing the same method....?
    public static boolean isCharacterAVowel(String char1) {
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels.contains(char1);
    }
    */

    public static boolean isCharacterAVowel(char char1) {
        if (char1 == 'a' || char1 == 'o' || char1 == 'e' || char1 == 'i' || char1 == 'u') {
            return true;
        } else return false;
    }

    public static int numOfArgs (Integer... args){
        return args.length;

    }

    public static String reverseString(String st) {
        String reverse = new String();
        for (int i = st.length(); i>0; i--) {
            reverse = reverse + st.charAt(i-1);
        }
        return reverse;
    }

    //Homework methods

    public static String echo (String s){
        String last2Letters = "" + s.charAt(s.length()-2) + s.charAt(s.length()-1);
        String echo = s;
        for (int i = 0; i < 3; i++) {
            echo = echo + last2Letters;
        }
        return echo;
    }

    public static boolean hasL (String s){
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'l' || s.charAt(i) == 'L'){
                return true;
            }
        }
        return false;
    }

    public static long millisecondsToDays (long l){
        long days = l/1000/60/60/24;
        return days;
    }
}

