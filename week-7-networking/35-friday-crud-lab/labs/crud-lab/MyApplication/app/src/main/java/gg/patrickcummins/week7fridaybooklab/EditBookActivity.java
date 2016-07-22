package gg.patrickcummins.week7fridaybooklab;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gg.patrickcummins.week7fridaybooklab.Models.Book;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class EditBookActivity extends AppCompatActivity {
    EditText titleEditText, authorEditText, imageUrlEditText, releaseDateEditText;
    Button submitButton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        setViews();

        setEditTexts();
        setOnClicks();
    }

    private void setOnClicks() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()){
                    Retrofit retrofit = new Retrofit.Builder().baseUrl(MainActivity.BASEURL).addConverterFactory(GsonConverterFactory.create()).build();

                    BooksService booksService = retrofit.create(BooksService.class);

                    Book book = new Book();
                    String title, author, image, releaseDate, id;
                    title = titleEditText.getText().toString();
                    author =authorEditText.getText().toString();
                    image = imageUrlEditText.getText().toString();
                    releaseDate = releaseDateEditText.getText().toString();
                    id = intent.getStringExtra("id");
                    book.setTitle(title);
                    book.setAuthor(author);
                    book.setImage(image);
                    book.setReleaseDate(releaseDate);


                    Call<Book> call = booksService.updateBook( book, id);
                    call.enqueue(new Callback<Book>() {
                        @Override
                        public void onResponse(Call<Book> call, Response<Book> response) {

                        }

                        @Override
                        public void onFailure(Call<Book> call, Throwable t) {

                            t.printStackTrace();

                            Toast.makeText(EditBookActivity.this, "Not Working", Toast.LENGTH_SHORT).show();

                        }
                    });
                    finish();
                    


                }
            }
        });
    }

    private void setEditTexts() {
        intent = getIntent();

        titleEditText.setText(intent.getStringExtra("title"));
        authorEditText.setText(intent.getStringExtra("author"));
        imageUrlEditText.setText(intent.getStringExtra("imageUrl"));
        releaseDateEditText.setText(intent.getStringExtra("releaseDate"));
    }

    private void setViews() {

        titleEditText = (EditText) findViewById(R.id.titleEditText);
        authorEditText = (EditText) findViewById(R.id.authorEditText);
        imageUrlEditText = (EditText) findViewById(R.id.pictureEditText);
        releaseDateEditText = (EditText) findViewById(R.id.releaseDateEditText);

        submitButton = (Button) findViewById(R.id.submitButton);

    }
}
