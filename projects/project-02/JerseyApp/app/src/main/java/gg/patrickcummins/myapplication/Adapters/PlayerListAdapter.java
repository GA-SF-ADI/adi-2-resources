package gg.patrickcummins.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import gg.patrickcummins.myapplication.Activitys.JerseyActivity;
import gg.patrickcummins.myapplication.R;
import gg.patrickcummins.myapplication.models.Player;

/**
 * Created by patrickcummins on 7/9/16.
 */

public class PlayerListAdapter extends BaseAdapter {
    private ArrayList<Player> playerArrayList;
    private Context context;

    public PlayerListAdapter(ArrayList<Player> playerArrayList, Context context) {
        this.playerArrayList = playerArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return playerArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return playerArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.player_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Player currentPlayer = playerArrayList.get(position);


        viewHolder.nameTextView.setText(currentPlayer.getName());
        viewHolder.positionTextView.setText("Position: " + currentPlayer.getPosition());
        viewHolder.numberTextView.setText("Number: " + currentPlayer.getNumber());
        viewHolder.playerImageView.setImageResource(currentPlayer.getPlayerPicture());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playerJerseyIntent = new Intent(context, JerseyActivity.class);
                playerJerseyIntent.putExtra("playerName", currentPlayer.getName());
                playerJerseyIntent.putExtra("playerNumber", currentPlayer.getNumber());
                playerJerseyIntent.putExtra("playerTeam", currentPlayer.getTeam());
                context.startActivity(playerJerseyIntent);
            }
        });
        return convertView;
    }

    private class ViewHolder {
        TextView nameTextView, positionTextView, numberTextView;
        ImageView playerImageView;

        public ViewHolder(View itemLayout) {
            this.nameTextView = (TextView) itemLayout.findViewById(R.id.playerNameTextView);
            this.positionTextView = (TextView) itemLayout.findViewById(R.id.playerPositionTextView);
            this.numberTextView = (TextView) itemLayout.findViewById(R.id.playerNumberTextView);
            this.playerImageView = (ImageView) itemLayout.findViewById(R.id.playerImageView);
        }
    }
}
