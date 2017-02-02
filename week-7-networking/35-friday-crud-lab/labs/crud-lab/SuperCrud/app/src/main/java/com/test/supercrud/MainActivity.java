package com.test.supercrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button createBook;
    Button viewBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createBook = (Button) findViewById(R.id.create_books_button);
        viewBooks = (Button) findViewById(R.id.view_books_button);


        createBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,CreateActivity.class);
                startActivity(intent);

            }
        });

        viewBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,ViewBooksActivity.class);
                startActivity(intent);

            }
        });
    }


}
