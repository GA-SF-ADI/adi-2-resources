package com.test.mycrudbooks;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


/**
 * Created by nolbertoarroyo on 7/22/16.
 */
public interface BookService {
    @GET("/books")
    Call<Example>getBooks();

    @DELETE("/books/{id}")
    Call<Example>deleteBook(@Path("id")String id);

    @PUT("/books/{id}")
    Call<Example>updateBook(@Path("id")String id, @Body Book book);

    @POST("/books")
    Call<Example>addBook(@Body Book book);











}
