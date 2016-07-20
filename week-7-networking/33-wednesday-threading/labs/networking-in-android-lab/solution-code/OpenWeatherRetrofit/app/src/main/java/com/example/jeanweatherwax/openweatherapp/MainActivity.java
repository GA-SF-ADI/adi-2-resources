package com.example.jeanweatherwax.openweatherapp;

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

import com.example.jeanweatherwax.openweatherapp.models.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String baseURL = "http://api.openweathermap.org";
    String appid = "c9460bbff7b36af0686c2dd73bfae04a";
    String units = "imperial";

    EditText editText;
    Button button;
    TextView cityView, descriptionView, humidityView, pressureView, temperatureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edittext);
        cityView = (TextView) findViewById(R.id.city);
        descriptionView = (TextView) findViewById(R.id.description);
        humidityView = (TextView) findViewById(R.id.humidity);
        pressureView = (TextView) findViewById(R.id.pressure);
        temperatureView = (TextView) findViewById(R.id.temperature);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = editText.getText().toString();
                getWeatherReport(location);
            }
        });


    }
    protected void getWeatherReport(String location) {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            OpenWeatherInterface weatherService = retrofit.create(OpenWeatherInterface.class);

            Call<Model> call = weatherService.getWeather(location, units, appid);

            call.enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

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
                public void onFailure(Call<Model> call, Throwable t) {

                }
            });

        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }

    }
}
