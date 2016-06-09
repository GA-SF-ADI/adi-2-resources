package com.company;

public class Main {

    public static void main(String[] args) {
	//calling methods
        //print false
        System.out.println(isEven(101)+"");
        //print true
        System.out.println(isEven(10004)+"");
        //print true

        System.out.println(sameWord("pineapple", "pineapple"));
        //print false
        System.out.println(sameWord("pineapple", "watermelon"));

        beforeW("lakswlkj");

        System.out.println(randomNum()+"");

        System.out.println(tomorrow(29, 2, 2016));
        System.out.println(tomorrow(20, 6, 1986));
        System.out.println(tomorrow(31, 12, 2007));

        System.out.println(everyOtherLetter("pineapples"));

        //print 13
        System.out.println(conditionalSum(4, 7));
        //print 36
        System.out.println(conditionalSum(16, 16));

        System.out.println(country("de"));
        System.out.println(country("US"));
        System.out.println(country("CA"));

        System.out.println(vowelOrConsonant('e'));
        System.out.println(vowelOrConsonant('g'));
    }

    //Question 1
    public static boolean isEven(int i){
        if(i%2 ==0){
            return true;
        } else return false;
    }

    //Question 2
    public static boolean sameWord(String word1, String word2){
        if(word1.equals(word2)){
            return true;
        } else return false;
    }

    //Question 3
    public static void beforeW(String s){
        if(!s.contains("w")){
            System.out.println("Does not contain w");
        } else {
            int position = s.indexOf("w");
            for (int i = 0; i < position; i++) {
                System.out.println(s.charAt(i));
            }
        }
    }

    //Question 4
    public static double randomNum(){
        //Assuming random number between 1 to 100
        double i = Math.random()*100;
        if(i>50){
            return i;
        } else {
            return -1;
        }
    }

    public static String tomorrow(int day, int month, int year){
        String nextDay = "";

        boolean monthWith30days = false;
        if (month == 4 || month == 6 || month == 9 || month == 11){
            monthWith30days = true;
        }

        boolean isFeb = false;
        if (month == 2){
            isFeb = true;
        }

        if (month == 12 && day == 31){
            year++;
            nextDay = "day:" + 1 + " month:" + 1 + " year:" + year;
            return nextDay;
        } else if(day == 31){
            month++;
            nextDay = "day:" + 1 + " month:" + month + " year:" + year;
            return nextDay;
        } else if(monthWith30days && day == 30){
            month++;
            nextDay = "day:" + 1 + " month:" + month + " year:" + year;
            return nextDay;
        } else if(isFeb && day >= 28){
            month++;
            nextDay = "day:" + 1 + " month:" + month + " year:" + year;
            return nextDay;
        } else {
            day++;
            nextDay = "day:" + day + " month:" + month + " year:" + year;
            return nextDay;
        }
    }

    //Question 7
    public static String everyOtherLetter(String word){
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            if(i%2==0){
                newWord += word.charAt(i);
            }
        }
        return newWord;
    }

    //Question 8
    public static int conditionalSum (int num1, int num2){
        if (num1 == num2){
            return num1 + num2 +4;
        } else return num1 + num2 + 2;
    }

    //Question 9
    public static String country (String countryShort){
        String returnCountry = "";
        switch(countryShort){
            case "us":
                returnCountry = "United States";
                break;
            case "US":
                returnCountry = "United States";
                break;
            case "de":
                returnCountry = "Germany";
                break;
            case "DE":
                returnCountry = "Germany";
                break;
            case "hu":
                returnCountry = "Hungary";
                break;
            case "HU":
                returnCountry = "Hungary";
                break;
            default:
                returnCountry = "Unknown";
        }
        return returnCountry;
    }

    //Question 10
    public static String vowelOrConsonant (char letter){
        if (letter == 'a' || letter == 'e'|| letter == 'i' || letter == 'o' || letter == 'u'){
            return "Vowel";
        } else return "Consonant";
    }
}
