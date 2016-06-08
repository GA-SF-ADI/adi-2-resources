/**
 * Created by fabrizio laudati  on 6/7/16.
 */

public class Main {


    public static void main(String... args) {

        int c = maxOfTwoNumbers(10, 30);
        System.out.println("Max Value of 10 and 30 is " + c);
        int d = maxOfThreeNumbers(20, 40, 70);
        System.out.println("Max Value of 20 and 40 and 70 is  " + d);
        boolean f = isCharacterAVowel('e');
        System.out.println(" is ' e ' an avowell letter ?   " + f);
        String testString = "jag testar";
        System.out.println(testString + "...String reversed... " + reverseString(testString));

    }

    public static int maxOfTwoNumbers(int n1, int n2) {
        int max;
        if (n1 < n2)
            max = n2;
        else
            max = n1;

        return max;


    }

    public static int maxOfThreeNumbers(int n1, int n2, int n3) {
        int max;
        if (n1 < n2 && n2 > n3) {
            max = n2;
        } else if (n2 < n3 && n1 < n3) {
            max = n3;
        } else {
            max = n1;
        }

        return max;

    }


    public static boolean isCharacterAVowel(char c) {

        if (c =='a') {
            return true;

        }else if(c == 'e'){
            return true;
        }else if(c == 'i'){
            return true;
        }else if (c == 'o'){
            return true;
        }else if (c =='u'){
            return true;
        }else{
            return false;
        }


    }

    public static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }




}