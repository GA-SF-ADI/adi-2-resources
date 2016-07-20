package com.example.kitty.networkinglab;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kitty.networkinglab.Models.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static String baseUrl = "http://api.openweathermap.org/";
    String query;

    //views
    EditText userInput;
    Button button;
    TextView cityText;
    TextView descriptionText;
    TextView pressureText;
    TextView humidityText;
    TextView tempText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup views
        userInput = (EditText) findViewById(R.id.edittext);
        button = (Button) findViewById(R.id.button);
        cityText = (TextView) findViewById(R.id.city);
        descriptionText = (TextView) findViewById(R.id.description);
        pressureText = (TextView) findViewById(R.id.pressure);
        humidityText = (TextView) findViewById(R.id.humidity);
        tempText = (TextView) findViewById(R.id.temperature);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query = userInput.getText().toString();
                getLocationInfo(query);
            }
        });


    }

    public void getLocationInfo(String input) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            WeatherInterface weatherInterface = retrofit.create(WeatherInterface.class);
            Call<Example> call = weatherInterface.getLocation(input);
            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    try {

                        cityText.setText("City: "+response.body().getName());
                        descriptionText.setText("Description: "+response.body().getWeather().get(0).getDescription());
                        pressureText.setText("Pressure: "+response.body().getMain().getPressure());
                        humidityText.setText("Humidity: "+response.body().getMain().getHumidity());
                        tempText.setText("Temperature: "+response.body().getMain().getTemp());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "request failed", Toast.LENGTH_LONG).show();
                }
            });

        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }
}
