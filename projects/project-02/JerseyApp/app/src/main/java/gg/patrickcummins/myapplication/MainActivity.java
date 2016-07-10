package gg.patrickcummins.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.SupportActionModeWrapper;
import android.view.View;
import android.widget.ImageView;

import static android.R.attr.drawable;
import static android.R.attr.process;

public class MainActivity extends AppCompatActivity {
    ImageView warriors, raiders, sharks;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = DatabaseHelper.getInstance(MainActivity.this);

        setImageViews();
        setOnClickListeners();

        if (helper.getTeamPlayerList("warriors").size() < 1){
            initializeTeams(helper);
        }

        

        //TODO: Make it so database table doesn't keep duplicating every time onCreate is called
    }

    private void initializeTeams(DatabaseHelper helper) {
        initializeWarriors(helper);
        initializeRaiders(helper);
        initializeSharks(helper);
    }

    private void initializeSharks(DatabaseHelper helper) {
        helper.insertPlayerRow(new Player("Joe Thorton", "Center", 19, R.drawable.joe_thorton, "sharks"));
        helper.insertPlayerRow(new Player("Joe Pavelski", "Center", 8, R.drawable.joe_pavelski, "sharks"));
        helper.insertPlayerRow(new Player("Brent Burns", "Defense", 8, R.drawable.brent_burns, "sharks"));

    }

    private void initializeWarriors(DatabaseHelper helper) {
        helper.insertPlayerRow(new Player("Stephen Curry", "Guard", 30, R.drawable.stephen_curry, "warriors"));
        helper.insertPlayerRow(new Player("Klay Thompson", "Guard", 11, R.drawable.klay_thompson, "warriors"));
        helper.insertPlayerRow(new Player("Draymond Green", "Forward", 23, R.drawable.draymond_green, "warriors"));
        helper.insertPlayerRow(new Player("Harrison Barnes", "Forward", 40, R.drawable.harrison_barnes, "warriors"));
        helper.insertPlayerRow(new Player("Andrew Bogut", "Forward-Center", 12, R.drawable.andrew_bogut, "warriors"));
        helper.insertPlayerRow(new Player("Andre Iguodala", "Guard-Forward", 9, R.drawable.andre_iguodala, "warriors"));
        helper.insertPlayerRow(new Player("Shaun Livingston", "Guard", 34, R.drawable.shaun_livingston, "warriors"));
        helper.insertPlayerRow(new Player("Festus Ezeli", "Forward-Center", 31, R.drawable.festus_ezeli, "warriors"));
        helper.insertPlayerRow(new Player("Ian Clark", "Guard", 21, R.drawable.ian_clark, "warriors"));
        helper.insertPlayerRow(new Player("Leandro Barbosa", "Guard", 19, R.drawable.leandro_barbosa, "warriors"));
        helper.insertPlayerRow(new Player("Marreese Speights", "Forward-Center", 5, R.drawable.marreese_speights, "warriors"));



    }

    private void initializeRaiders(DatabaseHelper helper){
        helper.insertPlayerRow(new Player("Derek Carr", "Quarterback", 4, R.drawable.derek_carr, "raiders"));
        helper.insertPlayerRow(new Player("Khalil Mack", "Defensive End", 53, R.drawable.khalil_mack, "raiders"));
        helper.insertPlayerRow(new Player("Amari Cooper", "Wide Reciever", 89, R.drawable.amari_cooper, "raiders"));
        helper.insertPlayerRow(new Player("Michael Crabtree", "Wide Reciever", 15, R.drawable.michael_crabtree, "raiders"));

    }

    private void setOnClickListeners() {
        warriors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRosterActivity("warriors");
            }
        });
        raiders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRosterActivity("raiders");
            }
        });
        sharks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRosterActivity("sharks");
            }
        });

    }

    private void startRosterActivity(String team) {
        Intent intent = new Intent(MainActivity.this, RostersActivity.class);
        intent.putExtra("team", team);
        startActivity(intent);

    }

    private void setImageViews() {
        warriors = (ImageView) findViewById(R.id.warriorsImageView);
        raiders = (ImageView) findViewById(R.id.raidersImageView);
        sharks = (ImageView) findViewById(R.id.sharksImageView);
    }

}
