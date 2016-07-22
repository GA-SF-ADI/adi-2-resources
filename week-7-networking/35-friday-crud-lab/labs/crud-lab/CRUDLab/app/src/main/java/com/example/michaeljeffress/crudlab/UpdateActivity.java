package com.example.michaeljeffress.crudlab;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
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
    TextView textView_Title;
    ImageView imageView;
    TextView textView_Author;
    TextView textView_ReleaseDate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_Title = (TextView) findViewById(R.id.textView_title);
        imageView = (ImageView) findViewById(R.id.imageView_image);
        textView_Author = (TextView) findViewById(R.id.textView_author);
        textView_ReleaseDate = (TextView) findViewById(R.id.textView_releasedate);



    }

    protected void getBookInfo(String title, String image, String author, String releaseDate) {
        Log.d("MainActivity: ", "getting book info");

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            CRUDInterface service = retrofit.create(CRUDInterface.class);

            Call<Bookshelf> call = service.getBooks();

            call.enqueue(new Callback<Bookshelf>() {
                @Override
                public void onResponse(Call<Bookshelf> call, Response<Bookshelf> response) {

                    try {

                        String title = response.body().getTitle();

                        String image = response.body().getImage();

                        String author = response.body().getAuthor();

                        String releaseDate = response.body().getReleaseDate();


                        textView_Title.setText(title);
                        textView_Author.setText(author);
                        textView_ReleaseDate.setText(releaseDate);

                        Picasso.with(UpdateActivity.this).load(image).into(imageView);


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
