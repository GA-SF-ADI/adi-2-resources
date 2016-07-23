package com.test.mycrudbooks;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsActivity extends AppCompatActivity {
    String baseUrl = "https://super-crud.herokuapp.com";
    private Book curBook;
    private ImageView bookImage;
    private EditText bookTitle;
    private EditText bookAuthor;
    private EditText bookYear;
    private Button updateBttn;
    private Button deleteBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setViews();
        setBookProperties();




        updateBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting editText values and setting it to book properties
                curBook.setTitle(bookTitle.getText().toString());
                curBook.setAuthor(bookAuthor.getText().toString());
                curBook.setReleaseDate(bookYear.getText().toString());
                //running updateBook to update new properties for currentbook
                updateBook(curBook.getId(),curBook);
                //going back to main activity after book is updated
                backToMain();


            }
        });
        deleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //deleting book onClick
                deleteBook(curBook.getId());
                //going back to main after book is deleted
                backToMain();


            }
        });

    }
    public void setViews(){
        bookImage = (ImageView)findViewById(R.id.book_image_details);
        bookTitle = (EditText)findViewById(R.id.title_tv_details);
        bookAuthor = (EditText)findViewById(R.id.author_tv_details);
        bookYear= (EditText)findViewById(R.id.year_tv_details);
        updateBttn = (Button)findViewById(R.id.update_button_details);
        deleteBook = (Button)findViewById(R.id.delete_button_details);

    }
    public void setBookProperties(){
        Intent recIntent = getIntent();

        curBook = (Book)recIntent.getSerializableExtra(MainActivity.CURRENT_BOOK);
        Picasso.with(DetailsActivity.this).load(curBook.getImage()).into(bookImage);
        bookTitle.setText(curBook.getTitle());
        bookAuthor.setText(curBook.getAuthor());
        bookYear.setText(curBook.getReleaseDate());

    }
    public void deleteBook(String id) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // the connection is available
            //adding retrofit
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            //get instance of our Book service and get Call

            BookService bookService = retrofit.create(BookService.class);
            Call<Example> call = bookService.deleteBook(id);


            //executing the call and updating views

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    try {


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });


        } else {
            // the connection is not available
            Toast.makeText(DetailsActivity.this,"no connection is available",Toast.LENGTH_SHORT).show();
        }

    }
    public void updateBook(String id, Book book) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // the connection is available
            //adding retrofit
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            //get instance of our Book service and get Call

            BookService bookService = retrofit.create(BookService.class);
            Call<Example> call = bookService.updateBook(id,book);


            //executing the call and updating views

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    try {


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });


        } else {
            // the connection is not available
            Toast.makeText(DetailsActivity.this,"no connection is available",Toast.LENGTH_SHORT).show();
        }

    }
    public void backToMain(){
        Intent backHomeIntent = new Intent(DetailsActivity.this, MainActivity.class);
        startActivity(backHomeIntent);
    }
}
