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
        return "Before tax, their gross monthly income was " + random + " dollars. However, after paying a 20% tax, " + super.payTax() + " dollars is their NET monthly income.";


    }


}
