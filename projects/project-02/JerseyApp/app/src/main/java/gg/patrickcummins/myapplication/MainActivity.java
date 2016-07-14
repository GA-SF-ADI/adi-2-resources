package gg.patrickcummins.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.SupportActionModeWrapper;
import android.view.MotionEvent;
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
        setOnTouchListeners();

        if (helper.getTeamPlayerList("warriors").size() < 1) {
            initializeTeams(helper);
        }



    }



    private void setOnTouchListeners() {

//        warriors.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                setImageViewOnTouch(v, event);
//                return true;
//            }
//        });
//        raiders.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                setImageViewOnTouch(v, event);
//                return true;
//            }
//        });
//        sharks.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                setImageViewOnTouch(v, event);
//                return true;
//            }
//        });


    }

    private void setImageViewOnTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                ImageView view = (ImageView) v;
                //overlay is black with transparency of 0x77 (119)
                view.getDrawable().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                view.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                ImageView view = (ImageView) v;
                //clear the overlay
                view.getDrawable().clearColorFilter();
                view.invalidate();
                break;
            }
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
        helper.insertPlayerRow(new Player("Brent Burns", "Defense", 88, R.drawable.brent_burns, "sharks", R.drawable.brent_burns_blue, R.drawable.brent_burns_white, R.drawable.brent_burns_black));
        helper.insertPlayerRow(new Player("Martin Jones", "Goalie", 31, R.drawable.martin_jones, "sharks", R.drawable.martin_jones_blue, R.drawable.martin_jones_white, R.drawable.martin_jones_black ));
        helper.insertPlayerRow(new Player("Joel Ward", "Right Wing", 42, R.drawable.joel_ward, "sharks", R.drawable.joel_ward_blue, R.drawable.joel_ward_white, R.drawable.joel_ward_black));
        helper.insertPlayerRow(new Player("Logan Couture", "Center", 39, R.drawable.logan_couture, "sharks", R.drawable.logan_couture_blue, R.drawable.logan_couture_white, R.drawable.logan_couture_black));
        helper.insertPlayerRow(new Player("Patrick Marleau", "Left Wing", 12, R.drawable.patrick_marleau, "sharks", R.drawable.patrick_marleau_blue, R.drawable.patrick_marleau_white, R.drawable.patrick_marleau_black));
        helper.insertPlayerRow(new Player("Paul Martin", "Defence", 7, R.drawable.paul_martin, "sharks", R.drawable.paul_martin_blue, R.drawable.paul_martin_white, R.drawable.paul_martin_black));
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

    private void initializeRaiders(DatabaseHelper helper) {
        helper.insertPlayerRow(new Player("Derek Carr", "Quarterback", 4, R.drawable.derek_carr, "raiders", -1, R.drawable.derek_carr_white, R.drawable.derek_carr_black));
        helper.insertPlayerRow(new Player("Khalil Mack", "Defensive End", 53, R.drawable.khalil_mack, "raiders", R.drawable.khalil_mack_pro_bowl, R.drawable.khalil_mack_white, R.drawable.khalil_mack_black));
        helper.insertPlayerRow(new Player("Amari Cooper", "Wide Receiver", 89, R.drawable.amari_cooper, "raiders", -1, R.drawable.amari_cooper_white, R.drawable.amari_cooper_black));
        helper.insertPlayerRow(new Player("Michael Crabtree", "Wide Receiver", 15, R.drawable.michael_crabtree, "raiders", -1, R.drawable.michael_crabtree_white, R.drawable.michael_crabtree_black));
        helper.insertPlayerRow(new Player("Latavius Murray", "Running Back", 28, R.drawable.latavius_murray, "raiders", R.drawable.latavius_murray_pro_bowl, R.drawable.latavius_murray_white, R.drawable.latavius_murray_black));
        helper.insertPlayerRow(new Player("Justin Tuck", "Defensive End", 91, R.drawable.justin_tuck, "raiders", -1, R.drawable.justin_tuck_white, R.drawable.justin_tuck_black));
        helper.insertPlayerRow(new Player("Charles Woodson", "Safety", 24, R.drawable.charles_woodson, "raiders", R.drawable.charles_woodson_pro_bowl, R.drawable.charles_woodson_white, R.drawable.charles_woodson_black));
        helper.insertPlayerRow(new Player("Marquette King", "Punter", 7, R.drawable.marquette_king, "raiders", -1, R.drawable.marquette_king_white, R.drawable.marquette_king_black));
        helper.insertPlayerRow(new Player("Reggie Nelson", "Safety", 27, R.drawable.reggie_nelson, "raiders", -1, R.drawable.reggie_nelson_white, R.drawable.reggie_nelson_black));
        helper.insertPlayerRow(new Player("Sebastian Janikowski", "Kicker", 11, R.drawable.sebastian_janikowski, "raiders", -1,R.drawable.sebastian_janikowski_white, R.drawable.sebastian_janikowski_black));
        helper.insertPlayerRow(new Player("Taiwan Jones", "Running Back", 22, R.drawable.taiwan_jones, "raiders", -1, R.drawable.taiwan_jones_white, R.drawable.taiwan_jones_black));
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
