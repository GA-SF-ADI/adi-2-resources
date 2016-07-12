package com.test.snug;

/**
 * Created by LangstonSmith on 7/8/16.
 */
public class Hat {

    private int id;
    private String name;
    private int price;
    private String material;
    private int fittedOrSnap;
    private String description;
    private String color;
    private int pictureID;


    public Hat(int id, int pictureID, String name, int price, String material, int fittedOrSnap, String description, String color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.material = material;
        this.fittedOrSnap = fittedOrSnap;
        this.description = description;
        this.color = color;
        this.pictureID = pictureID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }
}
