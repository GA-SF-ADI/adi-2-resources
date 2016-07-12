package gg.patrickcummins.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class CartActivity extends AppCompatActivity {
    ListView cartListView;
    ArrayList<CartItem> cartItems;
    Button checkoutButton;
    TextView priceTextView;
    DatabaseHelper helper;
    CartListAdapter cartListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        helper = DatabaseHelper.getInstance(CartActivity.this);
        setViews();

        cartItems = helper.getCartItemArrayList();


        cartListAdapter = new CartListAdapter(cartItems, CartActivity.this);

        cartListView.setAdapter(cartListAdapter);
        setTotal();
        setCheckoutClick();


    }

    private void setCheckoutClick() {
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date = new Date();
                int history_id;
                if (helper.isPurchaseHistoryEmpty()) {
                    history_id = 0;
                } else {
                    history_id = helper.getLastHistoryID() + 1;
                }
                for (int i = 0; i < cartItems.size(); i++) {
                    helper.insertPurchaseHistoryRow(cartItems.get(i), history_id, date.toString());
                }
                helper.clearCart();
                cartItems.clear();
                cartListAdapter.notifyDataSetChanged();
                String totalText = "Total: $00.00";
                priceTextView.setText(totalText);
                Toast.makeText(CartActivity.this, "Thank You for Your Purchase!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setTotal() {
        double total = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            total += cartItems.get(i).getPrice();

        }
        String totalText;
        if (total == 0) {
            totalText = "Total: $00.00";
        } else {
            totalText = "Total: $" + total;
        }

        priceTextView.setText(totalText);
    }

    private void setViews() {
        cartListView = (ListView) findViewById(R.id.cartListView);
        priceTextView = (TextView) findViewById(R.id.totalTextView);
        checkoutButton = (Button) findViewById(R.id.checkoutButton);

    }
}
