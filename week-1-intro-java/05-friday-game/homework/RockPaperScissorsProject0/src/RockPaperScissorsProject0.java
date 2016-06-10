//package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by audreyeso on 6/9/16.
 */
public class RockPaperScissorsProject0 {

    static String playOrHistory;
    //global declaration
    //static means one instance
    static int computerNumber;
    static Scanner keyboard = new Scanner(System.in);
    static String playAgain;

    public static void main(String[] args) {

        computerNumber = (int) (Math.random() * 3 + 1);
        System.out.println("Welcome to Audrey's Rock, Paper, Scissors Game!");
        System.out.println("Type a letter or number + enter to continue so that the computer knows you're ready!");
        String entry = keyboard.next();
        System.out.println("Type play to start the next game or type history to go back in time and check out old games!");
        playOrHistory = keyboard.next();



        switch (playOrHistory) {

            case "play":
                System.out.println("Let the games begin.");
                System.out.println("Choose rock, paper, or scissors.");
                playFunction(playOrHistory);
                //allow person to call the "play function"
                break;

            case "history":
                System.out.println("Let's go back in time and check out some old games!");
                //allow person to call the "history function"
                break;

            default:
                System.out.println("Error! Run the program again!");
                stopFunction(playOrHistory);
        }

    }

    //create 3 functions here: playFunction, historyFunction, stopFunction
    //They must return strings
    //They must take in a string

    public static void playFunction(String play) {
        //should this be void or String?
        //put if statements here
        System.out.println("What object do you choose?");
        playOrHistory = keyboard.next();

        if ((playOrHistory.equals("rock") && computerNumber == 1) ||
                (playOrHistory.equals("paper") && computerNumber == 2) ||
                (playOrHistory.equals("scissors") && computerNumber == 3)) {
            System.out.println("It's a tie!");


        }
        else if ((playOrHistory.equals("rock") && computerNumber == 3) ||
                (playOrHistory.equals("paper") && computerNumber == 1) ||
                (playOrHistory.equals("scissors") && computerNumber == 2)) {
            System.out.println("You win!");

        }
        else if ((playOrHistory.equals("rock") && computerNumber == 2) ||
                (playOrHistory.equals("paper") && computerNumber == 3) ||
                (playOrHistory.equals("scissors") && computerNumber == 1)) {
            System.out.println("You lose!");


        }
        System.out.print("Do you want to play again?");
        playAgain = keyboard.next();
        if (playAgain.equals("yes")) {
            playFunction(playOrHistory);
        }
    }




    public static void historyFunction(String history) {

    }

    public static String stopFunction(String stop) {
        String stopGame = "The game is over!";
        return stopGame;
    }

}









// I want them to keep being able to play again if they want to.