package com.test.crudlabappfinal;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static String baseUrl = "https://super-crud.herokuapp.com";
    private String TAG = "Main Activity";
    FloatingActionButton fab;
    ListView listView;
    Book[] bookArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listView_of_books);

        getAllBooks();

        handleIntent(getIntent());

        setFABlistener();


    }

    @Override
    protected void onResume() {

        getAllBooks();

        super.onResume();
    }

    //    TODO: Finish this getAllBooks method

    private void getAllBooks() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookInterface service = retrofit.create(BookInterface.class);

        Call<BookData> call = service.getAllBooks();

        call.enqueue(new Callback<BookData>() {
            @Override
            public void onResponse(Call<BookData> call, Response<BookData> response) {

                try {


                    Log.i(TAG, "onResponse: ");
                    bookArray = response.body().getBooks();

                    setListViewAdapter();


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<BookData> call, Throwable t) {

                t.printStackTrace();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());

        // Associate searchable info with the SearchView
        SearchView searchView = (SearchView) menu.findItem(R.id.searchView_in_main_activity).getActionView();
        searchView.setSearchableInfo(searchableInfo);

        // Return true to show menu, returning false will not show it.
        return true;
    }


    @Override
    protected void onNewIntent(Intent searchIntent) {
        handleIntent(searchIntent);
    }

    private void handleIntent(Intent searchIntent) {

        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())) {

//            TODO: Finish this section. Need to update the listView.

            String query = searchIntent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(MainActivity.this, "Searching for " + query, Toast.LENGTH_SHORT).show();

//            TODO: Notify adapter change

        }
    }

    private void setFABlistener() {
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent createNewBookIntent = new Intent(MainActivity.this, CreateBookActivity.class);
                startActivity(createNewBookIntent);

            }
        });

    }

    private void setListViewAdapter() {


        ListViewAdapter customBaseAdapter = new ListViewAdapter(bookArray, MainActivity.this);

        listView.setAdapter(customBaseAdapter);

    }


}
