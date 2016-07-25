package com.test.apipractice2;
import android.os.Bundle;

import com.squareup.picasso.Picasso;
import com.test.apipractice2.models.Root;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ViewBooksAdapter mAdapter;
    private BookInterface bookInterface;
    private String BASE_URL = "https://super-crud.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpBooks();

        listView = (ListView) findViewById(R.id.listView);


        bookInterface.getBooks().enqueue(new retrofit2.Callback<Root>() {
            @Override
            public void onResponse(retrofit2.Call<Root>call, retrofit2.Response<Root>response) {
                Root root = response.body();
                mAdapter = new ViewBooksAdapter(MainActivity.this,Arrays.asList(root.getBooks()));
                mAdapter.notifyDataSetChanged();
                listView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(retrofit2.Call<Root> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this,"No WIFI", Toast.LENGTH_LONG).show();
            }

        });
    }

    private void setUpBooks() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        bookInterface = retrofit.create(BookInterface.class);
    }

}
