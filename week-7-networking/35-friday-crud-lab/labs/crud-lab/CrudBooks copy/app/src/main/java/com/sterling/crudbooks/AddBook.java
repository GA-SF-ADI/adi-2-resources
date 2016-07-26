package com.sterling.crudbooks;

/**
 * Created by sterlinggerritz on 7/24/16.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class AddBook extends AppCompatActivity {
    String baseUrl = "https://super-crud.herokuapp.com";
    private EditText title, author,year;
    private Button addMe;
    private  Book newBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        consolidateViews();



        addMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newBook = new Book();
                newBook.setAuthor(author.getText().toString());
                newBook.setTitle(title.getText().toString());
                newBook.setReleaseDate(year.getText().toString());
                addBook(newBook);

            }
        });

    }
    public void consolidateViews(){
        title = (EditText)findViewById(R.id.newtitle);
        author = (EditText)findViewById(R.id.newauthor);
        year = (EditText)findViewById(R.id.newyear);
        addMe = (Button)findViewById(R.id.create_book_new);
    }
    public void addBook(Book book) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            RetroInterface bookService = retrofit.create(RetroInterface.class);
            Call<Example> call = bookService.addBook(book);




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



    }
}}
