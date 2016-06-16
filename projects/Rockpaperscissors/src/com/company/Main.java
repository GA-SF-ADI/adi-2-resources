import java.util.Random;
import java.lang.Object;
import java.util.Scanner;

package com.company;

public class Paper {

    public static void main(String[] args) {
        // Player and Comp options for weapons

        String userWeapon;  // User  weapon = "Paper", "Rock", "Scissors"
        String compWeapon = "";   // Comp  weapon = "Paper", "Rock", "Scissors"
        int compMove;         // Random number picker

        String userInputChoice;

        Scanner scan = new Scanner(System.in);
        Random cycleMove = new Random();

        System.out.println("Ready to play Paper, Rock, Scissors!\n" + "Choose your weapon!\n" +
                "Paper, Rock, Scissors");

        //Comp choices random weapon of Paper, Rock, or Scissors
        compMove = cycleMove.nextInt(3) + 1;


        if (compMove == 1)
            compWeapon = "Paper";
        else if (compMove == 2)
            compWeapon = "Rock";
        else if (compMove == 3)
            compWeapon = "Scissors";


        // Player choices of weapon of Paper, Rock, Scissors

        System.out.println("Player enter your weapon");

        userWeapon = scan.next();

        System.out.println("Computer choose" + compWeapon);


        //Results of Battle


        if (userWeapon.equals(compWeapon)) {
            System.out.println("Its a tie!");
        }
        else {
            if (userWeapon.equals("Rock")) {

                if (compWeapon.equals("Scissors")) {
                    System.out.println("Rock crushes scissors. You win!");
                } else if (compWeapon.equals("Paper")) {
                    System.out.println("Paper eats rock. You lose!");
                }
            }else if (userWeapon.equals("Paper")) {

                if (compWeapon.equals("Scissors")){
                        System.out.println("Scissors cut paper, You lose!");
                } else if (compWeapon.equals("Rock")) {
                    System.out.println("Paper eats rock, You win!");
                }
            }else if (userWeapon.equals("Scissors")) {
                if (compWeapon.equals("Paper")) {
                    System.out.println("Scissors cut paper, You win!");
                } else if (compWeapon.equals("Rock")) {
                    System.out.println("Rock breaks scissors, You lose!");
                }
            }else{
                    System.out.println("Invalid user input");
            }

        }
    }




}
