/**
 * Created by patrickcummins on 6/8/16.
 */
import java.util.Scanner;
public class Main {

    public static void main (String[]args){


    }
    public static boolean isEven(int i){
        if (i%2 == 0){
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean sameSpelling(String stringOne, String stringTwo){
        stringOne = stringOne.toLowerCase();
        stringTwo = stringTwo.toLowerCase();
        if(stringOne.equals(stringTwo)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void printWordToW(String word){
        for (int i = 0; i < word.length()-1; i++) {
            if (word.charAt(i) != 'w'){
                System.out.println(word.charAt(i));
            }
            else{
                break;
            }

        }
    }
    public static double returnRandom(){
        double numb = Math.random();
        if (numb>50){
            return numb;
        }
        else{
            return -1;
        }

    }
    public static String nextDay(int month, int day, int year){
        if (month ==12 && day ==31){
            return "Day: 1 Month: 1 Year: " +year+1;
        }
        else if(day ==31 && (month == 3 || month == 5 || month == 7 || month == 8 || month == 10) ){
            return "Day: 1 Month: " + month+1 + " Year: " +year;
        } else if(day ==30 && (month == 4 || month == 6 || month == 9 || month == 11) ){
            return "Day: 1 Month: " + month+1 + " Year: " +year;
        }
        else if(day==28 && month==2){
            return "Day: 1 Month: " + month+1 + " Year: " +year;
        }
        else{
            return "Day: "+ day+1 +" Month: " + month + " Year: " +year;
        }
    }
    public static String everyOtherLetter(String word){
        String newWord = "";
        for (int i = 0; i < word.length()-1 ; i+=2) {
            newWord = newWord + word.charAt(i);

        }
        return newWord;
    }
    public static void allLesserNumbers(int i){
        int counter = 1;
        if(i>5){
            while(counter <= i){
                if(i!=4){
                    System.out.println(i);
                }
            }

        }
    }
    public static int sameNumbers(int int1, int int2){
        if (int1 == int2){
            return (int1+2) + (int2+2);
        }
        else{
            return (int1+1) + (int2+1);
        }
    }
    public static void countryDomain() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter Country Domain:");
        String domain = reader.nextLine();
        domain = domain.toLowerCase();
        switch(domain){
            case "us":
                System.out.println("United States");
                break;
            case "de":
                System.out.printf("Germany");
                break;
            case "hu":
                System.out.printf("Hungary");
                break;
            default:
                System.out.println("Unknown");
        }
    }
    public static void isVowel(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter Letter:");
        String letter = reader.nextLine();
        letter=letter.toLowerCase();
        if(letter.equals('a') || letter.equals('e') || letter.equals('i') || letter.equals('o') || letter.equals('u')){
            System.out.printf("This is a vowel");
        } else{
            System.out.println("This is a consonant");
        }


    }
}
