package com.example.michaeljeffress.networkinglab;

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

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static String baseUrl = "http://api.openweathermap.org/"; //https?
    Button button;
    EditText editText;
    TextView textViewDescription;
    TextView textViewHumidity;
    TextView textViewPressure;
    TextView textViewTemperature;
    String city;
    String appId = "acddbcd50851c9181d2fee2455d87350";
    String description;
    String humidity;
    String pressure;
    String temperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText);
        textViewDescription = (TextView)findViewById(R.id.textView_1);
        textViewHumidity = (TextView)findViewById(R.id.textView_2);
        textViewPressure = (TextView)findViewById(R.id.textView_3);
        textViewTemperature = (TextView)findViewById(R.id.textView_4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city = editText.getText().toString();
                getWeather();
            }
        });

    }

    protected void getWeather() {
        Log.d("MainActivity: ", "getting github info");

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            OpenWeatherMapInterface service = retrofit.create(OpenWeatherMapInterface.class);

            Call<Example> call = service.getCity(city, appId);

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {

                    try {

                        String description = response.body().getWeather().get(0).getDescription(); //get(0) is there because weather is an array
                        String humidity = response.body().getMain().getHumidity().toString();
                        String pressure = response.body().getMain().getPressure().toString();
                        String temperature = response.body().getMain().getTemp().toString();

                        textViewDescription.setText("Description: " + description);
                        textViewHumidity.setText("Humidity: " + humidity + "%");
                        textViewPressure.setText("Pressure: " + pressure);
                        textViewTemperature.setText("Temperature: " + temperature);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });

        } else {
            Toast.makeText(MainActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }

    }

}
