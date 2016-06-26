package com.test.a2ndpandoraattempt;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LangstonSmith on 6/25/16.
 */
public class CustomStationAdapter extends BaseAdapter {

    private String stationName;
    private Context context;
    private Image albumCoverImage;
    private ArrayList<Station> listOfStations;
    private ViewHolder viewHolder;


    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.single_station_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();

        }

        final Station currentName = listOfStations.get(i);

        viewHolder.las


        return convertView;


        private class ViewHolder {

            TextView stationName;
            TextView lastListenedTo;


            public ViewHolder(View itemLayout) {
                this.stationName = (TextView) itemLayout.findViewById(R.id.textView_radio_station_name);
                this.lastListenedTo = (TextView) itemLayout.findViewById(R.id.textView_last_listened_to);

            }


        }

    }


}
