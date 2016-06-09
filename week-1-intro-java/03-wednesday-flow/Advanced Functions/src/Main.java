/**
 * Created by Fabrizio Laudati on 6/8/16.
 */
import java.util.Random;
import java.util.Scanner;


public class Main {


    public static void main(String... args) {
        System.out.println("is this number 11 a even numbber....   " + evenNumber(11));
        System.out.println("Is yelena and fabrizio the same word......" + compareWords("fabrizio", "yelena"));
        //stopprintingWords("kiwi");
        System.out.println(changedate(15, 8, 1960));
        System.out.println(ometewords("fabrizio"));
        printAllNumbersExcept4(10);
        System.out.println("test " + printnumbers(12, 15));
        countryDomain();
        isVowel();


    }

    public static boolean evenNumber(int number) {
        if ( number % 2 == 0 ) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean compareWords(String word1, String word2) {

        if ( word1.equals(word2) ) {
            return true;
        } else {
            return false;
        }


    }

    public static void stopprintingWords(String initial) {
        initial = "fabriwzio";
        for (int i = 0; i < initial.length(); i++) {
            if ( initial.charAt(i) == 'w' ) {
                break;
            } else {

                // just print the character at position i
                System.out.println(initial.charAt(i));
            }
        }

    }

    public static int generateRandomNumber() {

        Random r = new Random();
        int num = r.nextInt();
        System.out.println(num);
        if ( num > 50 ) {
            return num;
        } else {
            return -1;
        }
    }


    public static String changedate(int day, int month, int year) {

        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;
        if ( day == 31 ) {
            if ( month == 12 ) {
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

    public static String ometewords(String initial) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < initial.length(); i++) {
            if ( i % 2 == 0 ) {
                builder.append(initial.charAt(i));
            }
        }
        return builder.toString();


    }


    public static void printAllNumbersExcept4(int number) {

        int correntNumber = 1;
        while (correntNumber <= number) {
            if ( correntNumber != 4 ) {
                System.out.println(correntNumber);
            }
            correntNumber++;
        }
    }

    public static int printnumbers(int n1, int n2) {
        if ( n1 != n2 ) {
            if ( n1 < 10 ) {
                n1++;
            } else if ( n2 < 10 ) {
                n2++;
            } else {
                n1 = n1 + 2; // 14
                n2 = n2 + 2; // 17

            }
            return n1 + n2; // 14 + 17 = 31
        } else {
            return -1;
        }

    }

    private static void countryDomain() {

        System.out.println("Please enter a Country Domain :....");
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


