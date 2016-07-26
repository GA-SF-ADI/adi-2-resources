package ly.generalassemb.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom RecyclerView Adapter for rv_list_item.xml list item
 *
 * Created by alex on 6/17/16.
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder> {
    private ArrayList<String> data;

    public static class SampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;

        public SampleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
            imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);
        }
    }

    public CustomRecyclerViewAdapter(ArrayList<String> incomingData) {
        if(incomingData!=null){
            this.data = incomingData;
        }else {
            this.data = new ArrayList<String>();
        }

    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View listItemLayout = inflater.inflate(R.layout.rv_list_item,parent,false);

        SampleViewHolder viewHolder = new SampleViewHolder(listItemLayout);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {
        String dataItem = data.get(position);

        holder.textView.setText(dataItem);
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
