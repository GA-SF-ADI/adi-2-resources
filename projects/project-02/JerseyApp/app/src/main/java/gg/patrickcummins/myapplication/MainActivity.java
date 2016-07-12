package gg.patrickcummins.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.SupportActionModeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.R.attr.drawable;
import static android.R.attr.process;

public class MainActivity extends AppCompatActivity {
    ImageView warriors, raiders, sharks;
    DatabaseHelper helper;
    FloatingActionButton floatingActionButton;
    Button purchaseHistoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = DatabaseHelper.getInstance(MainActivity.this);

        setImageViews();
        setOnClickListeners();

        if (helper.getTeamPlayerList("warriors").size() < 1) {
            initializeTeams(helper);
        }


    }

    private void initializeTeams(DatabaseHelper helper) {
        initializeWarriors(helper);
        initializeRaiders(helper);
        initializeSharks(helper);
    }

    private void initializeSharks(DatabaseHelper helper) {
        helper.insertPlayerRow(new Player("Joe Thorton", "Center", 19, R.drawable.joe_thorton, "sharks", R.drawable.joe_thorton_blue, R.drawable.joe_thorton_white, R.drawable.joe_thorton_black));
        helper.insertPlayerRow(new Player("Joe Pavelski", "Center", 8, R.drawable.joe_pavelski, "sharks", R.drawable.joe_pavelski_blue, R.drawable.joe_pavelski_white, R.drawable.joe_pavelski_black));
        helper.insertPlayerRow(new Player("Brent Burns", "Defense", 8, R.drawable.brent_burns, "sharks", R.drawable.brent_burns_blue, R.drawable.brent_burns_white, R.drawable.brent_burns_black));

    }

    private void initializeWarriors(DatabaseHelper helper) {
        helper.insertPlayerRow(new Player("Stephen Curry", "Guard", 30, R.drawable.stephen_curry, "warriors", R.drawable.stephen_curry_blue, R.drawable.stephen_curry_white, R.drawable.stephen_curry_slate));
        helper.insertPlayerRow(new Player("Klay Thompson", "Guard", 11, R.drawable.klay_thompson, "warriors", R.drawable.klay_thompson_blue, R.drawable.klay_thompson_white, R.drawable.klay_thompson_slate));
        helper.insertPlayerRow(new Player("Draymond Green", "Forward", 23, R.drawable.draymond_green, "warriors", R.drawable.draymond_green_blue, R.drawable.draymond_green_white, R.drawable.draymond_green_slate));
        helper.insertPlayerRow(new Player("Harrison Barnes", "Forward", 40, R.drawable.harrison_barnes, "warriors", R.drawable.harrison_barnes_blue, R.drawable.harrison_barnes_white, R.drawable.harrison_barnes_slate));
        helper.insertPlayerRow(new Player("Andrew Bogut", "Forward-Center", 12, R.drawable.andrew_bogut, "warriors", R.drawable.andrew_bogut_blue, R.drawable.andrew_bogut_white, R.drawable.andrew_bogut_slate));
        helper.insertPlayerRow(new Player("Andre Iguodala", "Guard-Forward", 9, R.drawable.andre_iguodala, "warriors", R.drawable.andre_iguodala_blue, R.drawable.andre_iguodala_white, R.drawable.andre_iguodala_slate));
        helper.insertPlayerRow(new Player("Shaun Livingston", "Guard", 34, R.drawable.shaun_livingston, "warriors", R.drawable.shaun_livingston_blue, R.drawable.shaun_livingston_white, R.drawable.shaun_livingston_slate));
        helper.insertPlayerRow(new Player("Festus Ezeli", "Forward-Center", 31, R.drawable.festus_ezeli, "warriors", R.drawable.festus_ezeli_blue, R.drawable.festus_ezeli_white, R.drawable.festus_ezeli_slate));
        helper.insertPlayerRow(new Player("Ian Clark", "Guard", 21, R.drawable.ian_clark, "warriors", R.drawable.ian_clark_blue, R.drawable.ian_clark_white, R.drawable.ian_clark_slate));
        helper.insertPlayerRow(new Player("Leandro Barbosa", "Guard", 19, R.drawable.leandro_barbosa, "warriors", R.drawable.leandro_barbosa_blue, R.drawable.leandro_barbosa_white, R.drawable.leandro_barbosa_slate));
        helper.insertPlayerRow(new Player("Marreese Speights", "Forward-Center", 5, R.drawable.marreese_speights, "warriors", R.drawable.marreese_speights_blue, R.drawable.marreese_speights_white, R.drawable.marreese_speights_slate));


    }

    //TODO: Unfuckup Coops White Jersey
    private void initializeRaiders(DatabaseHelper helper) {
        helper.insertPlayerRow(new Player("Derek Carr", "Quarterback", 4, R.drawable.derek_carr, "raiders", -1, R.drawable.derek_carr_white, R.drawable.derek_carr_black));
        helper.insertPlayerRow(new Player("Khalil Mack", "Defensive End", 53, R.drawable.khalil_mack, "raiders", R.drawable.khalil_mack_pro_bowl, R.drawable.khalil_mack_white, R.drawable.khalil_mack_black));
        helper.insertPlayerRow(new Player("Amari Cooper", "Wide Reciever", 89, R.drawable.amari_cooper, "raiders", -1, R.drawable.amari_cooper_black, R.drawable.amari_cooper_black));
        helper.insertPlayerRow(new Player("Michael Crabtree", "Wide Reciever", 15, R.drawable.michael_crabtree, "raiders", -1, R.drawable.michael_crabtree_white, R.drawable.michael_crabtree_black));

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
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
        purchaseHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PurchaseHistoryActivity.class);
                startActivity(intent);
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
        floatingActionButton = (FloatingActionButton) findViewById(R.id.cartFab);
        purchaseHistoryButton = (Button) findViewById(R.id.purchaseHistoryButton);
    }

}
