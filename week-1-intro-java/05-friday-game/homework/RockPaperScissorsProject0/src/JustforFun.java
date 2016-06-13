//package com.company;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

// Play walk, bike, fly... can you get there faster than the computer?!
//Made just for fun to practice the same concepts
// Not as cool as Rock, Paper, Scissors because 1 and 2 can never beat 3 :(
public class JustforFun {
    static Scanner keyboard = new Scanner(System.in);
    static int computerNumber;
    static int humanSelectionWBF;
    static String playAgain;
    static int count1;
    static int count2;
    static int count3;
// global declaration

    public static void main(String[] args) {
        // write your code here

        System.out.println("*-----------------------------------------------*");
        System.out.println("Welcome to Audrey's Walk, Bike, or Fly Game!");
        System.out.println("*-----------------------------------------------*");
        System.out.println("Type a letter or number + enter to continue so that the computer knows you're ready!");
        String entry = keyboard.next();
        System.out.println("Press 1 if you want to play. Press 2 if you want to see your game history.");
        System.out.println("*-------------------------------------------------------------------*");
        int humanSelection = keyboard.nextInt();


        switch (humanSelection) {

            case (1):
                playGame();
                break;

            case (2):
                historyFunction();
                break;

            default:
                System.out.println("Hmmm that's not a 1 or a 2. Please restart the game. :)");


        }
    }


    public static void playGame() {
        System.out.println("Select 1 for walk, 2 for run, 3 for plane");
        humanSelectionWBF = keyboard.nextInt();
        int walk = 1;
        int bike = 2;
        int fly = 3;
        computerNumber = (int) (Math.random() * 3 + 1);

        if ((humanSelectionWBF == 1 && computerNumber == 2) || (humanSelectionWBF == 1 && computerNumber == 3) ||
                (humanSelectionWBF == 2 && computerNumber == 3)) {

            System.out.println(" You lose. You're too slow!");
            count1++;
        } else if ((humanSelectionWBF == 1 && computerNumber == 1) || (humanSelectionWBF == 2 && computerNumber == 2) ||
                (humanSelectionWBF == 3 && computerNumber == 3))

        {
            System.out.println(" It's a tie! You got there at the same time!");
            count2++;
        }
        else
        {
            System.out.println(" You win!! You got there before the computer!");
            count3++;
        }

        System.out.print("If you want to play again type yes, but if you want to view history type history.");
        playAgain = keyboard.next();
        playAgain.toLowerCase();
        if (playAgain.equals("yes")) {
            playGame();
        } else if (playAgain.equals("history")) {
            historyFunction();
        }

    }
    public static void historyFunction() {
        System.out.println("This is your game history!");
        System.out.println("Number of wins =" + (count3));
        System.out.println("Number of losses=" + (count1));
        System.out.println("Number of ties=" + (count2));

    }


}
