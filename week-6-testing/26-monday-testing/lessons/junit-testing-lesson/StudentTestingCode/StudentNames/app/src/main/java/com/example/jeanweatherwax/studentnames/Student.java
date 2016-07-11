package com.example.jeanweatherwax.studentnames;

/**
 * Created by jeanweatherwax on 7/5/16.
 */
public class Student {

    private static String firstName;
    private static String lastName;
    private static int numberGrade;


    public Student(String firstName, String lastName, int numberGrade) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.numberGrade = numberGrade;
    }


    public static int getNumberGrade() {
        return numberGrade;
    }

    public static void setNumberGrade(int numberGrade) {
        Student.numberGrade = numberGrade;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        Student.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        Student.lastName = lastName;
    }


    //Write a method that returns a string that is the full name
    public static String getFullName() {
        return firstName + " " + lastName;
    }

    //write a method that converts number to letter grade
    public static String getLetterGrade() {

        if(numberGrade >= 90) {
            return "A";
        } else if(numberGrade >= 80) {
            return "B";
        } else if(numberGrade >= 70) {
            return "C";
        } else if(numberGrade >=60) {
            return "D";
        } else {
            return "F";
        }

    }

}
