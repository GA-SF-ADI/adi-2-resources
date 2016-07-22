package com.example.michaeljeffress.crudlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by michaeljeffress on 7/22/16.
 */
public class ListCustomAdapter extends ArrayAdapter {
    int resource;
    Books [] books;

    public ListCustomAdapter(Context context, int resource, Books[] objects) {
        super(context, resource, objects);
        this.resource = resource;
        books = objects;

    }

    @Override
    public int getCount() {
        return books.length;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(resource,null);
        }

        TextView title = (TextView) view.findViewById(R.id.textView_title);

        Books curBook = books [position];

        title.setText(curBook.getTitle());


        return view;
    }


}
