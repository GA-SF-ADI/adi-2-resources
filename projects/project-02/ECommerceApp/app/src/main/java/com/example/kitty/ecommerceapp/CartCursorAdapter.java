package com.example.kitty.ecommerceapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kitty on 7/12/16.
 */
public class CartCursorAdapter extends CursorAdapter {

    private Runnable itemsUpdatedListener;

    public CartCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cart_item_layout, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        ImageView itemImage = (ImageView) view.findViewById(R.id.cart_list_item_image);
        TextView itemBrand = (TextView) view.findViewById(R.id.cart_list_item_brand);
        TextView itemName = (TextView) view.findViewById(R.id.cart_list_item_name);
        TextView itemQuantity = (TextView) view.findViewById(R.id.cart_list_quantity);
        TextView itemPrice = (TextView) view.findViewById(R.id.cart_list_price);
        ImageButton removeItemButton = (ImageButton) view.findViewById(R.id.cart_remove_item_button);

        itemImage.setImageResource(cursor.getInt(cursor.getColumnIndex(Helper.COL_ITEM_PIC)));
        itemBrand.setText(cursor.getString(cursor.getColumnIndex(Helper.COL_ITEM_BRAND)));
        itemName.setText(cursor.getString(cursor.getColumnIndex(Helper.COL_ITEM_NAME)));
        itemQuantity.setText("x" + cursor.getInt(cursor.getColumnIndex(Helper.COL_CART_QUANTITY)));

        //calculating price for the number of quantity saved in cart.
        double price;
//        if(cursor.getDouble(cursor.getColumnIndex(Helper.COL_SALE_PRICE))!=0) {
//            price = cursor.getDouble(cursor.getColumnIndex(Helper.COL_SALE_PRICE)) * cursor.getInt(cursor.getColumnIndex(Helper.COL_CART_QUANTITY));
//        } else {
            price = cursor.getDouble(cursor.getColumnIndex(Helper.COL_ITEM_PRICE)) * cursor.getInt(cursor.getColumnIndex(Helper.COL_CART_QUANTITY));
//        }
        itemPrice.setText("$"+price);

        //test
        removeItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper helper = Helper.getInstance(context);
                helper.deleteItemFromCart(cursor.getInt(cursor.getColumnIndex(Helper.COL_CART_ID)));
                swapCursor(helper.getItemJoinCartJoinSale());
                Toast.makeText(context, "Item removed!", Toast.LENGTH_SHORT).show();
                if (itemsUpdatedListener != null) {
                    itemsUpdatedListener.run();
                }
            }
        });
    }

    public void setItemsUpdatedListener(Runnable listener) {
        this.itemsUpdatedListener = listener;
    }
}
