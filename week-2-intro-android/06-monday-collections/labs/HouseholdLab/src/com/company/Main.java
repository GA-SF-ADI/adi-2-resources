package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Household> householdlist = new ArrayList<>();
        householdlist.add(new IguanaHousehold());
        householdlist.add(new PonyHousehold());

        for(Household household : householdlist) { //"for each household in the list, make them do their tasks
            household.earnMoney();
            household.garden();
            household.careForPet();
            household.payTaxes();
        }
    }

}