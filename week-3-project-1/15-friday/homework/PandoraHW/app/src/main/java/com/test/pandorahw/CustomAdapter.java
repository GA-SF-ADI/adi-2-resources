package com.test.pandorahw;

import android.content.ComponentName;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nolbertoarroyo on 6/26/16.
 */
public class CustomAdapter extends BaseAdapter {
    ArrayList<Station> stations;
    Context context;
    ViewHolder viewHolder;

    public CustomAdapter(Context context, ArrayList<Station> stations) {
        this.stations = stations;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stations.size();
    }

    @Override
    public Object getItem(int position) {
        return stations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        final Station currentStation = stations.get(position);

        viewHolder.stationName.setText(currentStation.getName());
        viewHolder.lastListened.setText(currentStation.getLastListened());
        viewHolder.stationImage.setImageResource(currentStation.getStationImage(R.drawable.music_black));


        return convertView;

    }

    private class ViewHolder {
        ImageView stationImage;
        TextView stationName;
        TextView lastListened;

        public ViewHolder(View convertView) {
            this.stationName = (TextView) convertView.findViewById(R.id.station_name);
            this.stationImage = (ImageView) convertView.findViewById(R.id.station_image);
            this.lastListened = (TextView) convertView.findViewById(R.id.station_listened);
        }

    }
}
