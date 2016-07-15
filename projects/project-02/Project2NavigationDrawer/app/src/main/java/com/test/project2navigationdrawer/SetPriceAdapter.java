package com.test.project2navigationdrawer;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import junit.framework.Test;

import org.w3c.dom.Text;

/**
 * Created by audreyeso on 7/12/16.
 */
public class SetPriceAdapter extends CursorAdapter {

    //price adapter for shopping cart

    LayoutInflater layoutInflater;

    public SetPriceAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.layoutInflater = layoutInflater;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.price_layout, parent, false);

    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView priceTextView = (TextView) view.findViewById(R.id.text_view_total_price_of_jewels);

       priceTextView.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_3_PRICE)));

    }
};

