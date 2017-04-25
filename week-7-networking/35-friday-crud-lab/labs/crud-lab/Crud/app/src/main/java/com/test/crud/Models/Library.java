package com.test.crud.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jon Kim on 7/22/16.
 */
public class Library {
    private List<Books> books = new ArrayList<Books>();

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
