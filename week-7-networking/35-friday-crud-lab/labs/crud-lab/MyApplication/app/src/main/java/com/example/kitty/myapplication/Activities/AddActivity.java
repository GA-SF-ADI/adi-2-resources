package com.example.kitty.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kitty.myapplication.BookInterface;
import com.example.kitty.myapplication.Models.Book;
import com.example.kitty.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kitty on 7/25/16.
 */
public class AddActivity extends AppCompatActivity {

    private String baseURL = "https://super-crud.herokuapp.com";

    EditText editTextAddTitle;
    EditText editTextAddAuthor;
    EditText editTextAddDate;
    EditText editTextAddImage;
    Button addSubmitButton;
    BookInterface bookInterface;

    Book newBook = new Book();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);

        setViews();

        addNewBook();

    }

    public void setViews() {
        editTextAddTitle = (EditText) findViewById(R.id.add_book_name);
        editTextAddAuthor = (EditText) findViewById(R.id.add_book_author);
        editTextAddDate = (EditText) findViewById(R.id.add_book_date);
        editTextAddImage = (EditText) findViewById(R.id.add_book_image);
        addSubmitButton = (Button) findViewById(R.id.add_book_button);
    }

    public void addNewBook(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bookInterface = retrofit.create(BookInterface.class);

        addSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newBook.setTitle(editTextAddTitle.getText().toString());
                newBook.setImage(editTextAddImage.getText().toString());
                newBook.setAuthor(editTextAddAuthor.getText().toString());
                newBook.setReleaseDate(editTextAddDate.getText().toString());
                bookInterface.addBook(newBook).enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        setResult(RESULT_OK, new Intent());
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
