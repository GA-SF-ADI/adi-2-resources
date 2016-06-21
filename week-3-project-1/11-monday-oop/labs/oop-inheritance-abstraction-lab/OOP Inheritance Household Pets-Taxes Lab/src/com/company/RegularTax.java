package com.company;

/**
 * Created by LangstonSmith on 6/20/16.
 */
public class RegularTax {

    protected double taxPercentage;
    protected double postTaxIncome;
    protected double grossReceivedMonthlyIncome;

    public RegularTax(double taxPercentage, double grossReceivedMonthlyIncome) {
        this.taxPercentage = taxPercentage;
        this.grossReceivedMonthlyIncome = grossReceivedMonthlyIncome;
    }

    public double getGrossReceivedMonthlyIncome() {
        return grossReceivedMonthlyIncome;
    }

    public void setGrossReceivedMonthlyIncome(double grossReceivedMonthlyIncome) {
        this.grossReceivedMonthlyIncome = grossReceivedMonthlyIncome;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    protected String payTax() {

        postTaxIncome = (grossReceivedMonthlyIncome * (1 - taxPercentage));

        return String.valueOf(postTaxIncome);


    }

}
