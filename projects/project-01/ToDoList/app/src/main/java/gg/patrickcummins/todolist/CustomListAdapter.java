package gg.patrickcummins.todolist;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by patrickcummins on 6/22/16.
 */

public class CustomListAdapter extends BaseAdapter {

        private Context context;
        private ArrayList<NamedList> mainList;



        public CustomListAdapter(Context context, ArrayList<NamedList> currentList) {
            this.context = context;
            this.mainList = currentList;
        }

        @Override
        public int getCount() {
            return mainList.size();
        }

        @Override
        public Object getItem(int position) {
            return mainList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;
            if (convertView == null){
                convertView = LayoutInflater.from(context).inflate(R.layout.list_layout, parent, false);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }


            final NamedList currentNamedList = mainList.get(position);

            viewHolder.nameTextView.setText(currentNamedList.getmName());
            if (currentNamedList.getColor() != null){

                if (currentNamedList.getColor().equals("blue")){
                    viewHolder.mLinearLayout.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_blue_light));
                }else if (currentNamedList.getColor().equals("red")){
                    viewHolder.mLinearLayout.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_red_light));
                }else if (currentNamedList.getColor().equals("green")){
                    viewHolder.mLinearLayout.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_green_light));
                }else if (currentNamedList.getColor().equals("orange")){
                    viewHolder.mLinearLayout.setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_orange_light));
                }else if (currentNamedList.getColor().equals("white")){
                    viewHolder.mLinearLayout.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white));
                }
            }
            viewHolder.deleteImageView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mainList.remove(position);
                    notifyDataSetChanged();
                    return false;
                }
            });

            return convertView;
        }
        private class ViewHolder{
            TextView nameTextView;
            LinearLayout mLinearLayout;
            ImageView deleteImageView;
            public ViewHolder(View itemLayout){
                this.nameTextView = (TextView) itemLayout.findViewById(R.id.listTitle);
                this.mLinearLayout = (LinearLayout) itemLayout.findViewById(R.id.mainList);
                this.deleteImageView = (ImageView) itemLayout.findViewById(R.id.deleteImageView);
            }
        }
    }


