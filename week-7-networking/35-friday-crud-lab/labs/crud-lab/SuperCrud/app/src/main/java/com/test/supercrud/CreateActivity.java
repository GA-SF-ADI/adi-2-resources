package com.test.supercrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {
    EditText bookTitle;
    EditText bookAuthor;
    EditText imageLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        bookTitle = (EditText) findViewById(R.id.edit_text_book_title);
        bookAuthor = (EditText) findViewById(R.id.edit_text_book_author);
        imageLink = (EditText) findViewById(R.id.edit_text_image_url);
    }


}
