package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("Rock, Paper, Scissors");
        System.out.println("");
        System.out.println("");

        System.out.println("Do you want to play a game? Type PLAY or Type HISTORY for a look back at Rock, Paper, Scissors.");
        System.out.println("");

        Scanner scan = new Scanner(System.in);
        playerPlay = scan.next();
        //Scanner play <code>

        if playerPlay == "PLAY"{
            System.out.println("What do you choose ROCK, PAPER, SCISSORS.");
            System.out.println("");
            Scanner scan = new Scanner(System.in);
            playerPlay = scan.next();
            //Scanner game <code>
        }
        else{

        }








        //computer move <code>
        Random randomnum = new Random();
        //System.out.println(randomnum.nextInt(2));
        if (randomnum.nextInt(2) == 0) {
            System.out.println("Computer Chooses Rock");
        }
        else if (randomnum.nextInt(2) == 1) {
            System.out.println("Computer Chooses Paper");
        }
        else{
            System.out.println("Computer Chooses Scissors");
        }
        //playerRock - playerinput Rock = 0;
        //playerPaper - playerinput Rock = 1;
        //playerScissor - playerinput Rock = 2;


        if {
            if //rock
            {
                //win condition > randomNum
                //lose condition
                //tie condition
            }

            if else //paper
            {

            }
            //win condition
            //lose condition
            //tie condition

            if else //scissors
            {
            //win condition
            //lose condition
            //tie condition

            }
        }

        else if {
            System.out.println("History:");
            System.out.println("");
            System.out.println("Believed to have originated in Japan, versions of Rock, Paper, Scissors have been played in all areas of world.");
        }

        else {
            System.out.println("Error: Please type Play or History");
        }


    }
}
