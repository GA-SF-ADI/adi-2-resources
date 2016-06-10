//package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by audreyeso on 6/9/16.
 * What does this project do?
 * Project: Rock, Paper, Scissors:
 * Here is a simple version of Rock, Paper, Scissors that a user can play against the computer
 * via the console. It also can show the user the game history of the game that he/she is playing.
 */
public class RockPaperScissorsProject0 {
    //global declaration (outside of the main) ... so that I can use these across functions and if statements
    //reminder--> static means one instance
    static String playOrHistory;
    static int computerNumber;
    static Scanner keyboard = new Scanner(System.in);
    static String playAgain;
    static int count;
    static int count2;
    static int count3;

    public static void main(String[] args) {

        System.out.println("*-----------------------------------------------*");
        System.out.println("Welcome to Audrey's Rock, Paper, Scissors Game!");
        System.out.println("*-----------------------------------------------*");
        System.out.println("Type a letter or number + enter to continue so that the computer knows you're ready!");
       String entry = keyboard.next();
        System.out.println("Type play to start the next game or type history to see game history!");
        System.out.println("*-------------------------------------------------------------------*");
        playOrHistory = keyboard.next().toLowerCase();
        //Did not work initially when I wrote this out separately because it took in playOrHistory first so then had to concatenate


        //Put ArrayList here and then print out the "counts" or use the count++ way instead

         /* ArrayList<Integer> theGameHistory = new ArrayList<Integer>();
           *theGameHistory.add(count++);
           * theGameHistory.add(count2);
         * theGameHistory.add(count3);
         *
         * This is another option that I was thinking about using, but decided to try something else instead.
         */



        switch (playOrHistory) {
            //will switch what happens depending on player's input

            case "play":
                // playOrHistory = keyboard.next().toLowerCase();
                // because I wrote ^ (in the main) even if the user types in PLaY, it will still work! Woo!
                System.out.println("Let the games begin!");
                System.out.println("********************");
                System.out.println("Choose rock, paper, or scissors.");
                playFunction(playOrHistory);
                //allow person to call the "play function"
                break;

            case "history":
                System.out.println("Let's check how you did!");
                historyFunction (playOrHistory);
                //allow person to call the "history function"
                break;

            default:
                System.out.println("Error! Run the program again!");
                //happens when the player types in something other than play or history
        }

    }

    /*
    I created 2 functions here: playFunction, historyFunction
    playFunction: allows the user to play the game
    historyFunction: allows the user to see their game history
     */

    public static void playFunction(String play) {

        System.out.println("What object do you choose?");
        playOrHistory = keyboard.next();
        //had to move this out of the if statements so that it would work for all statements!
        computerNumber = (int) (Math.random() * 3 + 1);
        /*
        had to move this down here so that it would keep changing
        its number otherwise the computer would get trapped with the same number
        and then the human can win every time if they catch on!
         */




        if ((playOrHistory.equals("rock") && computerNumber == 1) ||
                (playOrHistory.equals("paper") && computerNumber == 2) ||
                (playOrHistory.equals("scissors") && computerNumber == 3)) {
            String tie = ("It's a tie *-------------------------------------------------------------------*");
            System.out.println(tie);
            count3++;



        }
        else if ((playOrHistory.equals("rock") && computerNumber == 3) ||
                (playOrHistory.equals("paper") && computerNumber == 1) ||
                (playOrHistory.equals("scissors") && computerNumber == 2)) {
            String youWin = ("You win!*!*!*YOU ARE A CHAMPION!*!*!*");
            System.out.println(youWin);
            count++;

        }
        else if ((playOrHistory.equals("rock") && computerNumber == 2) ||
                (playOrHistory.equals("paper") && computerNumber == 3) ||
                (playOrHistory.equals("scissors") && computerNumber == 1)) {
            String youLose =("You lose! *-------------------------------------------------------------------*");
            System.out.println(youLose);
            count2++;


        }
        System.out.print("If you want to play again type yes, but if you want to view history type history.");
        playAgain = keyboard.next();
        playAgain.toLowerCase();
        if (playAgain.equals("yes")) {
            playFunction(playOrHistory);
        }
        else if (playAgain.equals("history")) {
            historyFunction(playOrHistory);
        }
    }




    public static void historyFunction(String history) {
    //print game history here

        System.out.println("This is your game history!");
        System.out.println("Number of wins =" + (count));
        System.out.println("Number of losses=" + (count2));
        System.out.println("Number of ties=" + (count3));
        if (count > count2) {
            System.out.println("Yea! You rock at Rocks, Paper, Scissors!");
            System.out.println("*!*!*YOU ARE THE ULTIMATE CHAMPION!*!*!*");
        }
        else {
            System.out.println("Good game! Come back anytime for a rematch!");
        }
        //System.out.println("Game History" + (theGameHistory(Integer));
    }


}