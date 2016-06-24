package com.test.audreyproject1_623;

/**
 * Created by audreyeso on 6/23/16.
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;

    private String name;
    private ArrayList<String> items;

    public Category(String name) {
        this.name = name;
        this.items = new ArrayList<String>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public ArrayList getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
}
