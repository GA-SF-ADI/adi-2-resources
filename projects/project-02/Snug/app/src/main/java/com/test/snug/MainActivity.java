package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Context context = getApplicationContext();

        ImageButton viewCartButton = (ImageButton) findViewById(R.id.button_in_toolbar_to_view_cart);
        viewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });


//        TODO: Get instance of database helper to make database/tables

//        TODO: Add hats below!(int id, int picture, double price, String material, int fittedOrSnap, String description, String color


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

//        TODO: Eventually will have to fetch hat records?

    }

    private ArrayList<Hat> getDataSet() {
        ArrayList results = new ArrayList<Hat>();
        for (int index = 0; index < 20; index++) {
            Hat hat = new Hat(index, 4, "SF Giants", 39, "100% Cotton", 0, "Plush and soft, this hat will keep you comfortable", "black");
            results.add(index, hat);
        }
        return results;
    }

    private void insertHatData() {

        SQLiteOpenHelper db = new SQLiteOpenHelper(this);

        db.addHat(0, "SF Giants", 4, 39, "100% Cotton", 0, "Plush and soft, this hat will keep you comfortable", "black");
        db.addHat(1, "Oakland", 1, 29, "50% Cotton", 1, "Great for a day at the beach!", "green");
        db.addHat(2, "Boston", 3, 19, "100% Polyester", 1, "Play the outfield with confidence", "red");
        db.addHat(3, "Yankees", 2, 59, "50% Polyester", 0, "Turn a double play in this stylish hat", "dark blue");


        /*Hat hat = new Hat(1, 4, "SF Giants", "39.99", "100% Cotton", 3, "Plush and soft, this hat will keep you comfortable", "black");
        hatList.add(hat);

        Hat hat2 = new Hat(1, 4, "Oakland", "39.99", "100% Cotton", 3, "Plush and soft, this hat will keep you comfortable", "black");
        hatList.add(hat2);

        Hat hat3 = new Hat(1, 4, "Seattle", "39.99", "100% Cotton", 3, "Plush and soft, this hat will keep you comfortable", "black");
        hatList.add(hat3);

        Hat hat4 = new Hat(1, 4, "Boston", "39.99", "100% Cotton", 3, "Plush and soft, this hat will keep you comfortable", "black");
        hatList.add(hat4);

        Hat hat5 = new Hat(1, 4, "Yankees", "39.99", "100% Cotton", 3, "Plush and soft, this hat will keep you comfortable", "black");
        hatList.add(hat5);

        mAdapter.notifyDataSetChanged();
*/


        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Log.d(LOG_TAG, "Hat item clicked");
                Intent intent = new Intent(MainActivity.this, SingleHatViewActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();


    }



}

