package com.test.project2navigationdrawer;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    ListView listView;
    DBAdapter customAdapter;
    TextView textViewSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar_second_activity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        super.onCreate(savedInstanceState);

        //all of the items and properties that I want to insert into the db
        myDb = DatabaseHelper.getInstance(this);

        myDb.insert("1", "bracelet", 1490.00, "yellow gold", "ruby", null, "Striking Collection", R.drawable.id1);
        myDb.insert("2", "bracelet", 5790.00, "white gold", "diamond", null, "Elegant Collection", R.drawable.id2);
        myDb.insert("3", "bracelet", 1890.00, "platinum", "sapphire", null, "Classic Collection", R.drawable.id3);
        myDb.insert("4", "earrings", 4049.00, "platinum", "diamond", null, "Striking Collection", R.drawable.id4);
        myDb.insert("5", "earrings", 879.00, "white gold", "sapphire", null, "Elegant Collection", R.drawable.id5);
        myDb.insert("6", "earrings", 989.00, "yellow gold", "ruby", null, "Classic Collection", R.drawable.id6);
        myDb.insert("7", "necklace", 8049.00, "yellow gold", "emerald", null, "Striking Collection", R.drawable.id7);
        myDb.insert("8", "necklace", 6079.00, "white gold", "diamond", null, "Elegant Collection", R.drawable.id8);
        myDb.insert("9", "necklace", 1089.00, "yellow gold", "sapphire", null, "Classic Collection", R.drawable.id9);
        populateListViewFromDB();

        textViewSearch = (TextView) findViewById(R.id.text_view_search);


        DatabaseHelper helper = new DatabaseHelper(SecondActivity.this);
        Cursor cursor = helper.getJewelry();

    }

    //populate ListView and called method getJewelry to get columns

    private void populateListViewFromDB() {
        final Cursor cursor = myDb.getJewelry();
        //allow activity to manage cursor
        //DEPRECATED
        Log.d("Second Activity", "populateListViewFromDB: Cursor" + cursor.getCount());
        startManagingCursor(cursor);

        //map string of column name to an id in the view
        String[] fromFieldNames = new String[]
                {myDb.COL_2_TYPE, myDb.COL_3_PRICE};
        int[] toViewIds = new int[]
                {R.id.text_view_type_of_jewelry};

        //created adapter to map columns of DB
        customAdapter = new DBAdapter(this, cursor, 0);

        //listview of my items
        listView = (ListView) findViewById(R.id.second_activity_list_view);
        listView.setAdapter(customAdapter);

        //when the user clicks on item, it will take them to a new,third activity with item features/description
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Cursor jewelCursor = DatabaseHelper.getInstance(SecondActivity.this).getJewelry();

                Log.d("Second Act", "onItemClick: item clicked");

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                jewelCursor.moveToPosition(position);
                intent.putExtra("id", jewelCursor.getInt(jewelCursor.getColumnIndex(DatabaseHelper.COL_1_ID)));
                startActivity(intent);
            }
        });

        //Items
        final DatabaseHelper databaseHelper = DatabaseHelper.getInstance(this);

        final ArrayList<Item> myItems = new ArrayList<Item>();

        final Item item1 = new Item("1", "bracelet", 1490.00, "yellow gold", "ruby", null, "striking collection", R.drawable.id1);
        Item item2 = new Item("2", "bracelet", 5790.00, "white gold", "diamond", null, "Elegant Collection", R.drawable.id2);
        Item item3 = new Item("3", "bracelet", 1890.00, "platinum", "sapphire", null, "Classic Collection", R.drawable.id3);
        Item item4 = new Item("4", "earrings", 4049.00, "platinum", "diamond", null, "Striking Collection", R.drawable.id4);
        Item item5 = new Item("5", "earrings", 879.00, "white gold", "sapphire", null, "Elegant Collection", R.drawable.id5);
        Item item6 = new Item("6", "earrings", 989.00, "yellow gold", "ruby", null, "Classic Collection", R.drawable.id6);
        Item item7 = new Item("7", "necklace", 8049.00, "yellow gold", "emerald", null, "Striking Collection", R.drawable.id7);
        Item item8 = new Item("8", "necklace", 6079.00, "white gold", "diamond", null, "Elegant Collection", R.drawable.id8);
        Item item9 = new Item("9", "necklace", 1089.00, "yellow gold", "sapphire", null, "Classic Collection", R.drawable.id9);

        myItems.add(item1);
        myItems.add(item2);
        myItems.add(item3);
        myItems.add(item4);
        myItems.add(item5);
        myItems.add(item6);
        myItems.add(item7);
        myItems.add(item8);
        myItems.add(item9);
    }

    //created for search and for menu to function
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.second, menu);

        // Find searchManager and searchableInfo
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());

        // Associate searchable info with the SearchView
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchableInfo);
        searchView.setBackgroundColor(Color.CYAN);

        return true;
    }

    //depending on what icon is selected from the menu, the user can go to a different activity or fragment
    //return home, view cart, return to second activity (featured jewelry page), or search
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if (id == R.id.home_icon) {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.cart) {

            ShoppingCartFragment fragment = new ShoppingCartFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            listView.setVisibility(View.GONE);

            fragmentTransaction.add(R.id.fragment_container_second_activity, fragment);
            fragmentTransaction.commit();
            return true;


        } else if (id == R.id.featured_jewels) {
            Intent intent = new Intent(SecondActivity.this, SecondActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.search) {
            handleIntent(getIntent());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //will allow user to search and create a toast that says "looking for" + whatever the user types in

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }


    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            Log.d("handleIntent", "");
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(SecondActivity.this, "Looking for " + query, Toast.LENGTH_SHORT).show();
            Cursor cursor = DatabaseHelper.getInstance(SecondActivity.this).searchShoppingList(query);
            customAdapter.changeCursor(cursor);

        }
    }

}