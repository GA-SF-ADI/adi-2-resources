package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here


        Employee[] employees = new Employee[3];
        employees[0] = new Secretary();
        employees[1] = new Biologist();
        employees[2] = new Teacher();

        for (int i = 0; i < employees.length; i++) {
            employees[i].sickDays();
            System.out.println("");
            employees[i].primaryResponsibility();
            System.out.println("");
            employees[i].getPaid(8);
            System.out.println("");
            employees[i].directDepositCheck(200);
            System.out.println("");
            employees[i].secondaryResponsibility();

        }

    }
}
