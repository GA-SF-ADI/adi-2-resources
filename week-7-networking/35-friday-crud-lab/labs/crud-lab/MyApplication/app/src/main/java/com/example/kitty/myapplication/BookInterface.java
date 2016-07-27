package com.example.kitty.myapplication;

import com.example.kitty.myapplication.Models.Book;
import com.example.kitty.myapplication.Models.Library;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by kitty on 7/25/16.
 */
public interface BookInterface {

    @GET("/books")  //
    Call<Library> getBooks();

    @POST("/books")  //
    Call<Book> addBook(@Body Book book);

    @GET("/books/{id}")  //
    Call<Book> getBook(@Path("id") String id);

    @PUT("/books/{id}")  //
    Call<Book> updateBook(@Path("id") String id, @Body Book book);

    @DELETE("/books/{id}")  //
    Call<Book> removeBook(@Path("id") String id);

}
