package com.example.hollis.booksapi.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.hollis.booksapi.Models.Book;
import com.example.hollis.booksapi.Models.BookResult;
import com.example.hollis.booksapi.Adapters.CustomBookAdapter;
import com.example.hollis.booksapi.PracticeAPIService;
import com.example.hollis.booksapi.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button getBooksButton, makeBookButton;
    PracticeAPIService apiService;
    Book[] data;
    CustomBookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://super-crud.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         apiService = retrofit.create(PracticeAPIService.class);
        setOnClickListener();

    }
    public void setViews(){
        listView = (ListView) findViewById(R.id.list_view);
        getBooksButton = (Button) findViewById(R.id.activity_main_get_books);
        makeBookButton = (Button) findViewById(R.id.activity_main_make_book);
    }

    public void setOnClickListener(){
        getBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiService.listBooks().enqueue(new Callback<BookResult>() {
                    @Override
                    public void onResponse(Call<BookResult> call, Response<BookResult> response) {
                        data = response.body().getBooks();
                         adapter = new CustomBookAdapter(response.body().getBooks(), MainActivity.this);
                        listView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<BookResult> call, Throwable t) {
                        Log.d("MainActivity", "GetBooks API call failed");
                        t.printStackTrace();
                    }
                });
            }
        });
        makeBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewBookActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book curBook = data[position];
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("ID", curBook.get_id());
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                apiService.deleteBook(data[position].get_id()).enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {

                    }
                });
                return false;
            }
        });
    }
}
