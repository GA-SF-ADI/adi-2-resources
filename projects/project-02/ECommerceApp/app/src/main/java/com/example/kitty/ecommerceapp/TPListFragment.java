package com.example.kitty.ecommerceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kitty on 7/12/16.
 */
public class TPListFragment extends ListFragment {

    public static final String TAG = "DataTag";
    public static final String INSERTED_INTO_DATABASE_KEY = "have inserted into database";
    SharedPreferences preferences;

    private Helper db;
    private MyCursorAdapter cursorAdapter;
    private Cursor cursor;

    ItemClickInterface itemClickInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            itemClickInterface = (ItemClickInterface) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement interface  ");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemClickInterface = (ItemClickInterface) getActivity();

        db = Helper.getInstance(getContext());

        //to make sure the data only gets imported once
        preferences = getActivity().getSharedPreferences(TAG, Context.MODE_PRIVATE);
        boolean dataImported = preferences.getBoolean(INSERTED_INTO_DATABASE_KEY, false);
        if(!dataImported) {
            setupAllItems();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cursor = db.getTPList();
        cursorAdapter = new MyCursorAdapter(getActivity(), cursor);
        setListAdapter(cursorAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        TP clickedTP = toTP((Cursor)l.getAdapter().getItem(position));
        itemClickInterface.onItemClicked(clickedTP);
    }


    public void searchTPList(String query) {
        Cursor cursor = db.searchTPList(query);
        cursorAdapter.changeCursor(cursor);
        cursorAdapter.notifyDataSetChanged();
    }

    //setting up database items
    public void setupAllItems() {
        TP tp = new TP("Charmin Ultra Soft", R.drawable.tp_1, "Charmin", 3, "Mega", 12, "some description", 14.99, false);
        db.addTP(tp);

        //make sure to pass sharedPreferences so the data won't get imported again
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(INSERTED_INTO_DATABASE_KEY, true);
        editor.commit();
    }

    // creating TP object from database columns
    public TP toTP(Cursor cursor){
        String name = cursor.getString(cursor.getColumnIndex(Helper.COL_ITEM_NAME));
        int pic = cursor.getInt(cursor.getColumnIndex(Helper.COL_ITEM_PIC));
        String brand = cursor.getString(cursor.getColumnIndex(Helper.COL_ITEM_BRAND));
        int  ply = cursor.getInt(cursor.getColumnIndex(Helper.COL_ITEM_PLY));
        String size = cursor.getString(cursor.getColumnIndex(Helper.COL_ITEM_SIZE));
        int numRoll = cursor.getInt(cursor.getColumnIndex(Helper.COL_ITEM_NUM_ROLL));
        String description = cursor.getString(cursor.getColumnIndex(Helper.COL_ITEM_DESCRIPTION));
        double price = cursor.getDouble(cursor.getColumnIndex(Helper.COL_ITEM_PRICE));
        boolean onSale = true; //need to update to check from sale table in db.

        TP tp = new TP(name, pic, brand, ply, size, numRoll, description, price, onSale);

        return tp;
    }
}
