package com.test.supercrud;

import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
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
    Call<Root>postBooks(@Body BookRequest bookRequest);

    //edit path for put and delete method
    @Multipart
    @PUT("/books/{title}")
    Call<Books>updateOneBook(@Part("title")RequestBody title, @Part("author") RequestBody author);


    //needs to be id
    @DELETE("/books/{id}")
    Response deleteOneBook(@Path("id") int itemId);

}
