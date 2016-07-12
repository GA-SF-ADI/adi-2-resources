package com.test.project2navigationdrawer;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ShoppingCartFragment extends Fragment {

    ShoppingCartSingleton shoppingCartSingleton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false);
    }


    public ShoppingCartSingleton getShoppingCartSingleton() {
        shoppingCartSingleton.getItem();
        return shoppingCartSingleton;
    }

    public double returnTotal (Item item) {

        double totalCost = 0;

        for(int i = 0; i < shoppingCartSingleton.getItem().size(); i++) {
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
