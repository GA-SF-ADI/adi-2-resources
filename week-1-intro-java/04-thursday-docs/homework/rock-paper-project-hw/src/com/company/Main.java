package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        gameStart();// calling method to start game

    }

    public  static void gameStart(){ //this method prints out the main menu and takes user input for the menu, uses if else to check user input
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("MAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' to play\n" + "2. Type 'history' to view your game history\n" + "Type 'quit' to stop playing");

        Scanner userInput = new Scanner(System.in);
        String  input = userInput.nextLine();
        if (input.equals("play")) {
            play();
        }else if (input.equals("history")) {
            history();
        }
        else if (input.equals("quit")) {
            gameStart();
        }
        else { gameStart();

        }


    }

    public static void play() {  // method  executes after the menu if user chose play
        System.out.println("Type in 'rock' 'paper' or 'scissors' to play.\n" + " Type 'quit' to go back to the Main Menu");
        Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();
        if (input.equals("quit")) {
            gameStart();
        }
    }

        public static void whoWins(String userPick, String cpuPick){



    }



    public static void history(){

    }
}