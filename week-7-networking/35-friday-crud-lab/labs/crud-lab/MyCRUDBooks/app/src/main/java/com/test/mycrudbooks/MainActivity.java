package com.test.mycrudbooks;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String baseUrl = "https://super-crud.herokuapp.com";
    ListView bookListView;
    private Button addBook;
    private ArrayList<Book> bookList;
    private Button getBooksBttn;
    public static String CURRENT_BOOK="current book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setButtonListeners();




        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                Book currentItem = bookList.get(position);
                intent.putExtra(CURRENT_BOOK, currentItem);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        getBooks(bookList);
    }

    //method for getting list of books from superCrud website
    public void getBooks(final ArrayList<Book> books) {
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
            Call<Example> call = bookService.getBooks();


            //executing the call and updating views

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    try {
                        bookList = (ArrayList<Book>) response.body().getBooks();
                        CustomAdapter adapter = new CustomAdapter(MainActivity.this, bookList);
                        bookListView.setAdapter(adapter);

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
            Toast.makeText(MainActivity.this,"no connection is available",Toast.LENGTH_SHORT).show();
        }

    }
    public void findViews(){
        getBooksBttn = (Button) findViewById(R.id.get_books_bttn);
        bookListView = (ListView) findViewById(R.id.books_lv);
        addBook = (Button)findViewById(R.id.add_book_home);
    }
    public void setButtonListeners(){
        getBooksBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onClick running getBooks method to get books list
                getBooks(bookList);
            }
        });
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // onClick starting a NewBook activity
                Intent addIntent = new Intent(MainActivity.this, NewBook.class);
                startActivity(addIntent);
            }
        });

    }
}
