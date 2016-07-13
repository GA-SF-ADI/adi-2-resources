package gg.patrickcummins.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by patrickcummins on 7/12/16.
 */

public class CartListAdapter extends BaseAdapter {
    private ArrayList<CartItem> cartItemArrayList;
    private Context context;

    public CartListAdapter(ArrayList<CartItem> cartItemArrayList, Context context) {
        this.cartItemArrayList = cartItemArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cartItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return cartItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cart_list_item, parent, false);
        }
        final CartItem currentItem = cartItemArrayList.get(position);
        ImageView jerseyImageView = (ImageView) convertView.findViewById(R.id.jerseyImageView);
        TextView jerseyTextView = (TextView) convertView.findViewById(R.id.playerNameTextView);
        TextView priceTextView = (TextView) convertView.findViewById(R.id.priceTextView);
        TextView quantityTextView = (TextView) convertView.findViewById(R.id.quantityTextView);
        TextView sizeTextView = (TextView) convertView.findViewById(R.id.sizeTextView);

        jerseyImageView.setImageResource(currentItem.getPicture());
        jerseyTextView.setText(currentItem.getPlayerName() + "-" + currentItem.getColor());
        priceTextView.setText("Price: $" + Math.round(currentItem.getPrice() *100.0)/100.0);
        quantityTextView.setText("Quantity: " + currentItem.getQuantity());
        sizeTextView.setText("Size: " + currentItem.getSize());

        return convertView;
    }
}
