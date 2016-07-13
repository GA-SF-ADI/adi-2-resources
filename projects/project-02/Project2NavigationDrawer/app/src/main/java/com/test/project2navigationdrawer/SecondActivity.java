package com.test.project2navigationdrawer;

import android.database.Cursor;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    ListView listView;
    DBAdapter customAdapter;
    Button shoppingCartButton;


    int[] imagePic = {R.drawable.rounddiamond,
            R.drawable.id1
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_second);


        super.onCreate(savedInstanceState);

        myDb = new DatabaseHelper(this);

        myDb.insert("1", "bracelet", "$49.00", "yellow gold", "ruby", null, "quantity 5", "striking",R.drawable.id1);
        myDb.insert("2", "bracelet", "$79.00", "white gold", "diamond", null, "quantity 5", "elegant", R.drawable.id1);
        myDb.insert("3", "bracelet", "$89.00", "platinum", "diamond", null, "quantity 5", "classic", R.drawable.id1);
        myDb.insert("4", "earrings", "$49.00", "yellow gold", "ruby", null, "quantity 5", "striking", R.drawable.id1);
        myDb.insert("5", "earrings", "$79.00", "white gold", "diamond", null, "quantity 5", "elegant", R.drawable.id1);
        myDb.insert("6", "earrings", "$89.00", "platinum", "diamond", null, "quantity 5", "classic", R.drawable.id1);
        myDb.insert("7", "necklace", "$49.00", "yellow gold", "ruby", null, "quantity 5", "striking", R.drawable.id1);
        myDb.insert("8", "necklace", "$79.00", "white gold", "diamond", null, "quantity 5", "elegant", R.drawable.id1);
        myDb.insert("9", "necklace", "$89.00", "platinum", "diamond", null, "quantity 5", "classic", R.drawable.id1);
        populateListViewFromDB();
    }


    private void populateListViewFromDB() {
        Cursor cursor = myDb.getJewelry();
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

        final ShoppingCartSingleton shoppingCart = ShoppingCartSingleton.getInstance();

        final ArrayList<Item> myItems = new ArrayList<Item>();

        Item item1 = new Item("1", "bracelet", 49.00, "yellow gold", "ruby", null, 1);
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


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                shoppingCart.addItem(myItems.get(position));
                Log.d("added to cart ", myItems.get(position).getType());
                customAdapter.notifyDataSetChanged();

            }
        });
    }
}
