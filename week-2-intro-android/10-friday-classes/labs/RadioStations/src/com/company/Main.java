package com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Monday");
        myList.add("Tuesday");
        myList.add("Wednesday");
        myList.add("Thursday");
        myList.add("Friday");
        myList.add("Saturday");

        myList.add(0, "Sunday");


        PlayList myPlayList = new PlayList (myList);

        System.out.println(myList);
        System.out.println(myList.get(2));
        myPlayList.removeSong(2);
        System.out.println(myPlayList);
    }
}
