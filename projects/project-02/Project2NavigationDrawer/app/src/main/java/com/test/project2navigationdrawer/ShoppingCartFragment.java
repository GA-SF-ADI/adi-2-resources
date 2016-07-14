package com.test.project2navigationdrawer;

import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class ShoppingCartFragment extends Fragment {
    DatabaseHelper databaseHelper;
    ListView listView;
    TextView textView;
    SetPriceAdapter setPriceAdapter;
    Button removeButton;

    double totalCost;
    double price;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       // shoppingCartSingleton = ShoppingCartSingleton.getInstance();
        databaseHelper = DatabaseHelper.getInstance(getContext());



        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        textView = (TextView) view.findViewById(R.id.shopping_fragment_total_cost_text_view);
        listView = (ListView) view.findViewById(R.id.shopping_fragment_total_cost_list_view);
        removeButton = (Button) view.findViewById(R.id.remove_button);

        removeButton.setOnClickListener(new AdapterView.OnClickListener() {
            public void onClick(View view) {

                Cursor cursor = databaseHelper.deleteAll();
                cursor.moveToFirst();

                price = 0;
                textView.setText("Your total is $" + price + "0" );
                cursor.moveToNext();
                cursor.close();

            }
        });

        //set to String
        textView.setText("Your total is $" + returnTotal()+"0");
        listView.setAdapter(setPriceAdapter);
        return view;

    }

    public double returnTotal() {

        totalCost = 0;
        Cursor cursor = databaseHelper.getShoppingCart();
        Log.d("cursor", " "+ cursor.getCount());
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
           price = cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.COL_3_PRICE_SHOPPING_CART));
            Log.d("price", " " + price);
            totalCost = totalCost + price;
            cursor.moveToNext();
        }
        cursor.close();
        return totalCost;

    }
//
//        while (int i = 0; i < databaseHelper.getShoppingCart(); i++) {
//            double price = databaseHelper.getShoppingCart().get(i).getPrice();
//            totalCost = totalCost + price;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

    }

}

