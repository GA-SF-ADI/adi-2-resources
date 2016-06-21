package com.company;

/**
 * Created by LangstonSmith on 6/20/16.
 */

public class TwentyPercentTax extends RegularTax {


    public TwentyPercentTax(double taxPercentage, double grossReceivedMonthlyIncome) {
        super(taxPercentage, grossReceivedMonthlyIncome);
    }

    @Override
    protected String payTax() {
        setTaxPercentage(.2);
        return super.payTax();


    }


}
