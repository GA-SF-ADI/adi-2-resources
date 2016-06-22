package com.example.kitty.weatherforecastlab;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kitty on 6/21/16.
 */
public class ViewHolder {

    TextView day;
    ImageView image;
    TextView dayWeather;
    TextView weatherHigh;
    TextView weatherLow;

    public ViewHolder(View iteamLayout) {
        this.day = (TextView) iteamLayout.findViewById(R.id.list_item_day);
        this.image = (ImageView) iteamLayout.findViewById(R.id.list_item_image);
        this.dayWeather = (TextView) iteamLayout.findViewById(R.id.list_item_day_weather);
        this.weatherHigh = (TextView) iteamLayout.findViewById(R.id.list_item_weather_high);
        this.weatherLow = (TextView) iteamLayout.findViewById(R.id.list_item_weather_low);
    }
}
