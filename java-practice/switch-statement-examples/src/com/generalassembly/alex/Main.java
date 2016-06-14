package com.generalassembly.alex;

import com.generalassembly.alex.ifStatements.IfStatements;
import com.generalassembly.alex.switchStatements.SwitchStatements;

public class Main {

    public static void main(String[] args) {
        printSwitchStatements();
        printIfStatements();
    }

    private static void printSwitchStatements(){
        System.out.println();
        printIntSwitch();
        printStringSwitch();
        printCharSwitch();
        System.out.println();
    }

    private static void printIfStatements(){
        printIfString();
        printIfChar();
        printIfInt();
        printIfLong();
        printIfFloat();
        printIfDouble();
    }

    private static void printIntSwitch(){
        SwitchStatements.print('a');
        SwitchStatements.print('b');
        SwitchStatements.print('B');
        SwitchStatements.print('z');
        System.out.println();
    }

    private static void printStringSwitch(){
        SwitchStatements.print(Constants.APPLE);
        SwitchStatements.print(Constants.BANANA);
        SwitchStatements.print(Constants.ORANGE);
        SwitchStatements.print("kiwi");
        System.out.println();
    }

    private static void printCharSwitch(){
        SwitchStatements.print(0);
        SwitchStatements.print(5);
        SwitchStatements.print(10);
        SwitchStatements.print(20);
        System.out.println();
    }

    private static void printIfString(){
        IfStatements.print(null);
        IfStatements.print("");
        IfStatements.print(Constants.APPLE);
        IfStatements.print(Constants.BANANA);
        IfStatements.print(Constants.ORANGE);
        System.out.println();
    }

    private static void printIfChar(){
        IfStatements.print('a');
        IfStatements.print('B');
        IfStatements.print('z');
        System.out.println();
    }

    private static void printIfInt(){
        IfStatements.print(2);
        IfStatements.print(3);
        IfStatements.print(10);
        IfStatements.print(11);
        IfStatements.print(12);
        System.out.println();
    }

    private static void printIfDouble(){
        IfStatements.print(10.123456789d);
        IfStatements.print(8.123456700d);
        IfStatements.print(13.123456999d);
        System.out.println();
    }

    private static void printIfFloat(){
        IfStatements.print(10.123f);
        IfStatements.print(5.113f);
        IfStatements.print(15.343f);
        System.out.println();
    }

    private static void printIfLong(){
        IfStatements.print(123456789l);
        IfStatements.print(111111189l);
        IfStatements.print(999999789l);
        System.out.println();
    }
}
