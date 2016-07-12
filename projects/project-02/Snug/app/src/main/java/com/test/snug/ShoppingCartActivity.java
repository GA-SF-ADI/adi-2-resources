package com.test.snug;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
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


//        TODO: Set up adapter

        ListView listView = (ListView) findViewById(R.id.listview_of_cart_items);

        SimpleCursorAdapter mAdapter;

        /*mAdapter = new SimpleCursorAdapter(this,*/
        /*        android.R.layout.simple_list_item_1, null,
                fromColumns, toViews, 0);
        setListAdapter(mAdapter);
*/
        final FloatingActionButton makeFinalPaymentFab = (FloatingActionButton) findViewById(R.id.fab_make_final_payment);
        makeFinalPaymentFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShoppingCartActivity.this, "Payment confirmed. Thank you!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ShoppingCartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

//                TODO: Reset cart counter in toolbar to 0


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
