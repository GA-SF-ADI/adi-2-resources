package com.adi;

public class Functions {

    public static void main(String[] args) {

        compareIntsAndDecimals(5,2);
        compareIntsAndDecimals(10, 12);
        tryBasicArithmetic(5,2);
        trySpecialNumberOperators(3,10);
    }

    // Difference between Integers and Numbers, Part II.B of data-types-and-variables lesson.
    public static void compareIntsAndDecimals(int divisor1, int divisor2) {

        System.out.println("INTEGERS & DECIMALS:");
        int num1 = divisor1;
        System.out.println("num1, type int = " + num1);

        int num2 = divisor1 / divisor2;
        System.out.println("num2, type int = "+divisor1+"/"+divisor2+" = " + num2);

        float num3 = divisor1 / divisor2;
        System.out.println("num3, type float = \"+divisor1+\"/\"+divisor2+\" = " + num3);

        float num4 = (float) divisor1 / (float) divisor2;
        System.out.println("num4, type float = "+divisor1+"f/"+divisor2+"f = " + num4);

        double num5 = (double) divisor1 / (double) divisor2;
        System.out.println("num5, type double = "+divisor1+"d/"+divisor2+"d = " + num5);
    }

    // Basic Arithmetic, Part II.B of data-types-and-variables lesson.
    public static void tryBasicArithmetic(int num1, int num2) {
        System.out.println("\nBASIC ARITHMETIC:");
        System.out.println("Take "+num1+" and "+num2+" and...");
        System.out.println("Add: " + (num1 + num2));
        System.out.println("Subtract: " + (num1 - num2));
        System.out.println("Divide: " + (num1 / num2));
        System.out.println("Multiply: " + (num1 * num2));
        System.out.println("Modulus: " + (num1 % num2));
    }

    // Special number Operators, Part II.C of data-types-and-variables lesson.
    public static void trySpecialNumberOperators(int num1, int num2) {
        System.out.println("\nSPECIAL NUMBER OPERATORS:");
        System.out.println("To The power! "+num1+"^"+num2+" => Math.pow! : "+ Math.pow(num1,num2) );
        System.out.println("Square root of: √("+num1+") => Math.sqrt! : "+ Math.sqrt(num1));
        System.out.println("Random number between 0 and 1 => Math.random! : "+ Math.random());
        System.out.println("Random number between 0 and "+num2+" => Math.random() * "+num2+" : "+ (int) (Math.random() * num2));
    }
}
