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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.listView_of_books);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        ImageButton deleteBookButton = (ImageButton) findViewById(R.id.imageButton_delete_book_x);

//        TODO: Make GET call to get full list of books



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent createNewBookIntent = new Intent(MainActivity.this, CreateBookActivity.class);
                startActivity(createNewBookIntent);


            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent editBookIntent = new Intent(MainActivity.this, EditBookActivity.class);
                startActivity(editBookIntent);


            }
        });


        handleIntent(getIntent());

        deleteBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                TODO: Make delete book call

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


}
