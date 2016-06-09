
package com.company;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        maxoftwonumbers();
        maxofthree();
        ischaractervowel();
        reversestring();



    }

    public static void maxoftwonumbers() {

        int x = 1;
        int y = 2;

        if (x > y) {
            System.out.println(x);
        }
        if (y > x) {
            System.out.println(y);
        }

    }

    public static void maxofthree() {
        int a = 1;
        int b = 2;
        int c = 3;

        if (a > b && a > c) {
            System.out.println(a);

        }

        if (b > a && b > c) {
            System.out.println(c);

        }
        if (c > a && c > b) {
            System.out.println(c);
        }
    }

    public static void ischaractervowel() {
        String letter = "a";
        if (letter.equals("a") || letter.equals("e") || letter.equals("i") || letter.equals("O") || letter.equals("u")) {
            System.out.println("you have entered a vowel!");
        } else {
            System.out.println("you did not enter a vowel");

        }
    }



//    public static boolean isCharacterAVowel(char c){
//        boolean test = (c=='a'|| c=='e' || c=='o' || c=='i' || c=='u');
//        return test;
//    }
//

   //  if("aeiou".indexof(c)!=-1);



    public static void reversestring() {
        String sourceString = "asdf";
        int i, len = sourceString.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--) {
            dest.append(sourceString.charAt(i));
        }
        System.out.println(dest.toString());
    }

    int age =12;
    String allowed = (age>18) ? "yes" : "no";

}


