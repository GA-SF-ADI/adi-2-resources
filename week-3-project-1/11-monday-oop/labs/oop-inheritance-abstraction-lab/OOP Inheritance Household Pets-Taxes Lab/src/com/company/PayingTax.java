package com.company;

/**
 * Created by LangstonSmith on 6/20/16.
 */

public class PayingTax extends RegularTax implements TaxInterface {

    public PayingTax(double taxPercentage, double grossReceivedMonthlyIncome) {
        super(taxPercentage, grossReceivedMonthlyIncome);
    }

    @Override
    public String inTwentyPercentTaxBracket() {

        return "They had to pay 20% because they were in that bracket for this year.";
    }

    @Override
    public String payTax() {
        setTaxPercentage(.2);
        int random;
        random = (int) (Math.random() * 2000 + 1);
        setGrossReceivedMonthlyIncome(random);
        return "Before tax, their gross monthly income was " + random + " dollars. However, after paying a 20% tax, " + super.payTax() + " dollars is their NET monthly income";


    }


}
