package com.example.kitty.ecommerceapp;

/**
 * Created by kitty on 7/10/16.
 */
public class TP {

    String name;
    String brand;
    double price;
    String description;
    int ply;
    String size;
    int numRolls;
    //int rating;


    public TP(String name, String brand, int ply, String size, int numRolls, String description, double price) {
        this.name = name;
        this.brand = brand;
        this.ply = ply;
        this.size = size;
        this.numRolls = numRolls;
        this.description = description;
        this.price = price;
    }
}
