package com.company;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String result1;
    static String result2;
    static String result3;

    static ArrayList<String> gameHistory = new ArrayList<>();

    public static void main(String[] args) {


        gameStart(); // calling method to start game


    }

    public static void gameStart() { //this method prints out the main menu and takes user input for the menu, uses if else to check user input
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("MAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play\n" + "2. Type 'history' to view your game history\n" + "Type 'quit' to stop playing");

        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        if (input.equals("play")) {
            play();
        } else if (input.equals("history")) {
            history(gameHistory);

        } else if (input.equals("quit")) {
            gameStart();
        } else if (!input.equals("play") || (!input.equals("play") || (!input.equals("play")))) {
            System.out.println("wrong input, try again");
            gameStart();

        }


    }

    public static void play() {  // method  executes after the menu if user chose play

        System.out.println("Type in 'rock' 'paper' or 'scissors' to play.\n" + " Type 'quit' to go back to the Main Menu");
        Scanner userInput = new Scanner(System.in);
        String userChoice = userInput.nextLine();
        ;
        if (userChoice.equals("quit")) {
            gameStart();

        } else if (userChoice.equals("scissors")) {
            System.out.println("user picks: scissors");
            gameHistory.add("user picks:scissors");

        } else if (userChoice.equals("rock")) {
            System.out.println("user picks: rock");
            gameHistory.add("user picks: rock");

        } else if (userChoice.equals("paper")) {
            System.out.println("user picks: paper");
            gameHistory.add("user picks:paper");

        } else if (!userChoice.equals("scissors") || (!userChoice.equals("rock") || (!userChoice.equals("paper")))) {
            System.out.println("not an option, try again");
            play();


        }


        int cpuChoice = (int) (Math.random() * 3);
        if (cpuChoice == 0)

        {
            System.out.println("computer pick: rock");
            gameHistory.add("computer pick: rock");
        } else if (cpuChoice == 1)

        {
            System.out.println("computer picks: scissors");
            gameHistory.add("computer pick: scissors");

        } else if (cpuChoice == 2)

        {
            System.out.println("computer picks: paper");
            gameHistory.add("computer pick: paper");

        }


        if (userChoice.equals("rock") && cpuChoice == 0)

        {
            System.out.println("it is a tie");
            gameHistory.add(" it is a tie");


        } else if (userChoice.equals("rock") && cpuChoice == 1)

        {
            System.out.println("You Win");
            gameHistory.add("You Win");

        } else if (userChoice.equals("rock") && cpuChoice == 2)

        {
            System.out.println("You Lose");
            gameHistory.add("You Lose");
        } else if (userChoice.equals("paper") && cpuChoice == 2)

        {
            System.out.println("it is a tie");
            gameHistory.add("it is a tie");
        } else if (userChoice.equals("paper") && cpuChoice == 1)

        {
            System.out.println("You Lose");
            gameHistory.add("You Lose");
        } else if (userChoice.equals("paper") && cpuChoice == 0)

        {
            System.out.println("You Won");
            gameHistory.add("You Won");

        } else if (userChoice.equals("scissors") && cpuChoice == 0)

        {
            System.out.println("You Lose");
            gameHistory.add("You Lose");
        } else if (userChoice.equals("scissors") && cpuChoice == 1)

        {
            System.out.println("it is a tie");
            gameHistory.add("it is a tie");
        } else if (userChoice.equals("scissors") && cpuChoice == 2)

        {
            System.out.println("You Won");
            gameHistory.add("You Won");
        }


        gameStart();
    }


    public static void history(ArrayList<String> result) {
        for (int i = 0; i < result.size(); i++) {

            System.out.println(gameHistory.get(i));

        }
        gameStart();
    }

}


