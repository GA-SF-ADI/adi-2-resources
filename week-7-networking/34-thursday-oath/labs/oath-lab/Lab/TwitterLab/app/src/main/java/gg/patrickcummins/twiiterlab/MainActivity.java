package gg.patrickcummins.twiiterlab;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import gg.patrickcummins.twiiterlab.Models.Book;
import gg.patrickcummins.twiiterlab.Models.Books;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    final static String BASEURL = "https://super-crud.herokuapp.com/";

    Button getBooksButton, addBookButton;
    ListView booksListView;
    List<Book> bookList;
    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();

    BooksService booksService = retrofit.create(BooksService.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();

        setOnClickListeners();
    }

    private void setOnClickListeners() {
        getBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllBooks();
            }
        });
        addBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddBookActivity.class);
                startActivity(intent);
            }
        });
        booksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, EditBookActivity.class);
                intent.putExtra("author", bookList.get(position).getAuthor());
                intent.putExtra("title", bookList.get(position).getTitle());
                intent.putExtra("imageUrl", bookList.get(position).getImage());
                intent.putExtra("releaseDate", bookList.get(position).getReleaseDate());
                intent.putExtra("id", bookList.get(position).getId());

                startActivity(intent);
            }
        });
        booksListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                deleteBook(position);
                getAllBooks();
                return false;
            }
        });

    }

    private void deleteBook(int position) {
        Call<Book> call = booksService.deleteBook(bookList.get(position).getId());
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {

            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Not Working", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAllBooks() {
        ConnectivityManager connMngr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkIno = connMngr.getActiveNetworkInfo();

        if (networkIno != null && networkIno.isConnected()) {



            Call<Books> call = booksService.getBooks();

            call.enqueue(new Callback<Books>() {
                @Override
                public void onResponse(Call<Books> call, Response<Books> response) {
                    try {
                        bookList = response.body().getBooks();

                        BookListAdapter bookListAdapter = new BookListAdapter(bookList, MainActivity.this);
                        booksListView.setAdapter(bookListAdapter);


                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                }

                @Override
                public void onFailure(Call<Books> call, Throwable t) {

                }
            });
        }
    }

    private void setViews() {
        getBooksButton = (Button) findViewById(R.id.getBooksButton);
        addBookButton = (Button) findViewById(R.id.addBookButton);

        booksListView = (ListView) findViewById(R.id.booksListView);

    }
}
