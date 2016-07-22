package com.example.michaeljeffress.crudlab;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button buttonCreate;
    Button buttonRead;
    ListView listView;
    private static String baseUrl = "https://super-crud.herokuapp.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView_Main);
        buttonCreate = (Button)findViewById(R.id.button_Create);
        buttonRead = (Button)findViewById(R.id.button_Read);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });

        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener();


        listView.setOnLongClickListener();

    }

    protected void getBookInfo(String title) {
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
                        create an instance of list adapter
                                constructor give books
                        listView.setAdapter(XX);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<Bookshelf> call, Throwable t) {

                }
            });

        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }


}
