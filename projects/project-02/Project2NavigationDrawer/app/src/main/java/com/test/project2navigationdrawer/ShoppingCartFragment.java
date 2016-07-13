package com.test.project2navigationdrawer;

import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


public class ShoppingCartFragment extends Fragment {

    ShoppingCartSingleton shoppingCartSingleton;
    ListView listView;
    TextView textView;
    SetPriceAdapter setPriceAdapter;
    DatabaseHelper myDb;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        shoppingCartSingleton = ShoppingCartSingleton.getInstance();

        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        //listView = (ListView) findViewById(R.id.shopping_fragment_total_cost_list_view);
        listView.setAdapter(setPriceAdapter);
        return view;

//        just added this part...tried to set custom adapter and listview to show price...

//        Cursor cursor = myDb.getJewelry();
//        setPriceAdapter = new SetPriceAdapter(this, cursor, 0);
//        listView = (ListView) findViewById(R.id.shopping_fragment_total_cost_list_view);
//        listView.setAdapter(setPriceAdapter);

        // create view object based on inflater
        //get inner views from that
        //set inner views based on shopping cart singleton
        //return view you made


    }


    public double returnTotal(Item item) {

        double totalCost = 0;

        for (int i = 0; i < shoppingCartSingleton.getItem().size(); i++) {
            totalCost = totalCost + item.getPrice();
        }
        return totalCost;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

    }

}
