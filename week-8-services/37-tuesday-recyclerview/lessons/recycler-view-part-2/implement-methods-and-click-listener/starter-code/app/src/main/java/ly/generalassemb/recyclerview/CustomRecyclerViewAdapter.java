package ly.generalassemb.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Custom RecyclerView Adapter for rv_list_item.xml list item
 *
 * It also shows an example of how to process item clicks
 *
 * Created by alex on 6/17/16.
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder> {
    // TODO: Step 6a) Create Data list variable



    // TODO: Step 8b) Declare a variable of the interface you defined in step 8a



    // TODO: Step 8a) Define your Interface to pass in position of clicked item!




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

            // TODO: Step 8d) Set click listener on itemView AND pass position through interface



        }
    }


    // TODO: Step 6b) Create Constructor for CustomRecyclerViewAdapter


    // TODO: 8c) Update constructor to take in implementation of your interface
    // TODO:     Set interface instance on the variable you created in step 8b


    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // TODO: Step 7a) Fill out this method

        return null;
    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {

        // TODO: Step 7b) Fill out this method


    }

    @Override
    public int getItemCount() {

        // TODO: Step 7c) Fill out this method

        return 0;
    }
}
