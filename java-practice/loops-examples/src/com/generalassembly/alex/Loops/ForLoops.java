package com.generalassembly.alex.Loops;

/**
 * This class shows you how to print values starting
 * from 0 and going to the stop value that is passed
 * in the function argument.
 *
 * Key part for the for-loops is to remember that:
 * - The first part "int start = 0" is where we declare/initialize the loop variable, in this case the loop variable is "start".
 * - The second part is "start < stop" which is our expression where we evaluate whether we should continue looping or not.
 * - The third part is the "start++" where we increment "start" by 1. "start++ is the same as start = start + 1"
 *
 * * Remember that each of the above parts is separated by a semicolon ";".
 *
 * Created by alex on 2/26/16.
 */
public class ForLoops {
    /**
     * For loop iterating over an 'int'
     *
     * Prints values starting from 0 and going to the stop value that is passed
     * in the function argument.
     *
     * @param stop int Value to stop printing at
     */
    public static void printUpTo(int stop){
        for (int start = 0; start < stop; start++){
            System.out.println("For-loop (int) value: " + start + " out of: " + stop);
        }
        System.out.println("");
    }

    /**
     * For loop iterating over a 'double'
     *
     * Prints values starting from 0 and going to the stop value that is passed
     * in the function argument.
     *
     * @param stop double Value to stop printing at
     */
    public static void printUpTo(double stop){
        for (double start = 0; start < stop; start++){
            System.out.println("For-loop (double) value: " + start + " out of: " + stop);
        }
        System.out.println("");
    }

    /**
     * For loop iterating over a 'float'
     *
     * Prints values starting from 0 and going to the stop value that is passed
     * in the function argument.
     *
     * @param stop float Value to stop printing at
     */
    public static void printUpTo(float stop){
        for (float start = 0; start < stop; start++){
            System.out.println("For-loop (float) value: " + start + " out of: " + stop);
        }
        System.out.println("");
    }

    /**
     * For loop iterating over a 'long'
     *
     * Prints values starting from 0 and going to the stop value that is passed
     * in the function argument.
     *
     * @param stop long Value to stop printing at
     */
    public static void printUpTo(long stop){
        for (long start = 0; start < stop; start++){
            System.out.println("For-loop (long) value: " + start + " out of: " + stop);
        }
        System.out.println("");
    }
}
