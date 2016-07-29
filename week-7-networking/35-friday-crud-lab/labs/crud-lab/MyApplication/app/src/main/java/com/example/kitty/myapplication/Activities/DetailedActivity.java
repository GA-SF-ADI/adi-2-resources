package com.example.kitty.myapplication.Activities;

import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.kitty.myapplication.BookInterface;
import com.example.kitty.myapplication.Models.Book;
import com.example.kitty.myapplication.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kitty on 7/25/16.
 */
public class DetailedActivity extends AppCompatActivity {

    private String baseURL = "https://super-crud.herokuapp.com";

    ImageView imageView;
    EditText editTextTitle;
    EditText editTextAuthor;
    EditText editTextDate;
    Button submitButton;
    Book currentBook;
    String id;
    BookInterface bookInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        setViews();
        getBook();

        updateBook();
    }

    public void setViews() {
        imageView = (ImageView) findViewById(R.id.detail_view_image);
        editTextTitle = (EditText) findViewById(R.id.detail_view_title);
        editTextAuthor = (EditText) findViewById(R.id.detail_view_author);
        editTextDate = (EditText) findViewById(R.id.detail_view_date);
        submitButton = (Button) findViewById(R.id.detail_view_submit_button);
    }

    public void getBook() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bookInterface = retrofit.create(BookInterface.class);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        bookInterface.getBook(id).enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                currentBook = response.body();
                Picasso.with(DetailedActivity.this).load(currentBook.getImage()).into(imageView);
                editTextTitle.setText(currentBook.getTitle());
                editTextAuthor.setText(currentBook.getAuthor());
                editTextDate.setText(currentBook.getReleaseDate());
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });
    }

    public void updateBook() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentBook.setTitle(editTextTitle.getText().toString());
                currentBook.setAuthor(editTextAuthor.getText().toString());
                currentBook.setReleaseDate(editTextDate.getText().toString());
//                currentBook.setImage();
                bookInterface.updateBook(id, currentBook).enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {

                    }
                });
            }
        });
    }
}
