package com.test.bookscanner2.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.test.bookscanner2.adapters.CustomBookListRecyclerViewAdapter;
import com.test.bookscanner2.R;

import java.util.ArrayList;

public class BookListActvity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;

    private ArrayList<String> dataList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list_actvity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView =(RecyclerView) findViewById(R.id.book_list_recycler_view);

        dataList.add("Arizona");
        dataList.add("California");
        dataList.add("New Mexico");
        dataList.add("New York");

        // linear layout manager for lists
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);

        // create the custom adapter with our data and set it on the recyclerView
        rvAdapter = new CustomBookListRecyclerViewAdapter(dataList);
        recyclerView.setAdapter(rvAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
