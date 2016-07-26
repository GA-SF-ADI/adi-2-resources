package com.test.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jon Kim on 7/26/16.
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.AlcViewHolder>{
    private ArrayList<Alcohol> data;

    private static OnRecyclerViewItemClickListener onItemClickListener;

    public interface OnRecyclerViewItemClickListener{
        void onItemClick(int position);
    }

    public static class AlcViewHolder extends RecyclerView.ViewHolder{
        public ImageView rvAlcImage;
        public TextView rvAlcName, rvAlcPrice;

        public AlcViewHolder(View itemView) {
            super(itemView);
            rvAlcImage = (ImageView)itemView.findViewById(R.id.rv_image_view);
            rvAlcName = (TextView)itemView.findViewById(R.id.rv_text_name);
            rvAlcPrice = (TextView)itemView.findViewById(R.id.rv_text_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getLayoutPosition());

                }
            });

        }
    }

    public CustomRecyclerViewAdapter(ArrayList<Alcohol> inComingData, OnRecyclerViewItemClickListener listener) {
        this.onItemClickListener = listener;

        if (inComingData != null){
            this.data = inComingData;
        } else {
            this.data = new ArrayList<>();
        }

    }

    @Override
    public AlcViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View listItemLayout = inflater.inflate(R.layout.rv_list_item, parent, false);

        AlcViewHolder viewHolder = new AlcViewHolder(listItemLayout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AlcViewHolder holder, int position) {
        Alcohol curAlc = data.get(position);
        holder.rvAlcName.setText(curAlc.getAlcName());
        holder.rvAlcPrice.setText(curAlc.getAlcPrice());
        holder.rvAlcImage.setImageResource(curAlc.getImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
