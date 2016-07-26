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
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder> /** TODO: Step 2 extends RecyclerViewAdapter */ {

    private ArrayList<String> data;

    // TODO: Step 3a Create SampleViewHolder class
    public static class SampleViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;

        // TODO: Step 3b Create constructor for SampleViewHolder class
        public SampleViewHolder(View itemView) {
            super(itemView);

            // TODO: Step 3c Create views and assign them inside SampleViewHolder constructor
            textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
            imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);


        }


    }




    public CustomRecyclerViewAdapter(ArrayList<String> inComingData) {
        if (inComingData != null){
            // if there is incoming data, use it
            this.data = inComingData;
        } else {
            // if there is no incoming data, make an empty list to avoid NullPointerExceptions
            this.data = new ArrayList<String>();
        }
    }

    // TODO: Step 5a/b implement the necessary methods
    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View listItemLayout = inflater.inflate(R.layout.rv_list_item, parent, false);

        SampleViewHolder viewHolder = new SampleViewHolder(listItemLayout);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {
        String dataItem = data.get(position);

        TextView textView = holder.textView;
        ImageView imageView = holder.imageView;

        textView.setText(dataItem);

        imageView.setImageResource(R.mipmap.ic_launcher);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }




}
