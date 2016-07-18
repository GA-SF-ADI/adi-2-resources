package com.example.kitty.ecommerceapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kitty on 7/12/16.
 */
public class DetailFragment extends Fragment {

    public static final String TAG = "DetailFragment";

    public static final String Item_ID_TAG = "Item_ID_tag";
    public static final int COMMENT_ACTIVITY_REQUEST_CODE = 12345;

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
    Button rateItButton;
    ListView commentList;

    RatingBar ratingBar;

    private Helper dbHelper;

    TP mTP;
    int quantity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = Helper.getInstance(getContext());
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
        rateItButton = (Button) v.findViewById(R.id.insert_comment_button);
        commentList = (ListView) v.findViewById(R.id.comment_list);
        ratingBar = (RatingBar) v.findViewById(R.id.detail_rating);

        //when you first go in to this page quantity should always be 1
        quantity = 1;

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
        ratingBar.setRating((float) 4); //assume 4 for now
        quantityTextView.setText(quantity+"");
        descriptionTextView.setText("Description: "+mTP.getDescription());
        numPlyTextView.setText("Number of ply: "+mTP.getPly());
        numRollTextView.setText("Number of rolls: "+mTP.getNumRolls());
        rollSizeTextView.setText("Roll size: "+mTP.getSize());

        // if on sale, price text in red and grab from sales price column
        if (mTP.isOnSale()) {
            priceTextView.setText("SALE: $\n" + mTP.getPrice());
            priceTextView.setTextColor(Color.RED);
        } else {
            priceTextView.setText("$" + mTP.getPrice());
        }

        //onClickListener for removing quantity button
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

        //add to cart button onClickListener
        // 1. add item and quantity to shopping cart table
        // 2. toast appear to indicate item added
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            dbHelper.getWritableDatabase();
            if (quantity <1) {
                Toast.makeText(getContext(), "Please select a quantity", Toast.LENGTH_SHORT).show();
            } else {
                dbHelper.addItemToCart(dbHelper.getTPID(mTP.getName()), quantity);
                Toast.makeText(getContext(), "Item added to your cart!", Toast.LENGTH_SHORT).show();
            }
            }
        });

        // button to go to adding comments activity
        rateItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toComment();
            }
        });

        updateCommentView();
    }

    //set up comment listview
    private void updateCommentView() {
        Cursor cursor = dbHelper.getTPComment(dbHelper.getTPID(mTP.getName()));
        CommentAdapter commentAdapter = new CommentAdapter(getContext(), cursor);
        commentList.setAdapter(commentAdapter);
    }

    public void toComment() {
        Intent intent = new Intent(getContext(), CommentActivity.class);
        intent.putExtra(Item_ID_TAG, dbHelper.getTPID(mTP.getName()));
        startActivityForResult(intent, COMMENT_ACTIVITY_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == COMMENT_ACTIVITY_REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK) {
                updateCommentView();
            }
        }
    }
}
