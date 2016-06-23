package com.test.audreyproject1_623;

/**
 * Created by audreyeso on 6/23/16.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomBaseAdapter extends BaseAdapter {
    private ArrayList<Category> data;
    private Context context;
    private ViewHolder viewHolder;

    public CustomBaseAdapter(ArrayList<Category> data, Context context) {

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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custombaseadapter, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Category currentCategory = data.get(position);

        viewHolder.firstTextView.setText(currentCategory.getName());
        //getName or get Items


        return convertView;

    }


    private class ViewHolder {
        TextView firstTextView;

        public ViewHolder(View itemLayout) {
            this.firstTextView = (TextView) itemLayout.findViewById(R.id.custom_adapter_text_view);

        }
    }
}


