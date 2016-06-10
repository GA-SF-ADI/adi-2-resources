/**
 * Created by mac on 6/9/16.
 */
import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static java.util.Scanner.*;


public class Main {


        public static void main(String... args) throws IOException {

            //boolean run = true;

            String fileName = "test.txt";


            int playgame;
            int number_Random = 0;


            Scanner sc = new Scanner(System.in);
                        System.out.println("=========================================================================");
                        System.out.println("                                Welcome                                  ");
                        System.out.println("=========================================================================");
                        System.out.println("=========================================================================");//Scanner Util
                        System.out.println("=========================================================================");
                        System.out.println("                         Do You Want to Play ?"                           );
                        System.out.println("=========================================================================");
                        System.out.println("                         For Rock input 1.....                           ");
                        System.out.println("                         For Paper input 2....                           ");
                        System.out.println("                         For Scissors input 3.                           ");
                        System.out.println("=========================================================================");    //Imput int next line
            playgame = sc.nextInt();


            Random rd = new Random();                           // new Random Util
            number_Random = rd.nextInt(3);                       //Random Namber will stop at 3

            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);




            if (number_Random == 0)     {System.out.println("                         Computer picked Rock                        ");
            }
            else if (number_Random == 1){System.out.println("                         Computer picked Paper                       ");
            }else                       {System.out.println("                         Computer picked Scissors                    ");
            }
            System.out.println("=========================================================================");





            if (playgame == 1)          {System.out.println("                           Player picked Rock                        ");
            }
            else if (playgame == 2)     {System.out.println("                         Player picked Paper                         ");
            }else if (playgame == 3)    {System.out.println("                       Player picked Scissors                        ");
            }else                       {System.out.println("                    WRONG INPUT PLEASE PLAY AGAIN"                    );}

            switch (number_Random) {
                case 0:
                    int number_Random1 = 1;
                        System.out.println("=========================================================================");
                        bw.write(" Computer as Rock  ");
                        System.out.println("=========================================================================");


                    if (playgame == (number_Random1)) {
                        System.out.println("=========================================================================");
                        System.out.println("                          you have the same !!!                          ");
                        bw.write(" you have the same !!!");
                        System.out.println("=========================================================================");

                    } else if (playgame == (2)){
                        System.out.println("=========================================================================");
                        System.out.println("                              you win !!!                                ");
                        bw.write("    you win !!!     ");
                        System.out.println("=========================================================================");

                    } else if (playgame == (3)) {
                        System.out.println("=========================================================================");
                        System.out.println("                             you Lost !!!                                ");
                        bw.write("    you Lost !!!    ");
                        System.out.println("=========================================================================");

                    } else {
                        System.out.println("Please input a number !");
                    }
                    break;

                case 1:
                    int number_Random2 = 2;
                        System.out.println("=========================================================================");
                        bw.write(" Computer as Paper !!!  ");
                        System.out.println("=========================================================================");

                    if (playgame == (number_Random2)) {
                        System.out.println("=========================================================================");
                        System.out.println("                         you have the same !!!");
                        bw.write(" you have the same !!!");
                        System.out.println("=========================================================================");

                    } else if (playgame == (3)){
                        System.out.println("=========================================================================");
                        System.out.println("                              you win !!!                                ");
                        bw.write("you win !!! ");
                        System.out.println("=========================================================================");

                    } else if (playgame == (1)) {
                        System.out.println("=========================================================================");
                        System.out.println("                              you Lost !!!                               ");
                        bw.write("you Lost !!! ");
                        System.out.println("=========================================================================");

                    } else {
                        System.out.println("                       Please play the game !"                            );
                    }
                    break;

                case 2:
                    int number_Random3 = 3;
                        System.out.println("=========================================================================");
                        bw.write("  Computer as Scissors !!! ");
                        System.out.println("=========================================================================");

                    if (playgame == (number_Random3)) {
                        System.out.println("=========================================================================");
                        System.out.println("                           you have the same !!!");
                        bw.write("You Have the same");
                        System.out.println("=========================================================================");

                    } else if (playgame == (1)){
                        System.out.println("=========================================================================");
                        System.out.println("                               you win !!!                               ");
                        bw.write("You win");
                        System.out.println("=========================================================================");

                    } else if (playgame == (2)) {
                        System.out.println("=========================================================================");
                        System.out.println("                              you Lost !!!                               ");
                        bw.write("You Lost");
                        System.out.println("=========================================================================");

                    } else {
                        System.out.println("                         Please play the game !                           ");
                    }

                    break;
            }
            sc.close();
            bw.close();


        }


    }

























