package com.company;

import java.util.Scanner;
/*
You have been provided the starter code for a simple calculator.
Given that the user enters two numbers, a result is shown depending on what
choice the user made from the main menu.

However, it is broken in certain cases.
Sometimes it behaves unexpectedly or throws errors.

Import the project into IntelliJ, and fix
as many bugs as possible using the tools you learned about today.
*/

public class Main {

    public static void main(String[] args) {
        System.out.println("=== CALCULATOR ===\n");
        System.out.println("Choose an operation: \n1. add\n2. subtract\n3. multiply\n4. divide\n");

        Scanner scanner = new Scanner(System.in);

        String answer = scanner.nextLine();

        if(answer.equals("1") || answer.equals("add")){
            add();
        } else if(answer.equals("2") || answer.equals("subtract")){
            subtract();
            //I changed it from 1 to 2 here.
        } else if(answer.equals("3") || answer.equals("multiply")){
            multiply();
        } else if(answer.equals("4") || answer.equals("divide")){
            divide();
        } else {
            System.out.println("Invalid input!");
        }
    }

    public static String getInput(String context){
        System.out.print(context+": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void add(){
        int firstNum = Integer.parseInt(getInput("First number"));
        int secondNum = Integer.parseInt(getInput("Second number"));
        int result = firstNum + secondNum;
        System.out.println("Result: "+result);
    }

    public static void subtract(){
        int firstNum = Integer.parseInt(getInput("First number"));
        int secondNum = Integer.parseInt(getInput("Second number"));
        int result = firstNum - secondNum;
        System.out.println("Result: "+result);
    }

    public static void multiply(){
        int firstNum = Integer.parseInt(getInput("First number"));
        int secondNum = Integer.parseInt(getInput("Second number"));
        int result = firstNum * secondNum;
        //I changed + to * so that it multiplies instead of add.
        System.out.println("Result: "+result);
    }

    public static void divide(){
        int firstNum = Integer.parseInt(getInput("First number"));
        int secondNum = Integer.parseInt(getInput("Second number"));
        float result = firstNum / secondNum;
        System.out.println("Result: "+result);
    }
}
