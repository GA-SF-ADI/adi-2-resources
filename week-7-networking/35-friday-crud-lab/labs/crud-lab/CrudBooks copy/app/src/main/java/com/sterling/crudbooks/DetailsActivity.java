package com.sterling.crudbooks;

/**
 * Created by sterlinggerritz on 7/24/16.
 */

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsActivity extends AppCompatActivity {
    private ImageView picassoCover;
    private Button save, delete;
    String baseUrl = "https://super-crud.herokuapp.com";
    private Book thisOne;
    private EditText title, author, year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        consolidateViews();
        setBookProperties();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                thisOne.setTitle(title.getText().toString());
                thisOne.setAuthor(author.getText().toString());
                thisOne.setReleaseDate(year.getText().toString());
                save(thisOne.getId(),thisOne);

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteBook(thisOne.getId());

            }
        });

    }
    public void consolidateViews(){
        picassoCover = (ImageView)findViewById(R.id.bookdetails);
        title = (EditText)findViewById(R.id.titledetails);
        author = (EditText)findViewById(R.id.authordetails);
        year= (EditText)findViewById(R.id.yeardetails);
        save = (Button)findViewById(R.id.savedetails);
        delete = (Button)findViewById(R.id.deletedetails);

    }
    public void setBookProperties(){
        Intent recIntent = getIntent();

        thisOne = (Book)recIntent.getSerializableExtra(MainActivity.CURRENT_BOOK);
        Picasso.with(DetailsActivity.this).load(thisOne.getImage()).into(picassoCover);
        title.setText(thisOne.getTitle());
        author.setText(thisOne.getAuthor());
        year.setText(thisOne.getReleaseDate());

    }
    public void deleteBook(String id) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RetroInterface retroInterface = retrofit.create(RetroInterface.class);
            Call<Example> call = retroInterface.deleteBook(id);

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    try {
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });
       }
    }
    public void save(String id, Book book) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            RetroInterface retroInterface = retrofit.create(RetroInterface.class);
            Call<Example> call = retroInterface.save(id,book);



            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    try {


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });



        }

    }

}