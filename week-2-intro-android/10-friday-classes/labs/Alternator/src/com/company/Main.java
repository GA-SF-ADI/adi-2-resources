package com.company;

public class Main {

    /*
     * Tests the Alternator methods
     */

        public static void main(String[] args) {

            Alternator alt3 = new Alternator(3, 6);

            System.out.println(alt3.alternate()); // prints 3

            System.out.println(alt3.alternate()); // prints 6
            // Note that this method both changes the state and return the state!

            System.out.println(alt3.alternate()); // prints 3

            System.out.println(alt3.alternate()); // prints 6

            Alternator alt5 = new Alternator(5, 10);

            System.out.println(alt5.alternate()); // prints 5

            System.out.println(alt5.alternate()); // prints 10

            System.out.println(alt5.alternate()); // prints 5

            System.out.println(alt3.alternate()); // prints 3

            System.out.println(alt5.alternate()); // prints 10
            // Note that the two objects work independently

        }

    }


