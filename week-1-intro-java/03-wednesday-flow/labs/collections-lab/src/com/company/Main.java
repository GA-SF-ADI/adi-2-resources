package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        palindrome("Dadss");

        int[] a={1,2,43,65,0,100};
        System.out.println("Max is: "+maxNo(a));

        int days=noOfDaysInTheMonth("January");

        int[] numAddSub={2,2,2,10,30};
        int result =addSub(numAddSub);
        System.out.println("The result of numAddSub function is: "+result);

        omitChars();

        omitVowels("heyyyyhiii");

        String[] cList={"US","India","UK","France","China"};
        swapCountry(cList);

        ArrayList<String> names =new ArrayList<>();
        names.add("neha");
        names.add("hello");
        names.add("hello");
        uniqueList(names);
    }

//Function 1:

    public static void palindrome(String originalStr){
        String lowCaseOriginalStr=originalStr.toLowerCase();
        String reversedStr=reverseString(lowCaseOriginalStr);
        if(reversedStr.equals(lowCaseOriginalStr)){
            System.out.println("The string "+originalStr+" is a palindrome");
        }
        else{
            System.out.println("The string "+originalStr+" is not a palindrome");
        }
    }

    public static String reverseString(String input){
        String temp="";
        for (int i=input.length()-1;i>=0;i--){
            temp=temp+input.charAt(i);
        }
        return temp;
    }

    //Function 2:  (Incomplete......)

    public static void omitChars(){
        ArrayList<Character> list= new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');

        int i=0;
        while (i%2==0 && i<list.size()){
            list.remove(i);

            i++;
        }
//        System.out.println(list);
//        String str=list.toString();
        System.out.println(list);

    }

//    public static void omitChars(){
//        char[] list={'a','b','c','d'};
//        int i=0;
//        while (i%2==0 && i<list.length){
//            list[i]=list[i+1];
//            i++;
//        }
//        for(int j=0;j<list.length;j++){
//            System.out.println(list[j]);
//        }
////        System.out.println("The new list is: "+list);
////        for(int i=0;i<list.length;i++){
////        }
//    }

    //Function 3:

    public static int maxNo(int[] a){
        int max=a[0];
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
        }
        return max;
    }

    //Function 4:

    public static int noOfDaysInTheMonth(String month){

            switch(month){
                case "January":System.out.println("31 days");
                    return 31;
//                    break;
                case "March":System.out.println("31 days");
                    return 31;
//                    break;
                case "May":System.out.println("31 days");
                    return 31;
//                    break;
                case "July":System.out.println("31 days");
                    return 31;
//                    break;
                case "August":System.out.println("31 days");
                    return 31;
//                    break;
                case "October":System.out.println("31 days");
                    return 31;
//                    break;
                case "December": System.out.println("31 days");
                    return 31;
//                    break;
                case "February":System.out.println("28 days");
                    return 28;
//                    break;
                case "April":System.out.println("30 days");
                    return 30;
//                    break;
                case "June":System.out.println("30 days");
                    return 30;
//                    break;
                case "September":System.out.println("30 days");
                    return 30;
//                    break;
                case "November":System.out.println("30 days");
                    return 30;
//                    break;
                default:
                    System.out.println("Not a valid month");
                    return 0;
//                    break;
            }
    }

    //Function 5:

    public static int addSub(int[] num){
        int newSum=0;
        for(int i=0;i<num.length;i++){
            if(num[i]>1 && num[i]<20){
                newSum=newSum+num[i];
            }
            if (num[i]>20){
                newSum=newSum-3;
            }
        }
        return newSum;
    }

    //funtion 6:   (Incomplete......)

    public static void uniqueList(ArrayList<String> names) {

        String first ="";
        ArrayList<String> newSt = new ArrayList<>();
        for (int j = 0; j < names.size(); j++) {

            for (int i = 1; i < names.size(); i++) {
//            String first=names.get(i);
                first = names.get(j);
                if (first.equals(names.get(i))) {
                    names.remove(i);
                }
            }
        }
            System.out.println("Unique list is:");
            for (int i = 0; i <names.size(); i++) {
                System.out.println(names.get(i));
            }
    }

    //function 7:

    public static void omitVowels(String s) {
        if (s.length() == 0) {
            System.out.println("String empty!");
        } else {
            String newS = s.replaceAll("[aAeEiIoOuU]", "");
            System.out.println(newS);
        }
    }

    //function 8:

    public static void swapCountry(String[] cList){
        String temp1="";
        String temp2="";
        temp1=cList[0];
        temp2=cList[cList.length-1];

        //swapping
        cList[0]=temp2;
        cList[cList.length-1]=temp1;

        //printing
        System.out.println("The swapped list is:");
        for(int i=0;i<cList.length;i++){
            System.out.println(cList[i]);
        }
    }
}





