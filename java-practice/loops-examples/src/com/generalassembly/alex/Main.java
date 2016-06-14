package com.generalassembly.alex;

import com.generalassembly.alex.Loops.DoWhileLoops;
import com.generalassembly.alex.Loops.ForLoops;
import com.generalassembly.alex.Loops.WhileLoops;

public class Main {
    private static int xIntValue = 5;
    private static double xDoubleValue = 5;
    private static float xFloatValue = 5;
    private static long xLongValue = 5;

    public static void main(String[] args) {
        printForLoops();
        printWhileLoops();
        printDoWhileLoops();
    }

    private static void printForLoops(){
        System.out.println("*** Start printing all for-loops *** \n");

        ForLoops.printUpTo(xIntValue);
        ForLoops.printUpTo(xLongValue);
        ForLoops.printUpTo(xDoubleValue);
        ForLoops.printUpTo(xFloatValue);

        System.out.println("*** Finished printing all for-loops ***");
    }

    private static void printWhileLoops(){
        System.out.println("*** Start printing all while-loops *** \n");

        WhileLoops.printUpTo(xIntValue);
        WhileLoops.printUpTo(xLongValue);
        WhileLoops.printUpTo(xDoubleValue);
        WhileLoops.printUpTo(xFloatValue);

        System.out.println("*** Finished printing all while-loops ***");

    }

    private static void printDoWhileLoops(){
        System.out.println("*** Start printing all do-while-loops *** \n");

        DoWhileLoops.printUpTo(xIntValue);
        DoWhileLoops.printUpTo(xLongValue);
        DoWhileLoops.printUpTo(xDoubleValue);
        DoWhileLoops.printUpTo(xFloatValue);

        System.out.println("*** Finished printing all do-while-loops ***");

    }

}
