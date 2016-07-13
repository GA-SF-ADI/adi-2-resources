package com.test.project2navigationdrawer;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.database.Cursor;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by audreyeso on 7/11/16.
 */
public class DBAdapter extends CursorAdapter {

    LayoutInflater layoutInflater;

    public DBAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.layoutInflater = layoutInflater;

    }

    //create custom adapter

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView typeOfJewelryTextView = (TextView) view.findViewById(R.id.text_view_type_of_jewelry);
        TextView priceOfJewelryTextView = (TextView) view.findViewById(R.id.text_view_price_of_jewelry);
        TextView goldOfJewelryTextView = (TextView) view.findViewById(R.id.text_view_gold_of_jewelry);
        TextView stoneOfJewelryTextView = (TextView) view.findViewById(R.id.text_view_stone_of_jewelry);
        TextView measurementOfJewelryTextView = (TextView) view.findViewById(R.id.text_view_measurement_of_jewelry);
        TextView quantityOfJewelryTextView = (TextView) view.findViewById(R.id.text_view_quantity_of_jewelry);
        TextView nameOfJewelryTextView = (TextView) view.findViewById(R.id.text_view_name_of_jewelry);
        ImageView imageOfJewelry = (ImageView) view.findViewById(R.id.image_view_of_jewelry);
        Button addToCartButton = (Button) view.findViewById(R.id.add_button_to_shopping_cart);


        final String type = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_2_TYPE));
        final double price = cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.COL_3_PRICE));
        final String gold = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_4_GOLD));
        final String stone = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_5_STONE));
        final String measurement = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_6_MEASUREMENT));
        final String quantity = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_7_QUANTITY));
        final String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_8_NAME));
        final int jewelry = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_9_IMAGE));

        Log.d(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_9_IMAGE)) + "", "images");

        typeOfJewelryTextView.setText(type);
        priceOfJewelryTextView.setText(Double.toString(price));
        goldOfJewelryTextView.setText(gold);
        stoneOfJewelryTextView.setText(stone);
        measurementOfJewelryTextView.setText(measurement);
        quantityOfJewelryTextView.setText(quantity);
        nameOfJewelryTextView.setText(name);
        imageOfJewelry.setImageResource(jewelry);

        //DatabaseHelper helper = DatabaseHelper.getInstance(context);


        final DatabaseHelper helper= DatabaseHelper.getInstance(context);

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Insert this item into the Shopping cart table

                // you can get this item
//                helper.insertShippingCart(type, , , ,);
                helper.insertShoppingCart(type, price, gold, stone, measurement, quantity, name, jewelry);

            }
        });
//
//        incrementButton = (Button) findViewById(R.id.increment_button_view);
//        incrementButton.setOnClickListener(new AdapterView.OnClickListener() {
//            public void onClick(View view) {
//
//            }
//
//        });
//
//        decrementButton = (Button) findViewById(R.id.decrement_button_view);
//        decrementButton.setOnClickListener(new AdapterView.OnClickListener() {
//            public void onClick(View view) {
//
//            }
//
//        });

    }
};


