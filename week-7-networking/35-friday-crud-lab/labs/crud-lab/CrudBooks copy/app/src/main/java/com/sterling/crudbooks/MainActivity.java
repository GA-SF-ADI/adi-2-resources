package com.sterling.crudbooks;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String baseUrl = "https://super-crud.herokuapp.com";
    private Button addBook;
    private ArrayList<Book> library;
    private Button pullBooksButton;
    public static String CURRENT_BOOK="current book";
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        consolidateViews();
        consolidateListeners();




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                Book currentItem = library.get(position);
                intent.putExtra(CURRENT_BOOK, currentItem);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        pullLibrary(library);
    }
//method to pull books from API
    public void pullLibrary(final ArrayList<Book> books) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            RetroInterface retroInterface = retrofit.create(RetroInterface.class);
            Call<Example> call = retroInterface.getBooks();

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    try {
                        library = (ArrayList<Book>) response.body().getBooks();
                        BookAdapter adapter = new BookAdapter(MainActivity.this, library);
                        listView.setAdapter(adapter);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });

    }}
    public void consolidateViews(){
        pullBooksButton = (Button) findViewById(R.id.pulllibrary);
       listView = (ListView) findViewById(R.id.listview);
        addBook = (Button)findViewById(R.id.add);
    }
    public void consolidateListeners(){
        pullBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pullLibrary(library);
            }
        });
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent addIntent = new Intent(MainActivity.this, AddBook.class);
                startActivity(addIntent);
            }
        });

    }
}