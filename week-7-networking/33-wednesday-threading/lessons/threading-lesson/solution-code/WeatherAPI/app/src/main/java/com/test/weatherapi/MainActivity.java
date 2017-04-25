package com.test.weatherapi;

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

import com.test.weatherapi.Models.BigWeather;
import com.test.weatherapi.Models.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static String baseUrl = "http://api.openweathermap.org/";
    private static String apiKey = "473ca71ffc56d0a1eeb90bdef7abd7da";


    EditText editText;
    Button button;
    TextView cityText, weatherText, pressureText, humidityText, tempText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.cityEdit);
        button = (Button) findViewById(R.id.button);
        cityText = (TextView) findViewById(R.id.cityText);
        weatherText = (TextView) findViewById(R.id.weatherText);
        pressureText = (TextView) findViewById(R.id.pressureText);
        humidityText = (TextView) findViewById(R.id.humidityText);
        tempText = (TextView) findViewById(R.id.tempText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWeather(editText.getText().toString());
                editText.setText("");
            }
        });



    }


    protected void getWeather(String cityName){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            WeatherService service = retrofit.create(WeatherService.class);
            Call<BigWeather> call = service.getWeather(cityName,apiKey);

            call.enqueue(new Callback<BigWeather>() {
                @Override
                public void onResponse(Call<BigWeather> call, Response<BigWeather> response) {
                    try {
                        String city = response.body().getName();
                        String weather = response.body().getWeather().get(0).getDescription();
                        String pressure = response.body().getMain().getPressure().toString();
                        String humidity = response.body().getMain().getHumidity().toString();
                        String temp = response.body().getMain().getTemp().toString();

                        cityText.setText("City: " +city);
                        weatherText.setText("Weather: "+weather);
                        pressureText.setText("Pressure: "+pressure);
                        humidityText.setText("Humidity: "+humidity);
                        tempText.setText("Temperature: "+temp);

                    }catch (Exception e) {
                        e.printStackTrace();
                    }


                }

                @Override
                public void onFailure(Call<BigWeather> call, Throwable t) {

                }
            });


        } else {
            Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }





    }
}
