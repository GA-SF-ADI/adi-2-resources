package com.example.hollis.booksapi.Activities;

import android.content.Intent;
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
public class EditActivity extends AppCompatActivity {
    private EditText titleText, authorText, releaseText, imageText;
    private Button submitButton;
    Book curBook;
    String id;
    PracticeAPIService apiService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://super-crud.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(PracticeAPIService.class);
        setViews();
        getBook();
        setOnClicks();
    }

    public void setViews(){
        titleText = (EditText) findViewById(R.id.activity_detail_edit_text_title);
        authorText = (EditText) findViewById(R.id.activity_detail_edit_text_author);
        releaseText = (EditText) findViewById(R.id.activity_detail_edit_text_release_date);
        imageText = (EditText) findViewById(R.id.activity_detail_edit_text_image);
        submitButton= (Button) findViewById(R.id.activity_detail_submit_button);
    }

    public void populateViews(){
        titleText.setText(curBook.getTitle());
        authorText.setText(curBook.getAuthor());
        releaseText.setText(curBook.getRelease_date());
        imageText.setText(curBook.getImage());
    }
    public void getBook(){
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        apiService.getBook(id).enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                curBook = response.body();
                populateViews();
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });
    }

    public void setOnClicks(){
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBook();
                apiService.updateBook(curBook, id).enqueue(new Callback<Book>() {
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
    private void updateBook(){
        String title = titleText.getText().toString();
        String author = authorText.getText().toString();
        String releaseDate = releaseText.getText().toString();
        String image = imageText.getText().toString();
        curBook.setTitle(title);
        curBook.setAuthor(author);
        curBook.setRelease_date(releaseDate);
        curBook.setImage(image);
    }
}
