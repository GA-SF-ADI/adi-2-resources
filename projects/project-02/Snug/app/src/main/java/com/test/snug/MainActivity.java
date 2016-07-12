package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Hat> hatList = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Context context = getApplicationContext();
        SQLiteOpenHelper db = new SQLiteOpenHelper(context);

        ImageButton cartButtonInToolbar = (ImageButton) findViewById(R.id.button_in_toolbar_to_view_cart);
        ImageButton searchButtonInToolbar = (ImageButton) findViewById(R.id.button_in_toolbar_to_search_for_hats);

//        TODO: Set text to # of cart items
/*
        TextView cartItemCounter = (TextView) findViewById(R.id.textview_num_of_hats_in_cart);
        cartItemCounter.setText(__);
*/


//        TODO: Add hats below!(int id, int picture, double price, String material, int fittedOrSnap, String description, String color


//        TODO: Eventually will have to fetch hat records?

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(context, 2);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyRecyclerViewAdapter(getDataSet(), context);

        mRecyclerView.setAdapter(mAdapter);

            /*RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);

            mRecyclerView.addItemDecoration(itemDecoration);*/


        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
        insertHatData();


       /* individualHatCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SingleHatViewActivity.class);
                startActivity(intent);

            }
        });
*/

        cartButtonInToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
                startActivity(intent);

            }
        });

        searchButtonInToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);

            }
        });


    }

    private ArrayList<Hat> getDataSet() {
        ArrayList results = new ArrayList<Hat>();

        results.add(new Hat(0, 4, "SF Giants", 39, "100% Cotton", 0, "Plush and soft, this hat will keep you comfortable", "black"));
        results.add(new Hat(1, 1, "Oakland", 29, "50% Cotton", 1, "Great for a day at the beach!", "green"));
        results.add(new Hat(2, 3, "Boston", 19, "100% Polyester", 1, "Play the outfield with confidence", "red"));
        results.add(new Hat(3, 2, "Yankees", 59, "50% Polyester", 0, "Turn a double play in this stylish hat", "dark blue"));

        return results;
    }

    private void insertHatData() {

        SQLiteOpenHelper db = new SQLiteOpenHelper(this);

        db.addHat(0, "SF Giants", 4, 39, "100% Cotton", 0, "Plush and soft, this hat will keep you comfortable", "black");
        db.addHat(1, "Oakland", 1, 29, "50% Cotton", 1, "Great for a day at the beach!", "green");
        db.addHat(2, "Boston", 3, 19, "100% Polyester", 1, "Play the outfield with confidence", "red");
        db.addHat(3, "Yankees", 2, 59, "50% Polyester", 0, "Turn a double play in this stylish hat", "dark blue");


        mAdapter.notifyDataSetChanged();


        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Log.d(LOG_TAG, "Hat item clicked");
                Intent intent = new Intent(MainActivity.this, SingleHatViewActivity.class);
                startActivity(intent);

            }
        });


    }


}

