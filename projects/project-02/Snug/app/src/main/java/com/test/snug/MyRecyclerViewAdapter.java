package com.test.snug;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by LangstonSmith on 7/9/16.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.DataObjectHolder> {

    private static String LOG_TAG = "MyRecyclerViewAdapter";

    public List<Hat> hatList;
    private Context mContext;
    private ArrayList<Hat> hatDataSet;
    private Random mRandom = new Random();
    private static MyClickListener myClickListener;

    int[] images = new int[]{

            R.drawable.a_s_america,
            R.drawable.a_s_america2,
            R.drawable.backs,
            R.drawable.beantown,
            R.drawable.brew_america,
            R.drawable.dodgers,
            R.drawable.florida,
            R.drawable.giants,
            R.drawable.marlins_america,
            R.drawable.padres,
            R.drawable.phils_america,
            R.drawable.red_sox_america,
            R.drawable.rockies_america,
            R.drawable.rsox,
            R.drawable.sgiants,
            R.drawable.tb,
            R.drawable.texas_america,
            R.drawable.wsox,
            R.drawable.yankees,
            R.drawable.yanks
    };


    int imageId = (int) (Math.random() * images.length);

    public MyRecyclerViewAdapter(ArrayList<Hat> hatDataSet, Context mContext) {
        this.hatDataSet = hatDataSet;
        this.mContext = mContext;
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView fittedOrSnap;
        TextView price;


        public DataObjectHolder(View itemView) {
            super(itemView);

            TextView name = (TextView) itemView.findViewById(R.id.textView_hat_name);
            TextView fittedOrSnap = (TextView) itemView.findViewById(R.id.textView_is_hat_fittedOrSnap);
            TextView price = (TextView) itemView.findViewById(R.id.textView_hat_price);
            CardView cardView = (CardView) itemView.findViewById(R.id.card_view);

            Log.i(LOG_TAG, "Adding Listener");

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myClickListener.onItemClick(getLayoutPosition(), v);

                }
            });

        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }


    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.name.setText(hatDataSet.get(position).getName());
        holder.fittedOrSnap.setText(String.valueOf(hatDataSet.get(position).getFittedOrSnap()));
        holder.price.setText(hatDataSet.get(position).getPrice());
    }

    public void addItem(Hat hat, int index) {
        hatDataSet.add(hat);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        hatDataSet.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return hatDataSet.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

}
