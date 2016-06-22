package com.example.kitty.weatherforecastlab;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView today;
    private ImageView todayImage;
    private TextView todayWeather;
    private TextView todayHigh;
    private TextView todayLow;

    private ListView forecastList;
    private Forecast forecast;

    private Weather weatherNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        today = (TextView) findViewById(R.id.day);
        todayImage = (ImageView) findViewById(R.id.today_image);
        todayWeather = (TextView) findViewById(R.id.current_weather);
        todayHigh = (TextView) findViewById(R.id.weather_high);
        todayLow = (TextView) findViewById(R.id.weather_low);

        weatherNow = new RainyDay(0, 18);

        todayImage.setImageResource(R.drawable.rainy);
        todayWeather.setText(weatherNow.getDayWeather()+"");
        todayHigh.setText(weatherNow.getDayHigh()+"");
        todayLow.setText(weatherNow.getDayLow()+"");

        forecast = forecast.getInstance();

        forecast.addDay(new SunnyDay(1, 30));
        forecast.addDay(new RainyDay(2, 22));
        forecast.addDay(new CloudyDay(3, 26));
        forecast.addDay(new CloudyDay(4, 22));
        forecast.addDay(new SunnyDay(5, 34));

        forecastList = (ListView) findViewById(R.id.forecast_list);

        CustomBaseAdaper customBaseAdaper = new CustomBaseAdaper(forecast, MainActivity.this);

        forecastList.setAdapter(customBaseAdaper);
    }
}
