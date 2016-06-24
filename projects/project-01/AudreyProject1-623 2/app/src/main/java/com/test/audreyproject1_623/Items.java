package com.test.audreyproject1_623;

/**
 * Created by audreyeso on 6/23/16.
 */

import java.io.Serializable;
import java.util.ArrayList;


public class Items implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;

    private String name;
    private ArrayList<String> items;


    public Items(String name) {
        this.name = name;
        this.items = new ArrayList<String>();

    }

    public String getItemsName() {
        return name;
    }

    public void setItemsName(String name) {
        this.name = name;

    }

    public ArrayList getListofItems() {
        return items;
    }

    public void setListOfItems(ArrayList<String> items) {
        this.items = items;
    }
}

