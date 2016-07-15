package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
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
    private String LOG_TAG = "ShoppingCartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        //Setting up views, toolbars, and binding data

        Toolbar toolbar = (Toolbar) findViewById(R.id.shopping_activity_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
/*
        ImageButton deleteFromCartButton = (ImageButton) findViewById(R.id.imagebutton_to_remove_hat_from_cart);
*/
        final ListView listViewOfCartItems = (ListView) findViewById(R.id.listview_of_cart_items);


//        TODO: Look into insertOrUpdate
        Context context = getApplicationContext();

        Log.e(LOG_TAG, "context gotten");

        HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

        Log.e(LOG_TAG, "db gotten for activity");

        Cursor hatsInCartCursor = db.getALLHatsFromCART();

        CartCustomCursorAdapter cartCustomCursorAdapter = new CartCustomCursorAdapter(ShoppingCartActivity.this, hatsInCartCursor, -1);

        listViewOfCartItems.setAdapter(cartCustomCursorAdapter);


        // Payment FAB

        FloatingActionButton makeFinalPaymentFab = (FloatingActionButton) findViewById(R.id.fab_make_final_payment);
        makeFinalPaymentFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO: Get count of cart items to make sure it's not empty before "payment"


                Context context = getApplicationContext();
                HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

                int numOfHatsInCart = db.checkNumOfHatsInCart();

                if (numOfHatsInCart == 0) {

                    Toast.makeText(ShoppingCartActivity.this, "No need to pay. Your cart is empty!",
                            Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(ShoppingCartActivity.this, "Payment confirmed. Thank you!\n " +
                            "     Your cart is now empty.", Toast.LENGTH_SHORT).show();


                    //Clicking on payment FAB clears all hats from cart table in database
                    db.deleteAllHatsFromCart();


                    Intent intent = new Intent(ShoppingCartActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();


                }
            }


        });

    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            return super.onOptionsItemSelected(item);
        }


        @Override
        public void onStart () {
            super.onStart();
            if (VERBOSE) Log.e(TAG, "++ ON START ++");
        }

        @Override
        public void onResume () {
            super.onResume();
            if (VERBOSE) Log.e(TAG, "+ ON RESUME +");
        }

        @Override
        public void onPause () {
            super.onPause();
            if (VERBOSE) Log.e(TAG, "- ON PAUSE -");
        }

        @Override
        public void onStop () {
            super.onStop();
            if (VERBOSE) Log.e(TAG, "-- ON STOP --");
        }

        @Override
        public void onDestroy () {
            super.onDestroy();
            if (VERBOSE) Log.e(TAG, "- ON DESTROY -");
        }

    }
