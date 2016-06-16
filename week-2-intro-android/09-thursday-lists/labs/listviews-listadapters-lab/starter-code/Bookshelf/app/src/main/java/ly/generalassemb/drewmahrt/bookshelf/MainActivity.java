package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mAdapter;
    //TODO: Define your other Adapters
    BaseAdapter mYearAdapter;
    BaseAdapter mAuthorAdapter;
    //TODO: Define your ListView
    ListView mListView;

    //TODO: Define your Book List
    List<Book> mBookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView  = (ListView) findViewById(R.id.myListView);

        //TODO: Instantiate List
        mBookList = generateBooks();

        //TODO: Instantiate BaseAdapters for year, author, title
        //Below is a partially complete example for one Adapter
        mAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {
                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = convertView;

                if (convertView == null) {
                    LayoutInflater li = (LayoutInflater) MainActivity.this
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = li.inflate(R.layout.book_list_item, null);
                }

                TextView textView1 = (TextView)v.findViewById(R.id.text1);
                //TODO: Get other TextViews
                TextView  textView2 = (TextView) v.findViewById(R.id.text2);
                TextView  textView3 = (TextView) v.findViewById(R.id.text3);

                textView1.setText("Title: "+mBookList.get(position).getTitle());
                //TODO: Set text for other TextViews
                textView2.setText("Author: " + mBookList.get(position).getAuthor());
                textView3.setText("Year: " + mBookList.get(position).getYear());



                return v;
            }
        };
        mListView.setAdapter(mAdapter);



        //TODO: Set listeners for buttons
        Button sortByAuthor = (Button) findViewById(R.id.authorSort);
        Button sortByTitle = (Button) findViewById(R.id.titleSort);
        Button sortByYear = (Button) findViewById(R.id.yearSort);

        sortByAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mBookList, new ComparatorAuthor());
                mAdapter.notifyDataSetChanged();
            }
        });
        sortByTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mBookList, new ComparatorTitle());
                mAdapter.notifyDataSetChanged();
            }
        });
        sortByYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mBookList, new ComparatorYear());
                mAdapter.notifyDataSetChanged();
            }
        });



    }

    //Method to generate a list of Books
    private List<Book> generateBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book("Apples Book","Brad","1950"));
        books.add(new Book("Cats Book","Ryan","1920"));
        books.add(new Book("Eagles Book","Kate","1987"));
        books.add(new Book("Strawberries Cathy","Brad","1982"));
        books.add(new Book("Dogs Book","Tom","2005"));
        books.add(new Book("Ants Book","Zane","2001"));

        return books;
    }
}
