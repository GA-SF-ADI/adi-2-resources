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
        return "After paying a 20% tax, " + super.payTax() + " dollars was their net monthly income.";



    }


}
