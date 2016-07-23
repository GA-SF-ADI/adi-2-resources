package com.test.mycrudbooks;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewBook extends AppCompatActivity {
    String baseUrl = "https://super-crud.herokuapp.com";
    private EditText editTitle, editAuthor,editYear;
    private Button createButton;
    private  Book newBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
        setViews();



        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newBook = new Book();
                newBook.setAuthor(editAuthor.getText().toString());
                newBook.setTitle(editTitle.getText().toString());
                newBook.setReleaseDate(editYear.getText().toString());
                addBook(newBook);

            }
        });

    }
    public void setViews(){
        editTitle = (EditText)findViewById(R.id.add_title_new);
        editAuthor = (EditText)findViewById(R.id.add_author_new);
        editYear = (EditText)findViewById(R.id.add_year_new);
        createButton = (Button)findViewById(R.id.create_book_new);
    }
    public void addBook(Book book) {
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
            Call<Example> call = bookService.addBook(book);


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
            Toast.makeText(NewBook.this,"book not added",Toast.LENGTH_SHORT).show();
        }

    }
}
