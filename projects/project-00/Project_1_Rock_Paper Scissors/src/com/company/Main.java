package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Welcome to Rock Paper Scissors!");

        boolean stillPlaying = true;

        while (stillPlaying) {

            welcomeMessage();

            Scanner userInput = new Scanner(System.in);  // Reading user input
            String playOrHistory = userInput.next();

            //user enter to play or to view history
            if(playOrNot(playOrHistory) == 1) { //user choose to plan

                System.out.println("1. Type in 'rock' or '1'\n" + "2. Type in 'paper' or '2'\n" + "3. Type in 'scissors' or '3'\n" +
                        "4. Type 'quit' or '4' to go back to the Main Menu");
                Scanner choice = new Scanner(System.in);
                String rockPaperOrScissors = choice.next();

                //user enter choice: rock, paper, scissors
                if(userChoice(rockPaperOrScissors).equals("1") || userChoice(rockPaperOrScissors).equals("2") || userChoice(rockPaperOrScissors).equals("3")){
                    outcome(userChoice(rockPaperOrScissors));
                } else if(userChoice(rockPaperOrScissors).equals("4")){ //go back to main menu

                } else {
                    System.out.println("Huh?!\nWant to try again?");
                }

            } else if(playOrNot(playOrHistory) == 2){ //user choose to view history
                System.out.println("=== GAME HISTORY ===");
                for (int i = 0; i < history.size(); i++) {
                    System.out.println(history.get(i));
                }
            } else if(playOrNot(playOrHistory) == 3){ //user choose to quit
                System.out.println("Goodbye!");
                stillPlaying = false;
            } else {
                System.out.println("Huh?!\nWant to try again?");
            }

        }
    }

    public static void welcomeMessage(){
        System.out.println("");
        System.out.println("MAIN MENU");
        System.out.println("=====");
        System.out.println("1. Type 'play' or '1' to play");
        System.out.println("2. Type 'history' or '2' to view your game history");
        System.out.println("3. Type 'quit or '3' to stop playing");
    }

    public static int playOrNot (String input){
        input = input.toLowerCase();
        if(input.equals("1") || input.equals("play")){
            return 1;
        } else if (input.equals("2") || input.equals("history")) {
            return 2;
        } else if (input.equals("3") || input.equals("quit")) {
            return 3;
        } else {
            return 4;
        }
    }

    public static String userChoice(String input){
        input = input.toLowerCase();
        if(input.equals("rock") || input.equals("1")){
            return "1";
        } else if (input.equals("paper") || input.equals("2")){
            return "2";
        } else if (input.equals("scissors") || input.equals("3")){
            return "3";
        } else if (input.equals("quit") || input.equals("4")) {
            return "4";
        } else return "5";
    }

    public static String computerChoice(){
        double choice = Math.random()*3;
        if(choice <= 1){
            return "1"; //rock
        } else if(choice <= 2){
            return "2"; //paper
        } else {
            return "3"; //scissors
        }
    }

    public static void outcome(String s){
        String c = computerChoice();
        //user rock; computer scissors
        if(s.equals("1") && c.equals("3")){
            System.out.println("Computer picks: scissors\n" + "User picks: rock\n" + "You win!");
            history.add("WIN: Player-rock computer-scissors");
        } else if(s.equals("1") && c.equals("2")){ //user rock; computer paper
            System.out.println("Computer picks: paper\n" + "User picks: rock\n" + "You lose!");
            history.add("LOSS: Player-rock computer-paper");
        } else if(s.equals("1") && c.equals("1")){ //user rock; computer rock
            System.out.println("Computer picks: rock\n" + "User picks: rock\n" + "It's a tie!");
            history.add("TIE: Player-rock computer-rock");
        } else if(s.equals("2") && c.equals("1")){ //user paper; computer rock
            System.out.println("Computer picks: rock\n" + "User picks: paper\n" + "You win!");
            history.add("WIN: Player-paper computer-rock");
        } else if(s.equals("2") && c.equals("2")){ //user paper; computer paper
            System.out.println("Computer picks: paper\n" + "User picks: paper\n" + "It's a tie!");
            history.add("TIE: Player-paper computer-paper");
        } else if(s.equals("2") && c.equals("3")){ //user paper; computer scissors
            System.out.println("Computer picks: scissors\n" + "User picks: paper\n" + "You lose!");
            history.add("LOSS: Player-paper computer-scissors");
        } else if(s.equals("3") && c.equals("1")){ //user scissors; computer rock
            System.out.println("Computer picks: rock\n" + "User picks: scissors\n" + "You lose!");
            history.add("LOSS: Player-scissors computer-rock");
        } else if(s.equals("3") && c.equals("2")){ //user scissors; computer paper
            System.out.println("Computer picks: paper\n" + "User picks: scissors\n" + "You win!");
            history.add("WIN: Player-scissors computer-paper");
        }  else if(s.equals("3") && c.equals("3")){ //user scissors; computer scissors
            System.out.println("Computer picks: scissors\n" + "User picks: scissors\n" + "It's a tie!");
            history.add("TIE: Player-scissors computer-scissors");
        } else{
            System.out.println("Ooops~~what happened?!");
        }

    }

}
