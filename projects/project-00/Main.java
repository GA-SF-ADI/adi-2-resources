package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String str = " MAIN MENU \n _____ \n 1. Type 'play' to play. \n 2. Type 'history' for history. \n 3. Type 'quit' to quit.";
        System.out.println(str);

        String str1 = " Type 'play' , 'history' , or 'quit' only";

        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();

        if(userInput.equals("play")){
            System.out.println("Choose rock, paper, or scissors.");
            compRandom();
        }else if(userInput.equals("history")){

        }else if(userInput.equals("quit")){
        }else System.out.println(str1);

    }
    public static void compRandom(){
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();

        int computerInt = (int)(Math.random()*3);

        if(computerInt==0){
            System.out.println("Computer picks: rock");
        }else if(computerInt==1){
            System.out.println("Computer picks: paper");
        }else if(computerInt==2){
            System.out.println("Computer picks: scissors");
        }else{
            System.out.println("aren't we playing rock, paper, scissors?");
        }

        if(userInput.equals("rock") && computerInt==0){
            System.out.println("tie");
        }else if(userInput.equals("rock") && computerInt==1){
            System.out.println("you lose");
        }else if(userInput.equals("rock") && computerInt==2){
            System.out.println("you win!");
        }else if(userInput.equals("paper") && computerInt==0){
            System.out.println("you win!");
        }else if(userInput.equals("paper") && computerInt==1){
            System.out.println("tie");
        }else if(userInput.equals("paper") && computerInt==2){
            System.out.println("you lose");
        }else if(userInput.equals("scissors") && computerInt==0){
            System.out.println("you lose");
        }else if(userInput.equals("scissors") && computerInt==1){
            System.out.println("you win!");
        }else if(userInput.equals("scissors") && computerInt==2){
            System.out.println("tie");
        }




    }

}
