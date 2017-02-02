package com.test.supercrud;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

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

public class ViewBooksActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Books> booksArrayList;
    ViewBooksAdapter mAdapter;
    Button deleteButton;

    private SuperCrudInterface superCrudInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_books);
        setupBooks();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.listView);
        deleteButton = (Button) findViewById(R.id.button_delete);

//
//        Intent intent = getIntent();
//        String title = intent.getExtras().getString("Title");
//        String author = intent.getExtras().getString("Author");
//        String image = intent.getExtras().getString("Image");
//
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int pos = listView.getCheckedItemPosition();
                if(pos > -1) {
                    //mAdapter.remove(postition);
                }

            }
        });


        //3. Created my model classes (books and root)
        //what users are directed to first

        superCrudInterface.getBooks().enqueue(new retrofit2.Callback<Root>() {
            @Override
            public void onResponse(retrofit2.Call<Root> call, retrofit2.Response<Root> response) {
                // grab the two objects from the response
                //STEP 5: use AuthenticationResponse object to get response
                //get the user if you want to

                Root root = response.body();
                mAdapter = new ViewBooksAdapter(ViewBooksActivity.this, Arrays.asList(root.getBooks()));
                mAdapter.notifyDataSetChanged();
                //change adapter to list
                listView.setAdapter(mAdapter);
                //set up adapter here

            }

            @Override
            public void onFailure(retrofit2.Call<Root> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(ViewBooksActivity.this, "No WIFI", Toast.LENGTH_LONG).show();

            }

        });
    }


    private void setupBooks() {
        // 5. Create retrofit instance with a base url and GsonConverter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        superCrudInterface = retrofit.create(SuperCrudInterface.class);
    }

}
