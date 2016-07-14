package gg.patrickcummins.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;

import static android.R.attr.x;
import static gg.patrickcummins.myapplication.R.drawable.warriors;
import static gg.patrickcummins.myapplication.R.id.priceTextView;

public class RostersActivity extends AppCompatActivity {
    Intent currentIntent;
    String team;
    ImageView teamImageView;
    ArrayList<Player> playerArrayList;
    ListView playerListView;
    PlayerListAdapter playerListAdapter;
    DatabaseHelper helper;
    FloatingActionButton floatingActionButton;
    EditText searchEditText;
    RadioButton nameRadio, numberRadio, positionRadio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rosters);

        getIntentandSetVariables();
        setTeam();
        setAdapter();
        setFabOnClick();
        setEditText();

    }

    private void setEditText() {
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    playerArrayList = helper.getTeamPlayerList(team);


                } else {
                    if (nameRadio.isChecked()) {
                        playerArrayList = helper.getTeamPlayerByNameList(team, s.toString());
                    } else if (positionRadio.isChecked()) {
                        playerArrayList = helper.getTeamPlayerByPositionList(team, s.toString());
                    } else if (numberRadio.isChecked()) {
                        playerArrayList = helper.getTeamPlayerByNumberList(team, s.toString());
                    }


                }
                playerListAdapter = new PlayerListAdapter(playerArrayList, RostersActivity.this);
                playerListView.setAdapter(playerListAdapter);

            }

            @Override
            public void afterTextChanged(Editable s) {
                playerListAdapter.notifyDataSetChanged();

            }
        });
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
            setTheme(R.style.WarriorsTheme);
        } else if (team.equals("raiders")) {
            teamImageView.setImageResource(R.drawable.raiders);
            playerArrayList = helper.getTeamPlayerList("raiders");
            setTheme(R.style.RaidersTheme);
        } else if (team.equals("sharks")) {
            teamImageView.setImageResource(R.drawable.sharks);
            playerArrayList = helper.getTeamPlayerList("sharks");
            setTheme(R.style.SharksTheme);
        }
    }

    private void getIntentandSetVariables() {
        currentIntent = getIntent();
        team = currentIntent.getStringExtra("team");

        teamImageView = (ImageView) findViewById(R.id.teamImageView);
        playerListView = (ListView) findViewById(R.id.playersListView);
        teamImageView = (ImageView) findViewById(R.id.teamImageView);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.cartFab);
        searchEditText = (EditText) findViewById(R.id.searchEditText);
        nameRadio = (RadioButton) findViewById(R.id.nameRadio);
        numberRadio = (RadioButton) findViewById(R.id.numberRadio);
        positionRadio = (RadioButton) findViewById(R.id.positionRadio);

        nameRadio.setChecked(true);
        currentIntent = getIntent();
        team = currentIntent.getStringExtra("team");
        helper = DatabaseHelper.getInstance(RostersActivity.this);


    }

}
