package com.test.mycrudbooks;

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
 * Created by nolbertoarroyo on 7/22/16.
 */
public class CustomAdapter extends BaseAdapter {
    ArrayList<Book> bookList;
    Context context;
    private ViewHolder viewHolder;
    public CustomAdapter(Context context, ArrayList<Book> bookList) {
        this.context = context;
        this.bookList= bookList;

    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Book curBook = bookList.get(position);

        Picasso.with(context).load(curBook.getImage()).into(viewHolder.bookImage);
        viewHolder.bookTitle.setText(curBook.getTitle());
        //find views








        return convertView;
    }
    private class ViewHolder {
        ImageView bookImage;
        TextView bookTitle;



        public ViewHolder(View itemLayout){
            bookImage = (ImageView)itemLayout.findViewById(R.id.item_img);
            bookTitle = (TextView)itemLayout.findViewById(R.id.item_title);

        }
    }
}
