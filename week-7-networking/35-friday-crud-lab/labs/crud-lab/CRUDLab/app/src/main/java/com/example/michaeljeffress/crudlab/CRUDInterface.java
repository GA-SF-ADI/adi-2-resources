package com.example.michaeljeffress.crudlab;

/**
 * Created by michaeljeffress on 7/22/16.
 */

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CRUDInterface {
    @GET("/books/")
    Call<Bookshelf> getBooks();

    @POST("/books/")
    Call<Books> createBook(@Body Books books);

    @PUT("/books/{id}")
    Call<Books> updateBook(@Path("id") String _id, @Body Books books);

    @DELETE("/books/{id}")
    Call<Books> deleteBook(@Path("id") String _id);



//    GET	/books	READS all books
//    POST	/books	CREATES new book
//    GET	/books/:id	READS one book
//    PUT	/books/:id	UPDATES one book
//    DELETE	/books/:id	DELETES one book

}
