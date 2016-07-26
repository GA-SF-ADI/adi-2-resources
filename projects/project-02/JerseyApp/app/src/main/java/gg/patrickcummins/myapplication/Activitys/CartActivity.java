package gg.patrickcummins.myapplication.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import gg.patrickcummins.myapplication.Adapters.CartListAdapter;
import gg.patrickcummins.myapplication.CaChingService;
import gg.patrickcummins.myapplication.DatabaseHelper;
import gg.patrickcummins.myapplication.R;
import gg.patrickcummins.myapplication.models.CartItem;

public class CartActivity extends AppCompatActivity {
    ListView cartListView;
    ArrayList<CartItem> cartItems;
    Button checkoutButton;
    TextView priceTextView, dateTextView;
    DatabaseHelper helper;
    CartListAdapter cartListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        helper = DatabaseHelper.getInstance(CartActivity.this);
        setViews();
        setIsPurchaseHistory();


        cartListView.setAdapter(cartListAdapter);
        setTotal();
        setCheckoutClick();


    }

    private void setIsPurchaseHistory() {
        Intent intent = getIntent();
        int history_id = intent.getIntExtra("history_id", -1);
        if (history_id >= 0) {
            String date = intent.getStringExtra("date");
            cartItems = helper.getCartItemArrayListByHistoryID(history_id);
            dateTextView.setText("Date Ordered:\n" + date);
            dateTextView.setVisibility(View.VISIBLE);
            checkoutButton.setVisibility(View.GONE);
            cartListAdapter = new CartListAdapter(cartItems, CartActivity.this, "nah");


        } else {
            cartItems = helper.getCartItemArrayList();
            cartListAdapter = new CartListAdapter(cartItems, CartActivity.this, "cart");
        }
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
                if (cartItems.isEmpty()) {
                    Toast.makeText(CartActivity.this, "Your Cart is Empty!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CartActivity.this, "Thank You for Your Purchase!", Toast.LENGTH_SHORT).show();
                }
                helper.clearCart();
                cartItems.clear();
                cartListAdapter.notifyDataSetChanged();
                String totalText = "Total:\n$00.00";
                priceTextView.setText(totalText);

                Intent intent = new Intent(CartActivity.this, CaChingService.class);
                startService(intent);
                finish();
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
            totalText = "Total:\n$00.00";
        } else {
            totalText = "Total:\n$" + Math.round(total * 100.0) / 100.0;
        }

        priceTextView.setText(totalText);
    }

    private void setViews() {
        cartListView = (ListView) findViewById(R.id.cartListView);
        priceTextView = (TextView) findViewById(R.id.totalTextView);
        checkoutButton = (Button) findViewById(R.id.checkoutButton);
        dateTextView = (TextView) findViewById(R.id.dateOrderedTextView);

    }
}
