package com.test.project2navigationdrawer;

import android.content.ClipData;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class ShoppingCartFragment extends Fragment {

    ShoppingCartSingleton shoppingCartSingleton;
    ListView listView;
    TextView textView;
    SetPriceAdapter setPriceAdapter;
    DatabaseHelper myDb;
    Button removeButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        shoppingCartSingleton = ShoppingCartSingleton.getInstance();

        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        textView = (TextView) view.findViewById(R.id.shopping_fragment_total_cost_text_view);
        listView = (ListView) view.findViewById(R.id.shopping_fragment_total_cost_list_view);
        removeButton = (Button) view.findViewById(R.id.remove_button);

        removeButton.setOnClickListener(new AdapterView.OnClickListener() {
            public void onClick(View view) {

            }
        });


        //set to String
        //textView.setText("Your total is $" + returnTotal()+"0");
        listView.setAdapter(setPriceAdapter);
        return view;

    }


//
//
//    public double returnTotal() {
//
//        double totalCost = 0;
//
//        for (int i = 0; i < shoppingCartSingleton.getItem().size(); i++) {
//            double price = shoppingCartSingleton.getItem().get(i).getPrice();
//            totalCost = totalCost + price;
//        }
//        return totalCost;
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

    }


}

