package gg.patrickcummins.week7fridaybooklab;

import gg.patrickcummins.week7fridaybooklab.Models.Book;
import gg.patrickcummins.week7fridaybooklab.Models.Books;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

import static android.os.FileObserver.DELETE;

/**
 * Created by patrickcummins on 7/22/16.
 */

public interface BooksService {
    @GET("books")
    Call<Books> getBooks();

    @POST("books")
    Call<Book> addBook(@Body Book book);

    @PUT("books/{id}")
    Call<Book> updateBook(@Path("id") String id,@Part("title") String title, @Part("author") String author, @Part("image") String imageUrl, @Part("releaseDate") String releaseDate);

    @DELETE("books/{id}")
    Call<Book> deleteBook(@Path("id") String id);
}
