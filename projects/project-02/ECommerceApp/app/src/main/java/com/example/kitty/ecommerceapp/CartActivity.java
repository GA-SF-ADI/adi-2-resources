package com.example.kitty.ecommerceapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {

    Helper dbHelper;
    CartCursorAdapter cartCursorAdapter;

    double total;

    ListView shoppingList;
    TextView totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipping_cart_layout);

        dbHelper = Helper.getInstance(CartActivity.this);
        shoppingList = (ListView) findViewById(R.id.shopping_cart_listview);
        totalCost = (TextView) findViewById(R.id.cart_total);

        Cursor cursor = dbHelper.getItemJoinCart();
        cartCursorAdapter = new CartCursorAdapter(this, cursor);
        shoppingList.setAdapter(cartCursorAdapter);

        // total updated when items changed
        cartCursorAdapter.setItemsUpdatedListener(new Runnable() {
            @Override
            public void run() {
                calculateCartTotalCost();
            }
        });

        calculateCartTotalCost();
    }

    private void calculateCartTotalCost() {
        Cursor cursor = dbHelper.getItemJoinCart();
        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            total = cursor.getDouble(cursor.getColumnIndex(Helper.COL_ITEM_PRICE)) * cursor.getInt(cursor.getColumnIndex(Helper.COL_CART_QUANTITY));
            while (cursor.moveToNext()) {
                total += (cursor.getDouble(cursor.getColumnIndex(Helper.COL_ITEM_PRICE)) * cursor.getInt(cursor.getColumnIndex(Helper.COL_CART_QUANTITY)));
            }
            totalCost.setText("Total: $" + total);
        } else totalCost.setText("Total: $0.00");
    }
}
