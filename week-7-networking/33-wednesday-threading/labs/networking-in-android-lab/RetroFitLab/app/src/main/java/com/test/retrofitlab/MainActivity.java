package com.test.retrofitlab;

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
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button findWeatherButton;
    EditText enterCity;
    TextView cityName;
    TextView weatherDescription;
    TextView pressure;
    TextView humidity;
    TextView temperature;
    String baseUrl = "http://api.openweathermap.org";
    String key ="e806173613d71ecde80904e264af92f9";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findWeatherButton = (Button)findViewById(R.id.get_weather);

        findViews();
        findWeatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = enterCity.getText().toString();
                getCityWeather(city);
            }
        });



    }


    public void findViews(){
        enterCity = (EditText)findViewById(R.id.city_et);
        cityName = (TextView)findViewById(R.id.city_name);
        weatherDescription = (TextView)findViewById(R.id.weather_description);
        pressure = (TextView)findViewById(R.id.pressure);
        humidity = (TextView)findViewById(R.id.humidity);
        temperature = (TextView)findViewById(R.id.temperature);
    }
    public void getCityWeather(String city){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // the connection is available
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            final WeatherService weatherService = retrofit.create(WeatherService.class);
            Call<Example> call = weatherService.getWeather(city,key);

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    try {
                        String name =response.body().getName();
                    cityName.setText("city " + name);
                    humidity.setText("humidity "+response.body().getMain().getHumidity().toString());
                    pressure.setText("pressure "+response.body().getMain().getPressure().toString());
                    temperature.setText("temperature "+response.body().getMain().getTemp().toString());
                        weatherDescription.setText("description "+response.body().getWeather().get(0).getDescription());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });

        } else {
            // the connection is not available
            Toast.makeText(MainActivity.this,"your are not connected",Toast.LENGTH_SHORT).show();
        }
    }
}
