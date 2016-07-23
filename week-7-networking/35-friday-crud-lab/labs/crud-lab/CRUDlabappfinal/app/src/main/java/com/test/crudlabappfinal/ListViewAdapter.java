package com.test.crudlabappfinal;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LangstonSmith on 7/22/16.
 */
public class ListViewAdapter extends BaseAdapter {

    private Book[] allBooks;
    private Context context;
    ImageButton deleteBookButton;
    ListView listView;
    String selectedID;
    String selectedTitle;
    String selectedAuthor;
    String selectedImage;
    String selectedDate;
    String selectedV;


    private static String baseUrl = "https://super-crud.herokuapp.com";


    public ListViewAdapter(Book[] allBooks, Context context) {
        this.allBooks = allBooks;
        this.context = context;
    }

    @Override
    public int getCount() {

        return allBooks.length;
    }

    @Override
    public Object getItem(int position) {

        return allBooks[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.single_book_listview_item, parent, false);
        }

        ImageView bookImage = (ImageView) convertView.findViewById(R.id.imageView_book_cover);
        TextView bookTitle = (TextView) convertView.findViewById(R.id.textView_name_of_book_in_list);
        deleteBookButton = (ImageButton) convertView.findViewById(R.id.imageButton_delete_book_x);

        final Book currentBook = allBooks[position];

        final String selectedBookID = currentBook.getId();

        bookTitle.setText(currentBook.getTitle());

        listView = (ListView) convertView.findViewById(R.id.listView_of_books);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                BookInterface service = retrofit.create(BookInterface.class);

                ListView listView = (ListView) view.findViewById(R.id.listView_of_books);

                Call<Book> call = service.getSpecificBook(selectedBookID);


                call.enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {

                        try {


                            Intent editBookIntent = new Intent(context, EditBookActivity.class);

                            editBookIntent.putExtra("selectedBookID", selectedBookID);

                            context.startActivity(editBookIntent);


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {

                    }
                });

            }
        });


        deleteBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("Adapter", "onClick: Clicked");

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                BookInterface service = retrofit.create(BookInterface.class);

                ListView listView = (ListView) view.findViewById(R.id.listView_of_books);

                Call<Book> call = service.deleteSpecificBook(selectedBookID);

                call.enqueue(new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {

                        try {

                            notifyDataSetChanged();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {

                        t.printStackTrace();
                    }
                });


            }
        });
        return convertView;

    }

}
