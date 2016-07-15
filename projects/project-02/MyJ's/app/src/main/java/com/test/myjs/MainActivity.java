package com.test.myjs;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnShoeSelectClickListener{
    ShoeOpenHelper mHelper;
    PagerAdapter adapter;
    ViewPager viewPager;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        handleIntent(getIntent());
        //inflate menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // set searchManager and searchableInfo
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());

        // link searchable info with the SearchView
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchableInfo);

        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set toolbar view, set app logo
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.jordan_logo);
        mHelper = new ShoeOpenHelper(MainActivity.this);
        insertDatabaseValues();
        setPageView();


    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    //running handleIntent which calls checks if there was a search, displays toast with search query
    //calling setQuery(), to send query to viewpager, tab is switched to search fragment tab when a search is made
    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(MainActivity.this, "Searching for " + query, Toast.LENGTH_SHORT).show();
            adapter.setQuery(query);
            viewPager.setCurrentItem(1);
            Log.d("mainActivity query","result:"+query);


        }

    }

    // creating shoe objects and populating database with shoes
    public void insertDatabaseValues() {
        if (mHelper.getShoesList().getCount()==0) {


            Shoe shoe1 = new Shoe(1, "Jordan I".toUpperCase(), " red and white high top ".toUpperCase(), 149.99, "High top".toLowerCase(), 1984, R.drawable.j_1,"white".toUpperCase());
            Shoe shoe2 = new Shoe(2, "Jordan II".toUpperCase(), " white and red high top ".toUpperCase(), 109.99, "High top".toUpperCase(), 1987, R.drawable.j_2,"white".toUpperCase());
            Shoe shoe3 = new Shoe(3, "Jordan III".toUpperCase(), " white and red high top ".toUpperCase(), 129.99, "High top".toUpperCase(), 1988, R.drawable.j_3,"white".toUpperCase());
            Shoe shoe4 = new Shoe(4, "Jordan IV".toUpperCase(), " black high top ".toUpperCase(), 139.99, "High top".toUpperCase(), 1989, R.drawable.j_4,"black".toUpperCase());
            Shoe shoe5 = new Shoe(5, "Jordan V".toUpperCase(), " black grey high top".toUpperCase(), 159.99, "High top".toUpperCase(), 1990, R.drawable.j_5,"black".toUpperCase());
            Shoe shoe6 = new Shoe(6, "Jordan VI".toUpperCase(), " black red high top".toUpperCase(), 149.99, "High top".toUpperCase(), 1991, R.drawable.j_6,"black".toUpperCase());
            Shoe shoe7 = new Shoe(7, "Jordan VII".toUpperCase(), "white and red high top ".toUpperCase(), 149.99, "High top".toUpperCase(), 1992, R.drawable.j_7,"black".toUpperCase());
            Shoe shoe8 = new Shoe(8, "Jordan VIII".toUpperCase(), " white and black high top ".toUpperCase(), 139.99, "High top".toUpperCase(), 1993, R.drawable.j_8,"white".toUpperCase());
            Shoe shoe9 = new Shoe(9, "Jordan IX".toUpperCase(), " white and black high top ".toUpperCase(), 129.99, "High top".toUpperCase(), 1994, R.drawable.j_9,"white".toUpperCase());
            Shoe shoe10 = new Shoe(10, "Jordan X".toUpperCase(), " white and black high top ".toUpperCase(), 119.99, "High top".toUpperCase(), 1995, R.drawable.j_10,"white".toUpperCase());
            Shoe shoe11 = new Shoe(11, "Jordan XI".toUpperCase(), " white and black high top ".toUpperCase(), 149.99, "High top".toUpperCase(), 1996, R.drawable.j_11,"white".toUpperCase());
            Shoe shoe12 = new Shoe(12, "Jordan XII".toUpperCase(), " white and black high top".toUpperCase(), 159.99, "High top".toUpperCase(), 1997, R.drawable.j_12,"white".toUpperCase());
            Shoe shoe13 = new Shoe(13, "Jordan XIII".toUpperCase(), " black and red high top ".toUpperCase(), 169.99, "High top".toUpperCase(), 1998, R.drawable.j_13,"black".toUpperCase());
            Shoe shoe14 = new Shoe(14, "Jordan XIV".toUpperCase(), "black and red high top ".toUpperCase(), 149.99, "High top".toUpperCase(), 1999, R.drawable.j_14,"black".toUpperCase());
            Shoe shoe15 = new Shoe(15, "Jordan XV".toUpperCase(), " all black high top ".toUpperCase(), 149.99, "High top".toUpperCase(), 2000, R.drawable.j_15,"black".toUpperCase());
            Shoe shoe16 = new Shoe(16, "Jordan XVI".toUpperCase(), " all black high top ".toUpperCase(), 159.99, "High top".toUpperCase(), 2001, R.drawable.j_16,"black".toUpperCase());
            Shoe shoe17 = new Shoe(17, "Jordan XVII".toUpperCase(), " white and blue high top".toUpperCase(), 169.99, "High top".toUpperCase(), 2002, R.drawable.j_17,"white".toUpperCase());
            Shoe shoe18 = new Shoe(18, "Jordan XVIII".toUpperCase(), " black and blue high top ".toUpperCase(), 159.99, "High top".toUpperCase(), 2003, R.drawable.j_18,"black".toUpperCase());
            Shoe shoe19 = new Shoe(19, "Jordan XIV".toUpperCase(), " black and red high top".toUpperCase(), 149.99, "High top".toUpperCase(), 2004, R.drawable.j_19,"black".toUpperCase());
            Shoe shoe20 = new Shoe(20, "Jordan XX".toUpperCase(), " white and black high top ".toUpperCase(), 159.99, "High top".toUpperCase(), 2005, R.drawable.j_20,"white".toUpperCase());
            Shoe shoe21 = new Shoe(21, "Jordan XXI".toUpperCase(), " all red high top".toUpperCase(), 119.99, "High top".toUpperCase(), 2006, R.drawable.j_21,"red".toUpperCase());
            Shoe shoe22 = new Shoe(22, "Jordan XXII".toUpperCase(), " white high top".toUpperCase(), 129.99, "High top".toUpperCase(), 2007, R.drawable.j_22,"white".toUpperCase());
            Shoe shoe23 = new Shoe(23, "Jordan XXIII".toUpperCase(), " black high top".toUpperCase(), 149.99, "High top".toUpperCase(), 2008, R.drawable.j_23,"black".toUpperCase());



            mHelper.insertRowShoes(shoe1);
            mHelper.insertRowShoes(shoe2);
            mHelper.insertRowShoes(shoe3);
            mHelper.insertRowShoes(shoe4);
            mHelper.insertRowShoes(shoe5);
            mHelper.insertRowShoes(shoe6);
            mHelper.insertRowShoes(shoe7);
            mHelper.insertRowShoes(shoe8);
            mHelper.insertRowShoes(shoe9);
            mHelper.insertRowShoes(shoe10);
            mHelper.insertRowShoes(shoe11);
            mHelper.insertRowShoes(shoe12);
            mHelper.insertRowShoes(shoe13);
            mHelper.insertRowShoes(shoe14);
            mHelper.insertRowShoes(shoe15);
            mHelper.insertRowShoes(shoe16);
            mHelper.insertRowShoes(shoe17);
            mHelper.insertRowShoes(shoe18);
            mHelper.insertRowShoes(shoe19);
            mHelper.insertRowShoes(shoe20);
            mHelper.insertRowShoes(shoe21);
            mHelper.insertRowShoes(shoe22);
            mHelper.insertRowShoes(shoe23);

        }

    }
        //setting viewpager and adapter
    public void setPageView() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("HOME"));
        tabLayout.addTab(tabLayout.newTab().setText("SEARCH"));
        tabLayout.addTab(tabLayout.newTab().setText("SHOPPING CART"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);
                adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onShoeSelected(long id) {
        //interface receives shoe Id from homeFragment
        //sends intent with shoe id to detailsActivity
        Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
        intent.putExtra("Shoe Id",id);
        startActivity(intent);


    }
}

