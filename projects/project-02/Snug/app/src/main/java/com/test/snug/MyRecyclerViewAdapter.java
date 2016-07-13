package com.test.snug;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.database.Cursor;
import android.database.DataSetObserver;

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
    public Cursor cursor;
    private ArrayList<Hat> hatDataSet;
    private Random mRandom = new Random();
    private static MyClickListener myClickListener;


    public MyRecyclerViewAdapter(Cursor cursor, Context mContext) {
        this.mContext = mContext;
        this.cursor = cursor;

    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView fittedOrSnap;
        TextView price;
        CardView cardView;


        public DataObjectHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.textView_hat_name);
            fittedOrSnap = (TextView) itemView.findViewById(R.id.textView_is_hat_fittedOrSnap);
            price = (TextView) itemView.findViewById(R.id.textView_hat_price);
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

//    TODO: Look in the cursor for onBindViewHolder

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        holder.

        holder.name.setText(hatDataSet.get(position).getName());
        holder.fittedOrSnap.setText(String.valueOf(hatDataSet.get(position).getFittedOrSnap()));
        holder.price.setText(String.valueOf(hatDataSet.get(position).getPrice() + ""));
    }

//    TODO: Fix method below

    /*public void addItem(Hat hat, int index) {
        cursor.add(hat);
        notifyItemInserted(index);
    }
    */

//    TODO: Fix method below
    public void deleteItem(int index) {
        SQLiteOpenHelper db = new SQLiteOpenHelper();

        Cursor cursor = db.deleteHat();

    }
    @Override
    public int getItemCount() {
        Log.d("dkjfad", cursor.getCount()+"");
        return cursor.getCount();

    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

}
