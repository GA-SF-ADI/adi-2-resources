package com.test.subclassanimals;

/**
 * Created by sterlinggerritz on 6/18/16.
 */
public class SubAnimals extends Animals {

     String mName;
     int mimgID;

    public SubAnimals(String Name, int imgID) {
        super(Name, imgID);
        this.mName = Name;
        this.mimgID = imgID;
    }
    public  SubAnimals[] subAnimals = {new SubAnimals("Lizard", R.drawable.lizard),
            new SubAnimals("Tapir", R.drawable.tapir)};

    //Getters for accessing my Data
    public String getName() {
        return mName;
    }

    @Override
    public String toString() {
        return mName;
    }

    public int getImgID() {
        return mimgID;
    }





}




