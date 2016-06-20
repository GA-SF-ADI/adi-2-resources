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
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mTitleAdapter;
    //TODO: Define your other Adapters
    BaseAdapter mAuthorAdapter;
    BaseAdapter mYearAdapter;
//    BaseAdapter mBookListAdapter;

    //TODO: Define your ListView

    ListView listView;

    //TODO: Define your Book List

    List<Book> mBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO: Instantiate List

        mBookList = generateBooks();
        listView = (ListView) findViewById(R.id.list_view);

        //TODO: Instantiate BaseAdapters for year, author, title


        //Below is a partially complete example for one Adapter
        mTitleAdapter = new BaseAdapter() {
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
                TextView textView2 = (TextView)v.findViewById(R.id.text2);
                TextView textView3 = (TextView)v.findViewById(R.id.text3);

                textView1.setText("Title: "+mBookList.get(position).getTitle());
                //TODO: Set text for other TextViews
                textView2.setText("Author: "+mBookList.get(position).getAuthor());
                textView3.setText("Year: "+mBookList.get(position).getYear());

                return v;
            }
        };


        mAuthorAdapter = new BaseAdapter() {
            @Override
            public int getCount() { return mBookList.size();
            }

            @Override
            public Object getItem(int position) { return mBookList.get(position); }

            @Override
            public long getItemId(int position) { return position; }


            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v =convertView;

                if(convertView== null){
                    LayoutInflater li = (LayoutInflater) MainActivity.this
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = li.inflate(R.layout.book_list_item, null);
                }
                TextView textView1 = (TextView)v.findViewById(R.id.text1);
                //TODO: Get other TextViews
                TextView textView2 = (TextView)v.findViewById(R.id.text2);
                TextView textView3 = (TextView)v.findViewById(R.id.text3);

                textView1.setText("Title: "+mBookList.get(position).getTitle());
                //TODO: Set text for other TextViews
                textView2.setText("Author: "+mBookList.get(position).getAuthor());
                textView3.setText("Year: "+mBookList.get(position).getYear());

                return v;
            }
        };

        mYearAdapter = new BaseAdapter() {
            @Override
            public int getCount() { return mBookList.size();
            }

            @Override
            public Object getItem(int position) { return mBookList.get(position); }

            @Override
            public long getItemId(int position) { return position; }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v =convertView;

                if(convertView== null){
                    LayoutInflater li = (LayoutInflater) MainActivity.this
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v = li.inflate(R.layout.book_list_item, null);
                }
                TextView textView1 = (TextView)v.findViewById(R.id.text1);
                //TODO: Get other TextViews
                TextView textView2 = (TextView)v.findViewById(R.id.text2);
                TextView textView3 = (TextView)v.findViewById(R.id.text3);

                textView1.setText("Title: "+mBookList.get(position).getTitle());
                //TODO: Set text for other TextViews
                textView2.setText("Author: "+mBookList.get(position).getAuthor());
                textView3.setText("Year: "+mBookList.get(position).getYear());

                return v;
            }
        };



        //TODO: Set listeners for buttons

        Button titleButton = (Button) findViewById(R.id.sortByTitle);
        Button authorButton = (Button) findViewById(R.id.sortByAuthor);
        Button yearButton = (Button) findViewById(R.id.sortByYear);

        View.OnClickListener titleButtonOnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Collections.sort(mBookList,new ComparatorTitle());
                mTitleAdapter.notifyDataSetChanged();
                listView.setAdapter(mTitleAdapter);

            }
        };
        titleButton.setOnClickListener(titleButtonOnClickListener);

        View.OnClickListener authorButtonOnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Collections.sort(mBookList, new ComparatorAuthor());
                mAuthorAdapter.notifyDataSetChanged();
                listView.setAdapter(mAuthorAdapter);
            }
        };
        authorButton.setOnClickListener(authorButtonOnClickListener);

        View.OnClickListener yearButtonOnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Collections.sort(mBookList, new ComparatorYear());
                mYearAdapter.notifyDataSetChanged();
                listView.setAdapter(mYearAdapter);
            }
        };
        yearButton.setOnClickListener(yearButtonOnClickListener);


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
