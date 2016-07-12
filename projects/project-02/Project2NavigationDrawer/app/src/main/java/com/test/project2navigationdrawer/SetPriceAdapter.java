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

    LayoutInflater layoutInflater;

    public SetPriceAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.layoutInflater = layoutInflater;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fragment_shopping_cart, parent, false);

    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView priceTextView = (TextView) view.findViewById(R.id.shopping_fragment_total_cost);

    }
};

