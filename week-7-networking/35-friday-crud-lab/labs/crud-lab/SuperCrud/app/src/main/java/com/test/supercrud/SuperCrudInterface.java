package com.test.supercrud;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by audreyeso on 7/22/16.
 */
public interface SuperCrudInterface {

    @GET("/books/")
    Call<Root> getBooks(@Query());
}
