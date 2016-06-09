/**
 * Created by Fabrizio Laudati on 6/8/16.
 */


import java.util.ArrayList;

public class Main {



        public static void main(String...args){

                System.out.println(" palindrome dad is ......" + palindrome_1("dad"));
                System.out.println(" every other element in the list a,b,c,d....." + otherElements( ));

                int [ ] monthsArray = {1,5,6,8};
                System.out.println(" maxvalue of 1,5,6,8 ..." + maxValue(monthsArray));

                System.out.println(" the month of December as ....    " + daysInMonth("December")+ "    Days");

                int [ ] numbersArray = {1,20,15,30};
                System.out.println(" sums of integers  ..." + mat(numbersArray));


                ArrayList<String> List = new ArrayList<String>();


                List.add("Fabrizio");
                List.add("Yelena");
                List.add("Matteo");
                List.add("Gia");
                List.add("Gia");

                System.out.println("Names  " + List);

                System.out.println("list without duplicates: " + duplicates(List));



                ArrayList<String> Countris = new ArrayList <String>();

                Countris.add("Italy");
                Countris.add("France");
                Countris.add("Germani");
                Countris.add("Russia");

                System.out.println("Names  " + Countris);

                Countris.remove("Italy");
                Countris.remove("France");
                Countris.remove("Germani");
                Countris.remove("Russia");
                Countris.remove("Italy");
                Countris.add("France");
                Countris.add("Germani");
                Countris.add("Russia");
                Countris.add("Italy");
                System.out.println("Names  " + Countris);  //I did know this one//


        }


        public static boolean palindrome_1(String input){

                String reverse = new StringBuffer(input).reverse().toString();

                if(reverse.equals(input)) {
                        return true;
                } else {
                        return false;
                }

        }


        public static  String otherElements( ){

                String allOderElemnt = new String( );

                ArrayList<Character> characterList = new ArrayList<>();

                characterList.add('a');
                characterList.add('b');
                characterList.add('c');
                characterList.add('d');
                characterList.add('e');

                for (int i = 1; i <characterList.size(); i+=2){

                        allOderElemnt = allOderElemnt + characterList.get(i);

                }
                return allOderElemnt;




        }

        public static int maxValue(int [ ] incomingArray){


                int maxValue = incomingArray[0];

                for (int currentValue : incomingArray){

                        if (currentValue > maxValue) {
                                maxValue = currentValue;
                        }

                }
                 return maxValue;


        }

        public static int daysInMonth(String month ){


                int daysInMonth;

                switch (month){
                        case "January":
                                daysInMonth=31;
                                break;
                        case "February":
                                daysInMonth=28;
                                break;
                        case "March":
                                daysInMonth=31;
                                break;
                        case "April":
                                daysInMonth=30;
                                break;
                        case "May":
                                daysInMonth=31;
                                break;
                        case "June":
                                daysInMonth=30;
                                break;
                        case "July":
                                daysInMonth=31;
                                break;
                        case "August":
                                daysInMonth=31;
                                break;
                        case "September":
                                daysInMonth=30;
                                break;
                        case "October":
                                daysInMonth=31;
                                break;
                        case "November":
                                daysInMonth=30;
                                break;
                        case "December":
                                daysInMonth=31;
                                break;
                        default:
                                daysInMonth=0;
                                break;


                }


                 return daysInMonth;


        }

                public static int mat(int [ ] incomingArray){


                        int returnSum = 0;

                        for( int currenValue : incomingArray){

                                if ( currenValue>20){
                                    returnSum = returnSum -3;
                                }else if (currenValue > 1){
                                        returnSum = returnSum +1;
                                }

                        }
                           return returnSum;

                }

                public static ArrayList<String> duplicates(ArrayList<String> array){
                        ArrayList<String> noDuplicates = new ArrayList<>();
                        for (String nameToCheck : array){
                                if (!noDuplicates.contains(nameToCheck)){
                                        noDuplicates.add(nameToCheck);
                                }
                        }
                return noDuplicates;

                }




}
