package com.company;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.awt.SystemColor.text;

public class Main {

    String asksForChoice = "Type in 'rock' 'paper' or 'scissors' to play.\n" +
            " Type 'quit' to go back to the Main Menu\n";


//    Type 'quit' to stop playing

//    Type 'quit' to go back to the Main Menu

//    class which .lowercases' all scanner entries

//
//    ==========================

    /*

         */
    public static void main(String[] args) {

        String welcomeMessage = "Welcome to Rock Paper Scissors!\n" +
                "\n" +
                "MAIN MENU\n" +
                "=====\n" +
                "\n" +
                "1. Type 'play' to play\n" +
                "2. Type 'history' to view your game history\n" +
                "Type 'quit' to stop playing\n" +
                "\n" +
                "• Please click below this line in the console, type your selection, and then press the return key\n";

        System.out.println(welcomeMessage);

        Scanner scanner = new Scanner(System.in);
        String textInputtedToConsole = scanner.nextLine();

        if (textInputtedToConsole.equalsIgnoreCase("play")) {
            System.out.println("");
            System.out.println("");
            System.out.println("Type in 'rock' 'paper' or 'scissors' to play.\n" +
                    " Type 'quit' to go back to the Main Menu\n");
        }

//        else if (/*PUT IN HISTORY SELECTION CODE HERE !!!!*/){
//
//        }
//
//        if (textInputtedToConsole.equalsIgnoreCase()){
//
//            System.out.println("Whoops! That's an invalid entry :(");
//
//        }
//


    }
}
