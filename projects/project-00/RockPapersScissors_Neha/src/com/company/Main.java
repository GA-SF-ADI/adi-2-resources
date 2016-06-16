package com.company;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String winner="";
    public static ArrayList<String> historyList=new ArrayList<>();

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {

        Scanner reader = new Scanner(System.in);

        System.out.println("");
        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("======================MAIN MENU=========================");
//        System.out.println("========================================================");
        System.out.println("1. Type 'play' to play");
        System.out.println("2. Type 'history' to view your game history");
        System.out.println("Type 'quit' to stop playing");

        String optionSelected = reader.nextLine().toLowerCase();

        switch (optionSelected) {
            case "1": playOptionSelected();
                break;
            case "play": playOptionSelected();
                break;
            case "2": printHistory(historyList);
                break;
            case "history": printHistory(historyList);
                break;
            case "quit":
                break;
            default: {
                System.out.println("Error: Invalid Option. Please select a valid option again");
                mainMenu();
            }
        }
    }

    public static void playOptionSelected() {

        Scanner reader = new Scanner(System.in);

        System.out.println("Type in 'rock' 'paper' or 'scissors' to play");
        System.out.println("Type 'quit' to go back to the Main Menu");

        String optionSelected = reader.nextLine().toLowerCase();

            switch (optionSelected) {
                case "rock": playGame("rock");
                    break;
                case "rocks": playGame("rocks");
                    break;
                case "paper": playGame("paper");
                    break;
                case "papers": playGame("papers");
                    break;
                case "scissor": playGame("scissor");
                    break;
                case "scissors": playGame("scissors");
                    break;
                case "quit": mainMenu();
                    break;
                default:
                    System.out.println("Error: Invalid Option Selected. Please select again");
                    playOptionSelected();
                    break;
            }
        }

    public static void playGame(String userSelected){

        String computerSelected="";

        Random rand = new Random();
        int randomValueSelected=rand.nextInt(3);

//        System.out.println("randomValueSelected is: "+randomValueSelected);

        if (randomValueSelected==0){
            computerSelected="rock";
        }
        else if(randomValueSelected==1){
            computerSelected="paper";
        }
        else if (randomValueSelected==2){
            computerSelected="scissor";
        }

        System.out.println("Computer picks: "+computerSelected);
        System.out.println("User picks: "+userSelected);

        winner=whoWon(computerSelected,userSelected);
        System.out.println(winner);

        mainMenu();

    }

    public static String whoWon(String compInput, String userInput){
        if(compInput.equals("rock") && (userInput.equals("rock") || userInput.equals("rocks"))){
//            System.out.println("It's a tie !");
            history("TIE: Player-rock Computer-rock");
            return "It's a tie !";
        }

        else if(compInput.equals("paper") && (userInput.equals("paper") || userInput.equals("papers"))){
//            System.out.println("It's a tie !");
            history("TIE: Player-paper Computer-paper");
            return "It's a tie !";
        }

        else if(compInput.equals("scissors") && (userInput.equals("scissor") || userInput.equals("scissors"))){
//            System.out.println("It's a tie !");
            history("TIE: Player-scissors Computer-scissors");
            return "It's a tie !";
        }

        else if(compInput.equals("rock") && (userInput.equals("scissor") || userInput.equals("scissors"))){
//            System.out.println("Computer wins !");
            history("LOSS: Player-scissor Computer-rock");
            return "You lose !";
        }

        else if((userInput.equals("rock") || userInput.equals("rock")) && compInput.equals("scissor")){
//            System.out.println("User wins !");
            history("WIN: Player-rock Computer-scissor");

            return "You win !";
        }

        else if(compInput.equals("paper") && (userInput.equals("rock") || userInput.equals("rocks"))){
//            System.out.println("Computer wins !");
            history("LOSS: Player-rock Computer-paper");
            return "You lose !";
        }

        else if(compInput.equals("rock") && (userInput.equals("paper") || userInput.equals("papers"))){
//            System.out.println("User wins !");
            history("WIN: Player-paper Computer-rock");
            return "You win !";
        }

        else if(compInput.equals("paper") && (userInput.equals("scissor") || userInput.equals("scissors"))){
//            System.out.println("User wins !");
            history("WIN: Player-scissors Computer-paper");
            return "You win !";
        }

        else if(compInput.equals("scissor") && (userInput.equals("paper") || userInput.equals("papers"))){
//            System.out.println("Computer wins !");
            history("LOSS: Player-paper Computer-scissors");
            return "You lose !";
        }
        return "";
    }

    public static void history(String his){
//        ArrayList<String> historyList=new ArrayList<>();
        historyList.add(his);
//        return historyList;
    }

    public static void printHistory(ArrayList<String> printHis){
        System.out.println("");
        System.out.println("===================GAME HISTORY========================");
        for(int i=0;i<historyList.size();i++){
            System.out.println(historyList.get(i));
        }
        mainMenu();
    }
}
