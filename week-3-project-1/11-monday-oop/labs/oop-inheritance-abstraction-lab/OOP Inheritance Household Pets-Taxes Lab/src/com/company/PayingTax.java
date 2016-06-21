package com.company;

/**
 * Created by LangstonSmith on 6/20/16.
 */

public class PayingTax extends RegularTax {


    public PayingTax(double taxPercentage, double grossReceivedMonthlyIncome) {
        super(taxPercentage, grossReceivedMonthlyIncome);
    }

    @Override
    public String payTax() {
        setTaxPercentage(.2);
        int random;
        random = (int) (Math.random() * 2000 + 1);
        setGrossReceivedMonthlyIncome(random);
        return "After paying a 20% tax, " + super.payTax() + " dollars was their net monthly income.";



    }


}
