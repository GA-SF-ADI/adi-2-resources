package com.company;

import java.util.Scanner;

public class Main {

    public static boolean firstFunction (int firstInt) {
        //I think there must be another way to do this.
        boolean response;
        if (firstInt % 2 == 0) {
            return response = true;
        }
        else if (firstInt % 2 != 0) {
            return response = false;
        }
        else {
            System.out.println ("Error!");
            return true;
            /*hmmm... not sure if returning true or false matters if the if and else if statements are alwways going
            to work? Will my if and else if statements always work with every int? Can I just do if and else?
            */
        }
    }

    public static boolean compareStrings (String word1, String word2 ) {

        if(word1.equals (word2)) {
            return true;
        }
        else {
            return false;
        }

//equalsignore case -- look into this
    }

    public static double generateRandomNumber () {
        double randomNumber = Math.random()*100;
        if (randomNumber > 50) {
            return randomNumber;
        }
        else {
            return -1;
        }

    }

    public static String computesDayMonthYear (int day, int month, int year){
        day = 8;
        int newDay = day + 1;
        month = 6;
        year = 2016;

        String monthDayYear;
        monthDayYear = ("Tomorrow's date is " + month + "/" + newDay + "/" + year + ".");
        return monthDayYear;
    }

    /*
    * Write a function that takes in a word,
    * omits every other letter in that word and returns a new word.
    * You can use control flow and multiple conditionals.
     */
    //public static String returnsNewWord (String oldWord) {

        //String newWord;
        //return newWord;
        //use toCharArray()
   // }

    /*Directions: Write a function that takes in a number
    greater than 5 and prints out all the numbers from
    1 to that number except number 4. Please use a while statement.
     */


    public static void printsNumbers (int greaterThanFive) {
//Why is this "void" if you want it to print out other ints?
        int i = 1;
        while (i <= greaterThanFive) {
            if (greaterThanFive != 4) {
                System.out.println(i);
            }
            i++;
        }

    }

   /* Write a function that takes in 2 numbers,
    * and checks if they are the same. I
     if they are not the same, it adds 1 to every number
     and returns its sum. If the numbers are the same,
     it adds 2 to every number and returns its sum.
     */
public static int sameOrNotSameNumbers (int a, int b) {

    if (a != b)
    {
        a = a+1;
        b = b+1;
        return a+b;
    }

    else{
        a = a+2;
        b = b+2;
        return a + b;
    }
}

   /* Write a function that asks the user to type
   in a letter and prints out whether the letter is a
   vowel or a consonant. You may use control flow and
   multiple conditionals.
    */

    //This is how I did it at first... (before I peeked at the answer).
    public static String vowelOrConsonant (char letter) {
        System.out.println("Type in a lowercase letter.");
        Scanner keyboard = new Scanner (System.in);
        letter = keyboard.next().charAt(0);
        String string1 = "That's a vowel!";
        String string2 = "That's a consonant!";

        if (letter == 'a' || letter == 'e'|| letter == 'i' || letter == 'o' || letter == 'u')  {
            return string1;
        }
        else {
            return string2;
        }

    }


    private static void isVowel() {
        String vowels = "aeiou";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in a letter. ");
        while (scanner.hasNext()) {
            if (vowels.contains(scanner.next())) {
                System.out.println("It is a vowel");
            } else {
                System.out.println("It is a consonant");
            }
        }
    }




    /* Write a function that asks the user to enter a country domain.
    If the user types in "us", the function prints out "United States",
    if the user enters "de", the function prints out "Germany", if the user types in "hu" the
    response should be "Hungary".
     */

    public static String countries (String domain) {
        System.out.println("Type in a domain.");
        Scanner keyboard = new Scanner (System.in);
        domain = keyboard.next();
        String domainUS = "The United States";
        String domainGermany = "Germany";
        String unknown = "unknown";

        if (domain.equals("us")){
            return domainUS;
        }
        else if (domain.equals("de")){
            return domainGermany;
        }

        else {
            return unknown;
        }

    }

    public static void main(String[] args) {
	// write your code here

        System.out.println(firstFunction(4));
        System.out.println(compareStrings("car", "car"));
        System.out.println(compareStrings("cat", "car"));
        System.out.println(generateRandomNumber());
        //it will generate the number for you, so you can leave it empty
        System.out.println(computesDayMonthYear(6,8,2016));
        System.out.println(sameOrNotSameNumbers(4,5));
        System.out.println(sameOrNotSameNumbers(-90,-90));
        System.out.println(sameOrNotSameNumbers(2,2));
        System.out.println(vowelOrConsonant('a'));
        System.out.println(countries("de"));

    }

}
