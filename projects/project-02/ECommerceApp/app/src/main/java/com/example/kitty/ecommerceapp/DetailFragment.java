package com.example.kitty.ecommerceapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by kitty on 7/12/16.
 */
public class DetailFragment extends Fragment {

    public static final String TAG = "DetailFragment";
    ImageView itemImageView;
    TextView brandTextView;
    TextView nameTextView;
    TextView priceTextView;
    ImageButton removeButton;
    TextView quantityTextView;
    ImageButton addButton;
    Button addToCartButton;
    TextView descriptionTextView;
    TextView numPlyTextView;
    TextView numRollTextView;
    TextView rollSizeTextView;

    RatingBar ratingBar;

    private Helper db;

    TP mTP;
    int quantity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = Helper.getInstance(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        itemImageView = (ImageView) v.findViewById(R.id.detail_item_image);
        brandTextView = (TextView) v.findViewById(R.id.detail_item_brand);
        nameTextView = (TextView) v.findViewById(R.id.detail_item_name);
        priceTextView = (TextView) v.findViewById(R.id.detail_item_price);
        removeButton = (ImageButton) v.findViewById(R.id.remove_quantity_button);
        quantityTextView = (TextView) v.findViewById(R.id.detail_quantity);
        addButton = (ImageButton) v.findViewById(R.id.add_quantity_button);
        addToCartButton = (Button) v.findViewById(R.id.add_to_cart_button);
        descriptionTextView = (TextView) v.findViewById(R.id.detail_description);
        numPlyTextView = (TextView) v.findViewById(R.id.detail_num_ply);
        numRollTextView = (TextView) v.findViewById(R.id.detail_num_rolls);
        rollSizeTextView = (TextView) v.findViewById(R.id.detail_roll_size);

        //when you first go in to this page quantity should always be 0
        quantity = 0;

        updateViews();
        return v;
    }

    public void setTP(TP tp){
        mTP = tp;
    }

    // set view based on selected item
    public void updateViews(){
        itemImageView.setImageResource(mTP.getPic());
        brandTextView.setText(mTP.getBrand());
        nameTextView.setText(mTP.getName());

        // if on sale, price text in red (also need to grab new price from other table)
        if(mTP.isOnSale()) {
            priceTextView.setText("SALE: $\n"+mTP.getPrice());
            priceTextView.setTextColor(Color.RED);
        } else {
            priceTextView.setText("$"+mTP.getPrice());
        }

        quantityTextView.setText(quantity+"");
        descriptionTextView.setText("Description: "+mTP.getDescription());
        numPlyTextView.setText("Number of ply: "+mTP.getPly());
        numRollTextView.setText("Number of rolls: "+mTP.getNumRolls());
        rollSizeTextView.setText("Roll size: "+mTP.getSize());

        //onClickListeneer for removing quanity button
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity>0) {
                    quantity--;
                    quantityTextView.setText(quantity+"");
                }
            }
        });

        //onClickListener for adding quantity button;
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                quantityTextView.setText(quantity+"");
            }
        });

        //add to cart button onClickListener ****to be updated
        // 1. add item and quantity to shopping cart table
        // 2. toast appear to indicate item added
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            db.getWritableDatabase();
            if (quantity <1) {
                Toast.makeText(getContext(), "Please select a quantity", Toast.LENGTH_SHORT).show();
            } else {
                db.addItemToCart(db.getTPID(mTP.getName()), quantity);
                Toast.makeText(getContext(), "Item added to your cart!", Toast.LENGTH_SHORT).show();
            }
            }
        });

    }
}
