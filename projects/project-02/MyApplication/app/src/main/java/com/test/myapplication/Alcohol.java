package com.test.myapplication;

/**
 * Created by Jon Kim on 7/8/16.
 */
public class Alcohol {
    private String alcName;
    private int alcPrice;
    private int abv;
    private String description;
    private int image;
    private int alcId;

    public Alcohol(String alcName, int alcPrice, int abv, String description, int image, int alcId) {
        this.alcName = alcName;
        this.alcPrice = alcPrice;
        this.abv = abv;
        this.description = description;
        this.image = image;
        this.alcId = alcId;
    }

    public String getAlcName() {
        return alcName;
    }

    public int getAlcPrice() {
        return alcPrice;
    }

    public String getDescription() {
        return description;
    }

    public int getAbv() {
        return abv;
    }

    public int getImage() {
        return image;
    }

    public int getAlcId() {
        return alcId;
    }
}
