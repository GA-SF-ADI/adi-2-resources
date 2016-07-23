package com.test.crud;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.test.crud.Models.Books;
import com.test.crud.Models.Library;
import com.test.crud.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {
    ImageView detailImage;
    EditText detailTitle, detailAuthor, detailDate, detailEditImage;
    Button editButton;
    Books books;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setViews();
        //receive intent from main activity for the book that was clicked and sets views with the values.
        Books curBook = (Books)getIntent().getSerializableExtra("book");
        if(!curBook.getImage().isEmpty()) {
            Picasso.with(DetailActivity.this).load(curBook.getImage()).into(detailImage);
        }
        detailTitle.setText(curBook.getTitle());
        detailAuthor.setText(curBook.getAuthor());
        detailDate.setText(curBook.getReleaseDate());

        id = curBook.get_id();
        //takes values from edittexts and makes new a book object that is sent to editbook method.
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                books = new Books();
                books.setTitle(detailTitle.getText().toString());
                books.setAuthor(detailAuthor.getText().toString());
                books.setReleaseDate(detailDate.getText().toString());
                books.setImage(detailEditImage.getText().toString());
                editBook(id, books);
                finish();
            }
        });

    }

    protected void setViews(){
        detailImage = (ImageView) findViewById(R.id.detail_image);
        detailTitle = (EditText) findViewById(R.id.detail_title);
        detailAuthor = (EditText) findViewById(R.id.detail_author);
        detailDate = (EditText) findViewById(R.id.detail_release_date);
        detailEditImage = (EditText) findViewById(R.id.detail_image_edit);
        editButton = (Button) findViewById(R.id.detail_edit_button);
    }
    //gets the id, book object to make the call for updating book.
    protected void editBook(String id, Books books){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(MainActivity.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            BookService service = retrofit.create(BookService.class);
            //TODO
            Call<Books> call = service.updateBook(id,books);

            call.enqueue(new Callback<Books>() {
                @Override
                public void onResponse(Call<Books> call, Response<Books> response) {

                    try {


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Books> call, Throwable t) {

                }
            });
        } else {
            Toast.makeText(DetailActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }
}
