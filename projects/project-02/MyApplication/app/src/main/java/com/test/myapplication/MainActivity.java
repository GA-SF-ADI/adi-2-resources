package com.test.myapplication;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView mainListView;
    SearchView searchView;
    DataBaseHelper mHelper;
    CustomAlcAdapter mAdapter;
    Alcohol mAlcohol;
    MenuItem mCartButton;
    Cart mCartItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = DataBaseHelper.getInstance(this);
        addData();

        mainListView = (ListView) findViewById(R.id.main_list_view);
        Cursor cursor = mHelper.getAlcoholList();
        mAdapter = new CustomAlcAdapter(this, cursor,0);
        mainListView.setAdapter(mAdapter);

        handleIntent(getIntent());

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                mAlcohol = mHelper.getAlcohol(l);
                intent.putExtra("alc", mAlcohol);
                startActivity(intent);
            }
        });

        mainListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                mAlcohol = mHelper.getAlcohol(l);
                mCartItem = new Cart(1,mAlcohol.getAlcId());
                mHelper.addCart(mCartItem);
                Toast.makeText(getBaseContext(), "Added item to cart" , Toast.LENGTH_LONG ).show();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.alc_menu, menu);
        mCartButton = menu.findItem(R.id.shopping_cart);
        mCartButton.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(MainActivity.this,CartActivity.class);
                startActivity(intent);
                return false;
            }
        });

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());

        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("Search by name, price, or abv!");
        searchView.setSearchableInfo(searchableInfo);

        return true;
    }



    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    public void addData(){
        if(mHelper.getAlcoholList().getCount()==0) {

            int resID = getResources().getIdentifier("jameson" , "drawable", getPackageName());
            int resID1 = getResources().getIdentifier("greygoose" , "drawable", getPackageName());
            int resID2 = getResources().getIdentifier("patron" , "drawable", getPackageName());
            int resID3 = getResources().getIdentifier("jwblue" , "drawable", getPackageName());
            int resID4 = getResources().getIdentifier("bacardi" , "drawable", getPackageName());
            int resID5 = getResources().getIdentifier("macallan" , "drawable", getPackageName());
            int resID6 = getResources().getIdentifier("makersmark" , "drawable", getPackageName());
            int resID7 = getResources().getIdentifier("hennessy" , "drawable", getPackageName());
            int resID8 = getResources().getIdentifier("remy" , "drawable", getPackageName());
            int resID9 = getResources().getIdentifier("bombay" , "drawable", getPackageName());

            Alcohol jameson = new Alcohol("Jameson", 23, 40, "Blended Irish whiskey", resID, 1);
            Alcohol greygoose = new Alcohol("Grey Goose", 30, 40, "Vodka produced in France", resID1, 2);
            Alcohol patron = new Alcohol("Patron", 37, 40, "Tequila produced in Mexico", resID2, 3);
            Alcohol jwBlue = new Alcohol("J.Walker Blue", 200, 40, "Johnnie Walker's premium blend--aged minimum of 25 years", resID3, 4);
            Alcohol bacardi = new Alcohol("Bacardi 151", 20, 75, "DEATH", resID4, 5);
            Alcohol macallan = new Alcohol("Macallan", 60, 40, "12 year aged scotch produced in Scotlan", resID5, 6);
            Alcohol makersMark = new Alcohol("Maker's Mark", 25, 40, "Blended bourbon from Kentucky, USA", resID6, 7);
            Alcohol hennessy = new Alcohol("Hennessy", 65, 40, "Cognac produced in France", resID7, 8);
            Alcohol remy = new Alcohol("Remy Martin", 35, 40, "Cognac produced in France", resID8, 9);
            Alcohol bombay = new Alcohol("Bombay", 27, 40, "Bombay Sapphire Gin has perfumed juniper, bitter citrus, and brown spice nose; smooth entry; a glycerous, medium-bodied palate; pungent, spicy juniper notes.", resID9, 10);

            mHelper.addAlcohol(jameson);
            mHelper.addAlcohol(greygoose);
            mHelper.addAlcohol(patron);
            mHelper.addAlcohol(jwBlue);
            mHelper.addAlcohol(bacardi);
            mHelper.addAlcohol(macallan);
            mHelper.addAlcohol(makersMark);
            mHelper.addAlcohol(hennessy);
            mHelper.addAlcohol(remy);
            mHelper.addAlcohol(bombay);


        }
    }

    private void handleIntent(Intent intent){
        if(intent!=null) {
            if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
                Log.d("Testing","cool");
                String query = intent.getStringExtra(SearchManager.QUERY);
                Cursor cursor = DataBaseHelper.getInstance(MainActivity.this).searchAlcohol(query);
                mAdapter.changeCursor(cursor);
                mAdapter.notifyDataSetChanged();
            }
            return;
        }
    }
}
