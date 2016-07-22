package com.test.crudlabappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateBookActivity extends AppCompatActivity {

    EditText id;
    EditText title;
    EditText author;
    EditText image;
    EditText releaseDate;
    EditText bookV;


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

                Intent intent = new Intent(CreateBookActivity.this, MainActivity.class);
                startActivity(intent);
                finish();


                String mId = id.getText().toString();
                String mTitle = title.getText().toString();
                String mAuthor = author.getText().toString();
                String mImage = image.getText().toString();
                String mReleaseDate = releaseDate.getText().toString();
                String mBookV = bookV.getText().toString();

//                TODO: Make PUT call to add book to book array

            }
        });
    }

}
