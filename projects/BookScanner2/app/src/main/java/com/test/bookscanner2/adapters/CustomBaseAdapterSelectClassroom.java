package com.test.bookscanner2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.bookscanner2.R;
import com.test.bookscanner2.modelsClassroom.ClassroomKinderToSecond;

import java.util.ArrayList;

/**
 * Created by audreyeso on 8/8/16.
 */

public class CustomBaseAdapterSelectClassroom extends BaseAdapter {

    private ArrayList<ClassroomKinderToSecond>data;
    private Context context;
    private ViewHolder viewHolder;

    public CustomBaseAdapterSelectClassroom(ArrayList<ClassroomKinderToSecond> data, Context context) {

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
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_select_classroom,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final ClassroomKinderToSecond currentClass = data.get(position);

        viewHolder.classroomNameTextView.setText(currentClass.getClassroomName());


        return convertView;
        }

    }



  class ViewHolder {
        TextView classroomNameTextView;


        public ViewHolder(View itemLayout) {
            this.classroomNameTextView = (TextView) itemLayout.findViewById(R.id.custom_adapter_text_view);



        }
    }
