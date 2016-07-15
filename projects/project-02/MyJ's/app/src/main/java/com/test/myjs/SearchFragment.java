package com.test.myjs;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
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
    String resultQuery;
    ListView resultsListView;
    ShoeOpenHelper helper;
    HomeFragment.OnShoeSelectClickListener mShoeSelect;
    ImageView noSearchImage;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mShoeSelect = (HomeFragment.OnShoeSelectClickListener)getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnShoeSelectClickListener");

        }}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        resultsListView = (ListView) v.findViewById(R.id.search_results_lv);
        //checking if result query is null, if true, list view is hidden and image is shown
        //if !null setResultsView is called
        if (resultQuery ==null) {
            Log.d("search query", "query:"+resultQuery);
            resultsListView.setVisibility(View.INVISIBLE);
            noSearchImage = (ImageView) v.findViewById(R.id.no_search_image);
            noSearchImage.setImageResource(R.drawable.air_j);
            noSearchImage.setVisibility(View.VISIBLE);
        } else {

                setResultsView();
        }
        return v;
    }



    public void setResultQuery(String resultQuery) {
        if ( getContext()!=null)
        {this.resultQuery = resultQuery;
        setResultsView();}

    }
    // method sets views, on click implements OnShoeSelectedListener to send shoe id to Main
    public void setResultsView(){
        noSearchImage.setVisibility(View.GONE);
        resultsListView.setVisibility(View.VISIBLE);
        final Cursor cursor = helper.getInstance(getContext()).search(resultQuery);

        CursorAdapter cursorAdapter = new CursorAdapter(getContext(), cursor, 0) {

            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                ImageView itemImageView = (ImageView) view.findViewById(R.id.shoe_img_home);
                TextView itemNameText = (TextView) view.findViewById(R.id.shoe_name_home);
                itemImageView.setImageResource(cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_IMG_ID)));
                itemNameText.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_NAME)));
            }
        };
        resultsListView.setAdapter(cursorAdapter);


        resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mShoeSelect.onShoeSelected(id);
            }
        });
      }
    }



