package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> gameResultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        readFile(); //opens text file containing past session history (stored in gameResultList) prior to executing the game
        menu();
    }

    public static void menu()  {
        Scanner menuScan = new Scanner(System.in);

        System.out.println("Welcome to Rock Paper Scissors!");
        System.out.println("");
        System.out.println("                          MAIN MENU");
        System.out.println("=================================================================");
        System.out.println("                     Type '1' to play");
        System.out.println("  Type '2' view your game history across sessions in a .txt file");
        System.out.println("                  Type 'quit' to stop playing");
        System.out.println("");
        System.out.println("");

        String menuChoice = menuScan.nextLine();


        if (menuChoice.equals("1")) {
            game();
        } else if (menuChoice.equals("2")) {
            history();

        } else if (!menuChoice.equals("1") && !menuChoice.equals("2") && !menuChoice.equals("quit")){
            System.out.println("invalid character, try again");
            menu();
        }

        try {
            saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    public static String userPickWeapon() {
        Scanner weaponScan = new Scanner(System.in);
        String weapon = "";

        while (!weapon.equals("rock") && !weapon.equals("paper") && !weapon.equals("scissors")) {

            System.out.println("Choose your weapon! Please enter either 'rock', 'paper', 'scissors', or 'q' to quit ");
            weapon = weaponScan.next();

            //Make player's play lowercase for uniformity
            weapon = weapon.toLowerCase();

            if (!weapon.equals("rock") && !weapon.equals("paper") && !weapon.equals("scissors")) {
                System.out.println("Invalid option. Try again.");

            }


        }
        return weapon;

    }

    public static String computerPickWeapon() {
        Random myRandomGenerator = new Random();
        Integer randomNum = myRandomGenerator.nextInt(3); // int random_integer = rand.nextInt(upperbound-lowerbound) + lowerbound;
        String computerWeapon = "";
        if (randomNum == 0) {
            computerWeapon = "rock";
        } else if (randomNum == 1) {
            computerWeapon = "paper";
        } else if (randomNum == 2) {
            computerWeapon = "scissors";
        }
        return computerWeapon;
    }


    public static void game() {
        String userInput = userPickWeapon();
        String computerInput = computerPickWeapon();

        if (userInput.equals(computerInput)) {
            System.out.println("It is a tie!");
            gameResultList.add("tie");

        } else if ((userInput.equals("rock") && computerInput.equals("paper"))
                || (userInput.equals("paper") && computerInput.equals("scissors"))
                || (userInput.equals("scissors") && computerInput.equals("rock"))) {
            System.out.println("Computer wins, you lost...");
            gameResultList.add("loss");
            ;


        } else if ((userInput.equals("rock") && computerInput.equals("scissors"))
                || (userInput.equals("scissors") && computerInput.equals("paper"))
                || (userInput.equals("paper") && computerInput.equals("rock"))) {
            System.out.println("Congratulations, you won!");

            gameResultList.add("win");
        }
        menu();

    }


    public static void history() {

        int tiecount = 0;
        int wincount = 0;
        int losscount = 0;

        for (int i = 0; i < gameResultList.size(); i++) {

            System.out.println(gameResultList.get(i));

        }

        for (String gameOutcome:gameResultList){
             System.out.println(gameOutcome);
            if (gameOutcome.equals("tie")) {
                tiecount++;
            }
            if (gameOutcome.equals("win")) {
                wincount++;
            }
            if (gameOutcome.equals("loss")) {
                losscount++;
            }

        }

        System.out.println("Wins: " + wincount);
        System.out.println("Losses: " + losscount);
        System.out.println("Ties: " + tiecount);

        menu();
    }

    public static void readFile(){
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader("history.txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {

                gameResultList.add(line);

//                System.out.println(line);
            }

            // Always close files.
             bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            "history.txt" + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + "history.txt" + "'");

        }
    }

    public static void saveFile()
            throws IOException {
        FileWriter writer = new FileWriter("history.txt");
        int size = gameResultList.size();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();


        for (int i=0;i<size;i++) {
            writer.write(String.valueOf(date));
            writer.write("\n");
            writer.write("***");
            String str = gameResultList.get(i).toString();
            writer.write(str);
            if(i < size-1) //**//This prevent creating a blank like at the end of the file**
            writer.write("\n");
        }
        writer.close();
        // This will reference one line at a time

//        menu();
    }

}




