package com.company;

public class Main {

    //Determining the higher of

    public static int maxOfTwoNumbers(int num1, int num2) {

        if (num1 > num2) {
            return num1;

        } else
            return num2;
    }

    //Determining max # out of 3 numbers

    public static int maxOfThree(int num1, int num2, int num3){

        if (num1 > num2 && num1 > num3){
            return num1;

        }else if (num2 > num1 && num2 > num3){
            return num2;

        }else{
            return num3;
        }

}

    //Function #3 of 5

    public static boolean isCharacterAVowel(char vowelcheck){

        if(vowelcheck == 'a'){
            return true;
        }else if(vowelcheck =='e'){
            return true;

        }else if(vowelcheck =='i'){
            return true;

        }else if(vowelcheck =='o'){
            return true;

        }else if(vowelcheck =='u'){
            return true;

        }else{
            System.out.println("False");
            return false;
        }

    }

    //Function #4 of 5

   public static int argumentNumber(//Not sure what goes in here...){
            return //__something here__.length;

}


    //Function #5 of 5

    public static String revString(String stringchoice){
        return revString(stringchoice);
    }

}
