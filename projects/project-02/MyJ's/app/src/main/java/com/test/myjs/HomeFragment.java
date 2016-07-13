package com.test.myjs;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.MainThread;
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
import java.util.List;
import java.util.Random;

/**
 * Created by nolbertoarroyo on 7/9/16.
 */
public class HomeFragment extends android.support.v4.app.Fragment {
    ArrayList<Shoe> shoeList;
    ListView homeListView;
    ShoeOpenHelper shoeHelper;
    ImageButton homeImageButton;
    TextView homeShoeName;
    OnRandImageClickListener mRandImage;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mRandImage = (OnRandImageClickListener)getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnRandImageClickListener");

    }}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_home,container,false);
        homeListView = (ListView)v.findViewById(R.id.home_lv);

        homeShoeName = (TextView)v.findViewById(R.id.home_shoe_tv);
        homeImageButton = (ImageButton) v.findViewById(R.id.homeImageButton);
        final Cursor cursor = shoeHelper.getInstance(getContext()).getShoesList();

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
        };

        Random r = new Random();
        int rand = r.nextInt(23)-1;

        cursor.moveToFirst();
        cursor.move(rand);
        homeListView.setAdapter(cursorAdapter);
        homeImageButton.setImageResource(cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_IMG_ID)));
        homeShoeName.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_NAME)));
        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randImgSelected = cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_IMG_ID);
                mRandImage.onRandImageSelected(randImgSelected);
            }
        });homeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemSelected = cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_IMG_ID);
                mRandImage.onRandImageSelected(itemSelected);
            }
        });
        return v;

    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public interface OnRandImageClickListener{
        public void onRandImageSelected(int position);
    }

}

