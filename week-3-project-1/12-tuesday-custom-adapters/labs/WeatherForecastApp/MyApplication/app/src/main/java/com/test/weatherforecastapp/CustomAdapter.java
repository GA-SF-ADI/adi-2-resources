package com.test.weatherforecastapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by NehaRege on 6/21/16.
 */
public class CustomAdapter extends BaseAdapter {

    private ArrayList<WeatherForecast> weatherForecastList;
    private Context context;
    private ViewHolder viewHolder;


    public CustomAdapter(Context context,ArrayList<WeatherForecast> weatherForecastList){
        this.context = context;
        this.weatherForecastList = weatherForecastList;
    }

    @Override
    public int getCount() {
        return weatherForecastList.size();
    }

    @Override
    public Object getItem(int position) {
        return weatherForecastList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final WeatherForecast currentWeatherForecast = weatherForecastList.get(position);
        Log.v("current weather", currentWeatherForecast.getDay() + " " + currentWeatherForecast.getHigh() + " " + currentWeatherForecast.getLow());

        viewHolder.button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                viewHolder.dayTextView.setText(currentWeatherForecast.getDay());
                viewHolder.highTextView.setText(currentWeatherForecast.getHigh());
                viewHolder.lowTextView.setText(currentWeatherForecast.getLow());
                notifyDataSetChanged();


            }
        });


        return convertView;

    }

    public class ViewHolder {
        TextView dayTextView;
        TextView highTextView;
        TextView lowTextView;
        Button button;

        public ViewHolder(View itemLayout){
            dayTextView = (TextView) itemLayout.findViewById(R.id.day);
            highTextView = (TextView) itemLayout.findViewById(R.id.high);
            lowTextView = (TextView) itemLayout.findViewById(R.id.low);
            button = (Button) itemLayout.findViewById(R.id.button);
        }
    }
}
