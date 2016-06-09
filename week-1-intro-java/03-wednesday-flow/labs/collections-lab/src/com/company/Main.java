package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        String palindrome = "dad";
        String inputMonth = "January";

        int[] inputIntArray = {3,2,5,6,7,4,39};

        int[] inputOnesandThrees = {454, 43, 2222, 6, 1, 3, 9};

        ArrayList<String> inputNames = new ArrayList<>();

        inputNames.add("Susie");
        inputNames.add("Sally");
        inputNames.add("Bojack");
        inputNames.add("Tom");
        inputNames.add("Bojack");

        System.out.println(isPalindrome(palindrome));
        System.out.println(everyOther());
        System.out.println(maxArrayValue(inputIntArray));
        System.out.println(daysMonth(inputMonth));
        System.out.println(onesandthrees(inputOnesandThrees));
        System.out.println(uniqueName(inputNames));
        System.out.println(eliminateVowel("fdaeoinkpfuiophfjkfdap"));

    }

    public static boolean isPalindrome(String word) {
        int i1 = 0;
        int i2 = word.length() - 1;
        while (i2 > i1) {
            if (word.charAt(i1) != word.charAt(i2)) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }

    public static String everyOther() {

        String outputEveryOther = "";

        ArrayList<Character> anyCharacters = new ArrayList<>();
        anyCharacters.add('w');
        anyCharacters.add('z');
        anyCharacters.add('T');
        anyCharacters.add('X');
        anyCharacters.add('l');

        int j = 0;
        for (int i = 0; i < anyCharacters.size(); i += 2) {
            outputEveryOther += anyCharacters.get(i);

        }
        return outputEveryOther;
    }

    public static int maxArrayValue(int[] inputArray){
      int maximum =0;
        int currentnumber;

        for(int i=0; i < inputArray.length; i++){
            currentnumber = inputArray[i];
            if (currentnumber > maximum) {
                maximum = currentnumber;
            }
        }
        return maximum;

    }

    public static int daysMonth(String inputMonth) {

        if(inputMonth.equals("January") || inputMonth.equals("March") || inputMonth.equals("May") || inputMonth.equals("July") ||
                inputMonth.equals("August") || inputMonth.equals("October") || inputMonth.equals("December")){
            return 31;
        }
        else if(inputMonth.equals("April") || inputMonth.equals("June") || inputMonth.equals("September") || inputMonth.equals("November")){
            return 30;
        }
        else if(inputMonth.equals("Febuary")){
            return 29;
        }
        else { return 0; }

    }

    public static int onesandthrees(int[] inputOnesandThrees){

    int sum =0;
    for(int i=0; i< inputOnesandThrees.length; i++){
        if(inputOnesandThrees[i]>=1 && inputOnesandThrees[i]<20){
            sum = sum + inputOnesandThrees[i];
        }
        else if(inputOnesandThrees[i]>=20){
            sum = sum - 3;
        }
    }
return sum;
}

public static ArrayList<String> uniqueName(ArrayList<String> inputNames) {

    ArrayList<String> returnNames = new ArrayList<>();

  for (String verify: inputNames) {

      if (!returnNames.contains(verify)) {
          returnNames.add(verify);
      }
  }
    return returnNames;


}


    public static String eliminateVowel(String randomstring) {
        char thisLetter;
        String purgedVowels = "";
        for (int i = 0; i < randomstring.length(); i++) {
            thisLetter = randomstring.charAt(i);
            if (thisLetter == 'a' || thisLetter == 'e' || thisLetter == 'i' || thisLetter == 'o' || thisLetter == 'u') {

            } else {
                purgedVowels += thisLetter;
            }

        }
        return purgedVowels;


    }
    }










