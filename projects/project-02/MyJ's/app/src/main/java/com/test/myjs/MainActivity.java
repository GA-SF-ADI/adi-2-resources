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


            Shoe shoe1 = new Shoe(1, "Jordan I", " red and white high top ", 149.99, "High top", 1984, R.drawable.j_1,"white");
            Shoe shoe2 = new Shoe(2, "Jordan II", " white and red high top ", 109.99, "High top", 1987, R.drawable.j_2,"white");
            Shoe shoe3 = new Shoe(3, "Jordan III", " white and red high top ", 129.99, "High top", 1988, R.drawable.j_3,"white");
            Shoe shoe4 = new Shoe(4, "Jordan IV", " black high top ", 139.99, "High top", 1989, R.drawable.j_4,"black");
            Shoe shoe5 = new Shoe(5, "Jordan V", " black grey high top", 159.99, "High top", 1990, R.drawable.j_5,"black");
            Shoe shoe6 = new Shoe(6, "Jordan VI", " black red high top", 149.99, "High top", 1991, R.drawable.j_6,"black");
            Shoe shoe7 = new Shoe(7, "Jordan VII", "white and red high top ", 149.99, "High top", 1992, R.drawable.j_7,"black");
            Shoe shoe8 = new Shoe(8, "Jordan VIII", " white and black high top ", 139.99, "High top", 1993, R.drawable.j_8,"white");
            Shoe shoe9 = new Shoe(9, "Jordan IX", " white and black high top ", 129.99, "High top", 1994, R.drawable.j_9,"white");
            Shoe shoe10 = new Shoe(10, "Jordan X", " white and black high top ", 119.99, "High top", 1995, R.drawable.j_10,"white");
            Shoe shoe11 = new Shoe(11, "Jordan XI", " white and black high top ", 149.99, "High top", 1996, R.drawable.j_11,"white");
            Shoe shoe12 = new Shoe(12, "Jordan XII", " white and black high top", 159.99, "High top", 1997, R.drawable.j_12,"white");
            Shoe shoe13 = new Shoe(13, "Jordan XIII", " black and red high top ", 169.99, "High top", 1998, R.drawable.j_13,"black");
            Shoe shoe14 = new Shoe(14, "Jordan XIV", "black and red high top ", 149.99, "High top", 1999, R.drawable.j_14,"black");
            Shoe shoe15 = new Shoe(15, "Jordan XV", " all black high top ", 149.99, "High top", 2000, R.drawable.j_15,"black");
            Shoe shoe16 = new Shoe(16, "Jordan XVI", " all black high top ", 159.99, "High top", 2001, R.drawable.j_16,"black");
            Shoe shoe17 = new Shoe(17, "Jordan XVII", " white and blue high top", 169.99, "High top", 2002, R.drawable.j_17,"white");
            Shoe shoe18 = new Shoe(18, "Jordan XVIII", " black and blue high top ", 159.99, "High top", 2003, R.drawable.j_18,"black");
            Shoe shoe19 = new Shoe(19, "Jordan XIV", " black and red high top", 149.99, "High top", 2004, R.drawable.j_19,"black");
            Shoe shoe20 = new Shoe(20, "Jordan XX", " white and black high top ", 159.99, "High top", 2005, R.drawable.j_20,"white");
            Shoe shoe21 = new Shoe(21, "Jordan XXI", " all red high top", 119.99, "High top", 2006, R.drawable.j_21,"red");
            Shoe shoe22 = new Shoe(22, "Jordan XXII", " white high top", 129.99, "High top", 2007, R.drawable.j_22,"white");
            Shoe shoe23 = new Shoe(23, "Jordan XXIII", " black high top", 149.99, "High top", 2008, R.drawable.j_23,"black");


            ShoeOpenHelper helper = ShoeOpenHelper.getInstance(MainActivity.this);
            helper.insertRowShoes(shoe1);
            helper.insertRowShoes(shoe2);
            helper.insertRowShoes(shoe3);
            helper.insertRowShoes(shoe4);
            helper.insertRowShoes(shoe5);
            helper.insertRowShoes(shoe6);
            helper.insertRowShoes(shoe7);
            helper.insertRowShoes(shoe8);
            helper.insertRowShoes(shoe9);
            helper.insertRowShoes(shoe10);
            helper.insertRowShoes(shoe11);
            helper.insertRowShoes(shoe12);
            helper.insertRowShoes(shoe13);
            helper.insertRowShoes(shoe14);
            helper.insertRowShoes(shoe15);
            helper.insertRowShoes(shoe16);
            helper.insertRowShoes(shoe17);
            helper.insertRowShoes(shoe18);
            helper.insertRowShoes(shoe19);
            helper.insertRowShoes(shoe20);
            helper.insertRowShoes(shoe21);
            helper.insertRowShoes(shoe22);
            helper.insertRowShoes(shoe23);

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

