package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.HashMap;

/**
 * Created by audreyeso on 6/13/16.
 */
public class HashMapsPractice {

    public static void main(String[] args) {

        /*

        HashMap<String,Student> studentMap = new HashMap<String,Student>();

        studentMap.put("195abc",adamStudent);
        studentMap.put("542ijk",bradStudent);

        Student retrievedStudent1 = studentMap.get("195abc"); //adamStudent
        Student retrievedStudent2 = studentMap.get("111"); //null

        studentMap.remove("542ijk");
        */

        //Create an array of ints containing the values: 1,2,3,4


        Integer myInts [] = {1, 2, 3, 4};

        //Create a LinkedList of Strings with the values: "One","Two","Three","Four"

        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("One");
        linkedList.add("Two");
        linkedList.add("Three");
        linkedList.add("Four");

        //Create a HashMap with the keys {"One","Two","Three","Four"}
        // taken from the list, and the
        // Integer values 1,2,3,4 taken from the array.

HashMap<String,Integer> myHashMap = new HashMap <String, Integer>();

        myHashMap.put(linkedList.get(0),myInts[0]);
        myHashMap.put(linkedList.get(1), myInts [1]);
        myHashMap.put(linkedList.get(2), myInts [2]);
        myHashMap.put(linkedList.get(3), myInts [3]);

        System.out.println(myHashMap);

        Integer mySecondInts [] = {34, 21, 90, 100};

        LinkedList<String> mySecondLinkedList = new LinkedList<String>();

        mySecondLinkedList.add("Thirty-four");
        mySecondLinkedList.add("Twenty-one");
        mySecondLinkedList.add("Ninety");
        mySecondLinkedList.add("One hundred");

        HashMap<String,Integer> mySecondHashMap = new HashMap<String, Integer>();

        mySecondHashMap.put(mySecondLinkedList.get(0), mySecondInts[0]);
        mySecondHashMap.put(mySecondLinkedList.get(1), mySecondInts[1]);
        mySecondHashMap.put(mySecondLinkedList.get(2), mySecondInts[2]);
        mySecondHashMap.put(mySecondLinkedList.get(3), mySecondInts[3]);

        //for(int x = 0; x <= mySecondLinkedList; x++) {

           // System.out.print(x);

       // }

        System.out.println(mySecondHashMap);

    }
}
