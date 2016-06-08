package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        boolean even = oddEven(2);

        wordComparator("Hellddo", "hello");

        printLetters("Heqwlooewlo");

        isGreaterThan50();

        date(20,02,1992);

        newWord("hi");


    }

    public static boolean oddEven(int num) {
        System.out.println("Function 1:");
        if (num % 2 == 0) {
            System.out.println("The number " + num + " is even");
            return true;
        } else {
            System.out.println("The number " + num + " is odd");
            return false;
        }
    }

    public static boolean wordComparator(String w1, String w2) {
        System.out.println("Function 2:");
        String temp1 = w1.toLowerCase();
        String temp2 = w2.toLowerCase();
        if (temp1.equals(temp2)) {
            System.out.println("The spelling of the words " + w1 + " and " + w2 + " is equal");
            return true;
        } else {
            System.out.println("The spelling of the words " + w1 + " and " + w2 + " is not equal");
            return false;
        }
    }

    public static void printLetters(String w1) {
        System.out.println("Function 3:");
        int i = 0;
        while (w1.charAt(i) != 'w' && i < w1.length()) {
            System.out.println(w1.charAt(i));
            i++;
        }
    }

    public static void isGreaterThan50(){
        System.out.println("Function 4:");
        double num= Math.random();
        System.out.println("The random number generated is "+num);
        if(num > 50){
            System.out.println("The number generated is "+num);
        }
        else {
            System.out.println("So the number is less than 50. So returning: -1\n");
        }
    }

    public static void date(int day, int month, int year){
        System.out.println("Function 5:");
        int today_date=day+1;
//        int today_date=day++;

        System.out.println("day: "+today_date+" month: "+month+" year: "+year);
    }

    public static void newWord(String w1){
        System.out.println("Function 6:");
        String repl = w1.replaceAll("hi","hello");

        System.out.println(repl);

    }

    public static void number_printing(int num){
        if(num <=5){
            System.out.println("Need a number greater than 5");
        }
        else {
            int no=1;
            while (num )
        }
    }









}



