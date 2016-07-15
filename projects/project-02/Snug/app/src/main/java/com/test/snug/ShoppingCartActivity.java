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

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_main_toolbar);
        setSupportActionBar(toolbar);
        ImageButton deleteFromCartButton = (ImageButton) findViewById(R.id.imagebutton_to_remove_hat_from_cart);
        final ListView listViewOfCartItems = (ListView) findViewById(R.id.listview_of_cart_items);


        // SimpleCursorAdapter for cart hats to display in listview





//        TODO: Look into insertOrUpdate
        Context context = getApplicationContext();

        Log.e(LOG_TAG, "context gotten");

        HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

        Log.e(LOG_TAG, "db gotten for activity");

        Cursor hatsInCartCursor = db.getALLHatsFromCART();

        Log.e(LOG_TAG, "getALLHatsFromCART() ran successfully");

        String[] columns = new String[]{HatsSQLiteOpenHelper.HAT_COLUMN_PICTUREID, HatsSQLiteOpenHelper.HAT_COLUMN_HATNAME};

        Log.e(LOG_TAG, "String[] columns successfully set up for custom cursor adapter");

        int[] viewNames = new int[]{R.id.image_of_hat_in_cart, R.id.textview_name_of_hat_in_cart};

        Log.e(LOG_TAG, "int[] viewNames successfully set up for custom cursor adapter");

        CursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(ShoppingCartActivity.this, R.layout.single_hat_line_in_cart, hatsInCartCursor, columns, viewNames, 0);

        Log.e(LOG_TAG, "simpleCursorAdapter successfully set for cart");


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
                Cursor cursor = db.deleteSpecificHatFromCart(listViewOfCartItems.);

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
