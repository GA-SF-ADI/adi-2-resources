package com.test.crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.crud.Models.Books;

import java.util.List;

/**
 * Created by Jon Kim on 7/22/16.
 */
public class JsonaAdapter extends BaseAdapter{
    ImageView bookImage;
    TextView bookAuthor, bookTitle;
    private List<Books> data;
    private Context context;

    public JsonaAdapter(List<Books> books, Context context) {
        this.data = books;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
        }
        bookImage = (ImageView) view.findViewById(R.id.book_image);
        bookAuthor = (TextView) view.findViewById(R.id.book_author);
        bookTitle = (TextView) view.findViewById(R.id.book_title);

        final Books currentBook = data.get(i);

        if(!currentBook.getImage().isEmpty()) {
            Picasso.with(context).load(currentBook.getImage()).into(bookImage);
        }
        bookAuthor.setText(currentBook.getAuthor());
        bookTitle.setText(currentBook.getTitle());

        return view;
    }
}
