package com.test.myjs;

import java.util.List;

/**
 * Created by nolbertoarroyo on 7/9/16.
 */
public class ShoppingCart {
    List<Shoe> shoeItems;
    int numItems;
    double totalPrice;
    int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public ShoppingCart(List<Shoe> shoeItems, int numItems, double totalPrice) {
        this.shoeItems = shoeItems;
        this.numItems = numItems;
        this.totalPrice = totalPrice;
        this.itemId = itemId;

    }

    public List<Shoe> getShoeItems() {
        return shoeItems;
    }

    public void setShoeItems(List<Shoe> shoeItems) {
        this.shoeItems = shoeItems;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
