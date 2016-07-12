package com.test.project2navigationdrawer;

/**
 * Created by audreyeso on 7/12/16.
 *
 *
 */
import java.util.ArrayList;

public class ShoppingCartSingleton {

    private static ShoppingCartSingleton shoppingCart;


    private static ArrayList<Item> item;

    private ShoppingCartSingleton(){
        item = new ArrayList<>();
    }

    public static ShoppingCartSingleton getInstance(){
        if(shoppingCart == null)
            shoppingCart = new ShoppingCartSingleton();
        return shoppingCart;
    }

    public void addItem(Item addItem){
        item.add(addItem);
    }

    public ArrayList<Item> getItem(){
        return item;
    }
}

