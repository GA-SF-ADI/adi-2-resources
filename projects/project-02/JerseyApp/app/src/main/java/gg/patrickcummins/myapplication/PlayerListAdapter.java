package gg.patrickcummins.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.onClick;
import static android.R.attr.start;

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
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.player_list_item, parent, false);
        }
        final Player currentPlayer = playerArrayList.get(position);
        ImageView playerImageView = (ImageView) convertView.findViewById(R.id.playerImageView);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.playerNameTextView);
        TextView positionTextView = (TextView) convertView.findViewById(R.id.playerPositionTextView);
        TextView numberTextView = (TextView) convertView.findViewById(R.id.playerNumberTextView);


        nameTextView.setText(currentPlayer.getName());
        positionTextView.setText("Position: " + currentPlayer.getPosition());
        numberTextView.setText("Number: " + currentPlayer.getNumber());
        playerImageView.setImageResource(currentPlayer.getPlayerPicture());


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
}
