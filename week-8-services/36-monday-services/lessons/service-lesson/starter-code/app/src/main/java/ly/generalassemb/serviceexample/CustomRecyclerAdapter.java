package ly.generalassemb.serviceexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by audreyeso on 7/30/16.
 */
public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.SampleViewHolder> {
    private static final String TAG = "Adapter";
    private ArrayList<String> data;

    public static class SampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public SampleViewHolder(final View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.list_item_text_view);
            imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Clicked on item: " + getLayoutPosition());
                }
            });
        }
    }

    public CustomRecyclerAdapter(ArrayList<String> inComingData) {
        this.data = inComingData;
    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View customRecyclerAdapterLayout = inflater.inflate(R.layout.custom_recycler_adapter, parent, false);
        SampleViewHolder viewHolder = new SampleViewHolder(customRecyclerAdapterLayout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {
        // Get our data item for the current position from the data list
        String dataItem = data.get(position);

        /**
         * Pull out the inflated TextView/ImageView references out of our SampleViewHolder
         * instance.
         *
         * Look at the constructor of SampleViewHolder() and note that variable fields
         * 'imageView' and 'textView' are both public ( which is why we don't need a getter ).
         */
        TextView textView = holder.textView;
        ImageView imageView = holder.imageView;

        // put our dataItem string as text into the text view
        textView.setText(dataItem);

        // set the launcher icon as our image resource
        imageView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}

