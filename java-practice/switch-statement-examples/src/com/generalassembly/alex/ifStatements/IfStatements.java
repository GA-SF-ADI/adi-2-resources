package com.generalassembly.alex.ifStatements;

import com.generalassembly.alex.Constants;

/**
 * Created by alex on 2/26/16.
 */
public class IfStatements {

    /**
     * Prints the inputString value if its "apple, banana, or print back what was input"
     * @param inputString
     */
    public static void print(String inputString){
        if (inputString == null){
            System.out.println("If-else (String) - inputString is null");
        } else if (inputString.isEmpty()){
            System.out.println("If-else (String) - inputString is empty");
        } else if (inputString.equals(Constants.APPLE)){
            System.out.println("If-else (String) - inputString is " + Constants.APPLE);
        } else if (inputString.contains(Constants.BANANA)){
            System.out.println("If-else (String) - inputString is " + Constants.BANANA);
        } else {
            System.out.println("If-else (String) - inputString not found: " + inputString);
        }
    }

    public static void print(char inputChar){
        if (inputChar == 'a'){
            System.out.println("If-else (char) - inputChar is 'a' ");
        } else if (inputChar == 'B'){
            System.out.println("If-else (char) - inputChar is 'B' ");
        } else {
            System.out.println("If-else (char) - inputChar is not found: " + inputChar);
        }
    }

    /**
     * Checks whether the int is odd or even, and prints it out.
     * Then prints out if int is equal to, less than, or greater then 10.
     * @param inputValue
     */
    public static void print(int inputValue){
        if (inputValue % 2 == 0){
            System.out.println("If-else (int) - " + inputValue + " is even");
            checkValue(inputValue);
        } else {
            System.out.println("If-else (int) - " + inputValue + " is odd");
            checkValue(inputValue);
        }
    }

    public static void print(float inputValue){
        if (inputValue == 10.123f){
            System.out.println("If-else (float) - " + inputValue + " is == 10.123");
        } else if (inputValue < 10.123f){
            System.out.println("If-else (float) - " + inputValue + " is < 10.123");
        } else {
            System.out.println("If-else (float) - " + inputValue + " is > 10.123");
        }
    }

    /**
     * Prints if inputValue is equal to, less then or greater then 10.123456789.
     *
     * @param inputValue
     */
    public static void print(double inputValue){
        if (inputValue == 10.123456789d){
            System.out.println("If-else (double) - " + inputValue + " is == 10.123456789");
        } else if (inputValue < 10.123456789d){
            System.out.println("If-else (double) - " + inputValue + " is < 10.123456789");
        } else {
            System.out.println("If-else (double) - " + inputValue + " is > 10.123456789d");
        }
    }

    /**
     * Prints if inputValue is equal to, less then or greater then 123456789.
     *
     * @param inputValue
     */
    public static void print(long inputValue){
        if (inputValue == 123456789){
            System.out.println("If-else (long) - " + inputValue + " is == 123456789");
        } else if (inputValue < 123456789){
            System.out.println("If-else (long) - " + inputValue + " is < 123456789");
        } else {
            System.out.println("If-else (long) - " + inputValue + " is > 123456789");
        }
    }

    private static void checkValue(int inputValue){
        if (inputValue == 10){
            System.out.println("\t\t" + inputValue + " is == 10");
        } else if (inputValue < 10){
            System.out.println("\t\t" + inputValue + " is < 10");
        } else {
            System.out.println("\t\t" + inputValue + " is > 10");
        }
    }
}
