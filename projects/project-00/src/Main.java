import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by patrickcummins on 6/9/16.
 */
public class    Main {
    public static HashMap<Integer, String> historyHash = new HashMap<>();
    public static int hashMapCurrentKey = 0;
    public static int textFileCurrent=0;

    static public void main (String [] args) throws IOException {

        populateHash();
        menu();


    }

    public static void populateHash() throws IOException {
        Scanner myScanner = new Scanner(new File("history.txt"));
        while(myScanner.hasNextLine()) {
            historyHash.put(hashMapCurrentKey, myScanner.nextLine());
            hashMapCurrentKey++;
            textFileCurrent++;
        }

    }

    public static void menu() throws IOException {
        Scanner myScanner = new Scanner(System.in);
        String playOrHistory;
        FileReader myFileReader = new FileReader("history.txt");

        System.out.println("Welcome to Rock Paper Scissors \nWould you like to: \n1(Play) Play a game \n2(History) View History \n3(Quit) Stop Program");
        playOrHistory = myScanner.nextLine().toLowerCase();
        if(playOrHistory.equals("1") || playOrHistory.equals("play")){
            playGame();

        } else if(playOrHistory.equals("2") || playOrHistory.equals("history")){
            printHistory();
            menu();
        } else if (playOrHistory.equals("3") || playOrHistory.equals("quit")) {
            writeHashToText();
        } else{
            System.out.println("Invalid Input");
            menu();

        }




    }

    public static void writeHashToText() throws IOException {
        FileWriter myWriter = new FileWriter("history.txt", true);
        for (int i = textFileCurrent + 1; i < historyHash.size(); i++) {
            myWriter.append(historyHash.get(i));

        }
        myWriter.close();
    }

    private static void printHistory() throws FileNotFoundException {

        int wins = 0;
        int losses = 0;
        int ties = 0;
        int currentHashKey=0;
        String current;

            while (currentHashKey< historyHash.size()) {
                current = historyHash.get(currentHashKey);
                System.out.println(current);
                if (current.equals("Tie")) {
                    ties += 1;

                } else if (current.equals("Win")) {
                    wins++;
                } else if (current.equals("Loss")) {
                    losses++;
                }
                currentHashKey++;
            }

        System.out.println("Total Wins: " +wins+"\nTotal Losses: "+ losses+"\nTotal Ties: " + ties);
    }

    public static void playGame() throws IOException {
        String choice;
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Choose: \n1(Rock) \n2(Paper) \n3(Scissors)");
        choice = myScanner.nextLine().toLowerCase();
        int computerChoice = (int) Math.floor(Math.random() * 3) + 1;
        if (choice.equals("rock") || choice.equals("1")){
            if (computerChoice ==1){
                System.out.println("Computer chooses rock, you tie");
                historyHash.put(hashMapCurrentKey, "Tie");

            } else if(computerChoice==2){
                System.out.println("Computer chooses paper, you lose :(");
                historyHash.put(hashMapCurrentKey, "Loss");
            }else if(computerChoice ==3){
                System.out.println("Computer chooses scissors, you Win!");
                historyHash.put(hashMapCurrentKey, "Win");
            }

        }else if(choice.equals("paper") || choice.equals("2")){
            if (computerChoice ==1){
                System.out.println("Computer chooses rock, you Win!");
                historyHash.put(hashMapCurrentKey, "Win");
            } else if(computerChoice==2){
                System.out.println("Computer chooses paper, you tie");
                historyHash.put(hashMapCurrentKey, "Tie");
            }else if(computerChoice ==3){
                System.out.println("Computer chooses scissors, you lose :(");
                historyHash.put(hashMapCurrentKey, "Loss");
            }
        }else if (choice.equals("scissors") || choice.equals("3")){
            if (computerChoice ==1){
                System.out.println("Computer chooses rock, you lose :(");
                historyHash.put(hashMapCurrentKey, "Loss");
            } else if(computerChoice==2){
                System.out.println("Computer chooses paper, you Win!");
                historyHash.put(hashMapCurrentKey, "Win");
            }else if(computerChoice ==3){
                System.out.println("Computer chooses scissors, you tie");
                historyHash.put(hashMapCurrentKey, "Tie");
            }
        }else{
            System.out.println("Sorry that input isn't accepted");
            playGame();
        }
        hashMapCurrentKey++;
        playAgain();

    }

    public static void playAgain() throws IOException {
        Scanner myScanner = new Scanner(System.in);
        String playAgain;
        System.out.println("Play again?(Y/N)");
        playAgain = myScanner.nextLine().toLowerCase();
        if(playAgain.equals("y") || playAgain.equals("yes") ){
            playGame();
        } else if (playAgain.equals("n") || playAgain.equals("no")) {
            System.out.println("Thank you for playing!");
            menu();
        }else {
            System.out.println("Invalid Input");
            playAgain();
        }
    }

}
