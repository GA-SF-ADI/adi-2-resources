/**
 * Created by nolbertoarroyo on 6/7/16.
 */
public class FunctionsLab {

    public static void main(String[] Args) {
        System.out.println(maxOfTwoNumbers(5, 4));
        System.out.println(maxOfThreeNumbers(4, 5, 3));
        System.out.println(isCharacterAVowel('a'));

        System.out.println(reverseString("android"));

    }


    //maxOfTwoNumbers method, it is comparing two numbers and giving out the max of the two

    public static int maxOfTwoNumbers(int num1, int num2) {
        int maxNumber = 0;
        if (num1 > num2) {
            maxNumber = num1;
        } else if (num2 > num1) {
            maxNumber = num2;

        } else {
            System.out.println("they are even");

        }
        return maxNumber;

    }

    //maxOfThreeNumbers,

    public static int maxOfThreeNumbers(int num1, int num2, int num3) {
        if (num1 > num2 && num1 > num3) {
            return num1;
        } else if (num2 > num1 && num2 > num3) {
            return num2;
        } else {
            return num3;
        }
    }

    //isCharacterAVowel method checking for vowels
    /* method two, this statement returns a true or false w/o having to add if/ else statements

    public static boolean isCharacterAVowel( char c){
        return c =='a' || c == 'e' || c =='i' || c == 'o' || c == 'u';

    }
*/
    public static boolean isCharacterAVowel(char ch) {


        if (ch == 'a') {
            return true;

        } else if (ch == 'e') {
            return true;
        } else if (ch == 'i') {
            return true;
        } else if (ch == 'o') {
            return true;
        } else if (ch == 'u') {
            return true;
        } else {
            return false;
        }
    }

        // using [] or ... allows you to input unlimited amount of arguments, you can use a method length to get the amount of args

        public static int argumentNumber(String[] args){
        return args.length;

    }




    // reverse a string using StringBuffer

    public static String reverseString(String v) {

        v = new StringBuffer(v).reverse().toString();
        return v;


    }


}


















