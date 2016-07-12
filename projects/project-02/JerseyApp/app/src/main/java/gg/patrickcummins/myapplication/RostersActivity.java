package gg.patrickcummins.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.attr.x;
import static gg.patrickcummins.myapplication.R.drawable.warriors;

public class RostersActivity extends AppCompatActivity {
    Intent currentIntent;
    String team;
    ImageView teamImageView;
    ArrayList<Player> playerArrayList;
    ListView playerListView;
    PlayerListAdapter playerListAdapter;
    DatabaseHelper helper;
    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rosters);



        getIntentandSetVariables();
        setTeam();
        setAdapter();
        setFabOnClick();



    }

    private void setFabOnClick() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RostersActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setAdapter() {
        playerListAdapter = new PlayerListAdapter(playerArrayList, RostersActivity.this);
        playerListView.setAdapter(playerListAdapter);
    }


    private void setTeam() {
        if (team.equals("warriors")) {
            teamImageView.setImageResource(R.drawable.warriors);
            playerArrayList = helper.getTeamPlayerList("warriors");
        } else if (team.equals("raiders")) {
            teamImageView.setImageResource(R.drawable.raiders);
            playerArrayList = helper.getTeamPlayerList("raiders");
        } else if (team.equals("sharks")) {
            teamImageView.setImageResource(R.drawable.sharks);
            playerArrayList = helper.getTeamPlayerList("sharks");
        }
    }

    private void getIntentandSetVariables() {
        currentIntent = getIntent();
        team = currentIntent.getStringExtra("team");

        teamImageView = (ImageView) findViewById(R.id.teamImageView);
        playerListView = (ListView) findViewById(R.id.playersListView);
        teamImageView = (ImageView) findViewById(R.id.teamImageView);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.cartFab);





        currentIntent = getIntent();
        team = currentIntent.getStringExtra("team");
        helper = DatabaseHelper.getInstance(RostersActivity.this);


    }

}
