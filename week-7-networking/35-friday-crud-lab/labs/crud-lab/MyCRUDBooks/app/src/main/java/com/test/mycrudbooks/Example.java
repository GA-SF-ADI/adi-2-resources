package com.test.mycrudbooks;

/**
 * Created by nolbertoarroyo on 7/22/16.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


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
