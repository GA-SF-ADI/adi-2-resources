package gg.patrickcummins.networkinglab;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gg.patrickcummins.networkinglab.models.Weather;
import gg.patrickcummins.networkinglab.models.WeatherObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {
    private static String baseUrl = "http://api.openweathermap.org/data/2.5/";
    private static String appId = "a97e4841b8d02ea90c4e3ec47d087a66";
    EditText editText;
    TextView cityTextView, weatherTextView, pressureTextView, humidityTextView, temperatureTextView;
    Button button;
    String cityname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityname = editText.getText().toString();
                getCityWeather(cityname);
            }
        });
    }

    private void getCityWeather(String cityname) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();

            WeatherService weatherService = retrofit.create(WeatherService.class);

            Call<WeatherObject>  call = weatherService.getWeather(cityname, appId);

            call.enqueue(new Callback<WeatherObject>() {
                @Override
                public void onResponse(Call<WeatherObject> call, Response<WeatherObject> response) {
                    try {
                        Log.d("OnRespone", "Responding" );
                        String city = response.body().getName();

                        List<Weather> weather = response.body().getWeather();
                        String weateherDescription = weather.get(0).getDescription();

                        int pressure = response.body().getMain().getPressure();
                        int humidity = response.body().getMain().getHumidity();
                        double temp = response.body().getMain().getTemp();

                        cityTextView.setText("City: " + city);
                        weatherTextView.setText("Weather: " + weateherDescription);
                        pressureTextView.setText("Pressure: " + pressure);
                        humidityTextView.setText("Humidity: " + humidity);
                        temperatureTextView.setText("Temperature: " + ((temp* 9/5)-459.67));



                    }catch (Exception e){
                        e.printStackTrace();

                    }
                }

                @Override
                public void onFailure(Call<WeatherObject> call, Throwable t) {

                }
            });
        }else {
            Toast.makeText(this, "Cannot Connect To Internet", Toast.LENGTH_SHORT).show();
        }
        }

    private void setViews() {
        editText = (EditText) findViewById(R.id.cityEditText);
        cityTextView = (TextView) findViewById(R.id.cityTextView);
        weatherTextView = (TextView) findViewById(R.id.weatherTextView);
        pressureTextView = (TextView) findViewById(R.id.pressureTextView);
        humidityTextView = (TextView) findViewById(R.id.humidityTextView);
        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        button = (Button) findViewById(R.id.getWeatherButton);
    }
}
