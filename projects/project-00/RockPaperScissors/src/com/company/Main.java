package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static ArrayList<String> history = new ArrayList<String>();


    public static void main(String[] args) {
        mainMenu();
    }


    public static void mainMenu(){
        String str = " MAIN MENU \n _____ \n 1. Type 'PLAY' to play. \n 2. Type 'HISTORY' for history. \n 3. Type 'QUIT' to quit.";
        System.out.println(str);

        String str1 = " Invalid input. Choose 'PLAY', 'HISTORY', or 'QUIT' only.";

        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();

        if (userInput.equalsIgnoreCase("play")) {
            play();
        } else if (userInput.equalsIgnoreCase("history")) {
            getHistory();
        } else if (userInput.equalsIgnoreCase("quit")) {
            System.out.println("Thanks for playing!!!");
            return;
        } else{
            System.out.println(str1);
            mainMenu();
        }

    }


    public static void play() {
        System.out.println("Choose rock, paper, or scissors.");

        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();

        int computerInt = (int) (Math.random() * 3);

        if (computerInt == 0) {
            System.out.println("Computer picks: rock");
        } else if (computerInt == 1) {
            System.out.println("Computer picks: paper");
        } else if (computerInt == 2) {
            System.out.println("Computer picks: scissors");
        }

        if (userInput.equalsIgnoreCase("rock") && computerInt == 0) {
            System.out.println("tie");
            history.add("You played rock, computer played rock. You tied");
        } else if (userInput.equalsIgnoreCase("rock") && computerInt == 1) {
            System.out.println("you lose");
            history.add("You played rock, computer played paper. You lost");
        } else if (userInput.equalsIgnoreCase("rock") && computerInt == 2) {
            System.out.println("you win!");
            history.add("You played rock, computer played scissors. You won");
        } else if (userInput.equalsIgnoreCase("paper") && computerInt == 0) {
            System.out.println("you win!");
            history.add("You played paper, computer played rock. You won");
        } else if (userInput.equalsIgnoreCase("paper") && computerInt == 1) {
            System.out.println("tie");
            history.add("You played paper, computer played paper. You tied");
        } else if (userInput.equalsIgnoreCase("paper") && computerInt == 2) {
            System.out.println("you lose");
            history.add("You played paper, computer played scissors. You lost");
        } else if (userInput.equalsIgnoreCase("scissors") && computerInt == 0) {
            System.out.println("you lose");
            history.add("You played scissors, computer played rock. You lost");
        } else if (userInput.equalsIgnoreCase("scissors") && computerInt == 1) {
            System.out.println("you win!");
            history.add("You played scissors, computer played paper. You won");
        } else if (userInput.equalsIgnoreCase("scissors") && computerInt == 2) {
            System.out.println("tie");
            history.add("You played scissors, computer played scissors. You tied");
        } else{
            System.out.println("Invalid input. Choose rock, paper, or scissors only.");
            play();
        }
        playAgain();


    }
    public static void playAgain(){
        System.out.println("Type 'PLAY' to play again, 'MAIN' for Main Menu, or 'QUIT' to quit.");

        Scanner replay = new Scanner(System.in);
        String playAgain = replay.nextLine();

        if(playAgain.equalsIgnoreCase("play")){
            play();
        }else if(playAgain.equalsIgnoreCase("main")){
            mainMenu();
        }else if(playAgain.equalsIgnoreCase("quit")){
            System.out.println("Thanks for playing!!!");
            return;
        }else {
            System.out.println("Invalid input. Choose 'PLAY', 'MAIN', or 'QUIT' only.");
            playAgain();
        }

    }

    public static void getHistory() {
        for (int i = 0; i <history.size() ; i++) {
            System.out.println(history.get(i));
        }
        getHistoryMenu();
    }

    public static void getHistoryMenu(){
        System.out.println("Type 'MAIN' for the Main Menu or 'QUIT' to quit.");
        Scanner scan = new Scanner(System.in);
        String userInput2 = scan.nextLine();

        if(userInput2.equalsIgnoreCase("main")){
            mainMenu();
        }else if(userInput2.equalsIgnoreCase("quit")){
            System.out.println("Thanks for playing!!!");
            return;
        }else{
            System.out.println("Invalid input. Choose 'MAIN' or 'QUIT' only.");
            getHistoryMenu();
        }
    }
}

