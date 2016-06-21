package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Employee[] eeList = new Employee[3];
        eeList[0] = new Doctor();
        eeList[1] = new Lawyer();
        eeList[2] = new Teacher();

        for (int i = 0; i < eeList.length; i++) {
            eeList[i].primaryResponsibility();
            eeList[i].secondaryResponsibility();
            eeList[i].setHoursWorked(Math.random()*80);
            eeList[i].getPaid();
        }

        Teacher teacher = (Teacher) eeList[2];
        teacher.thirdResponsibility();

    }
}
