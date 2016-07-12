package com.test.project2navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.database.Cursor;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by audreyeso on 7/11/16.
 */
public class DBAdapter extends CursorAdapter{

    LayoutInflater layoutInflater;

    public DBAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.layoutInflater = layoutInflater;
    }

    //create custom adapter

        //CursorAdapter cursorAdapter = new CursorAdapter(SecondActivity.this,iconCursor,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView typeOfJewelryTextView = (TextView)view.findViewById(R.id.text_view_type_of_jewelry);
                TextView priceOfJewelryTextView = (TextView)view.findViewById(R.id.text_view_price_of_jewelry);


                //iconImageView.setImageResource(getDrawableValue(cursor.getString(cursor.getColumnIndex(IconSQLiteOpenHelper.COL_ICON_NAME))));
                //iconTextView.setText(cursor.getString(cursor.getColumnIndex(IconSQLiteOpenHelper.COL_ICON_NAME)));
            }
        };


