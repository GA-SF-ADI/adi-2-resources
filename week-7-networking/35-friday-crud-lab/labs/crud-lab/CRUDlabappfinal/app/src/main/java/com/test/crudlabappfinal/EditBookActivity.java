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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditBookActivity extends AppCompatActivity {

    private static String baseUrl = "https://super-crud.herokuapp.com";

    private EditText selectedID;
    private EditText selectedTitle;
    private EditText selectedAuthor;
    private EditText selectedImage;
    private EditText selectedDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final Intent receivedIntent = getIntent();

        final String selectedBookID = receivedIntent.getStringExtra("selectedBookID");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookInterface service = retrofit.create(BookInterface.class);

        Call<Book> call = service.getSpecificBook(selectedBookID);

        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {

                try {

                    String IdOfBookBeingEdited = response.body().getId();
                    String titleOfBookBeingEdited = response.body().getTitle();
                    String authorOfBookBeingEdited = response.body().getAuthor();
                    String imageOfBookBeingEdited = response.body().getImage();
                    String dateOfBookBeingEdited = response.body().getReleaseDate();

                    selectedID = (EditText) findViewById(R.id.editText_book_id);
                    selectedTitle = (EditText) findViewById(R.id.editText_book_title);
                    selectedAuthor = (EditText) findViewById(R.id.editText_book_author);
                    selectedImage = (EditText) findViewById(R.id.editText_book_image);
                    selectedDate = (EditText) findViewById(R.id.editText_book_release_date);

                    selectedID.setText(IdOfBookBeingEdited);
                    selectedTitle.setText(titleOfBookBeingEdited);
                    selectedAuthor.setText(authorOfBookBeingEdited);
                    selectedImage.setText(imageOfBookBeingEdited);
                    selectedDate.setText(dateOfBookBeingEdited);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                BookInterface service = retrofit.create(BookInterface.class);

                ListView listView = (ListView) view.findViewById(R.id.listView_of_books);

                String editedBook = selectedBookID;

                Book newBook = new Book();

                String newID = selectedID.getText().toString();
                String newTitle = selectedTitle.getText().toString();
                String newAuthor = selectedAuthor.getText().toString();
                String newImage = selectedImage.getText().toString();
                String newDate = selectedDate.getText().toString();

                newBook.setId(newID);
                newBook.setTitle(newTitle);
                newBook.setAuthor(newAuthor);
                newBook.setImage(newImage);
                newBook.setReleaseDate(newDate);


                Call<Book> call = service.updateSpecificBook(editedBook, newBook);

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
