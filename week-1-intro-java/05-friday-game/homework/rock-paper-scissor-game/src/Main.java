/**
 * Created by mac on 6/9/16.
 */
import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class Main {


        public static void main(String... args) throws IOException {

            //String fileName = "test.txt";

            int playgame;
            int number_Random = 0;
            Random rd = new Random();                           // new Random Util
            number_Random = rd.nextInt(3);                       //Random Namber will stop at 3

            Scanner sc = new Scanner(System.in);                    //Scanner Util

            System.out.println("enter your choices......");
            System.out.println("For Rock input 1......");
            System.out.println("For Paper input 2......");
            System.out.println("For Scissors input 3...");         //Imput int next line

            //PrintWriter outputStream = new PrintWriter(fileName);  //
           // outputStream.println("Computer as Rock");
           // outputStream.close();
           // System.out.println();

            //FileWriter fw = new FileWriter(fileName);
           // BufferedWriter bw = new BufferedWriter(fw);
            //bw.write("Computer as Rock");
            //bw.close();
            //PrintWriter pw = new PrintWriter(fw);
            //pw.println("Computer as Rock");
            //pw.close();


            playgame = sc.nextInt();


            switch (number_Random) {
                case 0:
                    int number_Random1 = 1;
                    System.out.println("Computer as Rock");
                    if (playgame == (number_Random1)) {
                        System.out.println("same !!!");

                    } else if (playgame == (2)){
                        System.out.println("you win !!! ");

                    } else if (playgame == (3)) {
                        System.out.println("you Lost !!!    ");
                    } else {
                        System.out.println("Please input a number !");
                    }
                    break;

                case 1:
                    int number_Random2 = 2;
                    System.out.println("Computer as Paper");
                    if (playgame == (number_Random2)) {
                        System.out.println("same !!!");
                    } else if (playgame == (3)){
                        System.out.println("you win !!! ");
                    } else if (playgame == (1)) {
                        System.out.println("you Lost !!!    ");
                    } else {
                        System.out.println("Please play the game !");
                    }
                    break;

                case 2:
                    int number_Random3 = 3;
                    System.out.println("Computer as Scissors");
                    if (playgame == (number_Random3)) {
                        System.out.println("same !!!");
                    } else if (playgame == (1)){
                        System.out.println("you win !!! ");
                    } else if (playgame == (2)) {
                        System.out.println("you Lost !!!    ");
                    } else {
                        System.out.println("Please play the game !");

                    }
                    break;


            }
        }
    }























