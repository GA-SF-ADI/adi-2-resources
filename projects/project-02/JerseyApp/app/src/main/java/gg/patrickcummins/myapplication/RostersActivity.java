package gg.patrickcummins.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.x;
import static gg.patrickcummins.myapplication.R.drawable.warriors;

public class RostersActivity extends AppCompatActivity {
    Intent currentIntent;
    String team;
    ImageView teamImageView;
    ArrayList<Player> playerArrayList = new ArrayList<>();
    ListView playerListView;
    PlayerListAdapter playerListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rosters);
        currentIntent = getIntent();
        team = currentIntent.getStringExtra("team");
        teamImageView = (ImageView) findViewById(R.id.teamImageView);


        setGetIntentandSetVariables();
        setTeam();


    }

    private void setTeam() {
        if (team.equals("warriors")) {
            teamImageView.setImageResource(R.drawable.warriors);
        } else if (team.equals("raiders")) {
            teamImageView.setImageResource(R.drawable.raiders);
        } else if (team.equals("sharks")) {
            teamImageView.setImageResource(R.drawable.sharks);
        }
    }

    private void setGetIntentandSetVariables() {
        currentIntent = getIntent();
        team = currentIntent.getStringExtra("team");

        teamImageView = (ImageView) findViewById(R.id.teamImageView);
        playerListView = (ListView) findViewById(R.id.playersListView);


        //TODO: add Players from dataBase
        for (int i = 0; i < 10; i++) {
            playerArrayList.add(new Player("Klay Thompson", "Shooting Guard", 11, R.drawable.klay_thompson));
        }

        playerListAdapter = new PlayerListAdapter(playerArrayList, RostersActivity.this);
        playerListView.setAdapter(playerListAdapter);


    }
}
