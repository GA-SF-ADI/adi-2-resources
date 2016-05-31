package com.adi;

public class Main {

    public static void main(String[] args) {

        // Difference between Integers and Numbers, Part II.B of data-types-and-variables lesson.
        System.out.println("INTEGERS & DECIMALS:");
        int num1 = 5;
        System.out.println("num1, type int = " + num1);

        int num2 = 5 / 2;
        System.out.println("num2, type int = 5/2 = " + num2);

        float num3 = 5 / 2;
        System.out.println("num3, type float = 5/2 = " + num3);

        float num4 = 5f / 2f;
        System.out.println("num4, type float = 5f/2f = " + num4);

        double num5 = 5d / 2d;
        System.out.println("num5, type double = 5d/2d " + num5);


        // Basic Arithmetic, Part II.B of data-types-and-variables lesson.
        System.out.println("\nBASIC ARITHMETIC:");
        System.out.println("Take 3 and 5 and...");
        System.out.println("Add: " + (3 + 5));
        System.out.println("Subtract: " + (3 - 5));
        System.out.println("Divide: " + (3 / 5));
        System.out.println("Multiply: " + (3 * 5));
        System.out.println("Modulus: " + (3 % 5));


        // Special number Operators, Part II.C of data-types-and-variables lesson.
        System.out.println("\nSPECIAL NUMBER OPERATORS:");
        System.out.println("To The power! 3^2 => Math.pow! : "+ Math.pow(3,2) );
        System.out.println("Square root of: √(4) => Math.sqrt! : "+ Math.sqrt(4));
        System.out.println("Random number between 0 and 1 => Math.random! : "+ Math.random());
        System.out.println("Random number between 0 and 10 => Math.random() * 10 : "+ (int) (Math.random() * 10));
    }
}
