package com.generalassembly.alex.Loops;

/**
 * This class shows you how to print values starting
 * from 0 and going to the stop value that is passed
 * in the function argument.
 *
 * Key part for the do-while-loops is to remember the following parts:
 * - 1) We need to declare and initialize the loop variable like so: "int start = 0" - in this case the loop variable is "start".
 * - 2) "start < stop" is our expression where we evaluate whether we should continue looping or not.
 * - 3) We increment "start" by 1. Remember: "start++ is the same as start = start + 1"
 *
 * ** Remember that do-while-loops are guaranteed to execute AT LEAST ONCE!
 * * Remember that each of the above parts lives separately, unlike in a for-loop.
 *
 * Created by alex on 2/26/16.
 */
public class DoWhileLoops {
    /**
     * Do-while loop iterating over an 'int'
     *
     * Prints values starting from 0 and going to the stop value that is passed
     * in the function argument.
     *
     * @param stop int Value to stop printing at
     */
    public static void printUpTo(int stop){
        int start = 0; // 1) - See above
        do {
            System.out.println("Do-while-loop (int) value: " + start + " out of: " + stop);
            start++; // 3) - See above
        } while (start < stop); // 2) - See above
        System.out.println("");
    }

    /**
     * Do-while loop iterating over a 'long'
     *
     * Prints values starting from 0 and going to the stop value that is passed
     * in the function argument.
     *
     * @param stop long Value to stop printing at
     */
    public static void printUpTo(long stop){
        long start = 0; // 1) - See above
        do {
            System.out.println("Do-while-loop (long) value: " + start + " out of: " + stop);
            start++; // 3) - See above
        } while (start < stop); // 2) - See above
        System.out.println("");
    }

    /**
     * Do-while loop iterating over a 'float'
     *
     * Prints values starting from 0 and going to the stop value that is passed
     * in the function argument.
     *
     * @param stop float Value to stop printing at
     */
    public static void printUpTo(float stop){
        float start = 0; // 1) - See above
        do {
            System.out.println("Do-while-loop (float) value: " + start + " out of: " + stop);
            start++; // 3) - See above
        } while (start < stop); // 2) - See above
        System.out.println("");
    }

    /**
     * Do-while loop iterating over a 'double'
     *
     * Prints values starting from 0 and going to the stop value that is passed
     * in the function argument.
     *
     * @param stop double Value to stop printing at
     */
    public static void printUpTo(double stop){
        double start = 0; // 1) - See above
        do {
            System.out.println("Do-while-loop (double) value: " + start + " out of: " + stop);
            start++; // 3) - See above
        } while (start < stop); // 2) - See above
        System.out.println("");
    }
}
