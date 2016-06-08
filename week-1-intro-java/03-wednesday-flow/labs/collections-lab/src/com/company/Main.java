package com.company;

public class Main {
    boolean palind;

    public static void main(String[] args) {
        // write your code here
        palindrome("dagd");


    }

    public static void palindrome(String originalStr){
        String reversedStr=reverseString(originalStr);
        String lowCaseReversedStr=reversedStr.toLowerCase();
        if(lowCaseReversedStr.equals(originalStr)){
            System.out.println("The string "+originalStr+" ")
        }


    }

    public static String reverseString(String input){
        String temp="";
        for (int i=input.length()-1;i>=0;i--){
            temp=temp+input.charAt(i);
        }
        return temp;
    }
}


//    //Function1
//    public static void palindrome(String s) {
//        String newS = s.toLowerCase();
//
//        for (int i = 0; i < s.length(); i++) {
//
//            if (s.charAt(i) == s.charAt(s.length() - 1) && s.charAt()) {
//                System.out.println("The string " + s + " is a palindrome");
////                return true;
//            } else{
//                System.out.println("The string " + s + " is not a palindrome");
////                return false;
//            }
//
////            if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
////                System.out.println("The string " + s + " is a palindrome");
//////                return true;
////            } else{
////                System.out.println("The string " + s + " is not a palindrome");
//////                return false;
////            }
//        }
//    }


