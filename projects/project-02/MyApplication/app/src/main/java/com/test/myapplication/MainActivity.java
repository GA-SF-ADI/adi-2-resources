package com.test.myapplication;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView mainListView;
    SearchView searchView;
    DataBaseHelper mHelper;
    CustomAlcAdapter mAdapter;
    Alcohol mAlcohol;
    MenuItem mCartButton;
    Cursor mCursor,mCursor1;
    Cart mCartItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = DataBaseHelper.getInstance(this);
        addData();

        mainListView = (ListView) findViewById(R.id.main_list_view);
        mCursor = mHelper.getAlcoholList();
        mAdapter = new CustomAlcAdapter(this, mCursor,0);
        mainListView.setAdapter(mAdapter);

        handleIntent(getIntent());

        //onitemclick to get into detail view and send alcohol object that was clicked
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                mAlcohol = mHelper.getAlcohol(l);
                intent.putExtra("alc", mAlcohol);
                startActivity(intent);
            }
        });
        //longitemclick to add single item to cart
        mainListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                mAlcohol = mHelper.getAlcohol(l);
                mCartItem = new Cart(1,mAlcohol.getAlcId());
                mHelper.addCart(mCartItem);
                Toast.makeText(getBaseContext(), "Added item to cart" , Toast.LENGTH_SHORT ).show();
                return true;
            }
        });
    }
        //onbackpressed resets search list to default list when search list is showing
    @Override
    public void onBackPressed() {
        if(mCursor.getCount()!=mCursor1.getCount()){
            mCursor = mHelper.getAlcoholList();
            mAdapter.changeCursor(mCursor);
            mAdapter.notifyDataSetChanged();
        }else{
        super.onBackPressed();
        }
    }
        //setting up search and cart items
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
        searchView.setQueryHint("Search by name, price, or description");
        searchView.setSearchableInfo(searchableInfo);

        return true;
    }



    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    public void addData(){
        if(mHelper.getAlcoholList().getCount()==0) {

            int resID = R.drawable.jameson;
            int resID1 = R.drawable.greygoose;
            int resID2 = R.drawable.patron;
            int resID3 = R.drawable.jwblue;
            int resID4 = R.drawable.bacardi;
            int resID5 = R.drawable.macallan;
            int resID6 = R.drawable.makersmark;
            int resID7 = R.drawable.hennessy;
            int resID8 = R.drawable.remy;
            int resID9 = R.drawable.bombay;
            int resID10 = R.drawable.kahlua;
            int resID11 = R.drawable.fireball;
            int resID12 = R.drawable.hibiki;


            Alcohol jameson = new Alcohol("Jameson", 23, 40, "Blended Irish whiskey. Pretty good. My go to for the value.", resID, 1);
            Alcohol greygoose = new Alcohol("Grey Goose", 30, 40, "Vodka produced in France, its alright. Good mix.", resID1, 2);
            Alcohol patron = new Alcohol("Patron", 37, 40, "Tequila produced in Mexico, its alright. ", resID2, 3);
            Alcohol jwBlue = new Alcohol("J.Walker Blue", 200, 40, "Johnnie Walker's premium whiskey blend. pretty damn good. ", resID3, 4);
            Alcohol bacardi = new Alcohol("Bacardi 151", 20, 75, "DEATH", resID4, 5);
            Alcohol macallan = new Alcohol("Macallan", 60, 40, "12 year aged scotch produced in Scotland. Pretty good.", resID5, 6);
            Alcohol makersMark = new Alcohol("Maker's Mark", 25, 40, "Blended bourbon from Kentucky, USA. not that good.", resID6, 7);
            Alcohol hennessy = new Alcohol("Hennessy", 65, 40, "Cognac produced in France, blame it on the henny.", resID7, 8);
            Alcohol remy = new Alcohol("Remy Martin", 35, 40, "Cognac produced in France, blame it on the remy as well", resID8, 9);
            Alcohol bombay = new Alcohol("Bombay", 27, 40, "Bombay Sapphire Gin, only good with tonic.", resID9, 10);
            Alcohol kahlua = new Alcohol("Kahlua", 15, 20, "Coffee tasting mix. Best for irish car bombs!",resID10,11);
            Alcohol fireball = new Alcohol("Fireball", 15, 45, "Tastes like big red. Pitbull's go to",resID11, 12);
            Alcohol hibiki = new Alcohol("Hibiki", 80, 43, "Premium Japanese whiskey. Goes down smooth",resID12,13);


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
            mHelper.addAlcohol(kahlua);
            mHelper.addAlcohol(fireball);
            mHelper.addAlcohol(hibiki);

        }
    }
    //receiving the search query, searching db, then swapping main cursor for search cursor.
    private void handleIntent(Intent intent){
        if(intent!=null) {
            if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
                String query = intent.getStringExtra(SearchManager.QUERY);
                mCursor1 = DataBaseHelper.getInstance(MainActivity.this).searchAlcohol(query);
                mAdapter.swapCursor(mCursor1);
                mAdapter.notifyDataSetChanged();
            }
            return;
        }
    }
}
