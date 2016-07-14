package com.test.project2navigationdrawer;

import java.io.Serializable;

/**
 * Created by audreyeso on 7/12/16.
 */
public class Item implements Serializable {

    private static final long serialVersionUID = 7526472295622776147L;
    String id;
    String type;
    double price;
    String gold;
    String stone;
    String name;
    String measurement;
    int quantity;
   int image;


public Item (String id, String type, double price, String gold, String stone, String measurement, String name, int image) {
    this.id = id;
    this.type = type;
    this.price = price;
    this.gold = gold;
    this.stone = stone;
    this.name =name;
    this.measurement = measurement;
    this.image = image;

}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStone() {
        return stone;
    }

    public void setStone(String stone) {
        this.stone = stone;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
