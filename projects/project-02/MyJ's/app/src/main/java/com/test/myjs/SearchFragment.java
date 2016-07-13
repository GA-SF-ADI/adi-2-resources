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
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nolbertoarroyo on 7/9/16.
 */
public class SearchFragment extends Fragment {
    ArrayList<Shoe> resultsShoeList;
    ListView resultsListView;
    ShoeOpenHelper helper;
    HomeFragment.OnRandImageClickListener mRandImage;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mRandImage = (HomeFragment.OnRandImageClickListener)getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnRandImageClickListener");

        }}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_search,container,false);
        resultsListView = (ListView)v.findViewById(R.id.search_results_lv);
        final Cursor cursor = helper.getInstance(getContext()).getShoesList();

        CursorAdapter cursorAdapter = new CursorAdapter(getContext(),cursor,0) {

            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                ImageView itemImageView = (ImageView) view.findViewById(R.id.shoe_img_home);
                TextView itemNameText = (TextView)view.findViewById(R.id.shoe_name_home);
                itemImageView.setImageResource(cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_IMG_ID)));
                itemNameText.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_NAME)));
            }
        };resultsListView.setAdapter(cursorAdapter);


        resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_IMG_ID);
                mRandImage.onRandImageSelected(itemSelected);
            }
        });
        return v;

    }
}
