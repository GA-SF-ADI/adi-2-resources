package com.company;

import com.sun.prism.shader.Solid_TextureYV12_Loader;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {

    //Semi-done
    public static boolean palindromeCheck(String inputWord) {


        if (inputWord.toLowerCase().charAt(0) == (inputWord.toLowerCase().charAt(inputWord.length() - 1))) {

            System.out.println("Yahoooooooo! It's a palindrome!");
            return true;

        } else {
            System.out.println("Ohhh! Too bad :( That word isn't a palindrome!");
            return false;

        }

    }

    //DONE!
    public static void everyOtherElement() {

        String everyOtherString = new String();

        ArrayList<Character> listOfCharacters = new ArrayList<Character>();

        listOfCharacters.add(0, 'a');
        listOfCharacters.add(1, 'b');
        listOfCharacters.add(2, 'c');
        listOfCharacters.add(3, 'd');
        listOfCharacters.add(4, 'e');
        listOfCharacters.add(5, 'f');
        listOfCharacters.add(6, 'g');

        for (int place = 1; place < listOfCharacters.size(); place += 2) {

            everyOtherString = everyOtherString + listOfCharacters.get(place);

        }

        System.out.println(everyOtherString);

    }


    /*Finish this!

    public static int returnsMaxValue(int[] enteredArray) {

        int maximumValue = enteredArray[33];

        if ()

            return maximumValue

    }
*/
    //DONE!
    public static int daysInMonth(int enteredmonth) {

        switch (enteredmonth) {

            case 1:
                System.out.println("31 days");
                break;

            case 2:
                System.out.println("28 days (29 days in leap years!");
                break;

            case 3:
                System.out.println("31 days");
                break;

            case 4:
                System.out.println("30 days");
                break;

            case 5:
                System.out.println("31 days");
                break;

            case 6:
                System.out.println("30 days");
                break;

            case 7:
                System.out.println("31 days");
                break;

            case 8:
                System.out.println("31 days");
                break;

            case 9:
                System.out.println("30 days");
                break;

            case 10:
                System.out.println("31 days");
                break;

            case 11:
                System.out.println("30 days");
                break;

            case 12:
                System.out.println("31 days");
                break;

            default:
                System.out.println("0");
                break;

        }

        return enteredmonth;
    }


//Function #5

    public static int greaterThan20Check(int[] arrayEntry) {

        int returnSum = 0;

        for (int currentValue : arrayEntry) {
            if (currentValue > 20) {
                returnSum = returnSum - 3;
            } else if (currentValue > 1) {
                returnSum = returnSum + 1;
            }
        }

        return returnSum;
    }


//Function #6

    public static ArrayList<String> listOfUniqueNames(ArrayList<String> namearray) {

        ArrayList<String> duplicatesNone = new ArrayList<String>();
        for (String providedName : namearray) {
            if (!duplicatesNone.contains(providedName)) {
                duplicatesNone.add(providedName);
            }

        }
        return duplicatesNone;
    }

//Function #7

    public static boolean vowelDetermination(Character letter) {

        switch (letter) {

            case 'a':
                return true;
            case 'e':
                return true;

            case 'i':
                return true;

            case 'o':
                return true;

            case 'u':
                return true;

            default:
                return false;
        }

    }

    public static String consonantsOnly(String submittedString) {

        String noVowelsString = new String();

        if (submittedString.isEmpty()) {
            return "";

        }

        for (int i = 0; i < submittedString.length(); i++) {

            if (!vowelDetermination(Character.toLowerCase(submittedString.charAt(i)))) {

                //not sure about here
            }

        }

        return ""; //not sure what I'm returning...
    }

//Function #8

    public static ArrayList<String> changedCountryList(ArrayList<String> countries) {

        int sizeOfCountryArray = countries.size();

        if (countries.isEmpty()) {
            return null;
        }

        for(String country : countries){

            //Stuck on manipulating String array to swap first and last :(

        }


        return countries;
    }


    public static void main(String[] args) {
        //palindromeCheck("philadelphia");


        //Array list of numbers for greaterThan20Check method

        int[] customChosenNumbers = {2, 5, 8, 19, 29, 58};


        everyOtherElement();

        System.out.println();

        daysInMonth(4);

        System.out.println();

        System.out.println(greaterThan20Check(customChosenNumbers));

        System.out.println();

        //Array list for names for listOfUniqueNames method

        ArrayList<String> finalListofNames = new ArrayList<String>();

        finalListofNames.add(0, "Michael");
        finalListofNames.add(0, "Kevin");
        finalListofNames.add(0, "Luigi");
        finalListofNames.add(0, "Luigi");
        finalListofNames.add(0, "Luigi");
        finalListofNames.add(0, "Luigi");
        finalListofNames.add(0, "Luigi");
        finalListofNames.add(0, "Kelly");
        finalListofNames.add(0, "Stacy");
        finalListofNames.add(0, "Bruce");
        finalListofNames.add(0, "Bruce");
        finalListofNames.add(0, "Bruce");
        finalListofNames.add(0, "Bruce");

        System.out.println(listOfUniqueNames(finalListofNames));

        System.out.println(consonantsOnly("Michaelangelo"));

        //Countries for Array List

        ArrayList<String> countryList = new ArrayList<>(Arrays.asList("Kenya", "Brazil", "Japan", "Malaysia", "Peru"));
        System.out.println(changedCountryList(countryList));

    }
}





