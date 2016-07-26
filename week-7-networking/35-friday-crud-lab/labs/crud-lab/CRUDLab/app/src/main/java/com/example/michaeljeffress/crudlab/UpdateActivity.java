package com.example.michaeljeffress.crudlab;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by michaeljeffress on 7/22/16.
 */
public class UpdateActivity extends AppCompatActivity{
    private static String baseUrl = "https://super-crud.herokuapp.com";
    EditText editText_Title;
    EditText editText_URL;
    ImageView imageView;
    EditText editText_Author;
    EditText editText_ReleaseDate;
    Button button_Update;

    String title_Update;
    String url_Update;
    String author_Update;
    String releaseDate_Update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_layout);

        editText_Title = (EditText) findViewById(R.id.editText_Title);
        imageView = (ImageView) findViewById(R.id.imageView_Image);
        editText_URL = (EditText) findViewById(R.id.editText_URL);
        editText_Author = (EditText) findViewById(R.id.editText_Author);
        editText_ReleaseDate = (EditText) findViewById(R.id.editText_ReleaseDate);
        button_Update = (Button) findViewById(R.id.button_Update);



        Intent intent = getIntent();
        Books books = (Books)intent.getSerializableExtra("books");
 //       books.setTitle(intent.get);

    }

    protected void getBookInfo(String title, String image, String author, String releaseDate) {
        Log.d("UpdateActivity: ", "getting book info");

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            CRUDInterface service = retrofit.create(CRUDInterface.class);

            Call<Bookshelf> call = service.updateBook(Books);

            call.enqueue(new Callback<Bookshelf>() {
                @Override
                public void onResponse(Call<Bookshelf> call, Response<Bookshelf> response) {

                    try {

                        Books[] books = response.body().getBooks();

//                        String title = response.body().getTitle();
//
//                        String image = response.body().getImage();
//
//                        String author = response.body().getAuthor();
//
//                        String releaseDate = response.body().getReleaseDate();

//
//                        editText_Title.setText(title);
//                        editText_Author.setText(author);
//                        editText_ReleaseDate.setText(releaseDate);
//
//                        Picasso.with(UpdateActivity.this).load(image).into(imageView);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<Bookshelf> call, Throwable t) {

                }
            });

        } else {
            Toast.makeText(UpdateActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }


}
