package com.test.myjs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nolbertoarroyo on 7/10/16.
 */
public class HomeCustomAdapter extends BaseAdapter {
    private ArrayList<Shoe> shoeList;
    private Context context;
    private ViewHolder viewHolder;

    public HomeCustomAdapter(ArrayList<Shoe> shoeList, Context context) {
        super();
        this.shoeList = shoeList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return shoeList.size();
    }

    @Override
    public Object getItem(int position) {
        return shoeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView== null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
            viewHolder= new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Shoe currentShoe = shoeList.get(position);

        viewHolder.homeImageBttn.setImageResource(currentShoe.getImageId());
        viewHolder.homeTextName.setText(currentShoe.getName());

        //need onItemClickListener to go to other activity and show list
        return convertView;
    }

    public class ViewHolder {
        ImageButton homeImageBttn;
        TextView homeTextName;

        public ViewHolder(View convertView) {
            this.homeImageBttn = (ImageButton) convertView.findViewById(R.id.homeImage);
            this.homeTextName = (TextView) convertView.findViewById(R.id.home_shoe_tv);
        }
    }
}



