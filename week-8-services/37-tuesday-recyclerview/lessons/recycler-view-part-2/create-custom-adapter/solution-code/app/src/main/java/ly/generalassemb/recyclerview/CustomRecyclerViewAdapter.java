package ly.generalassemb.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Custom RecyclerView Adapter for rv_list_item.xml list item
 *
 * Created by alex on 6/17/16.
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder> {

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

        }
    }


    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
