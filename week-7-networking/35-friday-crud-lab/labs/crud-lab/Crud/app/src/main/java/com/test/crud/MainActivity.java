package com.test.crud;

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

import com.test.crud.Models.Books;
import com.test.crud.Models.Library;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    List<Books> books;
    Button addNewBook;
    JsonaAdapter jsonaAdapter;
    public static String baseUrl = "https://super-crud.herokuapp.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        getLibrary();
        //gets the book at the position from the array of books we called for and is sent to detail activity.
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Books curBook = books.get(i);
                intent.putExtra("book",curBook);
                startActivity(intent);

            }
        });
        //gets the book from the array of books and sends it to delete method for deletion.
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Books deleteBook = books.get(i);
                String id = deleteBook.get_id();
                deleteBook(id);
                getLibrary();
                Toast.makeText(getBaseContext(), "Removed Book" , Toast.LENGTH_SHORT ).show();
                return true;
            }
        });

        addNewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddBookActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void setViews(){
        addNewBook = (Button) findViewById(R.id.add_book);
        mListView = (ListView) findViewById(R.id.book_list);
    }

    @Override
    protected void onResume() {
        getLibrary();
        super.onResume();
    }

    protected void getLibrary(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            BookService service = retrofit.create(BookService.class);

            Call<Library> call = service.getLibrary();

            call.enqueue(new Callback<Library>() {
                @Override
                public void onResponse(Call<Library> call, Response<Library> response) {

                    try{
                        books = response.body().getBooks();
                        jsonaAdapter = new JsonaAdapter(books, MainActivity.this);
                        mListView.setAdapter(jsonaAdapter);

                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(Call<Library> call, Throwable t) {

                }
            });
        }
        else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }

    protected void deleteBook(String id){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(MainActivity.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            BookService service = retrofit.create(BookService.class);

            Call<Books> call = service.deleteBook(id);

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
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }
}
