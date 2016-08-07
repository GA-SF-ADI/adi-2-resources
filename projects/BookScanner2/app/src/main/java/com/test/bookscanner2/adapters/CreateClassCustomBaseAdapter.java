package com.test.bookscanner2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.bookscanner2.R;
import com.test.bookscanner2.modelsClassroom.Student;

import java.util.ArrayList;

/**
 * Created by audreyeso on 8/7/16.
 */
public class CreateClassCustomBaseAdapter extends BaseAdapter{

    private ArrayList<Student> data;
    private Context context;
    private ViewHolder viewHolder;


    public CreateClassCustomBaseAdapter(Context context, ArrayList<Student> studentList){
        this.data = studentList;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_student_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Student currentStudent = data.get(position);

        viewHolder.studentNameTextView.setText(currentStudent.getName());
        viewHolder.studentPictureImageView.findViewById(R.id.student_profile_image_view);



        final String toastText = currentStudent.getName() + " Name: "+ currentStudent.getName();
//        viewHolder.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
//            }
//        });

        /**
         * Return the whole item layout here so it can be drawn by the ListView
         */
        return convertView;
    }
    private class ViewHolder {
        TextView studentNameTextView;
        ImageView studentPictureImageView;

        public ViewHolder(View itemLayout){
            this.studentNameTextView= (TextView) itemLayout.findViewById(R.id.textview_student_name);
           this.studentPictureImageView = (ImageView)itemLayout.findViewById(R.id.student_profile_image_view);
        }
    }

    }
