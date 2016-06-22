package com.test.customadaptersforecastapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by audreyeso on 6/21/16.
 */
public class CustomBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Forecast> dataForecast;
    private ViewHolder viewHolder;


    public CustomBaseAdapter(Context context, ArrayList<Forecast> forecastArrayList) {
        this.context = context;
        this.dataForecast = forecastArrayList;

    }

    @Override
    public int getCount() {
        return dataForecast.size();
    }

    @Override
    public Object getItem(int position) {
        return dataForecast.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        final Forecast currentForecast = dataForecast.get(position);

        viewHolder.locationAndTemp.setText(currentForecast.getTemperature());


        final String toastText = currentForecast.getDayOfWeek();
        viewHolder.forecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    private class ViewHolder {
        Button forecast;
        TextView locationAndTemp;


        public ViewHolder(View itemLayout) {
            this.forecast = (Button) itemLayout.findViewById(R.id.list_item_forecast);
            this.locationAndTemp = (TextView)itemLayout.findViewById(R.id.list_item_weather);
        }
    }
}
