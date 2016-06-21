package com.test.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jon Kim on 6/21/16.
 */
public class CustomBaseAdapter extends BaseAdapter {
    private ArrayList<Weather> data;
    private Context context;
    private ViewHolder viewHolder;

    public CustomBaseAdapter(Context context, ArrayList<Weather> weatherList) {
        this.data = weatherList;
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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Weather currentWeather = data.get(position);

        viewHolder.firstTextView.setText(currentWeather.getDayWeek());
        viewHolder.secondTextView.setText(String.valueOf(currentWeather.getHigh()));
        viewHolder.thirdTextView.setText(String.valueOf(currentWeather.getLow()));
        viewHolder.fourthTextView.setText(String.valueOf(currentWeather.getDay()));


        return convertView;
    }

    private class ViewHolder {
        TextView firstTextView;
        TextView secondTextView;
        TextView thirdTextView;
        TextView fourthTextView;


        public ViewHolder(View itemLayout){
            this.firstTextView = (TextView) itemLayout.findViewById(R.id.day_week);
            this.secondTextView = (TextView) itemLayout.findViewById(R.id.high);
            this.thirdTextView = (TextView) itemLayout.findViewById(R.id.low);
            this.fourthTextView = (TextView) itemLayout.findViewById(R.id.day);

        }
    }

}
