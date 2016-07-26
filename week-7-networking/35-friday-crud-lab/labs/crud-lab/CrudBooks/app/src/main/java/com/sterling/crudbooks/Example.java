package com.sterling.crudbooks;
//autogenerated by pojo
/**
 * Created by sterlinggerritz on 7/24/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Example {

    @SerializedName("books")
    @Expose
    private List<Book> books = new ArrayList<Book>();

    /**
     *
     * @return
     * The books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     *
     * @param books
     * The books
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }

}