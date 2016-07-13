package com.test.project2navigationdrawer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        typeOfJewelryTextView.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_2_TYPE)));
        priceOfJewelryTextView.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_3_PRICE)));
        goldOfJewelryTextView.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_4_GOLD)));
        stoneOfJewelryTextView.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_5_STONE)));
        measurementOfJewelryTextView.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_6_MEASUREMENT)));
        quantityOfJewelryTextView.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_7_QUANTITY)));
        nameOfJewelryTextView.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_8_NAME)));
        Log.d(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_9_IMAGE))+ "", "images");
        imageOfJewelry.setImageResource(cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_9_IMAGE)));

//        addToCartButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//
//                notifyDataSetChanged();
//            }
//        });

    }
};


