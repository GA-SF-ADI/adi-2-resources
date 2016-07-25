package com.test.apipractice2;

import com.test.apipractice2.models.Root;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by audreyeso on 7/23/16.
 */
public interface BookInterface {

    //get list of books
    @GET("/books/")
    Call<Root> getBooks();

}
