package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ShoppingCartActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_main_toolbar);
        setSupportActionBar(toolbar);

        Context context = getApplicationContext();
        HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);


//        TODO: Set up adapter

        ListView listView = (ListView) findViewById(R.id.listview_of_cart_items);


        SimpleCursorAdapter mAdapter;


        Cursor cursor = db.getALLHats();  //<– TODO: Is this where I make an instance of the cart singleton?

        String[] columns = new String[]{HatsSQLiteOpenHelper.HAT_COLUMN_PICTUREID, HatsSQLiteOpenHelper.HAT_COLUMN_HATNAME}; //this code might look different from your mornings
        int[] viewNames = new int[]{R.id.image_of_hat_in_cart, R.id.textview_name_of_hat_in_cart};
        CursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(ShoppingCartActivity.this, android.R.layout.simple_list_item_1, cursor, columns, viewNames, 0);


        final FloatingActionButton makeFinalPaymentFab = (FloatingActionButton) findViewById(R.id.fab_make_final_payment);
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


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
