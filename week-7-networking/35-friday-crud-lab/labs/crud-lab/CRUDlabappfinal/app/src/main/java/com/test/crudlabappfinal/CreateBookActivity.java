package com.test.crudlabappfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class CreateBookActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_book_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CreateBookActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

//                TODO: Grab text in all of the ediTexts

                EditText id = (EditText) findViewById(R.id.editText_book_id);
                EditText title = (EditText) findViewById(R.id.editText_book_title);
                EditText author = (EditText) findViewById(R.id.editText_book_author);
                EditText image = (EditText) findViewById(R.id.editText_book_image);
                EditText releaseDate = (EditText) findViewById(R.id.editText_book_release_date);
                EditText bookV = (EditText) findViewById(R.id.editText_book_v);


//                TODO: Make PUT call to add book to book array

            }
        });
    }

}
