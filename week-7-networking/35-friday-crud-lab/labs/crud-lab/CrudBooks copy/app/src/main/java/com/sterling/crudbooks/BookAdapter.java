package com.sterling.crudbooks;

/**
 * Created by sterlinggerritz on 7/24/16.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class BookAdapter extends BaseAdapter {
    ArrayList<Book> library;
    Context context;

    private ViewHolder viewHolder;

    public BookAdapter(Context context, ArrayList<Book> library) {
        this.context = context;
        this.library= library;

    }

    @Override
    public int getCount() {
        return library.size();
    }

    @Override
    public Object getItem(int position) {
        return library.get(position);
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
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Book thisBook = library.get(position);
        Picasso.with(context).load(thisBook.getImage()).into(viewHolder.bookImage);
        viewHolder.bookTitle.setText(thisBook.getTitle());
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
