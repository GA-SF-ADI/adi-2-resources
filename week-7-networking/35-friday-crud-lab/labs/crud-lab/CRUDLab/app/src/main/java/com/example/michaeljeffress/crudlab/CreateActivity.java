package com.example.michaeljeffress.crudlab;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by michaeljeffress on 7/22/16.
 */
public class CreateActivity extends AppCompatActivity{

    private static String baseUrl = "https://super-crud.herokuapp.com";

    EditText editText_Title_Create;
    EditText editText_ImageURL_Create;
    EditText editText_Author_Create;
    EditText editText_ReleaseDate_Create;
    Button button_Create;

    String title_Create;
    String imageURL_Create;
    String author_Create;
    String releaseDate_Create;

    Books new_Book;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_layout);

        editText_Title_Create = (EditText)findViewById(R.id.editText_Title_Create);
        editText_ImageURL_Create = (EditText)findViewById(R.id.editText_ImageURL_Create);
        editText_Author_Create = (EditText)findViewById(R.id.editText_Author_Create);
        editText_ReleaseDate_Create = (EditText)findViewById(R.id.editText_ReleaseDate_Create);
        button_Create = (Button)findViewById(R.id.button_Create);

        title_Create = editText_Title_Create.getText().toString();
        imageURL_Create = editText_ImageURL_Create.getText().toString();
        author_Create = editText_Author_Create.getText().toString();
        releaseDate_Create = editText_ReleaseDate_Create.getText().toString();

        new_Book = new Books();
        new_Book.setTitle(title_Create);
        new_Book.setTitle(imageURL_Create);
        new_Book.setTitle(author_Create);
        new_Book.setTitle(releaseDate_Create);

    }

    protected void addNewBook (Books books) {
        Log.d("CreateActivity: ", "sneding book info");

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            CRUDInterface service = retrofit.create(CRUDInterface.class);

            Call<Books> call = service.createBook(books);

            call.enqueue(new Callback<Books>() {
                @Override
                public void onResponse(Call<Books> call, Response<Books> response) {

                    try {

                        button_Create.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        });



                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            });

        } else {
            Toast.makeText(CreateActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }
}
