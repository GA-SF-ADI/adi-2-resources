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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);

    }

}
