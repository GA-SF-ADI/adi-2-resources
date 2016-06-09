package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        boolean even = oddEven(2);

        wordComparator("Hellddo", "hello");

        printLetters("Heqwlooewlo");

        double rand = isGreaterThan50();

        date(20, 02, 1992);

//        newWord("hi");

        printNosExcept4(9);

        System.out.println("The sum is: "+checkEqualityAndAdd(5,4));

        System.out.println("The sum is: "+checkEqualityAndAdd(2,2));

        countryDomain();

        vowelConsonantDetector();
    }

    //function 1
    public static boolean oddEven(int num) {
        System.out.println("Function 1:");
        if (num % 2 == 0) {
            System.out.println("The number " + num + " is even");
            return true;
        } else {
            System.out.println("The number " + num + " is odd");
            return false;
        }
    }

    //function 2
    public static boolean wordComparator(String w1, String w2) {
        System.out.println("Function 2:");
        String temp1 = w1.toLowerCase();
        String temp2 = w2.toLowerCase();
        if (temp1.equals(temp2)) {
            System.out.println("The spelling of the words " + w1 + " and " + w2 + " is equal");
            return true;
        } else {
            System.out.println("The spelling of the words " + w1 + " and " + w2 + " is not equal");
            return false;
        }
    }

    //function 3
    public static void printLetters(String w1) {
        System.out.println("Function 3:");
        int i = 0;
        while (w1.charAt(i) != 'w' && i < w1.length()) {
            System.out.println(w1.charAt(i));
            i++;
        }
    }

    //function 4
    public static double isGreaterThan50() {
        System.out.println("Function 4:");
        double num = Math.random();
        System.out.println("The random number generated is " + num);
        if (num > 50) {
            System.out.println("The number generated is " + num);
            return num;
        } else {
            System.out.println("So the number is less than 50. \nSo returning: -1\n");
            return -1;
        }
    }

    //function 5
    public static void date(int day, int month, int year) {
        System.out.println("Function 5:");
        int today_date = day + 1;
        System.out.println("day:" + today_date + "  month:" + month + "  year:" + year);
    }

    //function 6
//    public static void newWord(String w1) {
//        System.out.println("Function 6:");
//        int i = 0;
//        do {
//
//        }
//
//        System.out.println(repl);
//
//    }

//    public static void number_printing(int num) {
//        if (num <= 5) {
//            System.out.println("Need a number greater than 5");
//        } else {
//            int no = 1;
//            while (num)
//        }
//    }

    //function 7
    public static void printNosExcept4(int num) {
        if (num > 5) {
            int i = 1;
            while (i < 4) {
                System.out.println(i);
                i++;
            }
            int j = 5;
            while (j<=num) {
                System.out.println(j);
                j++;
            }
        }
        else System.out.println("No should be greater than 5");
        System.out.println("");
    }

    //function 8
    public static int checkEqualityAndAdd(int a,int b){
        int sum;
        if(a==b){
            a=a+2;
            b=b+2;
            sum=a+b;
            return sum;
        }
        else {
            a++;
            b++;
            sum=a+b;
            return sum;
        }
    }

    //function 9
    public static void countryDomain(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a country domain: ");
        String domain = reader.nextLine();

        switch(domain){
            case "us":
            case "US":
                System.out.println("United States");
                break;
            case "de":
            case "DE":
                System.out.println("Germany");
                break;
            case "hu":
            case "HU":
                System.out.println("Hungary");
                break;
            default:
                System.out.println("Unknown");
                break;
        }
    }

    //function 10
    public static void vowelConsonantDetector(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        char letter=reader.next().charAt(0);
        if(letter == 'a' || letter =='e' || letter =='i' || letter=='o' || letter=='u'){
            System.out.println("The letter is a vowel");
        }
        else System.out.println("The letter is a consonant");
    }
}





