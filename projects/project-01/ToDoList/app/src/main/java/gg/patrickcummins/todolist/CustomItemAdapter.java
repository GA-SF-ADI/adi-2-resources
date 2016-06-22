package gg.patrickcummins.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by patrickcummins on 6/22/16.
 */

public class CustomItemAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ListItem> currentList;

    public CustomItemAdapter(Context context, ArrayList<ListItem> currentList) {
        this.context = context;
        this.currentList = currentList;
    }

    @Override
    public int getCount() {
        return currentList.size();
    }

    @Override
    public Object getItem(int position) {
        return currentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.itemNameTextView);
        TextView descriptionTextView = (TextView) convertView.findViewById(R.id.itemDescriptionTextView);

        final ListItem currentItem = currentList.get(position);

        nameTextView.setText(currentItem.getmName());
        descriptionTextView.setText(currentItem.getDescription());



        return convertView;
    }
}
