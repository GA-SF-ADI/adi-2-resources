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
public class CustomAdapter extends BaseAdapter{
    private ArrayList<Day> day;
    private Context context;
    private ViewHolder viewHolder;


    public CustomAdapter(Context context, ArrayList<Day>day) {
        this.day = day;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            ViewHolder viewHolder = new ViewHolder(convertView);
           convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();

        }
        Day today = day.get(position);
        viewHolder.highTemp.setText(today.getTemperatureHigh());
        viewHolder.lowTemp.setText(today.getTemperatureLow());


        //set onitemclicklistener to view activity showing a days info
        return convertView;
    }

    public class ViewHolder{
        TextView highTemp;
        TextView lowTemp;
        ImageView imageView1;

        public ViewHolder(View convertView){
            this.highTemp= (TextView)convertView.findViewById(R.id.highTemp);
            this.lowTemp = (TextView)convertView.findViewById(R.id.lowTemp);
            this.imageView1 = (ImageView)convertView.findViewById(R.id.image_view_1);
        }

    }
}
