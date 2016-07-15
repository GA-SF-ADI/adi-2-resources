package com.test.myjs;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by nolbertoarroyo on 7/9/16.
 */
public class ShoppingCartFragment extends Fragment {
    ShoeOpenHelper shoeHelper;
    ShoppingCart cart;
    ListView cartView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_shopping_cart,container,false);
        TextView cartTotal = (TextView)v.findViewById(R.id.cart_total);
        TextView cartPrice = (TextView)v.findViewById(R.id.cart_price);
        Button checkoutButton = (Button)v.findViewById(R.id.buy_button);
        Button emptyCart = (Button)v.findViewById(R.id.empty_cart);
        cartView = (ListView)v.findViewById(R.id.shopping_ListView);
        Cursor cursor = shoeHelper.getInstance(getContext()).getShoppingCart();

        CursorAdapter cursorAdapter = new CursorAdapter(getContext(),cursor,0) {

            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.cart_item_list,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

                ImageView shoeImage = (ImageView)view.findViewById(R.id.shoe_img_cart);
                TextView shoeName = (TextView)view.findViewById(R.id.shoe_name_cart);
                TextView cart = (TextView)view.findViewById(R.id.cart);
                TextView itemPrice = (TextView) view.findViewById(R.id.cart_item_price);

                shoeImage.setImageResource(cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoppingCart.COL_ITEM_IMAGE_ID)));
                shoeName.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoppingCart.COL_ITEM_NAME)));
                itemPrice.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoppingCart.COL_CART_PRICE)));

            }
        };cartView.setAdapter(cursorAdapter);
        return v;
    }
}
