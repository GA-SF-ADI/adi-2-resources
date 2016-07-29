package com.example.hollis.booksapi.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hollis.booksapi.Models.Book;
import com.example.hollis.booksapi.PracticeAPIService;
import com.example.hollis.booksapi.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hollis on 7/19/16.
 */
public class NewBookActivity extends AppCompatActivity {
    private EditText titleText, authorText, releaseText, imageText;
    private Button submitButton;
    Book newBook;
    PracticeAPIService apiService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        setViews();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://super-crud.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(PracticeAPIService.class);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createBook();
                apiService.createBook(newBook).enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

            }
        });
    }
    private void setViews(){
        titleText = (EditText) findViewById(R.id.activity_new_book_edit_text_title);
        authorText = (EditText) findViewById(R.id.activity_new_book_edit_text_author);
        releaseText = (EditText) findViewById(R.id.activity_new_book_edit_text_release_date);
        imageText = (EditText) findViewById(R.id.activity_new_book_edit_text_image);
        submitButton= (Button) findViewById(R.id.activity_new_book_submit_button);
    }
    private void createBook(){
        String title = titleText.getText().toString();
        String author = authorText.getText().toString();
        String releaseDate = releaseText.getText().toString();
        String image = imageText.getText().toString();
        newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setRelease_date(releaseDate);
        newBook.setImage(image);
    }
}
