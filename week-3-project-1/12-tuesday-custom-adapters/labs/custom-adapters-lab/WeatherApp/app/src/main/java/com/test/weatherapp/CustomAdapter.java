package com.test.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nolbertoarroyo on 6/21/16.
 */
public class CustomAdapter extends BaseAdapter {
    private ArrayList<Day> data;
    private Context context;
    private ViewHolder viewHolder;


    public CustomAdapter(Context context, ArrayList<Day> daysList) {
        this.data = daysList;
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
            ViewHolder viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();

        }

        Day currentDay = data.get(position);

        viewHolder.day.setText(currentDay.getDay());
        viewHolder.highTemp.setText(currentDay.getTemperatureHigh());
        viewHolder.lowTemp.setText(currentDay.getTemperatureLow());


        return convertView;
    }

    public class ViewHolder {
        TextView day;
        TextView highTemp;
        TextView lowTemp;
        ImageView imageView1;

        public ViewHolder(View itemLayout) {
            this.day = (TextView) itemLayout.findViewById(R.id.day);
            this.highTemp = (TextView) itemLayout.findViewById(R.id.highTemp);
            this.lowTemp = (TextView) itemLayout.findViewById(R.id.lowTemp);
            this.imageView1 = (ImageView) itemLayout.findViewById(R.id.image_view_1);
        }

    }
}
