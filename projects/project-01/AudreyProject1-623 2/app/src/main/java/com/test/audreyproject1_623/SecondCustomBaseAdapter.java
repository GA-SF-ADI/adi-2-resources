package com.test.audreyproject1_623;

/**
 * Created by audreyeso on 6/23/16.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import android.widget.CheckBox;


public class SecondCustomBaseAdapter extends BaseAdapter {
    private ArrayList<String> data;
    private Context context;

    public SecondCustomBaseAdapter(ArrayList<String> data, Context context) {

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
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.secondcustombaseadapter, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final String string = data.get(position);

        viewHolder.firstTextViewItems.setText(string);
        viewHolder.myCheckbox.isChecked();

        viewHolder.myCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (viewHolder.myCheckbox.isChecked()) {
                }
            }
        });

        return convertView;

    }


    private class ViewHolder {
        TextView firstTextViewItems;
        CheckBox myCheckbox;

        public ViewHolder(View itemLayout) {
            this.firstTextViewItems = (TextView) itemLayout.findViewById(R.id.second_custom_adapter_text_view);
            this.myCheckbox = (CheckBox) itemLayout.findViewById(R.id.on_check_box);

        }


    }
}


