package com.example.kitty.ecommerceapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {

    Helper db;
    CartCursorAdapter cartCursorAdapter;
    Cursor cursor;

    ListView shoppingList;
    TextView totalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shipping_cart_layout);

        db = Helper.getInstance(CartActivity.this);

        cursor = db.getItemJoinCart();
        cartCursorAdapter = new CartCursorAdapter(this, cursor);
        shoppingList.setAdapter(cartCursorAdapter);
    }
}
