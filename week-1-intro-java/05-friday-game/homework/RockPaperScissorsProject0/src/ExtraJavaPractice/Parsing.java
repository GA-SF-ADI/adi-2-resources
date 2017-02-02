package ExtraJavaPractice;

import java.util.Scanner;
/**
 * Created by audreyeso on 6/14/16.
 */

public class Parsing {


    public static void main(String[] args) {

        //Scanner keyboard = new Scanner(System.in);
        //Integer myNumber = keyboard.nextInt();
        //myNumber=Integer.parseInt("9");
        //System.out.println(myNumber);

        Integer myNumber = 7;
        System.out.print(myNumber.toString());
        System.out.println();
        System.out.println(myNumber);
        System.out.println();

        if(myNumber.equals("7")){
           System.out.print("okay!");
        } else{
            System.out.println();
            System.out.print("not okay!");
        }

        String myString = "900";
        System.out.println(myString);
        System.out.println();
        int i = Integer.parseInt(myString);
        System.out.println();
        System.out.println(myString);

        if(myString.contains("9")){
            System.out.println("There's a nine!");
        }
    }

}

