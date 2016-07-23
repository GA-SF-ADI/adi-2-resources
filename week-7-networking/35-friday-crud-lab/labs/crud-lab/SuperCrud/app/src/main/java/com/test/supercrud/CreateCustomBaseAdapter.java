package com.test.supercrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.List;

/**
 * Created by audreyeso on 7/22/16.
 */
public class CreateCustomBaseAdapter extends BaseAdapter {

    private List<Books> data;
    private Context context;

    public CreateCustomBaseAdapter(List<Books> data, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_create, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Books currentBook = data.get(position);
        //viewHolder.bookTitle.setText(currentBook.setTitle());
//        viewHolder.bookAuthor.setText(currentBook.setAuthor());
//        viewHolder.imageURL.setText(currentBook.setImage());
        return convertView;
    }

}

class ViewHolder {


    public ViewHolder(View itemLayout) {



    }
}
