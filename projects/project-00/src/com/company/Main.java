package com.company;

import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Random;

public class Main {

//    Class variables for player and computer entry into history

    static String rPSPlayerSelection;
    static int randomNum;
    static String computerEntryToHistory = Integer.toString(randomNum);
    static String playerEntryToHistory = rPSPlayerSelection;
    static String computerToHistory;
    static ArrayList<String> arrayForHistory = new ArrayList<String>();


    public static void welcomeMessage(){

        System.out.println("");

        System.out.println("Welcome to Rock Paper Scissors!\n" +
                "\n" +
                "MAIN MENU\n" +
                "=====\n" +
                "\n" +
                "1. Type 'play' to play\n" +
                "2. Type 'history' to view your game history\n" +
                "Type 'quit' to stop playing\n" +
                "\n" +
                "• Please click below this line in the console, type your " +
                "selection, and then press the return key\n");
    }

    public static void close() {
        scanner.close();
    }

    //    Game method
    public static void playingGame() {

        System.out.println("Type in 'rock' 'paper' or 'scissors' to play.\n" +
                " Type 'quit' to go back to the Main Menu\n");
        System.out.println("");

        System.out.println("");

//            rPS = Player's rock, paper, scissors initial choice

        Scanner rPSscan = new Scanner(System.in);

        rPSPlayerSelection = rPSscan.nextLine().toLowerCase(); //<–– Lower-casing method called on player entry

        System.out.println("");


//            Random number is generated

        Random rand = new Random();

        randomNum = rand.nextInt((3 - 1) + 1) + 1;

        String rpsComputerSelectionPrintOut;

//            Assigning random numbers to rock, paper, scissor print out

        if (randomNum == 1) {

            rpsComputerSelectionPrintOut = "rock";
            System.out.println("Computer picks: rock");

        } else if (randomNum == 2) {

            rpsComputerSelectionPrintOut = "paper";
            System.out.println("Computer picks: paper");

        } else if (randomNum == 3) {

            rpsComputerSelectionPrintOut = "scissors";
            System.out.println("Computer picks: scissors");

        }

//            Player's selection is printed

        System.out.println("User picks: " + rPSPlayerSelection);


//            Setting logic (e.g. paper beats rock, rock beats scissors, etc.)

        if (randomNum == 1 && rPSPlayerSelection.equals("paper")) {
            System.out.println("Yippee! You WIN!");
            computerToHistory = "rock";

        }

        if (randomNum == 2 && rPSPlayerSelection.equals("scissors")) {
            System.out.println("Yippee! You WIN!");
            computerToHistory = "paper";
        }

        if (randomNum == 3 && rPSPlayerSelection.equals("rock")) {
            System.out.println("Yippee! You WIN!");
            computerToHistory = "scissors";
        }

        if (randomNum == 1 && rPSPlayerSelection.equals("scissors")) {
            System.out.println("Sorry! You LOSE! HAHA!");
            computerToHistory = "rock";
        }

        if (randomNum == 2 && rPSPlayerSelection.equals("rock")) {
            System.out.println("Sorry! You LOSE! HAHA!");
            computerToHistory = "paper";
        }

        if (randomNum == 3 && rPSPlayerSelection.equals("paper")) {
            System.out.println("Sorry! You LOSE! HAHA!");
            computerToHistory = "scissors";
        }

        if (randomNum == 1 && rPSPlayerSelection.equals("rock")) {
            System.out.println("It's a tie!");
            computerToHistory = "rock";
        }
        if (randomNum == 2 && rPSPlayerSelection.equals("paper")) {
            System.out.println("It's a tie!");
            computerToHistory = "paper";

        }
        if (randomNum == 3 && rPSPlayerSelection.equals("scissors")) {
            System.out.println("It's a tie!");
            computerToHistory = "scissors";

        }

        arrayForHistory.add("Computer played –>" + computerToHistory + " You played –>" + rPSPlayerSelection);
        System.out.println("");
        System.out.println("");
        System.out.println("Welcome to Rock Paper Scissors!\n" +
                "\n" +
                "MAIN MENU\n" +
                "=====\n" +
                "\n" +
                "1. Type 'play' to play\n" +
                "2. Type 'history' to view your game history\n" +
                "Type 'quit' to stop playing\n" +
                "\n" +
                "• Please click below this line in the console, type your " +
                "selection, and then press the return key\n");
        Scanner firstScan = new Scanner(System.in);
        String playOrHistoryDecision = firstScan.nextLine();

        if (playOrHistoryDecision.equalsIgnoreCase("play")) {

            playingGame();
        }

        if (!playOrHistoryDecision.equalsIgnoreCase("history") || playOrHistoryDecision.equalsIgnoreCase("play")) {

            System.out.println("Hey, cut it out! That's not cool. That's not a valid entry. Please try again.");
            System.out.println("");
            playingGame();
        }

        if (playOrHistoryDecision.equalsIgnoreCase("history")) {

            System.out.println(arrayForHistory);
            System.out.println("");
            welcomeMessage();

        }

        if (playOrHistoryDecision.equalsIgnoreCase("quit")) {

            scanner.close();

        }


    }

    public static void showHistory(String computerToHistory, String rPSPlayerSelection) {

        System.out.println("WIN: Computer picked ->" + computerToHistory + " " + "and you picked ->" + rPSPlayerSelection);
        System.out.println("");
        System.out.println("");
        System.out.println("Welcome to Rock Paper Scissors!\n" +
                "\n" +
                "MAIN MENU\n" +
                "=====\n" +
                "\n" +
                "1. Type 'play' to play\n" +
                "2. Type 'history' to view your game history\n" +
                "Type 'quit' to stop playing\n" +
                "\n" +
                "• Please click below this line in the console, type your " +
                "selection, and then press the return key\n");
        Scanner firstScan = new Scanner(System.in);
        String playOrHistoryDecision = firstScan.nextLine();

    }

    public static void reloadAfterInvalidEntry() {

        System.out.println("Welcome to Rock Paper Scissors!\n" +
                "\n" +
                "MAIN MENU\n" +
                "=====\n" +
                "\n" +
                "1. Type 'play' to play\n" +
                "2. Type 'history' to view your game history\n" +
                "Type 'quit' to stop playing\n" +
                "\n" +
                "• Please click below this line in the console, type your " +
                "selection, and then press the return key\n");
        Scanner firstScan = new Scanner(System.in);
        String playOrHistoryDecision = firstScan.nextLine();

        if (playOrHistoryDecision.equalsIgnoreCase("play")) {

            playingGame();
        }

        if (playOrHistoryDecision.equalsIgnoreCase("history")) {

            showHistory(computerToHistory, rPSPlayerSelection);

        }


    }

    public static void main(String[] args) throws IOException {

//        Declaring welcome message String

        String welcomeMessage = "Welcome to Rock Paper Scissors!\n" +
                "\n" +
                "MAIN MENU\n" +
                "=====\n" +
                "\n" +
                "1. Type 'play' to play\n" +
                "2. Type 'history' to view your game history\n" +
                "Type 'quit' to stop playing\n" +
                "\n" +
                "• Please click below this line in the console, type your " +
                "selection, and then press the return key\n";

//        Printing welcome message

        System.out.println(welcomeMessage);

//        Priming console to accept typing

        Scanner firstScan = new Scanner(System.in);

        String playOrHistoryDecision = firstScan.nextLine();

        if ((playOrHistoryDecision.equalsIgnoreCase("play"))) {

            playingGame();

        }

        if (!playOrHistoryDecision.equalsIgnoreCase("history") || playOrHistoryDecision.equalsIgnoreCase("play")) {

            System.out.println("Hey, cut it out! That's not cool. That's not a valid entry. Please try again.");
            System.out.println("");
            playingGame();
        }


    }

}














