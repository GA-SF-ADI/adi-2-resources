package ly.generalassemb.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public ImageView imageView;
public TextView textView;

/**
 * Custom RecyclerView Adapter for rv_list_item.xml list item
 *
 * Created by alex on 6/17/16.
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<> { /** TODO: Step 2 extends RecyclerViewAdapter */

private ArrayList<String> data;
    // TODO: Step 3a Create SampleViewHolder class
// Inner class SampleViewHolder that is public and static. It is also extending RecyclerView.ViewHolder.
public static class SampleViewHolder extends RecyclerView.ViewHolder {
    public SampleViewHolder(View itemView) {
        super(itemView);
    }
}
    // TODO: Step 3b Create constructor for SampleViewHolder class


    // find our TextView from the parent view coming in
    textView = (TextView) itemView.findViewById(R.id.list_item_text_view);

    // find our ImageView from the parent view coming in
    imageView = (ImageView) itemView.findViewById(R.id.list_item_image_view);



    // TODO: Step 3c Create views and assign them inside SampleViewHolder constructor




    // TODO: Step 5a/b implement the necessary methods

    /**
     * Below three methods are auto generated when we implement them
     */

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



}
