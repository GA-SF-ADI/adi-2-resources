package com.company;

import java.text.NumberFormat;

/**
 * Created by sterlinggerritz on 6/20/16.
 */


    public abstract class Employee {

        private double hourlyWage;
        protected double hoursWorked;

        public Employee(double hourlyWage) {
            this.hourlyWage = hourlyWage;
        }

        public abstract void primaryResponsibility();
        public abstract void secondaryResponsibility();


        public void getPaid() {

            double pay = this.hoursWorked * this.hourlyWage;
            directDepositCheck(pay);
        }

        private void directDepositCheck(double amount) {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String moneyString = formatter.format(amount);
            System.out.println(String.format("Deposited %s", moneyString));
        }
    }

