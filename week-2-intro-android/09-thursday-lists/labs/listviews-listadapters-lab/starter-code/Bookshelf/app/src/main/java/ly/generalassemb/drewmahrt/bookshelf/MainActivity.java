package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mTitleAdapter;
<<<<<<< HEAD
    BaseAdapter mAuthorAdapter;
    BaseAdapter mYearAdapter;
    ListView mBookListView;

    List<Book> mBookList;

=======

    //TODO: Define your other Adapters
    BaseAdapter mYearAdapter;
    BaseAdapter mAuthorAdapter;
    BaseAdapter mAdapter;


    //TODO: Define your ListView
    ListView mListView;

    //TODO: Define your Book List
    List<Book> mBookList;
>>>>>>> bookshelf
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        //Instantiate List
        mBookList = generateBooks();
        Collections.sort(mBookList, new ComparatorTitle());

        //Instantiate BaseAdapters for year, author, title
=======
mListView = (ListView) findViewById(R.id.myListView);

        //TODO: Instantiate List
mBookList = generateBooks();
        //TODO: Instantiate BaseAdapters for year, author, title
        //Below is a partially complete example for one Adapter

>>>>>>> bookshelf
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
<<<<<<< HEAD
                TextView textView2 = (TextView)v.findViewById(R.id.text2);
                TextView textView3 = (TextView)v.findViewById(R.id.text3);

                textView1.setText("Title: "+mBookList.get(position).getTitle());
                textView2.setText("Author: "+mBookList.get(position).getAuthor());
                textView3.setText("Year: "+mBookList.get(position).getYear());
                return v;
            }
        };

        mAuthorAdapter = new BaseAdapter() {
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
=======
                //TODO: Get other TextViews
                    TextView textView2 = (TextView)v.findViewById(R.id.text2);
                    TextView textView3 = (TextView)v.findViewById(R.id.text3);

                    //TODO: Set text for other TextViews
                    textView1.setText("Title: "+mBookList.get(position).getTitle());
                    textView2.setText("Author: "+mBookList.get(position).getAuthor());
                    textView3.setText("Year: "+mBookList.get(position).getYear());


>>>>>>> bookshelf

                TextView textView1 = (TextView)v.findViewById(R.id.text1);
                TextView textView2 = (TextView)v.findViewById(R.id.text2);
                TextView textView3 = (TextView)v.findViewById(R.id.text3);

                textView1.setText("Author: "+mBookList.get(position).getAuthor());
                textView2.setText("Title: "+mBookList.get(position).getTitle());
                textView3.setText("Year: "+mBookList.get(position).getYear());
                return v;
            }
        };

<<<<<<< HEAD
        mYearAdapter = new BaseAdapter() {
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
                TextView textView2 = (TextView)v.findViewById(R.id.text2);
                TextView textView3 = (TextView)v.findViewById(R.id.text3);

                textView1.setText("Year: "+mBookList.get(position).getYear());
                textView2.setText("Title: "+mBookList.get(position).getTitle());
                textView3.setText("Author: "+mBookList.get(position).getAuthor());

                return v;
            }
        };

        mBookListView = (ListView)findViewById(R.id.book_list_view);
        mBookListView.setAdapter(mTitleAdapter);

        Button titleSortButton = (Button)findViewById(R.id.sort_title_button);
        Button authorSortButton = (Button)findViewById(R.id.sort_author_button);
        Button yearSortButton = (Button)findViewById(R.id.sort_year_button);

        titleSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mBookList,new ComparatorTitle());
                mBookListView.setAdapter(mTitleAdapter);
                mTitleAdapter.notifyDataSetChanged();
            }
        });

        authorSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mBookList,new ComparatorAuthor());
                mBookListView.setAdapter(mAuthorAdapter);
                mAuthorAdapter.notifyDataSetChanged();
            }
        });

        yearSortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mBookList,new ComparatorYear());
                mBookListView.setAdapter(mYearAdapter);
                mYearAdapter.notifyDataSetChanged();
            }
        });
    }

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
=======
//mListView.setAdapter(mAdapter);

        //TODO: Set listeners for buttons
            Button sortAuthorButton = (Button) findViewById(R.id.sortAuthorxml);
            Button sortTitleButton = (Button) findViewById(R.id.sortTitlexml);
            Button sortYearButton = (Button) findViewById(R.id.sortYearxml);


        sortAuthorButton.setOnClickListener(new View.OnClickListener() {
                @Override
                        public void onClick(View v) {
                    Collections.sort(mBookList, new ComparatorAuthor());
                            mAdapter.notifyDataSetChanged();
                }


            });

        sortTitleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mBookList, new ComparatorTitle());
                mAdapter.notifyDataSetChanged();
            }
                                           });
        sortYearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void OnClick(View v){
                Collections.sort(mBookList, new ComparatorYear());
            }
                                          }
        );


    //Method to generate a list of Books
    private List<Book> generateBooks() {
            List<Book> books = new ArrayList<>();

            books.add(new Book("Apples Book", "Brad", "1950"));
            books.add(new Book("Cats Book", "Ryan", "1920"));
            books.add(new Book("Eagles Book", "Kate", "1987"));
            books.add(new Book("Strawberries Cathy", "Brad", "1982"));
            books.add(new Book("Dogs Book", "Tom", "2005"));
            books.add(new Book("Ants Book", "Zane", "2001"));

            return books;
        }
}}
>>>>>>> bookshelf
