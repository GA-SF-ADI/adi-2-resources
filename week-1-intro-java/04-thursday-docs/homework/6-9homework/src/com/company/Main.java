package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {


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
            history();
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
            System.out.println("user picks: paper");

        }
    }


    public static void comPick() { // created a random object ot get a random number for computer choice
        Random cpu = new Random();
        cpu.nextInt(3);
        if (cpu.equals(0)) {
            System.out.println("computer picks rock");
        } else if (cpu.equals(1)) {
            System.out.println("computer picks scissors");

            if (cpu.equals(2)) {
                System.out.println("computer picks paper");


            }
        }
    }

    public static void whoWins(String userChoice, int cpuChoice) {
        if (userChoice.equals("rock") && (cpuChoice == 0)) {
            System.out.println("it is a tie");


        }
    }

    public static void history() {

    }

}
