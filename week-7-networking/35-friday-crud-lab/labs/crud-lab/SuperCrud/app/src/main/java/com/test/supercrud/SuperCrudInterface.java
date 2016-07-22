package com.test.supercrud;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by audreyeso on 7/22/16.
 */

//4. created interface
public interface SuperCrudInterface {

    //get list of books
    @GET("/books/")
    Call<Root> getBooks();

    @POST("/books/")
    Call<Root>postBooks(@Path("books") Books books);

    //edit path for put and delete method
    @PUT("/books/{}")
    Call<Root>updateOneBook(@Path("books") Books books);


    //needs to be id
    @DELETE("/books/{}")
    Call<Root>deleteOneBook(@Path("books") Books books);


}
