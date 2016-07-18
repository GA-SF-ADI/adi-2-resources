package com.differentdevices.fishtankv9;

/**
 * Created by sterlinggerritz on 7/11/16.
 */
public class ProductSingleton  {
    private int id;
    private String name;
    private String description;
    private Double price;
    private Integer rating;
    private String image;
    private String type;
    public boolean selected;

    public ProductSingleton(int id, String name, String description, Double price, Integer rating, String image, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.image = image;
        this.type = type;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Integer getRating() {
        return rating;
    }

    public String getImage() {
        return image;
    }

}
