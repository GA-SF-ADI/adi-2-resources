package gg.patrickcummins.week7fridaybooklab;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gg.patrickcummins.week7fridaybooklab.Models.Book;
import gg.patrickcummins.week7fridaybooklab.Models.Books;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddBookActivity extends AppCompatActivity {

    EditText titleEditText, authorEditText, imageUrlEditText, releaseDateEditText;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        setViews();

        setOnClickListeners();
    }

    private void setOnClickListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addBook();
                finish();
            }
        });
    }

    private void addBook() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            Retrofit retrofit = new Retrofit.Builder().baseUrl(MainActivity.BASEURL).addConverterFactory(GsonConverterFactory.create()).build();

            BooksService booksService = retrofit.create(BooksService.class);

            Book book = new Book();
            book.setTitle(titleEditText.getText().toString());
            book.setAuthor(authorEditText.getText().toString());
            book.setImage(imageUrlEditText.getText().toString());
            book.setReleaseDate(releaseDateEditText.getText().toString());


            Call<Book> call = booksService.addBook(book);
            call.enqueue(new Callback<Book>() {
                @Override
                public void onResponse(Call<Book> call, Response<Book> response) {

                }

                @Override
                public void onFailure(Call<Book> call, Throwable t) {

                    t.printStackTrace();

                    Toast.makeText(AddBookActivity.this, "Not Working", Toast.LENGTH_SHORT).show();

                }
            });


        }



    }

    private void setViews() {

        titleEditText = (EditText) findViewById(R.id.titleEditText);
        authorEditText = (EditText) findViewById(R.id.authorEditText);
        imageUrlEditText = (EditText) findViewById(R.id.pictureEditText);
        releaseDateEditText = (EditText) findViewById(R.id.releaseDateEditText);

        submitButton = (Button) findViewById(R.id.submitButton);

    }
}
