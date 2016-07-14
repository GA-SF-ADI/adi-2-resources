package com.test.myapplication;

import java.io.Serializable;

/**
 * Created by Jon Kim on 7/13/16.
 */
public class Cart implements Serializable{
    private int quantity;
    private int fAlcId;

    public Cart(int quantity, int fAlcId) {

        this.quantity = quantity;
        this.fAlcId = fAlcId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getfAlcId() {
        return fAlcId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setfAlcId(int fAlcId) {
        this.fAlcId = fAlcId;
    }
}
