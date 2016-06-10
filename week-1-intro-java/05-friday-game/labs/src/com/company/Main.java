package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static String computerChoice;
    static String answerGame;
    static ArrayList<String> score = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("Rock, Paper, Scissors");
        System.out.println("");

        System.out.println("Do you want to play or know more about Rock, Paper, Scissors?");
        System.out.println("Type PLAY to play the game or Type HISTORY for a look back at Rock, Paper, Scissors.");


        //Scanner whether to play answer? <code>
        Scanner scanner = new Scanner(System.in);
        String answerPlay = scanner.nextLine();
        if(answerPlay.equals("PLAY") || answerPlay.equals("play") || answerPlay.equals("Play")){
            play();
        }
        else if(answerPlay.equals("HISTORY") || answerPlay.equals("history") || answerPlay.equals("History")){
            history();
        }
        else {
            System.out.println("Invalid input!");

        System.out.println("");
            return;
        }

        //computer choice <code>
        Random randomnum = new Random();
        //System.out.println(randomnum.nextInt(2)); - to check if spitting out a number.
        if (randomnum.nextInt(2) == 0) {
            computerChoice = "Rock";
            System.out.println("Computer Chooses: Rock"); //playerRock - playerinput Rock = 0;
        }
        else if (randomnum.nextInt(2) == 1) {
            System.out.println("Computer Chooses: Paper"); //playerPaper - playerinput Rock = 1;
            computerChoice = "Paper";
        }
        else{
            System.out.println("Computer Chooses: Scissors"); //playerScissor - playerinput Rock = 2;
            computerChoice = "Scissors";
        }
        System.out.println("");
        results();

    }

    public static void play() {
        //Scanner game player choice answer <code>

        System.out.println("");
        System.out.println("Choose Rock, Paper, or Scissors:");

        Scanner scanner1 = new Scanner(System.in);
        answerGame = scanner1.nextLine();

        if (answerGame.equals("ROCK") || answerGame.equals("rock") || answerGame.equals("Rock")) {
            answerGame = new String("Rock");
        } else if (answerGame.equals("PAPER") || answerGame.equals("paper") || answerGame.equals("Paper")) {
            answerGame = new String("Paper");
        } else if (answerGame.equals("SCISSORS") || answerGame.equals("scissors") || answerGame.equals("Scissors")) {
            answerGame = new String("Scissors");
        } else {
            System.out.println("Invalid input!");
            return;
        }
    }

    public static void scoreHistory() {
        System.out.println("Player wins:" + score.size());
    }


    public static void results(){
        scoreHistory();
        if (answerGame.equals(computerChoice)) {
            System.out.println("It's a tie!");
        }
        else if (!answerGame.equals(computerChoice)) {
            if (answerGame.equals("Rock") && computerChoice.equals("Scissors")){
                score.add("player");
                System.out.println("Rock beats Scissors - Player wins!");
            }
            else if (answerGame.equals("Scissors") && computerChoice.equals("Paper")){
                score.add("player");
                System.out.println("Scissors beats Paper - Player wins!");
            }
            else if (answerGame.equals("Paper") && computerChoice.equals("Rock")) {
                score.add("player");
                System.out.println("Paper beats Rock - Player wins!");
            }
            else if (answerGame.equals("Scissors") && computerChoice.equals("Paper")){
                score.add("player");
                System.out.println("Scissors beats Paper - Player wins!");
            }
            else if (answerGame.equals("Rock") && computerChoice.equals("Paper")) {
                System.out.println("Paper beats Rock - Computer wins!");
            }
            else if (answerGame.equals("Paper") && computerChoice.equals("Scissors")){
                System.out.println("Scissors beats Paper - Computer wins!");
            }
            else {
                System.out.println("Rock beats Scissors - Computer wins!");
            }

        }

    }
    public static void history(){
        System.out.println("");
        System.out.println("History of Rock, Paper:");
        System.out.println("It all started in Japan and has worked its way all through the world");
        System.out.println("including tournaments Europe and America. It is played by people of all ages.");
    }
}

