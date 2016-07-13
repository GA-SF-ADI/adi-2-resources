package com.test.project2navigationdrawer;

import java.util.ArrayList;

/**
 * Created by audreyeso on 7/13/16.
// */
public class DatabaseSingleton {


    private static DatabaseSingleton databaseSingleton;

    private ArrayList<Item> item;


    public static DatabaseSingleton getInstance(){
        if(databaseSingleton == null)
            databaseSingleton = new DatabaseSingleton();
        return databaseSingleton;
    }

    public void insertItem(String type, String price, String gold, String stone, String measurement, String quantity, String name, int image){
        databaseSingleton.insertItem(type, price, gold, stone, measurement, quantity, name, image);
    }

    public ArrayList<Item> getItems(){
        return databaseSingleton.item;
    }

}

