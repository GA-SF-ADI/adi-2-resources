package com.example.hollis.booksapi.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hollis.booksapi.Models.Book;
import com.example.hollis.booksapi.R;
import com.squareup.picasso.Picasso;

/**
 * Created by hollis on 7/8/16.
 */
public class CustomBookAdapter extends BaseAdapter {
   Book[] data;
    Context context;

    public CustomBookAdapter(Book[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder vh;
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.book_layout, parent,false);
             vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        }else{
             vh = (ViewHolder) convertView.getTag();
        }
        Book curBook = data[position];
        vh.titleText.setText(curBook.getTitle());
        vh.authorText.setText(curBook.getAuthor());
        vh.releaseText.setText(curBook.getRelease_date());
        Picasso.with(context)
                .load(curBook.getImage())
                .into(vh.imageView);
        return convertView;
    }

    public class ViewHolder{
        TextView titleText;
        TextView authorText;
        TextView releaseText;
        ImageView imageView;

        public ViewHolder(View v){
            titleText = (TextView) v.findViewById(R.id.book_title);
            authorText = (TextView) v.findViewById(R.id.book_author);
            releaseText = (TextView) v.findViewById(R.id.book_release_date);
            imageView = (ImageView) v.findViewById(R.id.book_image);
        }
    }
}
