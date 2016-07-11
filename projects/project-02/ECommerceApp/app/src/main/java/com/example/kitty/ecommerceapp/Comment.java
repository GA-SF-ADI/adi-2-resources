package com.example.kitty.ecommerceapp;

/**
 * Created by kitty on 7/11/16.
 */
public class Comment {

    String comment;
    String itemID;
    int rating;

    public Comment(String comment, String itemID, int rating) {
        this.comment = comment;
        this.itemID = itemID;
        this.rating = rating;
    }
}
