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
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by nolbertoarroyo on 7/9/16.
 */
public class ShoppingCartFragment extends Fragment {
    ShoeOpenHelper shoeHelper;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_shopping_cart,container,false);
        Cursor cursor = shoeHelper.getInstance(getContext()).getShoesList();

        CursorAdapter cursorAdapter = new CursorAdapter(getContext(),cursor,0) {

            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.cart_item_list,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

            }
        };
        return v;
    }
}
