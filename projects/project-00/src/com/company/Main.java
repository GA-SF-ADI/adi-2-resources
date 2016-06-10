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


//    Method for random number to be generated

//    public static int randInt(int minRPSNum, int maxRPSNum,) {

//    Random rand = new Random();
//
//    int randomNum = rand.nextInt((maxRPSNum - minRPSNum) + 1) + minRPSNum;
//
//    return randomNum;


//    method for assigning rock, paper, and scissor choices to 1, 2, 3 numbers


    public static void main(String[] args) {

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

        System.out.println(welcomeMessage);

        Scanner firstScan = new Scanner(System.in);
        String playOrHistoryDecision = firstScan.nextLine();

//      if loop created for when player chooses play in main menu

        if (playOrHistoryDecision.equalsIgnoreCase("play")) {
            System.out.println("");
            System.out.println("");
            System.out.println("Type in 'rock' 'paper' or 'scissors' to play.\n" +
                    " Type 'quit' to go back to the Main Menu\n");


//            Reads/accepts player's rock, paper, scissors decision

            String rPS;
            Scanner rPSDecision = new Scanner(System.in);
            rPS = rPSDecision.nextLine();

//            System.out.println("Computer picks: " + ___________);

            Random rand = new Random();

            int randomNum = rand.nextInt((3 - 1) + 1) + 1;

            if (randomNum == 1) {

                System.out.println("Computer picks: rock");

            } else if (randomNum == 2) {

                System.out.println("Computer picks: paper");

            } else {
                System.out.println("Computer picks: scissors");

            }

            System.out.println("User picks: " + rPS);


            }


        }


//            randInt(1, 3);      CALLING RANDOM # GENERATOR METHOD!!!

//        Array<Integer> playerGameRPSChoice = new Array<Integer>(){

//        Integer[] decision;
//        decision = new Integer[3];
//
//        decision[1] = Integer.toString("rock")

//


//        else if (/*PUT IN HISTORY SELECTION CODE HERE !!!!*/){
//
//


    }














