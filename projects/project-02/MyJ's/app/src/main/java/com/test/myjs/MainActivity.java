package com.test.myjs;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnRandImageClickListener{
    private ShoeOpenHelper mHelper;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        handleIntent(getIntent());

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Find searchManager and searchableInfo
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());

        // Associate searchable info with the SearchView
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchableInfo);

        // Return true to show menu, returning false will not show it.
        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mHelper = new ShoeOpenHelper(MainActivity.this);
        insertDatabaseValues();
        setPageView();


    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(MainActivity.this, "Searching for " + query, Toast.LENGTH_SHORT).show();
        }

    }

    public void insertDatabaseValues() {
        if (mHelper.getShoesList().getCount()==0) {


            Shoe shoe1 = new Shoe(1, "Jordan 1", " ", 109.99, "High top", 1984, R.drawable.j_1);
            Shoe shoe2 = new Shoe(2, "Jordan 2", " ", 109.99, "High top", 1987, R.drawable.j_2);
            Shoe shoe3 = new Shoe(3, "Jordan 3", " ", 109.99, "High top", 1988, R.drawable.j_3);
            Shoe shoe4 = new Shoe(4, "Jordan 4", " ", 109.99, "High top", 1989, R.drawable.j_4);
            Shoe shoe5 = new Shoe(5, "Jordan 5", " ", 109.99, "High top", 1990, R.drawable.j_5);
            Shoe shoe6 = new Shoe(6, "Jordan 6", " ", 109.99, "High top", 1991, R.drawable.j_6);
            Shoe shoe7 = new Shoe(7, "Jordan 7", " ", 109.99, "High top", 1992, R.drawable.j_7);
            Shoe shoe8 = new Shoe(8, "Jordan 8", " ", 109.99, "High top", 1993, R.drawable.j_8);
            Shoe shoe9 = new Shoe(9, "Jordan 9", " ", 109.99, "High top", 1994, R.drawable.j_9);
            Shoe shoe10 = new Shoe(10, "Jordan 10", " ", 109.99, "High top", 1995, R.drawable.j_10);
            Shoe shoe11 = new Shoe(11, "Jordan 11", " ", 109.99, "High top", 1996, R.drawable.j_11);
            Shoe shoe12 = new Shoe(12, "Jordan 12", " ", 109.99, "High top", 1997, R.drawable.j_12);
            Shoe shoe13 = new Shoe(13, "Jordan 13", " ", 109.99, "High top", 1998, R.drawable.j_13);
            Shoe shoe14 = new Shoe(14, "Jordan 14", " ", 109.99, "High top", 1999, R.drawable.j_14);
            Shoe shoe15 = new Shoe(15, "Jordan 15", " ", 109.99, "High top", 2000, R.drawable.j_15);
            Shoe shoe16 = new Shoe(16, "Jordan 16", " ", 109.99, "High top", 2001, R.drawable.j_16);
            Shoe shoe17 = new Shoe(17, "Jordan 17", " ", 109.99, "High top", 2002, R.drawable.j_17);
            Shoe shoe18 = new Shoe(18, "Jordan 18", " ", 109.99, "High top", 2003, R.drawable.j_18);
            Shoe shoe19 = new Shoe(19, "Jordan 19", " ", 109.99, "High top", 2004, R.drawable.j_19);
            Shoe shoe20 = new Shoe(20, "Jordan 20", " ", 109.99, "High top", 2005, R.drawable.j_20);
            Shoe shoe21 = new Shoe(21, "Jordan 21", " ", 109.99, "High top", 2006, R.drawable.j_21);
            Shoe shoe22 = new Shoe(22, "Jordan 22", " ", 109.99, "High top", 2007, R.drawable.j_22);
            Shoe shoe23 = new Shoe(23, "Jordan 23", " ", 109.99, "High top", 2008, R.drawable.j_23);


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

    public void setPageView() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("HOME"));
        tabLayout.addTab(tabLayout.newTab().setText("SEARCH"));
        tabLayout.addTab(tabLayout.newTab().setText("SHOPPING CART"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
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
    public void onRandImageSelected(int position) {
        // need to make a static final for tag

        Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
        intent.putExtra("Position",position);
        startActivity(intent);
    }
}

