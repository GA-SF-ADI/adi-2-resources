package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SingleHatViewActivity extends AppCompatActivity {

    private static final String LOG_TAG = "SingleHatViewActivity";
    private static final boolean VERBOSE = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_hat_view);
        if (VERBOSE) Log.e(LOG_TAG, "+++ ON CREATE +++");


        //Setting up views, toolbars, and binding data


        Toolbar toolbar = (Toolbar) findViewById(R.id.single_hat_activity_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        final ImageView selectedHatImage = (ImageView) findViewById(R.id.imageview_single_hat);
        final TextView selectedHatTitle = (TextView) findViewById(R.id.textView_single_hat_title);
        final TextView selectedHatPrice = (TextView) findViewById(R.id.textView_single_hat_price);
        final TextView selectedHatDescription = (TextView) findViewById(R.id.textview_single_hat_static_description_with_colon);
        final TextView selectedHatBack = (TextView) findViewById(R.id.textview_single_hat_static_back);
        final TextView selectedHatMaterial = (TextView) findViewById(R.id.textview_single_hat_static_material_with_colon);

//        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        Receiving table position about the specific hat that was clicked on

        Intent intent = getIntent();

        final int selectedHatID = intent.getIntExtra("hatPosition", -1);

        //Setting the passed through data for the single hat being viewed

        HatsSQLiteOpenHelper hatDatabase = HatsSQLiteOpenHelper.getInstance(SingleHatViewActivity.this);

        final Cursor cursor = hatDatabase.getSpecificHat(selectedHatID);

        cursor.moveToFirst();

        selectedHatImage.setBackgroundResource(cursor.getInt(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_PICTUREID)));
        selectedHatTitle.setText(cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_HATNAME)));
        selectedHatPrice.setText("$" + cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_PRICE)));
        selectedHatDescription.setText("Description: " + cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_DESCRIPTION)));
        selectedHatBack.setText("Hat back is: " + cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_FittedOrSnap)));
        selectedHatMaterial.setText("Material: " + cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_MATERIAL)));


        //FAB for adding hat to cart

        FloatingActionButton addToCartButton = (FloatingActionButton) findViewById(R.id.fab);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SingleHatViewActivity.this, "Hat added to cart", Toast.LENGTH_SHORT).show();

                Context context = getApplicationContext();

                Log.e(LOG_TAG, "context successfully gotten for sending single hat to cart");

                HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

                Log.e(LOG_TAG, "db successfully gotten for sending single hat to cart");

                final int hatIDForCart = cursor.getInt(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_ID));

                Log.e(LOG_TAG, "hatIDForCart successfully gotten from db to send single hat to cart");

                final double hatPriceForCart = cursor.getDouble(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_PRICE));

                Log.e(LOG_TAG, "hatPriceForCart successfully gotten from db to send single hat to cart");

                db.addHatToCart(hatIDForCart, hatPriceForCart);

                Log.e(LOG_TAG, "single hat successfully added to cart table");

                Intent intent = new Intent(SingleHatViewActivity.this, MainActivity.class);
                startActivity(intent);

                cursor.close();


            }
        });

        /*//This was code I had when buttons where in my toolbar, rather than menu items. This code
        //displayed the # of hats in the cart

        Context context = getApplicationContext();
        HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

        Cursor numOfCartItemsCursor = db.getNumOfCartItems();

        if (numOfCartItemsCursor.getCount() > 0) {

            TextView cartItemCounter = (TextView) findViewById(R.id.textview_num_of_hats_in_cart);
            ImageView redCartCountBackgroundCircle = (ImageView) findViewById(R.id.cart_counter_red_circle_area);

            redCartCountBackgroundCircle.setImageResource(R.drawable.red_circle);

            cartItemCounter.setText(String.valueOf(numOfCartItemsCursor.getCount()));

        } else {
            TextView cartItemCounter = (TextView) findViewById(R.id.textview_num_of_hats_in_cart);
            ImageView redCartCountBackgroundCircle = (ImageView) findViewById(R.id.cart_counter_red_circle_area);

        }
*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.single_hat_view_menu, menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.button_item_in_single_hat_view_activity_toolbar_to_view_cart: {
                Intent intent = new Intent(SingleHatViewActivity.this, ShoppingCartActivity.class);
                startActivity(intent);

            }

            default:

                return super.onOptionsItemSelected(item);

        }


    }



    @Override
    public void onStart() {
        super.onStart();
        if (VERBOSE) Log.e(LOG_TAG, "++ ON START ++");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (VERBOSE) Log.e(LOG_TAG, "+ ON RESUME +");

        Context context = getApplicationContext();
        HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

        Cursor numOfCartItemsCursor = db.getNumOfCartItems();

        //This was code I had when buttons where in my toolbar, rather than menu items. This code
        //displayed the # of hats in the cart

        /*if (numOfCartItemsCursor.getCount() > 0) {

            TextView cartItemCounter = (TextView) findViewById(R.id.textview_num_of_hats_in_cart);
            ImageView redCartCountBackgroundCircle = (ImageView) findViewById(R.id.cart_counter_red_circle_area);

            redCartCountBackgroundCircle.setImageResource(R.drawable.red_circle);

            cartItemCounter.setText(String.valueOf(numOfCartItemsCursor.getCount()));

        } else {
            TextView cartItemCounter = (TextView) findViewById(R.id.textview_num_of_hats_in_cart);
            ImageView redCartCountBackgroundCircle = (ImageView) findViewById(R.id.cart_counter_red_circle_area);

        }*/


    }

    @Override
    public void onPause() {
        super.onPause();
        if (VERBOSE) Log.e(LOG_TAG, "- ON PAUSE -");
    }

    @Override
    public void onStop() {
        super.onStop();
        if (VERBOSE) Log.e(LOG_TAG, "-- ON STOP --");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (VERBOSE) Log.e(LOG_TAG, "- ON DESTROY -");
    }
}


