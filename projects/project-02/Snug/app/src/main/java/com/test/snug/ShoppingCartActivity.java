package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ShoppingCartActivity extends AppCompatActivity {

    private static final String TAG = "ShoppingCartActivity";
    private static final boolean VERBOSE = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        //Setting up views, toolbars, and binding data

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_main_toolbar);
        setSupportActionBar(toolbar);
        ImageButton deleteFromCartButton = (ImageButton) findViewById(R.id.imagebutton_to_remove_hat_from_cart);
        final ListView listViewOfCartItems = (ListView) findViewById(R.id.listview_of_cart_items);



        // SimpleCursorAdapter for cart hats to display in listview

        SimpleCursorAdapter mAdapter;

        Context context = getApplicationContext();
        final HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

        Cursor cursor = db.getALLHats();  //<– TODO: Is this where I make an instance of the cart singleton?

        String[] columns = new String[]{HatsSQLiteOpenHelper.HAT_COLUMN_PICTUREID, HatsSQLiteOpenHelper.HAT_COLUMN_HATNAME}; //this code might look different from your mornings
        int[] viewNames = new int[]{R.id.image_of_hat_in_cart, R.id.textview_name_of_hat_in_cart};
        CursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(ShoppingCartActivity.this, android.R.layout.simple_list_item_1, cursor, columns, viewNames, 0);

        HatsSQLiteOpenHelper hatDatabase = HatsSQLiteOpenHelper.getInstance(ShoppingCartActivity.this);


/*      hatDatabase.addHatToCart(0, R.drawable.a_s_america, "Oakland A’s", 50, "100% polyester", "Snap", "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHatToCart(1, R.drawable.a_s_america2, "Oakland A’s", 19.99, "100% wool", "Snap", "Great for a day at the beach!", "green");
        hatDatabase.addHatToCart(2, R.drawable.all_black_braves, "Atlanta Braves", 19.99, "100% cotton", "Snap", "Play the outfield with confidence", "black");*/


        // Payment FAB

        FloatingActionButton makeFinalPaymentFab = (FloatingActionButton) findViewById(R.id.fab_make_final_payment);
        makeFinalPaymentFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShoppingCartActivity.this, "Payment confirmed. Thank you!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ShoppingCartActivity.this, MainActivity.class);

//                TODO: Reset cart counter in toolbar to 0


                startActivity(intent);
                finish();


            }
        });

        //onClickListener for imagebutton that deletes hat from cart

       /* deleteFromCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                TODO: Need to finish deleting selected hat from cart
                Cursor cursor = db.deleteSpecificHat(listViewOfCartItems.);

                teamNamesFromDatabaseArrayList.add(cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_HATNAME)));


            }
        });
*/
    }

    @Override
    public void onStart() {
        super.onStart();
        if (VERBOSE) Log.e(TAG, "++ ON START ++");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (VERBOSE) Log.e(TAG, "+ ON RESUME +");
    }

    @Override
    public void onPause() {
        super.onPause();
        if (VERBOSE) Log.e(TAG, "- ON PAUSE -");
    }

    @Override
    public void onStop() {
        super.onStop();
        if (VERBOSE) Log.e(TAG, "-- ON STOP --");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (VERBOSE) Log.e(TAG, "- ON DESTROY -");
    }

}
