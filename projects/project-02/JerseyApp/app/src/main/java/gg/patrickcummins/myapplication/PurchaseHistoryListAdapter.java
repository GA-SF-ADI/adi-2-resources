package gg.patrickcummins.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;
import static gg.patrickcummins.myapplication.R.id.dateTextView;
import static gg.patrickcummins.myapplication.R.id.priceTextView;

/**
 * Created by patrickcummins on 7/12/16.
 */

public class PurchaseHistoryListAdapter extends BaseAdapter {
    private ArrayList<PurchaseHistoryItem> purchaseHistoryArrayList;
    private Context context;

    public PurchaseHistoryListAdapter(ArrayList<PurchaseHistoryItem> purchaseHistoryArrayList, Context context) {
        this.purchaseHistoryArrayList = purchaseHistoryArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return purchaseHistoryArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return purchaseHistoryArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.purchase_history_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final PurchaseHistoryItem currentItem = purchaseHistoryArrayList.get(position);


        viewHolder.priceTextView.setText("Price:\n$" + Math.round(currentItem.getPrice() * 100.0) / 100.0);
        viewHolder.dateTextView.setText("Date Ordered:\n" + currentItem.getDate());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CartActivity.class);
                intent.putExtra("history_id", currentItem.getHistory_ID());
                intent.putExtra("date", currentItem.getDate());
                context.startActivity(intent);

            }
        });


        return convertView;
    }

    private class ViewHolder {
        TextView priceTextView, dateTextView;

        public ViewHolder(View itemLayout) {
            this.priceTextView = (TextView) itemLayout.findViewById(R.id.priceTextView);
            this.dateTextView = (TextView) itemLayout.findViewById(R.id.dateTextView);
        }
    }
}
