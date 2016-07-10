package com.test.snug;

/**
 * Created by LangstonSmith on 7/8/16.
 */
public class Hat {

    private int id;
    private double price;
    private String material;
    private int fittedOrSnap;
    private String description;
    private String color;
    private int pictureID;


    public Hat(int id, int picture, double price, String material, int fittedOrSnap, String description, String color) {
        this.id = id;
        this.price = price;
        this.material = material;
        this.fittedOrSnap = fittedOrSnap;
        this.description = description;
        this.color = color;
        this.pictureID = picture;
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getFittedOrSnap() {
        return fittedOrSnap;
    }

    public void setFittedOrSnap(int fittedOrSnap) {
        this.fittedOrSnap = fittedOrSnap;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
