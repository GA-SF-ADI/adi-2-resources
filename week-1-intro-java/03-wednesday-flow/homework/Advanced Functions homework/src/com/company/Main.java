package com.company;

import java.util.Random;

public class Main {


    //#1

    public static boolean checkEvenorOdd(int inputnumber) {

        if ((inputnumber % 2 == 0)) {

            System.out.println("True!");
            return true;

        } else {
            return false;
        }

    }


//#2

    public static boolean wordComparison(String word1, String word2) {

        if (word1.equals(word2)) {

            return true;

        } else {

            return false;

        }

    }

//#3

    public static void newLineLetterPrinting(String stringWord) {

        for (int i = 0; i < stringWord.length(); i++) {

            if (stringWord.charAt(i) == 'w') {
                break;
            }

            System.out.println(stringWord.charAt(i));
        }
    }


//#4


    public static int randomInteger() {

        Random rand = new Random();

        int randnum = rand.nextInt();

        System.out.println(randnum);

        if (randnum > 50) {
            System.out.println(randnum);
        } else {
            return -1;
        }
        return randomInteger();
    }


//#5

    public static String whatsTheDate(int day, int month, int year) {

        int nextMonth = month;
        int nextDay = day;
        int nextYear = year;

        if (month == 12) {
            if (day == 31) {
                month = 1;
                day = 1;
                year = year + 1;
            }
        } else {
            nextDay = day + 1;
        }

        return String.format("day: %d, month: %d, year: %d", day, month, year);

    }

//#6

    public static String omitEveryOtherLetter(String inputWord) {

        StringBuilder finalstring = new StringBuilder();

        if (inputWord.length() == 0) {
            return "";
        }

        for (int i = 0; i < inputWord.length(); i++) {

            if (i % 2 == 0) {

                finalstring.append(inputWord.charAt(i));
            }

        }
        return finalstring.toString();
    }


//#7

    public static void exceptFour(int inputNumber) {

        int i = 0;
        while (i <= inputNumber) {

            if (inputNumber != 4) {

                System.out.println(inputNumber);
            }
            inputNumber++;
        }
    }

//#8

    public static int sameNumberCheck(int num1, int num2) {

        if (num1 == num2) {

            num1 = num1 + 2;
            num2 = num2 + 2;
        } else if (num1 != num2) {
            num1 = num1 + 1;
            num2 = num2 + 1;
        }

        return num1 + num2;

    }

//#9

    public static void printCountryDomain() {

        String countryabbreviation = new String();

        switch (countryabbreviation) {

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
                System.out.println("Unknown country");

        }

    }

//#10

    public static char vowelOrConsonant(char inputchar) {

        System.out.println("Please input a letter");




    public static void main(String[] args) {

        System.out.println(checkEvenorOdd(3));

        System.out.println(wordComparison("Michael", "Bruce"));

        System.out.println(randomInteger());

        //System.out.println(whatsTheDate(4, 4, 1988)); //Think my method's correct but it's not printing correctly...

        System.out.println(omitEveryOtherLetter("Philadelphia"));

        System.out.println(omitEveryOtherLetter("Pepsi"));

        // System.out.println(exceptFour(33));

        System.out.println(sameNumberCheck(44, 44));

        printCountryDomain("us");



    }

}

