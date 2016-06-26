package com.test.a2ndpandoraattempt;

import android.content.Context;
import android.graphics.Bitmap;
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
    private Bitmap albumCoverImage;
    private ArrayList<Station> listOfStations;
    ViewHolder viewHolder;

    public CustomStationAdapter(Context context, ArrayList<Station> listOfStations) {
        this.context = context;
        this.listOfStations = listOfStations;
    }

    @Override
    public int getCount() {
        return listOfStations.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfStations.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.single_station_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();

        }

        final Station currentName = listOfStations.get(i);

        viewHolder.stationName.setText(currentName.getStationName());
        viewHolder.lastListenedTo.setText(currentName.getStationName());


        return convertView;


    }


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
