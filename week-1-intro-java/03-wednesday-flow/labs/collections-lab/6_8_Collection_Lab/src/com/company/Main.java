package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // Question 1
        System.out.println(isPalindrome("lkjl"));
        System.out.println(isPalindrome("Mom"));

        // Question 2
        System.out.println(everyOtherLetter());

        //Question 3
        int[] q3Test = {3, 7, 1, 345, 76, 9};
        System.out.println(maxNum(q3Test));

        //Question 4
        System.out.println(numOfDaysInMonth(1));
        System.out.println(numOfDaysInMonth(2));
        System.out.println(numOfDaysInMonth(3));
        System.out.println(numOfDaysInMonth(4));
        System.out.println(numOfDaysInMonth(5));
        System.out.println(numOfDaysInMonth(6));
        System.out.println(numOfDaysInMonth(7));
        System.out.println(numOfDaysInMonth(8));
        System.out.println(numOfDaysInMonth(9));
        System.out.println(numOfDaysInMonth(10));
        System.out.println(numOfDaysInMonth(11));
        System.out.println(numOfDaysInMonth(12));
        System.out.println(numOfDaysInMonth(-4));

        //Question 5
        int[] q5Test = {3, 7, 1, 20, 76, 9};
        System.out.println(calculation(q5Test));

        //Question 6
        ArrayList<String> randomNames = new ArrayList<>();
        randomNames.add("Adam");
        randomNames.add("Adam");
        randomNames.add("Adam");
        randomNames.add("Bob");
        randomNames.add("Clair");
        randomNames.add("Bob");
        randomNames.add("Jason");
        randomNames.add("Adam");
        System.out.println(listOfNames(randomNames));

        //Question 7
        System.out.println(consonants("AlkdlkjIlakb"));
        System.out.println(consonants(""));

        //Question 8
        ArrayList<String> countries = new ArrayList<>();
        countries.add("China");
        countries.add("Japan");
        countries.add("France");
        countries.add("Canada");
        countries.add("Finland");
        countries.add("Iceland");
        countries.add("Russia");
        countries.add("Aruba");
        System.out.println(countryList(countries));
    }

    //Lab Methods
    //Question 1
    public static boolean isPalindrome(String s){
        String toLowerCase = s.toLowerCase();
        String reverse = "";
        for (int i = 0; i < s.length(); i++) {
            reverse += toLowerCase.charAt(s.length()-1-i);
        }
        if (toLowerCase.equals(reverse)){
            return true;
        } else return false;
    }

    //Question 2
    public static String everyOtherLetter(){
        char[] listOfChar = {'a', 'b', 'c', 'd', 'e', 'f'};
        String s = "";
        for (int i = 0; i < listOfChar.length; i++) {
            if(i%2==0){
                s += listOfChar[i];
            }
        }
        return s;
    }

    //Question 3
    public static int maxNum (int[] arrayInt){
        int max = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i]>max){
                max = arrayInt[i];
            }
        }
        return max;
    }

    //Question 4
    public static int numOfDaysInMonth (int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11){
            return 30;
        } else if (month == 2){
            //assuming not leap year
            return 28;
        } else return 0;
    }

    //Question 5
    public static int calculation (int[] arrayInt){
        int answer = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            if(1<arrayInt[i] && arrayInt[i]<=20){
                answer += arrayInt[i];
            } else if(arrayInt[i]>20){
                answer -= 3;
            }
        }
        return answer;
    }

    //Question 6
    public static ArrayList<String> listOfNames (ArrayList<String> listOfAllNames){
        for (int i = 0; i < listOfAllNames.size(); i++) {
            for (int j = i+1; j < listOfAllNames.size(); j++) {
                if(listOfAllNames.get(i).equals(listOfAllNames.get(j))){
                    listOfAllNames.remove(j);
                    j -= 1;
                }
            }
        }
        return listOfAllNames;
    }

    //Question 7
    public static String consonants (String word){
        String noVowels = "";
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
        for (int i = 0; i < word.length(); i++) {
            if (!vowels.contains(word.charAt(i))) {
                noVowels += word.charAt(i);
            }
        }
        return noVowels;
    }

    //Question 8
    public static ArrayList<String> countryList (ArrayList<String> allCountries){
        ArrayList<String> newList = new ArrayList<>();
        newList.add(allCountries.get(allCountries.size()-1));
        for (int i = 1; i < allCountries.size()-1; i++) {
            newList.add(allCountries.get(i));
        }
        newList.add(allCountries.get(0));
        return newList;
    }

}
