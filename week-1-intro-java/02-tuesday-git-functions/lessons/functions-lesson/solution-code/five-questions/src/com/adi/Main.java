package com.adi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome. \nThis little game allows you to interact through the console. \nWhen you're tired of playing, just type 'exit'.");
        System.out.println("\nAsk: who, what, why, when, or where");
        askAQuestion();
    }

    public static void askAQuestion() {

        String userString = grabUserInput();

        if (userString.contains("who")) {
            System.out.println("We're the ADI class.");
        }
        else if (userString.contains("what")) {
            System.out.println("We're people learning to be awesome android developers!");
        }
        else if (userString.contains("when")) {
            System.out.println("Right now!");
        }
        else if (userString.contains("where")) {
            System.out.println("We're in the Flatiron District of NYC.");
        }
        else if (userString.contains("why")) {
            System.out.println("To create awesome apps!");
        }
        else if (userString.contains("exit")) {
            askAgain();
        }
        else {
            System.out.println("I don't know how to answer that question.");
            System.out.println("Try again...");
        }
        askAQuestion();
    }

    public static String grabUserInput() {
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String cleanUserInput = userInput.trim().toLowerCase();
        return cleanUserInput;
    }

    public static void askAgain() {
        System.out.println("\nAre you sure you have no more questions? Y or N");
        String userInput = grabUserInput();
        if (userInput.equals("y")) {
            System.out.println("Thanks for playing. Goodbye.");
            System.exit(0);
        }
        else if (userInput.equals("n")) {
            System.out.println("Ask another then:");
            askAQuestion();
        }
    }

}
