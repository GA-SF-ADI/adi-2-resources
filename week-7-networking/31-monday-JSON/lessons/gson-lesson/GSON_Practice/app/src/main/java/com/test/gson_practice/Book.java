package com.test.gson_practice;

/**
 * Created by audreyeso on 7/18/16.
 */
public class Book {

    private String title;
    private String author;
    private Cover cover;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

}
