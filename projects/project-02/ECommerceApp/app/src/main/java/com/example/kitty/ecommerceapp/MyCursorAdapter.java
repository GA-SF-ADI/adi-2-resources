package com.example.kitty.ecommerceapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kitty on 7/12/16.
 */
public class MyCursorAdapter extends CursorAdapter {

    public MyCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView itemImage = (ImageView) view.findViewById(R.id.item_image);
        TextView itemBrand = (TextView) view.findViewById(R.id.item_brand);
        TextView itemName = (TextView) view.findViewById(R.id.item_name);
        TextView itemPrice = (TextView) view.findViewById(R.id.item_price);

        itemImage.setImageResource(cursor.getInt(cursor.getColumnIndex(Helper.COL_ITEM_PIC)));
        itemBrand.setText(cursor.getString(cursor.getColumnIndex(Helper.COL_ITEM_BRAND)));
        itemName.setText(cursor.getString(cursor.getColumnIndex(Helper.COL_ITEM_NAME)));

        // to check if it's on sale or not, if not found in sales table, default value is 0
        if(cursor.getDouble(cursor.getColumnIndex(Helper.COL_SALE_PRICE))==0) {
            itemPrice.setText("$"+cursor.getDouble(cursor.getColumnIndex(Helper.COL_ITEM_PRICE)));
        } else {
            itemPrice.setText("$"+cursor.getDouble(cursor.getColumnIndex(Helper.COL_SALE_PRICE)));
            itemPrice.setTextColor(Color.RED);
        }
    }
}
