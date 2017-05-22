package com.test.crudlabappfinal;

/**
 * Created by LangstonSmith on 7/22/16.
 */

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BookInterface {


    @GET("/books")
    Call<BookData> getAllBooks();


    @POST("/books/{id}")
    Call<Book> createAndAddSpecificBook(@Path("id") String id, @Body Book newBook);


    @GET("/books/{id}")
    Call<Book> getSpecificBook(@Path("id") String id);


    @PUT("/books/{id}")
    Call<Book> updateSpecificBook(@Path("id") String id, @Body Book newBook);

    @DELETE("/books/{id}")
    Call<Book> deleteSpecificBook(@Path("id") String id);


}
