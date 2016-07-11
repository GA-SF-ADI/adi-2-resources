package com.test.subclassanimals;

/**
 * Created by sterlinggerritz on 6/18/16.
 */
public class Animals {
    public String name;
    public int imgID;

    //creating constructor
    public Animals(String name, int imgID) {
        this.name = name;
        this.imgID = imgID;

    }
    public static Animals[] animals = {new Animals("Mammals", R.drawable.mammals),
            new Animals("Reptiles", R.drawable.reptiles), };

    //Getters for accessing my Data
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getImgID() {
        return imgID;
    }

    //creating objects of Class Animal



}


