package com.company;

import java.util.ArrayList;

/**
 * Created by kitty on 6/20/16.
 */
public class Community {

    ArrayList<Household> community;

    public Community(ArrayList<Household> community) {
        this.community = community;
    }

    public void addHousehold(Household household) {
        community.add(household);
    }

    public int getSize() {
        return community.size();
    }

    public Household getHousehold(int i) {
        return community.get(i);
    }
}
