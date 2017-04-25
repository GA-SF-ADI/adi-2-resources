package com.test.crud;

import com.test.crud.Models.Books;
import com.test.crud.Models.Library;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Jon Kim on 7/22/16.
 */
public interface BookService {
    @GET("/books/")
    Call<Library> getLibrary();

    @POST("/books/")
    Call<Books> addBook(@Body Books books);

    @PUT("/books/{id}")
    Call<Books> updateBook(@Path("id") String id, @Body Books books);

    @DELETE("/books/{id}")
    Call<Books> deleteBook(@Path("id") String id);
}
