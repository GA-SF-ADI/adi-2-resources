package com.generalassembly.alex;

public class Main {

    public static void main(String[] args) {
        printNoArguments();
        printOneArgument();
        printTwoArguments();
    }

    private static void printNoArguments(){
        System.out.println();
        noReturnNoArgument();
        returnIntNoArgument();
        returnFloatNoArgument();
        returnDoubleNoArgument();
        returnStringNoArgument();
    }

    private static void printOneArgument(){
        System.out.println();
        System.out.println("About to return (int) for (one) argument value of 5");
        int returnValue = returnIntOneArgument(5);
        System.out.println("Return (int) for (one) argument is: " + returnValue);
    }

    private static void printTwoArguments(){
        System.out.println();
        System.out.println("About to return (float) for (two) arguments - apple and 10");
        float returnValue = returnFloatTwoArguments("apple", 5);
        System.out.println("Return (float) for (two) arguments is: " + returnValue);
    }


    private static void noReturnNoArgument(){
        System.out.println("This method returns (void), has no arguments");
    }

    private static int returnIntNoArgument(){
        System.out.println("This method returns (int) 0, has no arguments");
        return 0;
    }

    private static double returnDoubleNoArgument(){
        System.out.println("This method returns (double) 0.0, has no arguments");
        return 0.0d;
    }

    private static float returnFloatNoArgument(){
        System.out.println("This method returns (float) 0.0, has no arguments");
        return 0.0f;
    }

    private static String returnStringNoArgument(){
        System.out.println("This method returns (String) 'hello', has no arguments");
        return "hello";
    }

    private static int returnIntOneArgument(int argument){
        System.out.println("This method returns (int) and has one argument");
        return argument * 5;
    }

    private static float returnFloatTwoArguments(String inputString, float argumentTwo){
        float returnValue = argumentTwo;
        switch (inputString){
            case "apple":
                System.out.println("This method returns (float), has two arguments - one is apple");
                returnValue = argumentTwo * 5;
                break;
            case "banana":
                System.out.println("This method returns (float), has two arguments - one is banana");
                returnValue = argumentTwo * 10;
                break;
            default:
                System.out.println("This method returns (float), has two arguments - one is " + inputString);
                break;
        }
        return returnValue;
    }


}
