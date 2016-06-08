package com.company;

public class Main {

    public static void main(String[] args) {

    }

    public static int maxOfTwoNumbers(int num1, int num2) {

        if (num1>num2){
            return num1;
        }else return num2;

    }

    public static int maxOfThree(int num1, int num2, int num3){

        if (num1>num2){
            return num1;
        } else if (num1>num3){
            return num1;
        } else if (num2>num1){
            return num2;
        } else if (num2>num3){
            return num2;
        } else {
            return num3;
        }

    }

    public static boolean isCharacterAVowel(char userChar){

        if (userChar=='a'){
            return true;
        }else if (userChar=='e'){
            return true;
        }else if (userChar=='i'){
            return true;
        }else if (userChar=='o'){
            return true;
        }else if (userChar=='u'){
            return true;
        }else{
            return false;
        }

    }
    //  I googled this but have no idea if it's correct
    public static void returnNumber(String[] args) {
        System.out.println(args.length);
    }

    //

    public static String reverseString(String[]args){
        String a = new String ("jag tester");
    }



}
