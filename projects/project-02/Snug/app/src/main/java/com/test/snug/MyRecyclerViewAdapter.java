package com.test.snug;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LangstonSmith on 7/9/16.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.DataObjectHolder> {

    private static String LOG_TAG = "MyRecyclerViewAdapter";

    public List<Hat> hatList;

    private ArrayList<Hat> mDataset;
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
            R.drawable.yanks};


    // Get a random between 0 and images.length-1
    int imageId = (int) (Math.random() * images.length);


    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView fittedOrSnap;
        TextView price;


        public DataObjectHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.textView_hat_name);
            fittedOrSnap = (TextView) itemView.findViewById(R.id.textView_is_hat_fittedOrSnap);
            price = (TextView) itemView.findViewById(R.id.textView_hat_price);

            Log.i(LOG_TAG, "Adding Listener");

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {myClickListener.onItemClick(getPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MyRecyclerViewAdapter(ArrayList<Hat> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.name.setText(mDataset.get(position).getName());
        holder.fittedOrSnap.setText(mDataset.get(position).getFittedOrSnap());
        holder.price.setText(mDataset.get(position).getPrice());
    }

    public void addItem(Hat hat, int index) {
        mDataset.add(hat);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

}
