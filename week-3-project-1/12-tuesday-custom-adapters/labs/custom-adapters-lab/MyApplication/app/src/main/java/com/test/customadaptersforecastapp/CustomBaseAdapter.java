package com.test.customadaptersforecastapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by audreyeso on 6/21/16.
 */
public class CustomBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Forecast> dataForecast;
    private ViewHolder viewHolder;
    //private ArrayList<DaysOfTheWeek>dataDaysOfTheWeek;

    public CustomBaseAdapter(Context context, ArrayList<Forecast> forecastArrayList) {
        this.context = context;
        this.dataForecast = forecastArrayList;
        //this.dataDaysOfTheWeek = dataDaysOfTheWeek;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view, parent, false);

            //should be changed to listview? or list item?
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //setText method, images are set here
        return convertView;
    }

    private class ViewHolder {
        Button forecast;


        public ViewHolder(View itemLayout) {
            this.forecast = (Button) itemLayout.findViewById(R.id.list_item_forecast);
        }
    }
}
