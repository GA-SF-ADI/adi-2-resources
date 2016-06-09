package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(evenOdd(35));
        System.out.println(compareWordSpelling("asdf", "awdf"));
        printUntilW("fdsanklwlkjjw");
        System.out.println(largerFifty());
        nextDay(30,11,1984);
        replaceWord("giraffe hippo giraffe hippo stegosaurous");
        printRangeBelow(30);
        samePlusTwo(908,34);
        countryDomain();
        testVowel();

    }

    //Write a function that takes in a number and returns true if the number is even or false if the number is odd.
    public static boolean evenOdd(int number) {
        if ((number % 2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    //Write a function that takes in two words and compares them. If the spelling is the same, the functions returns true, otherwise false.
    public static boolean compareWordSpelling(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        } else {
            return false;
        }
    }

    //Write a function that takes in a word and prints out its every letter on a new line before it sees the letter "w".
    //If it encounters "w" the function should stop executing.

    public static void printUntilW(String w1) {
        int i = 0;
        while (w1.charAt(i) != 'w' && i < w1.length()) {
            System.out.println(w1.charAt(i));
            i++;
        }
    }

    //  Write a function that generates a random number. Print it out. If the number is greater that 50, return it, otherwise return -1.
    // You may use control flow and multiple conditionals.

    public static double largerFifty(){
        double num = Math.random();
        System.out.println("Here is the random number: "+num);
        if(num > 50){
            return num;
        }
        else {
            return -1;
        }
    }
    // Write a function that takes in 3 integers: day, month, and year and computes day, month, and year of the next day.
    // The function should return a string (e.g. day:12 month:11 year:1988)

    public static void nextDay(int day, int month, int year){

        int today=day+1;
        System.out.println("It is the "+ today +" day of " + month + "and the year is " +year); //seems a bit too easy, did I misunderstand the instructions?
    }

    //Write a function that takes in a word, omits every other letter in that word and returns a new word.
    // You can use control flow and multiple conditionals.

    public static void replaceWord(String inputWord){
        String replaceInputWith = inputWord.replaceAll("giraffe","*mystery animal*");
        System.out.println(replaceInputWith);

    }

    // Write a function that takes in a number greater than 5 and prints out all the numbers from 1 to that number except number 4.
    // Please use a while statement.

    public static void printRangeBelow(int number){

        for (int i=0; i<number; i++){
            if(i!=4){
                System.out.println(i);
            }
        }
    }


    //Write a function that takes in 2 numbers, and checks if they are the same. If they are not the same, it adds 1 to every number and returns its sum.
    // If the numbers are the same, it adds 2 to every number and returns its sum.

    public static int samePlusTwo(int first, int second){
        if (first == second){
            return (first+2) + (second+2); //returns sum adding two to each number in instance where ints are the same value
        }
        else{
            return (first+1) + (second+1);
        }
    }


    // Write a function that asks the user to enter a country domain. If the user types in "us", the function prints out "United States", if the user enters "de", the function prints out "Germany", if the user types in "hu" the response should be "Hungary".
    // In all other cases the function should print out "Unknown". Please try to use a switch statement and make sure the function works with a user's input of lower and upper case strings.

        public static void countryDomain(){
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter Country Domain:");
            String answer = reader.nextLine();
            answer = answer.toLowerCase();  //makes input uniform (all lower case) to avoid capitalization conflicts
            switch (answer) {
                case "us":
                    System.out.println("United States");
                    break;
                case "de":
                    System.out.println("Germany");
                    break;
                case "hu":
                    System.out.println("Hungary");
                    break;
                default:
                    System.out.println("Unknown");
            }
        }

    // Write a function that asks the user to type in a letter and prints out whether the letter is a vowel or a consonant.

        public static void testVowel(){
            Scanner input = new Scanner(System.in);
            System.out.println("Which letter are you thinking of ?");
            String letter = input.nextLine();
            letter=letter.toLowerCase(); //make them all lower case to circumvent case sensitivity conflicts
            if(letter.equals('a') || letter.equals('e') || letter.equals('i') || letter.equals('o') || letter.equals('u')){
                System.out.printf("This is a vowel");
            } else{
                System.out.println("not a vowel!");
            }


        }
    }







