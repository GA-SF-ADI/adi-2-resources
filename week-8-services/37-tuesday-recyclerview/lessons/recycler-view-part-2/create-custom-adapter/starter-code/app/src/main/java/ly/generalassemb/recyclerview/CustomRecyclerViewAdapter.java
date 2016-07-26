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
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.SampleViewHolder>{


    /** TODO: Step 2 extends RecyclerViewAdapter */
// TODO: Step 3a Create SampleViewHolder class
public static class SampleViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;


    // TODO: Step 3b Create constructor for SampleViewHolder class
    public SampleViewHolder(View itemView) {
        super(itemView);

        textView = (TextView)itemView.findViewById(R.id.list_item_text_view);
        imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);

    }
    // TODO: Step 3c Create views and assign them inside SampleViewHolder constructor


    // TODO: Step 5a/b implement the necessary methods
}
//Need to fill these in so you can draw it
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
