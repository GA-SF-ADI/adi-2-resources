package com.example.kitty.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kitty.myapplication.Models.Book;

import java.util.List;

/**
 * Created by kitty on 7/25/16.
 */
public class CustomAdapter extends BaseAdapter {

    private List<Book> books;
    private Context context;
    private ViewHolder viewHolder;

    public CustomAdapter(List<Book> books, Context context) {
        this.books = books;
        this.context = context;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int i) {
        return books.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.book_list_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final Book currentBook = books.get(i);

        // ToDo: to set up view holder

        return view;
    }

    private class ViewHolder {
        TextView titleTextView;
        TextView authorTextView;
        TextView dateTextView;
        ImageView image;

        public ViewHolder(View itemLayout){
            this.titleTextView = (TextView) itemLayout.findViewById(R.id.list_item_title);
            this.authorTextView = (TextView) itemLayout.findViewById(R.id.list_item_author);
            this.dateTextView = (TextView) itemLayout.findViewById(R.id.list_item_date);
            this.image = (ImageView) itemLayout.findViewById(R.id.list_item_image);

        }
    }

}
