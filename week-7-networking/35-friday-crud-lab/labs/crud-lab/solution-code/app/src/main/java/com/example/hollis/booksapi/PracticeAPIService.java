package com.example.hollis.booksapi;

import com.example.hollis.booksapi.Models.Book;
import com.example.hollis.booksapi.Models.BookResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by hollis on 7/8/16.
 */
public interface PracticeAPIService {
    @GET("books")
    Call<BookResult> listBooks();

    @GET("books/{id}")
    Call<Book> getBook(@Path("id") String id);

    @POST("books")
    Call<Book> createBook(@Body Book book);

    @PUT("books/{id}")
    Call<Book> updateBook(@Body Book book, @Path("id") String id);

    @DELETE("books/{id}")
    Call<Book> deleteBook(@Path("id") String id);
}
