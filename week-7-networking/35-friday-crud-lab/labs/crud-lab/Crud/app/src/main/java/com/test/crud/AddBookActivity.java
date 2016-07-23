package com.test.crud;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.crud.Models.Books;
import com.test.crud.Models.Library;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddBookActivity extends AppCompatActivity {
    EditText addTitle, addAuthor, addDate, addImage;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        setViews();

        //add button makes a new book with values taken from the edittexts.
        //then sends to addbook method for call.
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Books newBook = new Books();
                newBook.setAuthor(addAuthor.getText().toString());
                newBook.setTitle(addTitle.getText().toString());
                newBook.setImage(addImage.getText().toString());
                newBook.setReleaseDate(addDate.getText().toString());

                addBook(newBook);
                finish();
            }
        });

    }

    protected void setViews(){
        addTitle = (EditText) findViewById(R.id.add_title);
        addAuthor = (EditText) findViewById(R.id.add_author);
        addDate = (EditText) findViewById(R.id.add_date);
        addImage = (EditText) findViewById(R.id.add_image);
        addButton = (Button) findViewById(R.id.add_button);
    }

    //addbook receives a book from the add button then uses book to make call.
    protected void addBook(Books books) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(MainActivity.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            BookService service = retrofit.create(BookService.class);

            Call<Books> call = service.addBook(books);

            call.enqueue(new Callback<Books>() {
                @Override
                public void onResponse(Call<Books> call, Response<Books> response) {

                    try {


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Books> call, Throwable t) {

                }
            });
        } else {
            Toast.makeText(AddBookActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }
}
