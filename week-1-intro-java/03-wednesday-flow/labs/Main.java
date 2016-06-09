package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        monthDays("may");


    }


    //1
    public static boolean palindrome(char[]myWord){
        int num1 = 0;
        int num2 = myWord.length -1;
        while(num1<num2){
            if(myWord[num1]==myWord[num2]){
                return true;
            }
            num1++;
            num2--;
        }
        return false;
    }

    //2

    public static String everyOther(){

        String otherChars = new String();
        ArrayList<Character> charList = new ArrayList<>();

        charList.add('a');
        charList.add('b');
        charList.add('c');
        charList.add('d');
        charList.add('e');

        for (int i = 0; i < charList.size(); i+=2) {
            otherChars = otherChars + charList.get(i);

        }
        return otherChars;
    }

    //3



    //4

    public static int monthDays(String month){
        int daysMonth;

        switch (month){
            case "january":
                daysMonth=31;
            break;
            case "febuary":
                daysMonth= 29;
            break;
            case "march":
                daysMonth= 31;
            break;
            case "april":
                daysMonth= 30;
            break;
            case "may":
                daysMonth= 31;
            break;
            case "june":
                daysMonth= 30;
            break;
            case "july":
                daysMonth= 31;
            break;
            case "august":
                daysMonth= 31;
            break;
            case "september":
                daysMonth= 30;
            break;
            case "october":
                daysMonth= 31;
            break;
            case "november":
                daysMonth= 30;
            break;
            case "december":
                daysMonth= 31;
            break;


        }
        return daysMonth;

    }

    //5
    public static int sumSubtract(int[]myNum){


    }
}
