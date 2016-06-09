package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> labArray = new ArrayList<>();
        int[] anArray;
        anArray = new int[3];{
        }
        System.out.println(anArray.length);

        pigLatin("lion");
        arrayTwo();

    }

    public static void arrayTwo() {
        ArrayList<String> wildlifeNYC = new ArrayList<>();
        wildlifeNYC.add("lion");
        wildlifeNYC.add("tiger");
        wildlifeNYC.add("cheetah");
        printAnimals(wildlifeNYC);
    }

    public static void printAnimals(ArrayList<String> arrayTwo) {
        for (int i = 0; i < arrayTwo.size(); i++) {
            System.out.println("Today, I spotted a " + arrayTwo.get(i) + " in the concrete jungle!");

        }
    }

    public static int sum(int[] arrayThree){
        if (arrayThree.length == 0){
            return 0;
        }
        else if (arrayThree.length == 1){
            return arrayThree[0];
        }
        else{
            return arrayThree[0] + arrayThree[1];
        }
    }

    public static void pigLatin(String word){
        String latin = "";
        if (word.charAt(0) == 'a'){
            System.out.println(word + "way");
        }
        else{
            for (int i = 1; i < word.length(); i++){
                latin = latin + word.charAt(i);
            }
            System.out.println(latin + word.charAt(0) + "ay");
        }
    }
}
