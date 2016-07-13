package gg.patrickcummins.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.purchase_history_list_item, parent, false);
        }
        final PurchaseHistoryItem currentItem = purchaseHistoryArrayList.get(position);
        TextView priceTextView = (TextView) convertView.findViewById(R.id.priceTextView);
        TextView dateTextView = (TextView) convertView.findViewById(R.id.dateTextView);

        priceTextView.setText("Price: $" + currentItem.getPrice());
        dateTextView.setText("Date Ordered: " + currentItem.getDate());
        return convertView;
    }
}
