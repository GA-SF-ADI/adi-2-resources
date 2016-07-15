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
    OnShoeSelectClickListener mShoeSelect;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //casting activity with interface
        try{
            mShoeSelect = (OnShoeSelectClickListener)getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnRandImageClickListener");

    }}



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflate fragment view
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
                TextView itemPrice=(TextView)view.findViewById(R.id.price_list_home);
                itemImageView.setImageResource(cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_IMG_ID)));
                itemNameText.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_NAME)));
                itemPrice.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_PRICE)));
            }
        };
        //random int to display random image in home fragment ImageButton
        Random r = new Random();
        final int rand = r.nextInt(22)+1;
        //setting cursor to random position, setting shoe selected properies to views
        cursor.moveToFirst();
        cursor.move(rand);
        homeListView.setAdapter(cursorAdapter);
        homeImageButton.setImageResource(cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_IMG_ID)));
        homeShoeName.setText(cursor.getString(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_NAME)));
        //homeImageButton click implements interface and sends shoe id to main activity
        homeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            cursor.moveToPosition(rand);
                mShoeSelect.onShoeSelected(cursor.getInt(cursor.getColumnIndex(ShoeOpenHelper.DataEntryShoes.COL_ID)));
            }
        });
            //on item click the OnShoeSelectedListener is implemented to send shoe Id to MainActivity
            homeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mShoeSelect.onShoeSelected(id);
            }
        });
        return v;

    }
    //created interface to send data to main activity
    public interface OnShoeSelectClickListener{
        public void onShoeSelected(long id);
    }

}

