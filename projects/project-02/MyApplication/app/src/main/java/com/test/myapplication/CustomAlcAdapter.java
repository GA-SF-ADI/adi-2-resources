package com.test.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jon Kim on 7/11/16.
 */
public class CustomAlcAdapter extends CursorAdapter{
    TextView listAlcName, listAlcPrice;
    ImageView listAlcImage;


    public CustomAlcAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        listAlcName = (TextView)view.findViewById(R.id.list_alc_name);
        listAlcImage = (ImageView)view.findViewById(R.id.list_alc_image);
        listAlcPrice = (TextView)view.findViewById(R.id.list_alc_price);

        listAlcName.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_ALC_NAME)));
        listAlcPrice.setText("$"+cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_ALC_PRICE)));
        listAlcImage.setImageResource(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_ALC_IMAGE)));

    }
}
