package com.example.kitty.ecommerceapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kitty on 7/12/16.
 */
public class CartCursorAdapter extends CursorAdapter {

    public CartCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cart_item_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView itemImage = (ImageView) view.findViewById(R.id.cart_list_item_image);
        TextView itemBrand = (TextView) view.findViewById(R.id.cart_list_item_brand);
        TextView itemName = (TextView) view.findViewById(R.id.cart_list_item_name);
        TextView itemQuantity = (TextView) view.findViewById(R.id.cart_list_quantity);
        TextView itemPrice = (TextView) view.findViewById(R.id.cart_list_price);

        //to update
        itemImage.setImageResource(cursor.getInt(cursor.getColumnIndex(Helper.COL_ITEM_PIC)));
        itemBrand.setText(cursor.getString(cursor.getColumnIndex(Helper.COL_ITEM_BRAND)));
        itemName.setText(cursor.getString(cursor.getColumnIndex(Helper.COL_ITEM_NAME)));
        itemQuantity.setText(cursor.getInt(cursor.getColumnIndex(Helper.COL_CART_QUANTITY)));

        //calculating price for the number of quantity saved in cart.
        double price = cursor.getDouble(cursor.getColumnIndex(Helper.COL_ITEM_PRICE)) * cursor.getInt(cursor.getColumnIndex(Helper.COL_CART_QUANTITY));

        itemPrice.setText("$"+price);
    }
}
