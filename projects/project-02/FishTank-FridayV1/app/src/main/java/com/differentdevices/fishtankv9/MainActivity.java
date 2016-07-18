package com.differentdevices.fishtankv9;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

//import android.app.SearchManager;
//import android.content.Context;
//import android.support.v7.widget.SearchView;
//import android.view.Menu;
//import android.view.MenuInflater;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor favoritesCursor;
    private ProductAdapter adapter;
    private List<ProductSingleton> productlist;
    private Dbase dbHelper;
    private final static String TAG = "Main Activity";
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Create an OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {


                    public void onItemClick(AdapterView<?> listView,
                                            View v,
                                            int position,
                                            long id) {
                        //when you click a category it will open the fish categories activity and tell it whether to display fish or coral

                        if (position == 0) {
                            int categorynumber = 0;
                            Intent intent = new Intent(MainActivity.this,
                                    com.differentdevices.fishtankv9.FishCategories.class);
                            intent.putExtra(com.differentdevices.fishtankv9.FishCategories.EXTRA_CATEGORYNO, categorynumber);
                            startActivity(intent);
                        }

                        if (position == 1) {
                            int categorynumber = 1;
                            Intent intent = new Intent(MainActivity.this,
                                    com.differentdevices.fishtankv9.FishCategories.class);
                            intent.putExtra(com.differentdevices.fishtankv9.FishCategories.EXTRA_CATEGORYNO, categorynumber);
                            startActivity(intent);
                        }

                        if (position == 2) {
                            int categorynumber = 2;
                            Intent intent = new Intent(MainActivity.this,
                                    com.differentdevices.fishtankv9.FishCategories.class);
                            intent.putExtra(com.differentdevices.fishtankv9.FishCategories.EXTRA_CATEGORYNO, categorynumber);
                            startActivity(intent);
                        }

                    }
                };


        //Add the listener to the list view
         listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);


        ListView listFavorites = (ListView) findViewById(R.id.list_favorites);

        try {
            SQLiteOpenHelper DatabaseHelper = new Dbase(this);
            db = DatabaseHelper.getReadableDatabase();

// TODO: 7/15/16 add favorites to database 
            favoritesCursor = db.query("PRODUCT_LIST",
                    new String[]{"_id", "TYPE", "NAME",}, "FAVORITE = 1",
                    null, null, null, null);

            CursorAdapter favoriteAdapter =
                    new SimpleCursorAdapter(MainActivity.this,
                            android.R.layout.simple_list_item_1,
                            favoritesCursor,
                            new String[]{"NAME"},
//                            new String[]{"TYPE"},
                            new int[]{android.R.id.text1}, 0);
            listFavorites.setAdapter(favoriteAdapter);
//


        } catch (SQLiteException e) {
//            e.printStackTrace();  //added tuesday
//            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
//            toast.show();
        }

        listFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    intent.putExtra(DetailsActivity.EXTRA_FISHNO, (int) id);
                    startActivity(intent);
                }


            }

        });
        handleIntent(getIntent());


    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        favoritesCursor.close();
        db.close();
    }

//    public void onRestart() {
//
//        super.onRestart();
//
//
//        try {
//            Dbase DatabaseHelper = new Dbase(this);
//            db = DatabaseHelper.getReadableDatabase();
//            Cursor fishCursor = db.query("PRODUCT_LIST",
//                    new String[] { "_id", "TYPE", "NAME"},
//                    "FAVORITE = 1",
//                    null, null, null, null);
//
//            Log.d("Message", fishCursor.getColumnName(1));
//
//            ListView listFavoritesFish = (ListView)findViewById(R.id.list_favorites);
//
//            CursorAdapter adapterFish = (CursorAdapter) listFavoritesFish.getAdapter();
//            adapterFish.changeCursor(fishCursor);
//            listFavoritesFish.setAdapter(adapterFish);
//
//            favoritesCursor = fishCursor;
//        }
//
//        catch(SQLiteException e) {
//            e.printStackTrace();
//            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
//            toast.show();
//        }
//
//    }

    //search function goes here


    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            Log.d(TAG, "handling intent");
            String query = intent.getStringExtra(SearchManager.QUERY);
            dbHelper = Dbase.getInstance(this);

            productlist = dbHelper.searchProductList(query);
            adapter = new ProductAdapter(productlist, LayoutInflater.from(MainActivity.this), true);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


        searchView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View view) {
                Log.i(TAG, "onViewAttachedToWindow: ");
            }

            @Override
            public void onViewDetachedFromWindow(View view) {
                Log.i(TAG, "onViewDetachedFromWindow: ");
                productlist = Dbase.getInstance(MainActivity.this).getProduct();
                adapter = new ProductAdapter(productlist, LayoutInflater.from(MainActivity.this), true);

                handleIntent(getIntent());

                listView.setAdapter(adapter);
            }
        });


        return true;
    }
}
