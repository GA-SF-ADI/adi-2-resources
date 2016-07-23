package com.test.crudlabappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateBookActivity extends AppCompatActivity {

    EditText id;
    EditText title;
    EditText author;
    EditText image;
    EditText releaseDate;
    EditText bookV;


    private static String baseUrl = "https://super-crud.herokuapp.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        id = (EditText) findViewById(R.id.editText_book_id);
        title = (EditText) findViewById(R.id.editText_book_title);
        author = (EditText) findViewById(R.id.editText_book_author);
        image = (EditText) findViewById(R.id.editText_book_image);
        releaseDate = (EditText) findViewById(R.id.editText_book_release_date);
        bookV = (EditText) findViewById(R.id.editText_book_v);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newId = id.getText().toString();
                String newTitle = title.getText().toString();
                String newAuthor = author.getText().toString();
                String newImage = image.getText().toString();
                String newReleaseDate = releaseDate.getText().toString();
                Integer newBookV = Integer.parseInt(bookV.getText().toString());

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                BookInterface service = retrofit.create(BookInterface.class);

                Book completelyNewBook = new Book();

                completelyNewBook.setId(newId);
                completelyNewBook.setTitle(newTitle);
                completelyNewBook.setAuthor(newAuthor);
                completelyNewBook.setImage(newImage);
                completelyNewBook.setReleaseDate(newReleaseDate);
                completelyNewBook.setV(newBookV);


                Call<Book> call = service.createAndAddSpecificBook(newId, completelyNewBook);

                call.enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {

                        try {

                            finish();


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {

                    }
                });


            }
        });
    }

}
