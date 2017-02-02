package gg.patrickcummins.week7fridaybooklab.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrickcummins on 7/22/16.
 */

public class Books {

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

