package com.test.supercrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by audreyeso on 7/22/16.
 */
public class ViewBooksAdapter extends BaseAdapter {
    private List<Books> data;
    private Context context;
    private ViewHolder viewHolder;

    //array adapter or base adapter instead
    //pass in root
    public ViewBooksAdapter(Context context, List<Books> booksList) {

        this.data = booksList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        return null;
//    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.book_item_view, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        final Books currentBook = data.get(position);
        viewHolder.titleTextView.setText(currentBook.getTitle().toString());
        viewHolder.authorTextView.setText(currentBook.getTitle().toString());
        viewHolder.getYearPublishedTextView.setText(currentBook.getTitle().toString());
        //viewHolder.imageView.setImageResource(currentBook.getImage());

        return convertView;
    }


    static class ViewHolder {

        TextView titleTextView;
        TextView authorTextView;
        TextView getYearPublishedTextView;
        ImageView imageView;

        public ViewHolder(View bookItemLayout) {

            this.titleTextView = (TextView) bookItemLayout.findViewById(R.id.book_item_title_textview);
            this.authorTextView = (TextView) bookItemLayout.findViewById(R.id.book_item_author_textview);
            this.getYearPublishedTextView = (TextView) bookItemLayout.findViewById(R.id.book_item_ye_textview);
            imageView = (ImageView) bookItemLayout.findViewById(R.id.product_item_imageView);

        }

        //Picasso.with(ViewBooksAdapter.this).load(imageUrl).into(view);
    }
}



