package com.company;

import java.sql.Array;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static java.awt.SystemColor.text;

public class Main {


    public static void main(String[] args) {

//Declaring welcome message String

        String welcomeMessage = "Welcome to Rock Paper Scissors!\n" +
                "\n" +
                "MAIN MENU\n" +
                "=====\n" +
                "\n" +
                "1. Type 'play' to play\n" +
                "2. Type 'history' to view your game history\n" +
                "Type 'quit' to stop playing\n" +
                "\n" +
                "• Please click below this line in the console, type your selection, and then press the return key\n";

//        Printing welcome message


        System.out.println(welcomeMessage);

//        Priming console to accept typing

        Scanner firstScan = new Scanner(System.in);
        String playOrHistoryDecision = firstScan.nextLine();

//        Creating if loop for when player chooses play in main menu

        if (playOrHistoryDecision.equalsIgnoreCase("play")) {
            System.out.println("");
            System.out.println("");
            System.out.println("Type in 'rock' 'paper' or 'scissors' to play.\n" +
                    " Type 'quit' to go back to the Main Menu\n");

//            rPS = Player's rock, paper, scissors initial choice

            String rPSPlayerSelection;
            Scanner rPSscan = new Scanner(System.in);
            rPSPlayerSelection = rPSscan.nextLine();

            System.out.println("");
//            Random number is generated

            Random rand = new Random();

            int randomNum = rand.nextInt((3 - 1) + 1) + 1;

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

            //            Computer's selection is printed


//            Player's selection is printed

            System.out.println("User picks: " + rPSPlayerSelection);
//            Setting logic (e.g. paper beats rock, rock beats scissors, etc.)
//            boolean randomNum = 2 = true; &&rPS = ""){


                System.out.println("");

        }


    }


}














