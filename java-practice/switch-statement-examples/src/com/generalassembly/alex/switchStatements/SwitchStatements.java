package com.generalassembly.alex.switchStatements;

import com.generalassembly.alex.Constants;

/**
 * Print out certain values based on method argument.
 *
 * * Remember: Switch statements and if-statements can be interchanged
 *
 * Created by alex on 2/26/16.
 */
public class SwitchStatements {

    /**
     * Print whether we found an "apple, orange or banana".
     *
     * @param inputString
     */
    public static void print(String inputString){
        if (inputString == null){
            return; // we return here so we do not crash because inputString is null
        }
        switch (inputString){
            case Constants.APPLE:
                System.out.println("Switch (String) - I found an " + Constants.APPLE);
                break;
            case Constants.ORANGE:
                System.out.println("Switch (String) - I found an " + Constants.ORANGE);
                break;
            case Constants.BANANA:
                System.out.println("Switch (String) - I found a " + Constants.BANANA);
                break;
            default:
                System.out.println("Switch (String) - I didn't find any " + inputString + " :(");
                break;
        }
    }

    /**
     * Print whether we found "0, 5, 10, or no coins".
     *
     * @param inputValue
     */
    public static void print(int inputValue){
        switch (inputValue){
            case 0:
                System.out.println("Switch (int) - I found " + 0 + " coins");
                break;
            case 5:
                System.out.println("Switch (int) - I found " + 5 + " coins");
                break;
            case 10:
                System.out.println("Switch (int) - I found " + 10 + " coins");
                break;
            default:
                System.out.println("Switch (int) - I didn't find any " + inputValue + " coins :(");
                break;
        }
    }

    /**
     * Print whether we found letters "a, b, B, or no letters".
     *
     * @param inputChar
     */
    public static void print(char inputChar){
        switch (inputChar){
            case 'a':
                System.out.println("Switch (char) - I found the letter - a");
                break;
            case 'b':
                System.out.println("Switch (char) - I found the letter - b");
                break;
            case 'B':
                System.out.println("Switch (char) - I found the letter - B");
                break;
            default:
                System.out.println("Switch (char) - I didn't find any " + inputChar + " letters :(");
                break;
        }
    }


}
