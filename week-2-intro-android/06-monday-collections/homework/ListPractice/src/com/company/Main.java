package com.company;
import java.util.ArrayList;
import java.util.LinkedList;

/*The students must create a LinkedList
containing ints 1-10. Afterwards, they must test to see if the values 5-15 exist in the list,
and remove the elements that exist (so remove 5-10.)
Finally, print the size of the list.
Starter code is provided in ListTest.java
 */

public class Main {

   // public static void removeAndPrint (LinkedList <Integer> testList) {


    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(10);

        System.out.println(linkedList);


        for(int i=5;i<=15;i++){
            Integer myInt = new Integer(i);

            if (linkedList.contains(myInt)){
                System.out.println("removing" + myInt);
                linkedList.remove();

            }

        }

        System.out.println(linkedList);
    }
}
