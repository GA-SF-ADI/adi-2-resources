package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println(isPaliindrome("dad"));

    }

    // function returns true if the word is a palindrome and false if it is not
    public static boolean isPaliindrome(String str){
        StringBuffer s = new StringBuffer();
        s.append(str);
        String rev = s.reverse().toString();
        if (rev.equals(str)){
           return true;

        }else {
            return false;
        }
    }

    public static String everyOtherInAWord(ArrayList myList){
        for (int i = 0; i < myList.length(); i+=2;) {
            System.out.println(i);
            
        }

    }

    public static int maxOfAnArray(int [] myArray){

    }

}
