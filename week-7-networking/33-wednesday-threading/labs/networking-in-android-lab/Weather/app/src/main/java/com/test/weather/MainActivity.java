package com.test.weather;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.weather.models.Forecast;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText citySearchEditText = (EditText) findViewById(R.id.edittext);
        Button fetchWeatherButton = (Button) findViewById(R.id.button);

        fetchWeatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            
                String userCitySearch = citySearchEditText.getText().toString();

                getForecastForCity(userCitySearch);

            }
        });

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {



            fetchWeatherButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                }
            });


        } else {

            Toast.makeText(MainActivity.this, "Looks like you don't have internet " +
                    "connectivity!\n Please try turning on your mobile data or connecting" +
                    " to wifi.", Toast.LENGTH_SHORT).show();


        }

    }


    private void getForecastForCity(String cityName) {

        String baseUrl = "https://api.openweathermap.org/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetroInterface retroInterface = retrofit.create(RetroInterface.class);

        Call<Forecast> call = retroInterface.getForecast(cityName, "002b37154b02170b9f4015bde45b169b");


        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {


                try {

                    String finalCityName = response.body().getName();

                    String finalWeather = response.body().getWeather().get(0).getDescription();

                    Integer finalPressure = response.body().getMain().getPressure();

                    Integer finalHumidity = response.body().getMain().getHumidity();

                    Double finalTemp = response.body().getMain().getTemp();


                    TextView finalCityNameView = (TextView) findViewById(R.id.city);
                    TextView finalCityWeatherView = (TextView) findViewById(R.id.description);
                    TextView finalCityPressureView = (TextView) findViewById(R.id.pressure);
                    TextView finalCityHumidityView = (TextView) findViewById(R.id.humidity);
                    TextView finalCityTempView = (TextView) findViewById(R.id.temperature);


                    finalCityNameView.setText(finalCityName);
                    finalCityWeatherView.setText(finalWeather);
                    finalCityPressureView.setText(finalPressure);
                    finalCityHumidityView.setText(finalHumidity);
                    finalCityTempView.setText(finalTemp.toString());


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {

            }
        });


    }


}
