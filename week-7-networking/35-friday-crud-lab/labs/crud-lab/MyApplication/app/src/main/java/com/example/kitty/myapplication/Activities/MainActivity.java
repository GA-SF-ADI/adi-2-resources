package com.example.kitty.myapplication.Activities;

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
import android.widget.Toast;

import com.example.kitty.myapplication.BookInterface;
import com.example.kitty.myapplication.CustomAdapter;
import com.example.kitty.myapplication.Models.Book;
import com.example.kitty.myapplication.Models.Library;
import com.example.kitty.myapplication.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String baseURL = "https://super-crud.herokuapp.com";

    private BookInterface bookInterface;
    private List<Book> booksList;
    private CustomAdapter adapter;
    private Button addNewButton;
    private ListView bookListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpBookList();
        setUpAddNewButton();
    }

    public void setUpAddNewButton() {
        addNewButton = (Button) findViewById(R.id.add_new_button);
        addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);

                startActivityForResult(intent, 123);
            }
        });
    }

    public void setUpBookList() {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            bookListView = (ListView) findViewById(R.id.books_list);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            bookInterface = retrofit.create(BookInterface.class);

            bookInterface.getBooks().enqueue(new Callback<Library>() {
                @Override
                public void onResponse(Call<Library> call, Response<Library> response) {
                    booksList = response.body().getBooks();
                    adapter = new CustomAdapter(booksList, MainActivity.this);
                    bookListView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<Library> call, Throwable t) {

                }
            });

            bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                    Book currentBook = booksList.get(i);
                    intent.putExtra("id", currentBook.getId());
                    startActivity(intent);
                }
            });
        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 123) {
            if (resultCode == RESULT_OK) {
                setUpBookList();
            }
        }
    }
}
