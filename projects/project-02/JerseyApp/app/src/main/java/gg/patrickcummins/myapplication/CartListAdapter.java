package gg.patrickcummins.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static gg.patrickcummins.myapplication.R.id.jerseyImageView;
import static gg.patrickcummins.myapplication.R.id.priceTextView;
import static gg.patrickcummins.myapplication.R.id.quantityTextView;
import static gg.patrickcummins.myapplication.R.id.sizeTextView;

/**
 * Created by patrickcummins on 7/12/16.
 */

public class CartListAdapter extends BaseAdapter {
    private ArrayList<CartItem> cartItemArrayList;
    private Context context;
    private String activity;

    public CartListAdapter(ArrayList<CartItem> cartItemArrayList, Context context, String activity) {
        this.cartItemArrayList = cartItemArrayList;
        this.context = context;
        this.activity = activity;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cart_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final CartItem currentItem = cartItemArrayList.get(position);


        viewHolder.jerseyImageView.setImageResource(currentItem.getPicture());
        viewHolder.jerseyTextView.setText(currentItem.getPlayerName() + "-" + currentItem.getColor());
        viewHolder.priceTextView.setText("Price: $" + Math.round(currentItem.getPrice() * 100.0) / 100.0);
        viewHolder.quantityTextView.setText("Quantity: " + currentItem.getQuantity());
        viewHolder.sizeTextView.setText("Size: " + currentItem.getSize());
        if (activity.equals("cart")) {
            viewHolder.deleteImageView.setVisibility(View.VISIBLE);
            viewHolder.deleteImageView.setOnClickListener(new View.OnClickListener() {
                DatabaseHelper helper = DatabaseHelper.getInstance(context);

                @Override
                public void onClick(android.view.View v) {
                    helper.removeFromCart(position + 1);
                    cartItemArrayList.remove(position);
                    notifyDataSetChanged();
                }
            });
        }

        return convertView;
    }

    private class ViewHolder {
        TextView jerseyTextView, priceTextView, quantityTextView, sizeTextView;
        ImageView deleteImageView, jerseyImageView;

        public ViewHolder(View itemLayout) {
            this.jerseyTextView = (TextView) itemLayout.findViewById(R.id.playerNameTextView);
            this.priceTextView = (TextView) itemLayout.findViewById(R.id.priceTextView);
            this.quantityTextView = (TextView) itemLayout.findViewById(R.id.quantityTextView);
            this.sizeTextView = (TextView) itemLayout.findViewById(R.id.sizeTextView);
            this.deleteImageView = (ImageView) itemLayout.findViewById(R.id.delete);
            this.jerseyImageView = (ImageView) itemLayout.findViewById(R.id.jerseyImageView);
        }
    }
}
