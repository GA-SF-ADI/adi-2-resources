package gg.patrickcummins.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ListView cartListView;
    ArrayList<CartItem> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        DatabaseHelper helper = DatabaseHelper.getInstance(CartActivity.this);

        cartItems = helper.getCartItemArrayList();

        cartListView = (ListView) findViewById(R.id.cartListView);

        ArrayAdapter<CartItem> cartItemArrayAdapter = new ArrayAdapter<CartItem>(this, android.R.layout.simple_list_item_1, cartItems);

        cartListView.setAdapter(cartItemArrayAdapter);


    }
}
