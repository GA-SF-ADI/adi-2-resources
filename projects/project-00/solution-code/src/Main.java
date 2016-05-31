import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by drewmahrt on 4/22/16.
 */
public class Main {
    private static ArrayList<String> gameHistory;

    public static void main(String[] args) {
        gameHistory = new ArrayList<>();

        mainMenu();
    }

    private static void mainMenu() {
        System.out.println("\nWelcome to Rock Paper Scissors!\n");
        System.out.println("MAIN MENU\n=====\n1. Type 'play' to play\n2. Type 'history' to view your game history\nType 'quit' to stop playing\n");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.equals("play")) {
            playGame();
        } else if (input.equals("history")) {
            System.out.println("=== GAME HISTORY ===");
            for (int i = 0; i < gameHistory.size(); i++) {
                System.out.println(gameHistory.get(i));
            }
            mainMenu();
        }else if(input.equals("quit")){
            return;
        }else{
            System.out.println("Invalid input, please try again.\n");
            mainMenu();
        }

    }

    private static void playGame(){
        String computerChoice = getComputerChoice();

        Scanner scanner = new Scanner(System.in);
        String playerChoice = "";

        while(!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors") && !playerChoice.equals("quit")) {
            System.out.println("\n\nType in 'rock' 'paper' or 'scissors' to play.\n Type 'quit' to go back to the Main Menu\n");
            playerChoice = scanner.nextLine();
        }

        switch (playerChoice) {
            case "rock":
                System.out.println("Computer picks: "+computerChoice+"\nUser picks: "+playerChoice);
                if(computerChoice.equals("paper")) {
                    System.out.println("You lose!");
                    gameHistory.add("LOSS: Player-"+ playerChoice +" computer-"+computerChoice);
                }else {
                    System.out.println("You win!");
                    gameHistory.add("WIN: Player-"+ playerChoice +" computer-"+computerChoice);
                }
                break;
            case "paper":
                System.out.println("Computer picks: "+computerChoice+"\nUser picks: "+playerChoice);
                if(computerChoice.equals("scissors")) {
                    System.out.println("You lose!");
                    gameHistory.add("LOSS: Player-"+ playerChoice +" computer-"+computerChoice);
                }else {
                    System.out.println("You win!");
                    gameHistory.add("WIN: Player-"+ playerChoice +" computer-"+computerChoice);
                }
                break;

            case "scissors":
                System.out.println("Computer picks: "+computerChoice+"\nUser picks: "+playerChoice);
                if(computerChoice.equals("rock")) {
                    System.out.println("You lose!");
                    gameHistory.add("LOSS: Player-"+ playerChoice +" computer-"+computerChoice);
                }else {
                    System.out.println("You win!");
                    gameHistory.add("WIN: Player-"+ playerChoice +" computer-"+computerChoice);
                }
                break;
            case "quit":
                break;
            default:
                break;
        }
        mainMenu();
    }

    public static String getComputerChoice(){
        Random r = new Random(System.currentTimeMillis());
        int choice = r.nextInt(3);

        switch (choice) {
            case 0:
                return "rock";
            case 1:
                return "scissors";
            case 2:
                return "paper";
            default:
                return "";
        }
    }

}
