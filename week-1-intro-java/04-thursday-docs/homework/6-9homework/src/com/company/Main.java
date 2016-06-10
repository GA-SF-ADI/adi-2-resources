package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String winOrLose;
    static String mUser;
    static String mcpu;
    static String mResult;

    public static void main(String[] args) {


        gameStart(); // calling method to start game
        ArrayList gameHistory = new ArrayList();
        gameHistory.add(mResult);
        comPick();
        whoWins(mUser,);



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

        } else if (input.equals("quit")) {
            gameStart();
        } else {
            gameStart();

        }


    }

    public static void play() {  // method  executes after the menu if user chose play

        System.out.println("Type in 'rock' 'paper' or 'scissors' to play.\n" + " Type 'quit' to go back to the Main Menu");
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        ;
        if (input.equals("quit")) {

        } else if (input.equals("scissors")) {
            System.out.println("user picks: scissors");

        } else if (input.equals("rock")) {
            System.out.println("user picks: rock");

        } else if (input.equals("paper")) {
            mUser = "user picks: paper";


        }
        //rand();

    }

   /* public static void rand() {
        int r = (int) (Math.random() * 3);


        if (r == 0) {
            mcpu = "computer picks rock";
        } else if (r == 1) {
            System.out.println("computer picks: scissors");

            if (r == 2) {
                System.out.println("computer picks: paper");


            }
        }
    }
*/

    public static void comPick() { // created a random object ot get a random number for computer choice
        int mcpu;
        Random cpu = new Random();
        mcpu = cpu.nextInt(3);
        if (mcpu == 0) {
            System.out.println("computer pick: rock");
        } else if (mcpu == 1) {
            System.out.println("computer picks: scissors");

        } else if (mcpu == 2) {
            System.out.println("computer picks: paper");


        }
    }


    public static void whoWins(String userChoice, int cpuChoice) {
        if (userChoice.equals("rock") && (cpuChoice == 0)) {
            winOrLose = ("it is a tie");
        } else if (userChoice.equals("rock") && (cpuChoice == 1));
        {
            winOrLose = ("You Win");
        }else if (userChoice.equals("rock") && (cpuChoice == 2));
        {
            winOrLose = ("You Lose");
        }
        else if (userChoice.equals("paper") && (cpuChoice == 2));
        {

            winOrLose = ("it is a tie");
        }
        else if (userChoice.equals("paper") && (cpuChoice == 1));
        {
            winOrLose = "you lose";
        }

        else if (userChoice.equals("paper") && (cpuChoice == 0));
        {
            winOrLose = "you won";

        }else if (userChoice.equals("scissors") && (cpuChoice == 0));
        {
            winOrLose = "you lose";
        }else if (userChoice.equals("scissors") && (cpuChoice == 1));
        {
            winOrLose = "it is a tie";
        }else if (userChoice.equals("scissors") && (cpuChoice == 2));
        {
            winOrLose = "you won";
        }



        mResult = mcpu + mUser.toString() + winOrLose;
        System.out.println(mResult);


    }


    public static void history(ArrayList<String> outcomes) {
        for (int i = 0; i < outcomes.size(); i++) {


            System.out.println(i);


        }

    }
}

