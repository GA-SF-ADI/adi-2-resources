package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(evenOdd(5));
        System.out.println(wordCompare("cool", "cool"));
        System.out.println(randomNumber());
        System.out.println(nextDate(31, 12, 1988));
        twoNumbers(2, 2);
        countryDomain("hu");
        vowelCon('x');
        exceptFour(5);
    }

    //1
    public static boolean evenOdd(int int1){
        if (int1%2==0){
            return true;
        }else {
            return false;
        }
    }
    //2
    public static boolean wordCompare(String word1, String word2){
        if (word1.equals(word2)){
            return true;
        }else {
            return false;
        }
    }
    //3
    public static void stopW(String word3){
        for (int i = 0; i < word3.length() ; i++) {
            char c = word3.charAt(i);
            if (c!='w'){
                System.out.println(c);
            }

        }
    }
    //4  //multiply double by 1000, then convert to int
    public static int randomNumber(){
        double randRange = Math.random()*100;
        int randNum = (int)randRange;
        if (randNum>50){
            return randNum;
        }else{
            return -1;
        }
    }
    //5
    public static String nextDate(int day, int month, int year){
        int nextDay = day;
        int nextMonth = month;
        int nextYear = year;

        if (month==12){
            if (day==31){
                nextMonth=1;
                nextDay=1;
                nextYear=year+1;
            }
        }else {
            nextDay=day +1;
        }
        return String.format("day:" + nextDay, "month:" + nextMonth, "year:" + nextYear);

    }

    //6 no idea how to do this one
    public static void everyOther(String word){

    }


    //7
    public static void exceptFour(int user){
        int newNum=1;
        while(newNum<=user){
            if(user!=4){
                System.out.println(newNum);
            }
            newNum++;
        }

    }


    //8
    public static int twoNumbers(int num1, int num2){

        if(num1==num2){
            num1=num1+2;
            num2=num2+2;
        }else if(num1!=num2){
            num1++;
            num2++;
        }return num1 + num2;


    }
    //9
    public static void countryDomain(String country){
        switch(country){
            case "us":
                System.out.println("United States");
                break;
            case "US":
                System.out.println("United States");
                break;
            case "de":
                System.out.println("Germany");
                break;
            case "DE":
                System.out.println("Germany");
                break;
            case "hu":
                System.out.println("Hungary");
                break;
            case "HU":
                System.out.println("Hungary");
                break;
        }

    }
    //10
    public static void vowelCon(char user){
        if(user=='a'||user=='e'||user=='i'||user=='o'||user=='u'){
            System.out.println("Letter is a vowel");
        }else{
            System.out.println("Letter is a consonant");
        }



    }

}





