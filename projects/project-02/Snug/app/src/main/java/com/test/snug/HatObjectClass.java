package com.test.snug;

/**
 * Created by LangstonSmith on 7/8/16.
 */
public class HatObjectClass {

    private double price;
    private String material;
    private boolean fittedOrSnap;
    private String description;
    private String color;
    private int hatPicture;

    public HatObjectClass(double price, String material, boolean fittedOrSnap, String description, String color, int hatPicture) {
        this.price = price;
        this.material = material;
        this.fittedOrSnap = fittedOrSnap;
        this.description = description;
        this.color = color;
        this.hatPicture = hatPicture;
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

    public boolean isFittedOrSnap() {
        return fittedOrSnap;
    }

    public void setFittedOrSnap(boolean fittedOrSnap) {
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

    public int getHatPicture() {
        return hatPicture;
    }

    public void setHatPicture(int hatPicture) {
        this.hatPicture = hatPicture;
    }
}
