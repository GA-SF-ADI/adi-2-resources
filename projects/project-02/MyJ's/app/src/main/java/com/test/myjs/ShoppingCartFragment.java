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
import android.widget.Toast;

/**
 * Created by nolbertoarroyo on 7/9/16.
 */
public class ShoppingCartFragment extends Fragment {
    ShoeOpenHelper shoeHelper;
    ListView cartView;
    TextView cartTotal;
    TextView cartPrice;
    Button checkoutButton;
    Button emptyCart;

    @Nullable
    @Override//finding views for fragment layout
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        cartTotal = (TextView) v.findViewById(R.id.cart_total);
        cartPrice = (TextView) v.findViewById(R.id.cart_price);
        checkoutButton = (Button) v.findViewById(R.id.shopping_cart_buy_button);
        emptyCart = (Button) v.findViewById(R.id.empty_cart);
        cartView = (ListView) v.findViewById(R.id.shopping_ListView);

        Cursor cursor = shoeHelper.getInstance(getContext()).getShoppingCart();

        CursorAdapter cursorAdapter = new CursorAdapter(getContext(), cursor, 0) {

            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.cart_item_list, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

                ImageView shoeImage = (ImageView) view.findViewById(R.id.shoe_img_cart);
                TextView shoeName = (TextView) view.findViewById(R.id.shoe_name_cart);
                TextView cart = (TextView) view.findViewById(R.id.cart);
                TextView itemPrice = (TextView) view.findViewById(R.id.cart_item_price);

                //setting values for shoe properties in shopping cart
                shoeImage.setImageResource(cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoppingCart.COL_ITEM_IMAGE_ID)));
                shoeName.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoppingCart.COL_ITEM_NAME)));
                itemPrice.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoppingCart.COL_CART_PRICE)));

            }

        };

        cartView.setAdapter(cursorAdapter);
        return v;
    }
}
/*checkoutButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        switch (v.getId()) {
        case R.id.buy_button:
        shoeHelper.deleteAllFromCart();
        Toast.makeText(getContext(), "Thank you for your purchase", Toast.LENGTH_SHORT).show();
        break;
        case R.id.empty_cart:
        shoeHelper.deleteAllFromCart();
        Toast.makeText(getContext(), "Your cart is Empty", Toast.LENGTH_SHORT).show();
        break;
        }
        }
        });
        */