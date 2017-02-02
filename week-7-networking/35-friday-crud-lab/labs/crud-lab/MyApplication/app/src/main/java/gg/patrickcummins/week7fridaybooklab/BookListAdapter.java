package gg.patrickcummins.week7fridaybooklab;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.List;

import gg.patrickcummins.week7fridaybooklab.Models.Book;

/**
 * Created by patrickcummins on 7/22/16.
 */

public class BookListAdapter extends BaseAdapter {
    private List<Book> bookList;
    private Context context;

    public BookListAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.book_item_layout, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Book  currentBook = bookList.get(position);

        viewHolder.authorTextView.setText("Author: " + currentBook.getAuthor());
        viewHolder.titleTextView.setText("Book: " + currentBook.getTitle());
        viewHolder.releaseDateTextView.setText("Release Date: " + currentBook.getReleaseDate());

        Picasso.with(context).load(currentBook.getImage()).into(viewHolder.bookImageView);

        return convertView;
    }
    private class ViewHolder {
        TextView authorTextView, titleTextView, releaseDateTextView;
        ImageView bookImageView;

        public ViewHolder(View itemLayout) {
            this.authorTextView = (TextView) itemLayout.findViewById(R.id.authorTextView);
            this.titleTextView = (TextView) itemLayout.findViewById(R.id.titleTextView);
            this.releaseDateTextView = (TextView) itemLayout.findViewById(R.id.releaseDateTextView);
            this.bookImageView = (ImageView) itemLayout.findViewById(R.id.bookImageView);
        }
    }
}
