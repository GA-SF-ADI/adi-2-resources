package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.Random;

public class Main {


    public static void main(String[] args) throws IOException {

//        OPENING AND PRINTING GAME HISTORY!

        // The name of the file to open.
        String fileName = "/Users/LangstonSmith/Desktop/adi-2/adi-" +
        "2-resources/projects/project-00/src/com/company/Gamehistory.txt";

        // This will reference one line at a time
        String gameHistoryLine = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((gameHistoryLine = bufferedReader.readLine()) != null) {
                System.out.println(gameHistoryLine);
            }

            // Always close files.
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();

            System.out.println(gameHistoryLine);

//        Defining boolean variable so that game loops

            boolean pOrH = true;
//        Creating while loop so that game loops


            while (pOrH = true) {

//            Declaring welcome message String

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

//            If history is selected in main menu


//        Creating if loop for when player chooses play in main menu

                if (playOrHistoryDecision.equalsIgnoreCase("play")) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Type in 'rock' 'paper' or 'scissors' to play.\n" +
                            " Type 'quit' to go back to the Main Menu\n");

//            rPS = Player's rock, paper, scissors initial choice

                    String rPSPlayerSelection;
                    Scanner rPSscan = new Scanner(System.in);

                    rPSPlayerSelection = rPSscan.nextLine().toLowerCase(); //<–– Lower-casing method called on player entry

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

//            Player's selection is printed

                    System.out.println("User picks: " + rPSPlayerSelection);

//            Setting logic (e.g. paper beats rock, rock beats scissors, etc.)

                    if (randomNum == 1 && rPSPlayerSelection.equals("paper")) {
                        System.out.println("Yippee! You WIN!");
                    }

                    if (randomNum == 2 && rPSPlayerSelection.equals("scissors")) {
                        System.out.println("Yippee! You WIN!");
                    }

                    if (randomNum == 3 && rPSPlayerSelection.equals("rock")) {
                        System.out.println("Yippee! You WIN!");
                    }

                    if (randomNum == 1 && rPSPlayerSelection.equals("scissors")) {
                        System.out.println("Sorry! You LOSE! HAHA!");
                    }

                    if (randomNum == 2 && rPSPlayerSelection.equals("rock")) {
                        System.out.println("Sorry! You LOSE! HAHA!");
                    }

                    if (randomNum == 3 && rPSPlayerSelection.equals("paper")) {
                        System.out.println("Sorry! You LOSE! HAHA!");
                    }

                    if (randomNum == 1 && rPSPlayerSelection.equals("rock")) {
                        System.out.println("It's a tie!");
                    }
                    if (randomNum == 2 && rPSPlayerSelection.equals("paper")) {
                        System.out.println("It's a tie!");
                    }
                    if (randomNum == 3 && rPSPlayerSelection.equals("scissors")) {
                        System.out.println("It's a tie!");
                    }

                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");


                }

            }


        }


    }

}













