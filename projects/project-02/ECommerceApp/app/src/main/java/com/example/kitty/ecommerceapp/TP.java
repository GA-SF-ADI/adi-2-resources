package com.example.kitty.ecommerceapp;

/**
 * Created by kitty on 7/10/16.
 */
public class TP {

    private String name;
    private int pic;
    private String brand;
    private double price;
    private String description;
    private int ply;
    private String size;
    private int numRolls;
    private boolean isOnSale;


    public TP(String name, int pic, String brand, int ply, String size, int numRolls, String description, double price, boolean sale) {
        this.name = name;
        this.pic = pic;
        this.brand = brand;
        this.ply = ply;
        this.size = size;
        this.numRolls = numRolls;
        this.description = description;
        this.price = price;
        this.isOnSale = sale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPly() {
        return ply;
    }

    public void setPly(int ply) {
        this.ply = ply;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNumRolls() {
        return numRolls;
    }

    public void setNumRolls(int numRolls) {
        this.numRolls = numRolls;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
