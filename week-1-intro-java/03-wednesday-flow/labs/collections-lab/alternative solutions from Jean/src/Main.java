import java.util.*;

/**
 * Created by jeanweatherwax on 5/27/16.
 */
public class Main {

    public static void main(String args[]) {

        System.out.println(isPalindrome1("kayak"));
        System.out.println(isPalindrome1("bear"));
        System.out.println(isPalindrome2("kayak"));
        System.out.println(isPalindrome2("bear"));

        System.out.println(everyOtherChar());

        int[] numbers = {1, 2, 5, 1, 19, 33, 12};
        System.out.println(maxArray(numbers));

        System.out.println(numDaysInMonth(12));
        System.out.println(numDaysInMonth(90));
        System.out.println(numDaysInMonth(2));

        System.out.println(sumOperations(numbers));

        ArrayList<String> names = new ArrayList<>(Arrays.asList("Timmy", "Bobby", "Jo", "Timmy", "Ann"));
        System.out.println(uniqueNames(names));

        System.out.println(consonantsOnly("AhoyCaptain"));

        System.out.println(middleLinkedList(5));
        System.out.println(middleLinkedList(8));
        System.out.println(middleLinkedList(0));

        ArrayList<String> countries = new ArrayList<>(Arrays.asList("China", "Japan", "USA", "Canada", "Brazil", "France", "Chile"));
        System.out.println(modifiedCountriesList(countries));

        namesAndAges();

    }

    public static boolean isPalindrome1(String input) {

        String reverse = new StringBuffer(input).reverse().toString(); //get reverse of string

        if(reverse.equals(input)) { //is a palindrome
            return true;
        } else { //is not a palindrome
            return false;
        }

    }

    public static boolean isPalindrome2(String input) { //second way to check for palindrome - yay

        int start = 0;
        int end = input.length() - 1;
        int half = end/2;

        for(int i = 0; i < half; i++, start++, end--) { //iterate from start and end of string
            if(input.charAt(start) != input.charAt(end)) //we have found a condition that makes it not a palindrome
                return false;
        }

        return true;

    }

    public static String everyOtherChar() {

        String string = "abcd";

        StringBuilder answer = new StringBuilder();

        for(int i=0; i < string.length(); i++) {
            if(i%2 != 0) { //check if it's an odd index
                answer.append(string.charAt(i));
            }
        }

        return answer.toString();
    }

    public static int maxArray(int[] input) {

        int maximum = input[0]; //initialize array

        for (int i = 1; i < input.length; i++) { //loop replaces max value if next value is greater
            if (input[i] > maximum) {
                maximum = input[i];
            }
        }

        return maximum;
    }

    public static int numDaysInMonth(int month) { //I used number for months. You could also use string input of month name.

        if(month > 12) {
            return 0; //invalid input!
        } else if(month == 2) { //february
            return 28;
        } else if(month == 9 || month == 4 || month == 6 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public static int sumOperations(int[] input) {

        int sum = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] != 1) { //if value is not 1
                if(input[i] > 20) { //if value is great than 20 subtract 3
                    sum += (input[i] - 3);
                } else { //value not greater than 20
                    sum += input[i];
                }
            }
        }
        return  sum;
    }

    public static ArrayList<String> uniqueNames(ArrayList<String> names) {

        ArrayList<String> uniqueNames = new ArrayList<String>();

        int size = names.size();
        for(int i = 0; i < size; i++) {
            if(!uniqueNames.contains(names.get(i))) {
                uniqueNames.add(names.get(i));
            }
        }
        return uniqueNames;
    }

    public static String consonantsOnly(String input) {

        if(input == null || input.isEmpty()) { //base cases
            return null;
        }

        StringBuilder consonantsOnly = new StringBuilder();

        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U')); //omitting y for now...

        for(int i = 0; i < input.length(); i ++) {
            if(!vowels.contains(input.charAt(i))) { //is consonant, not in vowels arraylist
                consonantsOnly.append(input.charAt(i));
            }
        }
        return consonantsOnly.toString();

    }

    public static int middleLinkedList(int input) {

        if(input == 0) { //base case
            return 0;
        }


        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i < input; i++) {
            list.add(i);
        }

        if(input % 2 == 0) { //even number
            return -1;
        } else {
            return list.get(input/2 - 1);
        }
    }

    public static void namesAndAges() {
        HashMap<String, Integer> namesAndAges = new HashMap<>();
        namesAndAges.put("Billy", 4);
        namesAndAges.put("Tommy", 19);
        namesAndAges.put("Shelly", 48);
        namesAndAges.put("Kirsten", 33);
        namesAndAges.put("Uncle Bo", 80);

        System.out.println("Enter a family member's name to see their age.");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        if(!namesAndAges.containsKey(input)) {
            System.out.println("Such family member does not exist!");
        } else {
            System.out.println("Age of " + input + " is : " + namesAndAges.get(input).toString());
        }
    }

    public static ArrayList<String> modifiedCountriesList(ArrayList<String> countries) {

        int size = countries.size();

        if(countries.isEmpty()) { //base case
            return null;
        }

        Collections.swap(countries, 0, (size-1));

        return countries;

    }

}
