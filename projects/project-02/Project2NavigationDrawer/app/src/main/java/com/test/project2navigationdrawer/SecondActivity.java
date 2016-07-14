package com.test.project2navigationdrawer;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    ListView listView;
    DBAdapter customAdapter;
    Button shoppingCartButton;
    Button featuredJewelryButton;
    Button returnHomeButton;
    TextView textViewSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_second);

        super.onCreate(savedInstanceState);

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
        handleIntent(getIntent());

        DatabaseHelper helper = new DatabaseHelper(SecondActivity.this);
        Cursor cursor = helper.getJewelry();


    }


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
                {R.id.text_view_type_of_jewelry, R.id.text_view_price_of_jewelry};
        //create adapter to map columns of DB

        customAdapter = new DBAdapter(this, cursor, 0);


        listView = (ListView) findViewById(R.id.second_activity_list_view);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Cursor jewelCursor = DatabaseHelper.getInstance(SecondActivity.this).getJewelry();

                Log.d("Second Act", "onItemClick: item clicked");

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                jewelCursor.moveToPosition(position);
                intent.putExtra("id", jewelCursor.getInt(jewelCursor.getColumnIndex(DatabaseHelper.COL_1_ID)));
//
//                iconCursor.moveToPosition(position);
//                intent.putExtra("id", iconCursor.getInt(iconCursor.getColumnIndex(IconSQLiteOpenHelper.COL_ID)));
                startActivity(intent);

                //does not go to third activity and does not display list
                //cannot focus on the cell/list item
                //tell what id is clicked
                //use extras..put
            }
        });

//detail view lesson:
        //pass intent

        returnHomeButton = (Button) findViewById(R.id.return_home_button);
        returnHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        featuredJewelryButton = (Button) findViewById(R.id.featured_jewelry_button_second_act);
        featuredJewelryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SecondActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });
        shoppingCartButton = (Button) findViewById(R.id.shopping_cart_button);
        shoppingCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingCartFragment fragment = new ShoppingCartFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                listView.setVisibility(View.GONE);

                switch (view.getId()) {
                    case R.id.shopping_cart_button: {
                        Log.d("case shopping cart", "in switch case");
                        fragmentTransaction.add(R.id.fragment_container_second_activity, fragment);
                        fragmentTransaction.commit();
                        break;
                    }

                }
            }

        });

        //when you click "Item"

        //final ShoppingCartSingleton shoppingCart = ShoppingCartSingleton.getInstance();

        final DatabaseHelper databaseHelper = DatabaseHelper.getInstance(this);

        final ArrayList<Item> myItems = new ArrayList<Item>();

        final Item item1 = new Item("1", "bracelet", 49.00, "yellow gold", "ruby", null, R.drawable.id1);
        Item item2 = new Item("2", "bracelet", 79.00, "white gold", "diamond", null, 1);
        Item item3 = new Item("3", "bracelet", 89.00, "platinum", "diamond", null, 1);
        Item item4 = new Item("4", "earrings", 49.00, "yellow gold", "ruby", null, 1);
        Item item5 = new Item("5", "earrings", 79.00, "white gold", "diamond", null, 1);
        Item item6 = new Item("6", "earrings", 89.00, "platinum", "diamond", null, 1);
        Item item7 = new Item("7", "necklace", 49.00, "yellow gold", "ruby", null, 1);
        Item item8 = new Item("8", "necklace", 79.00, "white gold", "diamond", null, 1);
        Item item9 = new Item("9", "necklace", 89.00, "platinum", "diamond", null, 1);

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

        // Return true to show menu, returning false will not show it.
        return true;
    }

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
