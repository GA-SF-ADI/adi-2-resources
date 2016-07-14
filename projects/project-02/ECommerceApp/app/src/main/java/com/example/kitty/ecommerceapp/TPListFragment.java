package com.example.kitty.ecommerceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
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

    private String query = null;

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

        if(query == null) {
            cursor = db.getTPList();
        } else {
            cursor = db.searchTPList(query);
            query = null;
        }

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
        this.query = query;
//        Cursor cursor = db.searchTPList(query);
//        cursorAdapter.changeCursor(cursor);
//        cursorAdapter.notifyDataSetChanged();
    }

    //setting up database items
    public void setupAllItems() {

        // adding items
        TP tp1 = new TP("Ultra Soft Toilet Paper", R.drawable.tp_1, "Charmin", 2, "Mega", 12, "Give your family even more of the comforting softness they love with Charmin Ultra Soft Toilet Paper! Its unique Comfort Cushions are softer and 75% more absorbent.", 16.49, true);
        TP tp2 = new TP("Ultra Strong Toilet Paper", R.drawable.tp_2, "Charmin", 2, "Mega", 12, "Pick the pack that cleans better*: Charmin Ultra Strong Toilet Paper! Charmin Ultra Strong 2-ply bath tissue is 4X stronger* when wet. ", 16.49, true);
        TP tp3 = new TP("Ultra Strong Toilet Paper", R.drawable.tp_3, "Charmin", 2, "Double", 24, "Pick the pack that cleans better*: Charmin Ultra Strong Toilet Paper! Charmin Ultra Strong 2-ply bath tissue is 4X stronger* when wet. ", 16.49, true);
        TP tp4 = new TP("1000 Septic-Safe Toilet Paper", R.drawable.tp_4, "Scott", 1, "Regular", 12, "Performance and long lasting rolls with the value you expect.", 12.79, false);
        TP tp5 = new TP("1000 Septic-Safe Toilet Paper", R.drawable.tp_5, "Scott", 1, "Regular", 24, "Performance and long lasting rolls with the value you expect.", 17.99, false);
        TP tp6 = new TP("Angel Soft® Toilet Paper", R.drawable.tp_6, "Angel Soft", 2, "Double", 36, "An ideal balance of softness & strength.", 15.99, false);
        TP tp7 = new TP("Ultra Comfort Care Toilet Paper", R.drawable.tp_7, "Cottonelle", 2, "Double", 18, "You deserve a little luxury in life, and so does your bottom.", 10.99, false);
        TP tp8 = new TP("Ultra Plush Toilet Paper", R.drawable.tp_8, "Quilted Northern", 3, "Double", 48, "Silky. Smooth. Soft.", 25.99, false);
        TP tp9 = new TP("Longer Lasting Toilet Paper", R.drawable.tp_9, "Angel Soft", 2, "Mega", 12, "Stock up on necessities with Angel Soft Toilet Paper Mega Rolls. This package comes with 12 mega rolls that are equal to 48 regular rolls so you can be sure you have enough to last for a while.", 11.59, false);
        TP tp10 = new TP("Sensitive Toilet Paper", R.drawable.tp_10, "Charmin", 2, "Double Plus", 12, "Make going to the bathroom a little more enjoyable with Charmin Sensitive toilet paper!", 10.29, true);

        db.addTP(tp1);
        db.addTP(tp2);
        db.addTP(tp3);
        db.addTP(tp4);
        db.addTP(tp5);
        db.addTP(tp6);
        db.addTP(tp7);
        db.addTP(tp8);
        db.addTP(tp9);
        db.addTP(tp10);

        // adding sale items and prices
        db.addSale(1, 13.99);
        db.addSale(2, 13.99);
        db.addSale(3, 13.99);

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
        double price;
        boolean onSale = true;
        if(cursor.getDouble(cursor.getColumnIndex(Helper.COL_SALE_PRICE))!=0) {
            onSale = true;
            price = cursor.getDouble(cursor.getColumnIndex(Helper.COL_SALE_PRICE));
        } else {
            onSale = false;
            price = cursor.getDouble(cursor.getColumnIndex(Helper.COL_ITEM_PRICE));
        }

        TP tp = new TP(name, pic, brand, ply, size, numRoll, description, price, onSale);

        return tp;
    }
}
