package com.example.kitty.myapplication.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kitty.myapplication.BookInterface;
import com.example.kitty.myapplication.CustomAdapter;
import com.example.kitty.myapplication.Models.Book;
import com.example.kitty.myapplication.Models.Library;
import com.example.kitty.myapplication.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String baseURL = "https://super-crud.herokuapp.com";

    Button addNewButton;
    ListView bookListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpBookList();
        setUpAddNewButton();
    }

    public void setUpAddNewButton() {
        addNewButton = (Button) findViewById(R.id.add_new_button);
        addNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);

                // ToDo: go to add activity to add new book.
            }
        });
    }

    public void setUpBookList() {

        bookListView = (ListView) findViewById(R.id.books_list);

        CustomAdapter myAdapter = new CustomAdapter(getBookList(), this);
        bookListView.setAdapter(myAdapter);

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);

                // ToDo: go to detailed activity to edit book

            }
        });
    }

    protected List<Book> getBookList() {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            BookInterface bookInterface = retrofit.create(BookInterface.class);

            Call<Library> call = bookInterface.getBooks();

            call.enqueue(new Callback<Library>() {
                @Override
                public void onResponse(Call<Library> call, Response<Library> response) {

                    try {

                        String city = response.body().getName();

                        String description = response.body().getWeather().get(0).getDescription();

                        String humidity = response.body().getMain().getHumidity().toString();

                        String pressure = response.body().getMain().getPressure().toString();

                        String temperature = response.body().getMain().getTemp().toString();

                        cityView.setText("City: " + city);
                        descriptionView.setText("Weather: " + description);
                        humidityView.setText("Humidity: " + humidity + "%");
                        pressureView.setText("Pressure: " + pressure + " hPa");
                        temperatureView.setText("Temperature: " + temperature + (char) 0x00B0);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Library> call, Throwable t) {

                }
            });

        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }

    }
}
