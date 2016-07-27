package com.example.kitty.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kitty.myapplication.Models.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kitty on 7/25/16.
 */
public class CustomAdapter extends BaseAdapter {

    private String baseURL = "https://super-crud.herokuapp.com";

    private List<Book> books;
    private Context context;
    private ViewHolder viewHolder;

    private BookInterface bookInterface;

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

        viewHolder.titleTextView.setText(currentBook.getTitle());
        viewHolder.authorTextView.setText(currentBook.getAuthor());
        viewHolder.dateTextView.setText(currentBook.getReleaseDate());
        Picasso.with(context).load(currentBook.getImage()).into(viewHolder.image);

        viewHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                bookInterface = retrofit.create(BookInterface.class);

                bookInterface.removeBook(currentBook.getId()).enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {

                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {

                    }
                });
            }
        });

        return view;
    }

    private class ViewHolder {
        TextView titleTextView;
        TextView authorTextView;
        TextView dateTextView;
        ImageView image;
        ImageButton removeButton;

        public ViewHolder(View itemLayout){
            this.titleTextView = (TextView) itemLayout.findViewById(R.id.list_item_title);
            this.authorTextView = (TextView) itemLayout.findViewById(R.id.list_item_author);
            this.dateTextView = (TextView) itemLayout.findViewById(R.id.list_item_date);
            this.image = (ImageView) itemLayout.findViewById(R.id.list_item_image);
            this.removeButton = (ImageButton) itemLayout.findViewById(R.id.list_item_remove);

        }
    }

}
