import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(isEven(10));
        //stopPrintingWhenW("kiwi");
        //System.out.println(compareWords("New York", "New York"));
        //System.out.println(generateRandomNumber());
        //System.out.println(omitEveryOtherLetter("summer"));
        //System.out.println(computeNextDay(31, 12, 1988));
        //printAllNumbersExcept4(10);
        //System.out.println(compareNumbers(101, 101));
        //printCountry();
        //isVowel();
    }

    //Write a function that takes in a number and return true if the number is even or false if the number is odd. You may use control flow and multiple conditionals.
    private static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Simplified solution
     *
     private static boolean isEven(int number) {
     return (number % 2 == 0);
     }
     */

    //Write a function that takes in two words and compares them. If the spelling is the same, the functions returns true, otherwise false.
    private static boolean compareWords(String word1, String word2) {
        if (word1.equals(word2)) {
            return true;
        } else {
            return false;
        }
    }

    //Write a function that takes in a word and prints out its every letter on a new line before it sees the letter "w". If it encounters "w"
    //the function should stop executing.
    private static void stopPrintingWhenW(String initial) {
        for (int i = 0; i < initial.length(); i ++) {
            if (initial.charAt(i) == 'w') {
                break;
            }
            System.out.println(initial.charAt(i));
        }
    }

    //Write a function that generates a random number. Print it out. If the number is greater that 50, return it, otherwise return -1. You may use control flow and multiple conditionals.
    private static int generateRandomNumber() {
        Random r = new Random();
        int num = r.nextInt();
        System.out.println(num);
        if (num > 50) {
            return num;
        } else {
            return -1;
        }
    }


    //Write a function that takes in 3 integers: day, month, and year and computes day, month, and year of the next day. The function should return a
    //string (e.g. day:12 month:11 year:1988)
    private static String computeNextDay(int day, int month, int year) {
        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;
        if (month == 12) {
            if (day == 31) {
                nextDay = 1;
                nextMonth = 1;
                nextYear = year + 1;
            } else {
                nextDay = day + 1;
                nextMonth = month;
            }
        }
        return String.format("day:%d, month:%d year:%d", nextDay, nextMonth, nextYear);
    }

    //Write a function that takes in a word, omit every other letter in that word and return a new word. You can use
    //control flow and multiple conditionals.
    public static String omitEveryOtherLetter(String initial) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < initial.length(); i++) {
            if (i % 2 == 0) {
                builder.append(initial.charAt(i));
            }
        }
        return builder.toString();
    }

    //Write a function that takes in a number greater than 5 and prints out all the numbers from 1 to that number except number 4.
    //Please use while statement.
    private static void printAllNumbersExcept4(int number) {
        int currentNumber = 1;
        while (currentNumber <= number) {
            if (currentNumber != 4) {
                System.out.println(currentNumber);
            }
            currentNumber ++;
        }
    }

    //Write a function that takes in 2 numbers, checks if they are the same. If they are not the same, it adds 1 to every number and returns
    //its sum. If the numbers are the same, it adds 2 to every number and returns its sum.
    private static int compareNumbers(int number1, int number2) {
        if (number1 != number2) {
            if (number1 > 100) {
                number1++;
            }
            if (number2 > 100) {
                number2++;
            }
        }
        else {
            number1 +=2;
            number2 +=2;
        }
        return number1 + number2;
    }

    //Write a function that asks the user to enter a country domain. If the user types in "us", the function prints out "United States",
    //if the user enters "de", the function prints out "Germany", if the user types in "hu" the response should be "Hungary".
    //In all other cases the function should print out "Unknown". Please try to use a switch statement.
    private static void printCountry() {
        System.out.print("Enter a domain:");

        Scanner sc = new Scanner(System.in);
        String domain = sc.nextLine();

        domain = domain.toLowerCase();

        switch (domain) {

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
                break;
        }
    }

    //Write a function that asks the user to type in a letter and PRINTS OUT the response whether the letter is a vowel or a consonant.
    //You may use control flow and multiple conditionals.
    private static void isVowel() {
        String vowels = "aeouiy";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in a letter and I will tell you whether it is a vowel or a consonant: ");
        while (scanner.hasNext()) {
            if (vowels.contains(scanner.next())) {
                System.out.println("It is a vowel");
            } else {
                System.out.println("It is a consonant");
            }
        }
    }


}
