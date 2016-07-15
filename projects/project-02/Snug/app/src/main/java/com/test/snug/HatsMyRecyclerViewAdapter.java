package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by LangstonSmith on 7/9/16.
 */
public class HatsMyRecyclerViewAdapter extends RecyclerView.Adapter<HatsMyRecyclerViewAdapter.ViewHolder> implements SearchView.OnQueryTextListener {

    private static String LOG_TAG = "HatsMyRecyclerViewAdapter";

    public List<Hat> hatList;
    private Context mContext;
    public Cursor cursor;
    private ArrayList<Hat> hatDataSet;
    private Random mRandom = new Random();
    private static MyItemClickListener myItemClickListener;

    public HatsMyRecyclerViewAdapter(Cursor cursor, Context mContext, MyItemClickListener myListener) {
        this.mContext = mContext;
        this.cursor = cursor;
        this.myItemClickListener = myListener;

    }

    public void updateCursor(Cursor cursor) {
        this.cursor = cursor;

        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView fittedOrSnap;
        TextView price;
        ImageView image;
        CardView cardView;


        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.textView_hat_name);
            fittedOrSnap = (TextView) itemView.findViewById(R.id.textView_is_hat_fittedOrSnap);
            price = (TextView) itemView.findViewById(R.id.textView_hat_price);
            image = (ImageView) itemView.findViewById(R.id.hat_photo);

            final CardView cardView = (CardView) itemView.findViewById(R.id.card_view);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {//<–– TODO: Ask if this is the right place for intent to be passed. Also ask about interface stuff...
                    Log.d(LOG_TAG, "Clicked on hat at adapterPosition: " + getAdapterPosition());

                    myItemClickListener.onItemClick(getLayoutPosition());


                }
            });


        }

        @Override
        public void onClick(View v) {


        }

    }


    public interface MyItemClickListener {
        void onItemClick(int position);

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);

        ViewHolder dataObjectHolder = new ViewHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        cursor.moveToPosition(position);

        holder.name.setText(cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_HATNAME)));
        holder.fittedOrSnap.setText(cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_FittedOrSnap)));
        holder.price.setText("$" + cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_PRICE)));//<–Ask about this yellow area
        holder.image.setImageResource(cursor.getInt(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_PICTUREID)));


    }

//    TODO: Fix method below

/*
    public void addItem(Hat hat, int index) {

            HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper();

        cursor.add
        notifyItemInserted(index);
    }
*/

    //    TODO: Fix method below
    /*public void deleteItem(int index) {
        HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper();

        Cursor cursor = db.deleteHat();

    }*/


    @Override
    public int getItemCount() {
        return cursor.getCount();

    }

    @Override
    public boolean onQueryTextChange(String query) {
        // Here is where we are going to implement our filter logic
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }


}
