package com.test.networkinginandroidpractice;

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

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static String weatherUrl = " http://openweathermap.org/api";
    EditText editText;
    Button cityButton;
    TextView cityView, weatherDescriptionView, humidityView, pressureView, temperatureView;
    String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edit_user);
        cityButton = (Button) findViewById(R.id.city_button);

        cityView = (TextView) findViewById(R.id.city_name);
        weatherDescriptionView = (TextView) findViewById(R.id.weather_descrip);
        humidityView = (TextView) findViewById(R.id.humidity);http://openweathermap.org/api
        pressureView = (TextView) findViewById(R.id.pressure);
        temperatureView = (TextView) findViewById(R.id.temperature);

       cityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cityName = editText.getText().toString();
                getWeather(cityName);
            }
        });
    }

    public void getWeather(String weatherInfo) {

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // the connection is available
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(weatherUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


           OpenWeatherMap service = retrofit.create(OpenWeatherMap.class);

            Call<Example> call = service.getWeather();

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {

                    try {

                        String cityName = response.body().getName();
                        cityView.setText("City Name" + cityName);
                        String weatherDescription = response.body().getWind();
                        weatherDescriptionView.setText("Weather" + weatherDescription);
                        String humidity = response.body().getClouds();
                        humidityView.setText("Humidity" + humidity);
                        String pressure = response.body().getWind();
                        pressureView.setText("Pressure" + pressure);
                        String temperature = response.body().getWeather();
                        temperatureView.setText("Pressure" + temperature);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });


        } else {
            Toast.makeText(MainActivity.this, "Connect to WIFI", Toast.LENGTH_SHORT).show();
        }

    }
}
