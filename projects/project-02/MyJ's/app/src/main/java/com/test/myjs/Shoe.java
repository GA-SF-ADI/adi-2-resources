package com.test.myjs;

/**
 * Created by nolbertoarroyo on 7/8/16.
 */
public class Shoe {
    private int id;
    private String name;
    private String description;
    private Double price;
    private String style;
    private int year;
    private int imageId;
    private String color;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Shoe(int id, String name, String description, Double price, String style, int year, int imageId, String color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.style = style;
        this.year = year;
        this.imageId = imageId;
        this.color = color;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
