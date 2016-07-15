package com.example.kitty.ecommerceapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by kitty on 7/14/16.
 */
public class CommentAdapter extends CursorAdapter {

    public CommentAdapter(Context context, Cursor cursor) {
        super(context, cursor);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.comment_item_layout, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        TextView commentRating = (TextView) view.findViewById(R.id.comment_list_rating);
        TextView commentDetail = (TextView) view.findViewById(R.id.comment_list_comment);

        commentRating.setText(cursor.getInt(cursor.getColumnIndex(Helper.COL_REVIEW_RATING)) + " star(s)");
        commentDetail.setText("Comment: " + cursor.getString(cursor.getColumnIndex(Helper.COL_REVIEW_COMMENT)));
    }

}
