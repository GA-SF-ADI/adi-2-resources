package com.test.bookscanner2.interfaces;

/**
 * Created by audreyeso on 8/6/16.
 */

import com.test.bookscanner2.models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenLibraryAPI {

    //https://openlibrary.org/api/books?bibkeys=ISBN:9780980200447&jscmd=data&format=json

    @GET("books")
    Call<Example> getBookDescription(@Query("bibkeys")String ISBN,
                                     @Query("jscmd") String data,
                                     @Query("format") String json);

}
