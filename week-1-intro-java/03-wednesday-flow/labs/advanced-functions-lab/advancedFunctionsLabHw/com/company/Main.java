package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(isNumEven(50));
        System.out.println(checkIfStringsAreSame("maps", "mas"));
        stopAtW("mow");
        randomNumber();
        System.out.println(tomorrowsDate(8, 6, 2016));
        System.out.println(newWord("android"));
        printAllExceptFour(10);
        System.out.println(sumOfSameNumbers(2,2));
        userCountry();
        vowelOrConsonant();



    }
//function that takes in a number and returns true if the number is even or false if the number is odd
    public static boolean isNumEven(int num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
//function that takes in two words and compares them. If the spelling is the same, the functions returns true, otherwise false.
    public static boolean checkIfStringsAreSame(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        } else {
            return false;
        }

    }
//function that takes in a word and prints out its every letter on a new line before it sees the letter "w". If it encounters "w" the function should stop executing.
    public static void stopAtW(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c != 'w') {
                System.out.println(c);

            }
        }

    }
    // function that generates a random number. Print it out. If the number is greater that 50, return it, otherwise return -1

    public static int randomNumber() {
        int rand = (int) (Math.random() * 100);
        int notEqual = -1;
        System.out.println(rand);
        if (rand > 50) {
            return rand;
        } else {
            return notEqual;
        }


    }
//this method takes in a day month and year and returns the next days date
    public static String tomorrowsDate(int day, int month, int year) {
        day += 1;

        String date = "Day: " + day + " Month: " + month + " Year: " + year;
        return date;
    }

//takes in a word and prints a new word containing every other letter in the original string
    public static String newWord(String word1) {
        String word2 = "";
        for (int i = 1; i < word1.length(); i += 2) {
            word2 += word1.charAt(i);
        }
        return word2;
    }

    //Write a function that takes in a number greater than 5 and prints out all the numbers from 1 to that number except number 4. Please use a while statement.
    public static void printAllExceptFour(int number) {

        int i = 1;
        while (i <= number) {
            if (i != 4) {
                System.out.println(i);
            }
            i++;
        }

    }
//takes two numbers and checks if they are the same, adds 2 to each and returns the sum, adds 1 to each and returns the sum if not same
    public static int sumOfSameNumbers(int num1, int num2){
        if (num1 == num2){
            num1 +=2;
            num2 +=2;
            int sum = num1 + num2;
            return sum;
        }else {
            num1 +=1;
            num2 +=1;
            int sum = num1 + num2;
            return sum;
        }

    }
//function that asks the user to enter a country domain. If the user types in "us", the function prints out "United States", if the user enters "de", the function prints out "Germany", if the user types in "hu" the response should be "Hungary". In all other cases the function should print out "Unknown"
    public static void userCountry(){

        Scanner input = new Scanner(System.in);
        System.out.println("please enter a country");
        String country = input.nextLine();
        country = country.toLowerCase();

        switch (country){
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
//function that asks the user to type in a letter and prints out whether the letter is a vowel or a consonant
    public static void vowelOrConsonant(){
        Scanner scan = new Scanner(System.in);
        System.out.println("please type a letter");
        String letter = scan.nextLine();
        if (letter.charAt(0) == 'a'|| letter.charAt(0) == 'e' || letter.charAt(0) == 'i' || letter.charAt(0) == 'o' || letter.charAt(0) == 'u'){
            System.out.println(" it is a vowel");
        }else{
            System.out.println("it is a consonant");
        }

    }
}
