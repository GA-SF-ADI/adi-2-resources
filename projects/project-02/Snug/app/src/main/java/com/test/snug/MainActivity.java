package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Hat> hatList = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "Main Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        ImageButton cartButtonInToolbar = (ImageButton) findViewById(R.id.button_in_toolbar_to_view_cart);
        ImageButton searchButtonInToolbar = (ImageButton) findViewById(R.id.button_in_toolbar_to_search_for_hats);

        SharedPreferences sharedPreferences = getSharedPreferences("hats added to database.key", Context.MODE_PRIVATE);
        Context context = getApplicationContext();
        HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);


        Cursor cursor = db.getNumOfCartItems();


        if (cursor.getCount() > 0) {

            TextView cartItemCounter = (TextView) findViewById(R.id.textview_num_of_hats_in_cart);
            ImageView redCartCountBackgroundCircle = (ImageView) findViewById(R.id.cart_counter_red_circle_area);

            redCartCountBackgroundCircle.setImageResource(R.drawable.red_circle);

            cartItemCounter.setText(String.valueOf(cursor.getCount()));


        } else {
            TextView cartItemCounter = (TextView) findViewById(R.id.textview_num_of_hats_in_cart);
            ImageView redCartCountBackgroundCircle = (ImageView) findViewById(R.id.cart_counter_red_circle_area);


        }

        ////////////////////////////////////////////////////////////////////////////////

        if (sharedPreferences.contains("hatsAdded") == false) {

            insertHatData();


        } else {


            Cursor allHatsCursor = db.getALLHats();

            Log.d(LOG_TAG, "allHatsCursor created");

            RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.mainactivity_hat_recyclerview);

            Log.d(LOG_TAG, "recyclerview bound");

            mRecyclerView.setHasFixedSize(true);

            Log.d(LOG_TAG, "recyclerview setHasFixedSize set to true");

            mLayoutManager = new GridLayoutManager(context, 2);

            Log.d(LOG_TAG, "GridLayoutManager context set");

            mRecyclerView.setLayoutManager(mLayoutManager);

            Log.d(LOG_TAG, "mLayoutManager passed through to setLayoutManager");

            mAdapter = new HatsMyRecyclerViewAdapter(allHatsCursor, context);

            Log.d(LOG_TAG, "mAdapter created");

            mRecyclerView.setAdapter(mAdapter);

            Log.d(LOG_TAG, "mRecyclerView set on mAdapter");
        }

        cartButtonInToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ShoppingCartActivity.class);
                startActivity(intent);

            }
        });

        searchButtonInToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);

            }
        });


    }


    private void insertHatData() {

        HatsSQLiteOpenHelper hatDatabase = HatsSQLiteOpenHelper.getInstance(MainActivity.this);

        Log.d(LOG_TAG, "instance of hatDatabase made in preparation for hats to be added to database");

        hatDatabase.addHatToHatDatabase(0, R.drawable.a_s_america, "Oakland A’s", 50, "100% polyester", "Snap", "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHatToHatDatabase(1, R.drawable.a_s_america2, "Oakland A’s", 19.99, "100% wool", "Snap", "Great for a day at the beach!", "green");
        hatDatabase.addHatToHatDatabase(2, R.drawable.all_black_braves, "Atlanta Braves", 19.99, "100% cotton", "Snap", "Play the outfield with confidence", "black");
        hatDatabase.addHatToHatDatabase(3, R.drawable.all_black_colorado, "Colorado Rockies", 19.99, "50% polyester 50% wool ", "Snap", "Turn a double play in this stylish hat", "black");
        hatDatabase.addHatToHatDatabase(4, R.drawable.all_blue_cubs, "Chicago Cubs", 19.99, "50% polyester 50% cotton ", "Snap", "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHatToHatDatabase(5, R.drawable.all_blue_mets, "New York Mets", 19.99, "50% wool 50% cotton ", "Snap", "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHatToHatDatabase(6, R.drawable.all_blue_tribe, "Cleveland Indians", 50, "100% polyester", "Snap", "Great for a day at the beach!", "blue");
        hatDatabase.addHatToHatDatabase(7, R.drawable.all_blue_twins, "Minnesota Twins", 19.99, "100% wool", "Snap", "Play the outfield with confidence", "blue");
        hatDatabase.addHatToHatDatabase(8, R.drawable.all_green_a_s, "Oakland A’s", 19.99, "100% cotton", "Snap", "Turn a double play in this stylish hat", "green");
        hatDatabase.addHatToHatDatabase(9, R.drawable.all_orange_houston, "Houston Astros", 19.99, "50% polyester 50% wool ", "Snap", "Block the sun and look good in this beautiful hat", "orange");
        hatDatabase.addHatToHatDatabase(10, R.drawable.all_read_angels, "LA Angels", 19.99, "50% polyester 50% cotton ", "Snap", "Plush and soft, this hat will keep you comfortable", "read");
        hatDatabase.addHatToHatDatabase(11, R.drawable.all_read_cardnials, "St. Louis Cardinals", 19.99, "50% wool 50% cotton ", "Snap", "Great for a day at the beach!", "read");
        hatDatabase.addHatToHatDatabase(12, R.drawable.all_red_dc, "DC Nationals", 19.99, "100% polyester", "Snap", "Play the outfield with confidence", "red");
        hatDatabase.addHatToHatDatabase(13, R.drawable.all_red_reds, "Cincinnati Reds", 19.99, "100% wool", "Snap", "Turn a double play in this stylish hat", "red");
        hatDatabase.addHatToHatDatabase(14, R.drawable.army_pirates, "Pittsburgh Pirates", 19.99, "100% cotton", "Snap", "Block the sun and look good in this beautiful hat", "brown");
        hatDatabase.addHatToHatDatabase(15, R.drawable.army_reds, "Cincinnati Reds", 19.99, "50% polyester 50% wool ", "Snap", "Plush and soft, this hat will keep you comfortable", "borwn");
        hatDatabase.addHatToHatDatabase(16, R.drawable.backs, "AZ Diamondbacks", 50, "50% polyester 50% cotton ", "Snap", "Great for a day at the beach!", "black");
        hatDatabase.addHatToHatDatabase(17, R.drawable.beantown, "Boston Red Sox", 19.99, "50% wool 50% cotton ", "Snap", "Play the outfield with confidence", "blue");
        hatDatabase.addHatToHatDatabase(18, R.drawable.black_brim_reds, "Cincinnati Reds", 19.99, "100% polyester", "Snap", "Turn a double play in this stylish hat", "red");
        hatDatabase.addHatToHatDatabase(19, R.drawable.black_home_giants, "San Francisco Giants", 50, "100% wool", "Snap", "Block the sun and look good in this beautiful hat", "black");
        hatDatabase.addHatToHatDatabase(20, R.drawable.black_miami, "Miami Marlins", 19.99, "100% cotton", "Snap", "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHatToHatDatabase(21, R.drawable.black_rattles, "AZ Diamondbacks", 29.99, "50% polyester 50% wool ", "Snap", "Great for a day at the beach!", "black");
        hatDatabase.addHatToHatDatabase(22, R.drawable.black_red_a_on_black_arizona, "AZ Diamondbacks", 29.99, "50% polyester 50% cotton ", "Snap", "Play the outfield with confidence", "black");
        hatDatabase.addHatToHatDatabase(23, R.drawable.black_rockies, "Colorado Rockies", 29.99, "50% wool 50% cotton ", "Snap", "Turn a double play in this stylish hat", "black");
        hatDatabase.addHatToHatDatabase(24, R.drawable.black_throwback_marlins, "Miami Marlins", 50, "100% polyester", "Snap", "Block the sun and look good in this beautiful hat", "black");
        hatDatabase.addHatToHatDatabase(25, R.drawable.black_top_baltimore, "Baltimore Orioles", 29.99, "100% wool", "Snap", "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHatToHatDatabase(26, R.drawable.black_top_chi_sox, "Chicago White Sox", 29.99, "100% cotton", "Snap", "Great for a day at the beach!", "black");
        hatDatabase.addHatToHatDatabase(27, R.drawable.black_top_pitts, "Pittsburgh Pirates", 29.99, "50% polyester 50% wool ", "Snap", "Play the outfield with confidence", "black");
        hatDatabase.addHatToHatDatabase(28, R.drawable.blue_brim_astros, "Houston Astros", 50, "50% polyester 50% cotton ", "Snap", "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHatToHatDatabase(29, R.drawable.blue_mets, "New York Mets", 29.99, "50% wool 50% cotton ", "Snap", "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHatToHatDatabase(30, R.drawable.blue_rangers, "Texas Rangers", 29.99, "100% polyester", "Snap", "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHatToHatDatabase(31, R.drawable.blue_top_brewers, "Milwaukee Brewers", 29.99, "100% wool", "Snap", "Great for a day at the beach!", "blue");
        hatDatabase.addHatToHatDatabase(32, R.drawable.all_blue_mets, "New York Mets", 50, "100% cotton", "Snap", "Play the outfield with confidence", "blue");
        hatDatabase.addHatToHatDatabase(33, R.drawable.blueleafjays, "Toronto Blue Jays", 29.99, "50% polyester 50% wool ", "Snap", "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHatToHatDatabase(34, R.drawable.brew_america, "Milwaukee Brewers", 29.99, "50% polyester 50% cotton ", "Snap", "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHatToHatDatabase(35, R.drawable.brewers_glove, "Milwaukee Brewers", 29.99, "50% wool 50% cotton ", "Snap", "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHatToHatDatabase(36, R.drawable.cursive_o_s_baltimore, "Baltimore Orioles", 29.99, "100% polyester", "Snap", "Great for a day at the beach!", "black");
        hatDatabase.addHatToHatDatabase(37, R.drawable.dark_blue_boston, "Boston Red Sox", 29.99, "100% wool", "Snap", "Play the outfield with confidence", "blue");
        hatDatabase.addHatToHatDatabase(38, R.drawable.dark_blue_rays, "Toronto Blue Jays", 29.99, "100% cotton", "Snap", "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHatToHatDatabase(39, R.drawable.dodgers, "LA Dodgers", 50, "50% polyester 50% wool ", "Snap", "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHatToHatDatabase(40, R.drawable.florida, "Miami Marlins", 39.99, "50% polyester 50% cotton ", "Snap", "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHatToHatDatabase(41, R.drawable.giants, "San Francisco Giants", 39.99, "50% wool 50% cotton ", "Snap", "Great for a day at the beach!", "black");
        hatDatabase.addHatToHatDatabase(42, R.drawable.green_road_a_s, "Oakland A’s", 39.99, "100% polyester", "Snap", "Play the outfield with confidence", "green");
        hatDatabase.addHatToHatDatabase(43, R.drawable.hanging_red_sox_for_boston, "Boston Red Sox", 39.99, "100% wool", "Snap", "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHatToHatDatabase(44, R.drawable.left_facing_blue_jay, "Toronto Blue Jays", 39.99, "100% cotton", "Snap", "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHatToHatDatabase(45, R.drawable.light_blue_90s_seattle, "Seattle Mariners", 50, "50% polyester 50% wool ", "Snap", "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHatToHatDatabase(46, R.drawable.marlins_america, "Miami Marlins", 39.99, "50% polyester 50% cotton ", "Snap", "Great for a day at the beach!", "blue");
        hatDatabase.addHatToHatDatabase(47, R.drawable.old_blue_breweers, "Milwaukee Brewers", 39.99, "50% wool 50% cotton ", "Snap", "Play the outfield with confidence", "blue");
        hatDatabase.addHatToHatDatabase(48, R.drawable.old_orioles, "Baltimore Orioles", 39.99, "100% polyester", "Snap", "Turn a double play in this stylish hat", "white");
        hatDatabase.addHatToHatDatabase(49, R.drawable.old_padres, "San Diego Padres", 50, "100% wool", "Snap", "Block the sun and look good in this beautiful hat", "yellow");
        hatDatabase.addHatToHatDatabase(50, R.drawable.old_school_blue_cardinals, "St. Louis Cardinals", 39.99, "100% cotton", "Snap", "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHatToHatDatabase(51, R.drawable.old_school_blue_seattle, "Seattle Mariners", 39.99, "50% polyester 50% wool ", "Fitted", "Great for a day at the beach!", "blue");
        hatDatabase.addHatToHatDatabase(52, R.drawable.old_school_c_indians, "Cleveland Indians", 39.99, "50% polyester 50% cotton ", "Fitted", "Play the outfield with confidence", "blue");
        hatDatabase.addHatToHatDatabase(53, R.drawable.old_school_cleveland, "Cleveland Indians", 50, "50% wool 50% cotton ", "Fitted", "Turn a double play in this stylish hat", "red");
        hatDatabase.addHatToHatDatabase(54, R.drawable.old_whitesox, "Chicago White Sox", 39.99, "100% polyester", "Fitted", "Block the sun and look good in this beautiful hat", "white");
        hatDatabase.addHatToHatDatabase(55, R.drawable.orange_brim_sf, "San Francisco Giants", 39.99, "100% wool", "Fitted", "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHatToHatDatabase(56, R.drawable.orange_d_detroit, "Detroit Tigers", 39.99, "100% cotton", "Fitted", "Great for a day at the beach!", "black");
        hatDatabase.addHatToHatDatabase(57, R.drawable.orange_marlins, "Miami Marlins", 39.99, "50% polyester 50% wool ", "Fitted", "Play the outfield with confidence", "orange");
        hatDatabase.addHatToHatDatabase(58, R.drawable.orange_ny_mets, "New York Mets", 39.99, "50% polyester 50% cotton ", "Fitted", "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHatToHatDatabase(59, R.drawable.orange_on_dark_blue_houston, "Houston Astros", 39.99, "50% wool 50% cotton ", "Fitted", "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHatToHatDatabase(60, R.drawable.orangebrimmets, "New York Mets", 50, "100% polyester", "Fitted", "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHatToHatDatabase(61, R.drawable.padres, "San Diego Padres", 9.99, "100% wool", "Fitted", "Great for a day at the beach!", "black");
        hatDatabase.addHatToHatDatabase(62, R.drawable.phils_america, "Philadelphia Phillies", 9.99, "100% cotton", "Fitted", "Play the outfield with confidence", "red");
        hatDatabase.addHatToHatDatabase(63, R.drawable.purple_rockies, "Colorado Rockies", 9.99, "50% polyester 50% wool ", "Fitted", "Turn a double play in this stylish hat", "purple");
        hatDatabase.addHatToHatDatabase(64, R.drawable.rangers_red_top, "Texas Rangers", 50, "50% polyester 50% cotton ", "Fitted", "Block the sun and look good in this beautiful hat", "red");
        hatDatabase.addHatToHatDatabase(65, R.drawable.red_blue_diamondbacks, "AZ Diamondbacks", 9.99, "50% wool 50% cotton ", "Fitted", "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHatToHatDatabase(66, R.drawable.red_brim_atlanta, "Atlanta Braves", 9.99, "100% polyester", "Fitted", "Great for a day at the beach!", "blue");
        hatDatabase.addHatToHatDatabase(67, R.drawable.red_brim_braves, "Atlanta Braves", 9.99, "100% wool", "Fitted", "Play the outfield with confidence", "blue");
        hatDatabase.addHatToHatDatabase(68, R.drawable.red_brim_cardinals, "St. Louis Cardinals", 50, "100% cotton", "Fitted", "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHatToHatDatabase(69, R.drawable.red_brim_houston, "Houston Astros", 9.99, "50% polyester 50% wool ", "Fitted", "Block the sun and look good in this beautiful hat", "black");
        hatDatabase.addHatToHatDatabase(70, R.drawable.red_brim_indians, "Cleveland Indians", 9.99, "50% polyester 50% cotton ", "Fitted", "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHatToHatDatabase(71, R.drawable.red_brim_reds, "Cincinnati Reds", 9.99, "50% wool 50% cotton ", "Fitted", "Great for a day at the beach!", "black");
        hatDatabase.addHatToHatDatabase(72, R.drawable.red_brim_twins, "Minnesota Twins", 50, "100% polyester", "Fitted", "Play the outfield with confidence", "blue");
        hatDatabase.addHatToHatDatabase(73, R.drawable.red_hat_backs, "AZ Diamondbacks", 9.99, "100% wool", "Fitted", "Turn a double play in this stylish hat", "red");
        hatDatabase.addHatToHatDatabase(74, R.drawable.red_hat_nats, "DC Nationals", 9.99, "100% cotton", "Fitted", "Block the sun and look good in this beautiful hat", "red");
        hatDatabase.addHatToHatDatabase(75, R.drawable.red_hat_twins, "Minnesota Twins", 9.99, "50% polyester 50% wool ", "Fitted", "Plush and soft, this hat will keep you comfortable", "red");
        hatDatabase.addHatToHatDatabase(76, R.drawable.red_p_phillies, "Philadelphia Phillies", 50, "50% polyester 50% cotton ", "Fitted", "Great for a day at the beach!", "blue");
        hatDatabase.addHatToHatDatabase(77, R.drawable.red_sox_america, "Boston Red Sox", 9.99, "50% wool 50% cotton ", "Fitted", "Play the outfield with confidence", "black");
        hatDatabase.addHatToHatDatabase(78, R.drawable.red_top_philly, "Philadelphia Phillies", 9.99, "100% polyester", "Fitted", "Turn a double play in this stylish hat", "red");
        hatDatabase.addHatToHatDatabase(79, R.drawable.redsnakes, "AZ Diamondbacks", 50, "100% wool", "Fitted", "Block the sun and look good in this beautiful hat", "red");
        hatDatabase.addHatToHatDatabase(80, R.drawable.rockies_america, "Colorado Rockies", 14.95, "100% cotton", "Fitted", "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHatToHatDatabase(81, R.drawable.rsox, "Boston Red Sox", 14.95, "50% polyester 50% wool ", "Fitted", "Great for a day at the beach!", "black");
        hatDatabase.addHatToHatDatabase(82, R.drawable.s_mariners, "Seattle Mariners", 14.95, "50% polyester 50% cotton ", "Fitted", "Play the outfield with confidence", "black");
        hatDatabase.addHatToHatDatabase(83, R.drawable.sgiants, "San Francisco Giants", 14.95, "50% wool 50% cotton ", "Fitted", "Turn a double play in this stylish hat", "black");
        hatDatabase.addHatToHatDatabase(84, R.drawable.spiky_pirates_p_on_black, "Pittsburgh Pirates", 50, "100% polyester", "Fitted", "Block the sun and look good in this beautiful hat", "black");
        hatDatabase.addHatToHatDatabase(85, R.drawable.standard_a_s, "Oakland A’s", 14.95, "100% wool", "Fitted", "Plush and soft, this hat will keep you comfortable", "green");
        hatDatabase.addHatToHatDatabase(86, R.drawable.standard_blue_royals, "Kansas City Royals", 14.95, "100% cotton", "Fitted", "Great for a day at the beach!", "blue");
        hatDatabase.addHatToHatDatabase(87, R.drawable.standard_dodgers, "LA Dodgers", 14.95, "50% polyester 50% wool ", "Fitted", "Play the outfield with confidence", "blue");
        hatDatabase.addHatToHatDatabase(88, R.drawable.standard_yanks, "New York Yankees", 50, "50% polyester 50% cotton ", "Fitted", "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHatToHatDatabase(89, R.drawable.tb, "Tampa Bay Rays", 14.95, "50% wool 50% cotton ", "Fitted", "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHatToHatDatabase(90, R.drawable.texas_america, "Texas Rangers", 14.95, "100% polyester", "Fitted", "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHatToHatDatabase(91, R.drawable.three_stripe_pirates, "Pittsburgh Pirates", 50, "100% wool", "Fitted", "Great for a day at the beach!", "black");
        hatDatabase.addHatToHatDatabase(92, R.drawable.twins_blue_up_top, "Minnesota Twins", 14.95, "100% cotton", "Fitted", "Play the outfield with confidence", "blue");
        hatDatabase.addHatToHatDatabase(93, R.drawable.white_sd_letters_padres, "San Diego Padres", 14.95, "50% polyester 50% wool ", "Fitted", "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHatToHatDatabase(94, R.drawable.white_tigers_d, "Detroit Tigers", 14.95, "50% polyester 50% cotton ", "Fitted", "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHatToHatDatabase(95, R.drawable.white_w_nats, "DC Nationals", 14.95, "50% wool 50% cotton ", "Fitted", "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHatToHatDatabase(96, R.drawable.wsox, "Chicago White Sox", 50, "100% polyester", "Fitted", "Great for a day at the beach!", "black");
        hatDatabase.addHatToHatDatabase(97, R.drawable.yankees, "New York Yankees", 14.95, "100% wool", "Fitted", "Play the outfield with confidence", "blue");
        hatDatabase.addHatToHatDatabase(98, R.drawable.yanks, "New York Yankees", 14.95, "100% cotton", "Fitted", "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHatToHatDatabase(99, R.drawable.yellow_top_pirates, "Pittsburgh Pirates", 50, "50% polyester 50% wool ", "Fitted", "Block the sun and look good in this beautiful hat", "yellow");

        Log.d(LOG_TAG, "All hats inserted into database");

        SharedPreferences sharedPreferences = getSharedPreferences("hats added to database.key", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("hatsAdded", "hatsin");
        editor.apply();

    }


}

