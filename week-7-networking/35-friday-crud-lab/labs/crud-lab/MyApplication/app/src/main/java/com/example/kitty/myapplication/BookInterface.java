package com.example.kitty.myapplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kitty on 7/25/16.
 */
public interface BookInterface {

    @GET("/books")  //
    Call<Library> getBooks();

    @POST("/books")  //
    Call<Book> addBook(@Body Book book);

    @GET("/books")  //
    Call<Book> getBook(@Path(":id") String id);

    @PUT("/books")  //
    Call<Book> updateBook(@Path(":id") String id);

    @DELETE("/books")  //
    Call<Book> removeBook(@Path(":id") String id);

}
