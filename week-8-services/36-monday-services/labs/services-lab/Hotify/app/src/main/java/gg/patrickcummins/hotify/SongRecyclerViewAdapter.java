package gg.patrickcummins.hotify;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by patrickcummins on 7/26/16.
 */

public class SongRecyclerViewAdapter extends RecyclerView.Adapter<SongRecyclerViewAdapter.ViewHolder> {
    private ArrayList<Song> data;

    private static OnSongClick onSongClickListener;

    public SongRecyclerViewAdapter(ArrayList<Song> data, OnSongClick onSongClick) {
        this.onSongClickListener = onSongClick;
        if (data!=null) {
            this.data = data;
        }else{
            this.data = new ArrayList<>();
        }
    }

    public interface OnSongClick{
        void setSong(int position);
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_song_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSongClickListener.setSong(getLayoutPosition());
                }
            });

        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewHolder viewHolder = new ViewHolder(inflater.inflate(R.layout.item_song_layout, parent, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song currentSong = data.get(position);
        holder.textView.setText(currentSong.getSongName());


    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
