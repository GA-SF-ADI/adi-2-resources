package com.example.kitty.weatherforecastlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by kitty on 6/21/16.
 */
public class CustomBaseAdaper extends BaseAdapter {

    private ArrayList<Weather> data;
    private Context context;
    private ViewHolder viewHolder;

    public CustomBaseAdaper(Forecast forecast, Context context) {
        this.data = forecast.getDays();
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        final Weather currentWeather = data.get(position);
        viewHolder.day.setText("Day " + currentWeather.getDay());

        if(currentWeather.getWeather().equals("Sunny")) {
            viewHolder.image.setImageResource(R.drawable.sunny);
        } else if(currentWeather.getWeather().equals("Rainy")) {
            viewHolder.image.setImageResource(R.drawable.rainy);
        } else if(currentWeather.getWeather().equals("Cloudy")) {
            viewHolder.image.setImageResource(R.drawable.cloudy);
        }

        viewHolder.dayWeather.setText(currentWeather.getDayWeather()+"");
        viewHolder.weatherHigh.setText(currentWeather.getDayHigh()+"");
        viewHolder.weatherLow.setText(currentWeather.getDayLow()+"");

        return convertView;
    }
}
