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
 * It also shows an example of how to process item clicks
 *
 * Created by alex on 6/17/16.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.SampleViewHolder> {
    private ArrayList<String> data;
    private static OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    /**
     * Interface to pass position of clicked item back to whoever implements
     * this interface
     */
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(int position);
    }

    /**
     * View holder for our ImageView and TextView element inside rv_list_item.xml
     *
     * Note: The `View itemView` represents the LinearLayout inside rv_list_item.xml
     *
     * By setting a click listener on the whole linear layout, we make the whole
     * list item clickable.
     *
     * We could also set click listeners just for the imageView and or textView if
     * we wished to do so.
     */
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
                    // Passing along the position of the clicked item layout
                    onRecyclerViewItemClickListener.onItemClick(getLayoutPosition());
                }
            });
        }
    }

    /**
     * Custom Adapter constructor that takes in ArrayList of string data. This could be a list
     * of class objects as well.
     *
     * The constructor also takes in an implementation of OnRecyclerViewItemClickListener so that
     * we can pass position of clicked item back to the implementor
     *
     * @param inComingData
     * @param onRecyclerViewItemClickListener
     */
    public CustomAdapter(ArrayList<String> inComingData, OnRecyclerViewItemClickListener onRecyclerViewItemClickListener){
        this.data = inComingData;
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get context from parent ViewGroup
        Context context = parent.getContext();

        // Get layoutInflater, which will inflate our custom list item layout for us
        LayoutInflater inflater = LayoutInflater.from(context);

        /**
         * Inflate the custom list item layout. The view returned back is our top level
         * view. If you look at step 0, you'll see our top level layout is LinearLayout.
         *
         * We pass this LinearLayout view to our SampleViewHolder so we can pull our
         * ImageView and TextView out of it via their id's
         */
        View listItemLayout = inflater.inflate(R.layout.rv_list_item, parent, false);

        // Return a new SampleViewHolder instance
        SampleViewHolder viewHolder = new SampleViewHolder(listItemLayout);
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
