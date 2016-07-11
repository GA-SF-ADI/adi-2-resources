package com.test.myjs;

import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nolbertoarroyo on 7/9/16.
 */
public class HomeFragment extends android.support.v4.app.Fragment {
    ArrayList<Shoe> shoeList;
    HomeCustomAdapter customAdapter;
    ListView homeListView;
    ShoeOpenHelper shoeHelper;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_home,container,false);
        homeListView = (ListView)v.findViewById(R.id.home_lv);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // populate list
        shoeList = new ArrayList<Shoe>();



        //declare customadapter
        customAdapter = new HomeCustomAdapter(shoeList,getContext());


        // set custom adapter on our list view
        homeListView.setAdapter(customAdapter);


    }
}
