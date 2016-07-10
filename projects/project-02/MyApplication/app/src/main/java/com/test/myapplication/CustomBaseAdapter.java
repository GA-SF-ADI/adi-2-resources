package com.test.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jon Kim on 7/9/16.
 */
public class CustomBaseAdapter extends BaseAdapter{
    private ArrayList<Alcohol> data;
    private Context context;
    TextView listAlcName, listAlcPrice;
    ImageView listAlcImage;

    public CustomBaseAdapter(ArrayList<Alcohol> data, Context context) {
        this.data = data;
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
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }
        listAlcName = (TextView)convertView.findViewById(R.id.list_alc_name);
        listAlcImage = (ImageView)convertView.findViewById(R.id.list_alc_image);
        listAlcPrice = (TextView)convertView.findViewById(R.id.list_alc_price);

        final Alcohol curAlcohol = data.get(position);

        listAlcName.setText(curAlcohol.getAlcName());
        listAlcImage.setImageResource(curAlcohol.getImage());
        listAlcPrice.setText(curAlcohol.getAlcPrice());


        return null;
    }
}
