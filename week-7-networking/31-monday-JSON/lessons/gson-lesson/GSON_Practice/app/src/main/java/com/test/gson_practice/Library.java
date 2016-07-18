package com.test.gson_practice;

/**
 * Created by audreyeso on 7/18/16.
 */
public class Library {

    public Bookshelf[] getBookshelfs() {
        return bookshelfs;
    }

    public void setBookshelfs(Bookshelf[] bookshelfs) {
        this.bookshelfs = bookshelfs;
    }

    private Bookshelf [] bookshelfs;
}
