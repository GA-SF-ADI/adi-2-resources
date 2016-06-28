package ly.generalassemb.drewmahrt.cursorlab;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by audreyeso on 6/27/16.
 */
public class CustomBaseAdapter extends BaseAdapter {
    private ArrayList<String> data;
    private Context context;

    public CustomBaseAdapter(ArrayList<String> data, Context context) {

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
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custombaseadapter, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final String string = data.get(position);

        viewHolder.firstTextView.setText(string);

        return convertView;

    }

    private class ViewHolder {
        TextView firstTextView;

        public ViewHolder(View itemLayout) {
            this.firstTextView = (TextView) itemLayout.findViewById(R.id.custom_adapter_text_view);

        }
    }

}