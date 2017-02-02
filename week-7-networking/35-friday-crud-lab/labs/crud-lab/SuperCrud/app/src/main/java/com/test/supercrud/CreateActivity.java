package com.test.supercrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateActivity extends AppCompatActivity {
    CreateCustomBaseAdapter customBaseAdapter;
    private ListView listView;
    private ArrayList<Books> booksArrayList;
    private SuperCrudInterface service;
    private Button addButton;
    private EditText bookTitle;
    private EditText bookAuthor;
    private EditText imageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        //listView = (ListView) findViewById(R.id.listView_created_books);
        customBaseAdapter = new CreateCustomBaseAdapter(booksArrayList, this);
        bookTitle = (EditText) findViewById(R.id.edit_text_book_title);
        bookAuthor = (EditText) findViewById(R.id.edit_text_book_author);
        imageURL = (EditText) findViewById(R.id.edit_text_image_url);
        addButton = (Button) findViewById(R.id.button_add);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(SuperCrudInterface.class);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String bookTitleString = bookTitle.getText().toString();
                final String bookAuthorString = bookAuthor.getText().toString();
                final String imageURLString = imageURL.getText().toString();
                Intent intent = new Intent(CreateActivity.this, ViewBooksActivity.class);
                intent.putExtra("Title", bookTitleString);
                intent.putExtra("Author", bookAuthorString);
                intent.putExtra("Image", imageURLString);

                customBaseAdapter.notifyDataSetChanged();
            }

//            BookRequest bookRequest = new BookRequest();
//            bookRequest.setAuthor(view.gettext.toString);
//            bookRequest.settitle(view.gettext[].
//
//            toString()
//
//            );
            Call<BookRequest> bookRequestCall = service.postBooks(bookRequest);
            bookRequestCall.enqueue(new
            Callback<Response> response
            )

            {
                int statusCode = response.code();
            }

            Books books = new Books();
            books.setAuthor(listView.toString());
            books.setTitle(listView.toString());


            @Override
            public void onFailure(retrofit2.Call<Root> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(CreateActivity.this, "No WIFI", Toast.LENGTH_LONG).show();

            }


        });
    }
}


