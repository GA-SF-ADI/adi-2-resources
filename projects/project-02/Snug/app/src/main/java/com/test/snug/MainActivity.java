package com.test.snug;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

        Context context = getApplicationContext();
        SQLiteOpenHelper db = new SQLiteOpenHelper(context);


        ImageButton cartButtonInToolbar = (ImageButton) findViewById(R.id.button_in_toolbar_to_view_cart);
        ImageButton searchButtonInToolbar = (ImageButton) findViewById(R.id.button_in_toolbar_to_search_for_hats);


//        TODO: Set text to # of cart items
/*
        TextView cartItemCounter = (TextView) findViewById(R.id.textview_num_of_hats_in_cart);
        cartItemCounter.setText(__);
*/


        insertHatData();


        Cursor allHatsCursor = db.getAllHats();

        Log.d(LOG_TAG, "allHatsCursor created");

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.mainactivity_hat_recyclerview);

        Log.d(LOG_TAG, "recyclerview bound");

        mRecyclerView.setHasFixedSize(true);

        Log.d(LOG_TAG, "recyclerview setHasFixedSize set to true");

        mLayoutManager = new GridLayoutManager(context, 2);

        Log.d(LOG_TAG, "GridLayoutManager context set");

        mRecyclerView.setLayoutManager(mLayoutManager);

        Log.d(LOG_TAG, "mLayoutManager passed through to setLayoutManager");

        mAdapter = new MyRecyclerViewAdapter(allHatsCursor, context);

        Log.d(LOG_TAG, "mAdapter created");

        mRecyclerView.setAdapter(mAdapter);

        Log.d(LOG_TAG, "mRecyclerView set on mAdapter");


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


//        TODO: Check for cart items. If cart has items, display the red dot and counter


    }

    /* private ArrayList<Hat> getDataSet() {
         ArrayList results = new ArrayList<Hat>();

         results.add(new Hat(0, 4, "SF Giants", 39, "100% Cotton", 0, "Plush and soft, this hat will keep you comfortable", "black"));
         results.add(new Hat(1, 1, "Oakland", 29, "50% Cotton", 1, "Great for a day at the beach!", "green"));
         results.add(new Hat(2, 3, "Boston", 19, "100% Polyester", 1, "Play the outfield with confidence", "red"));
         results.add(new Hat(3, 2, "Yankees", 59, "50% Polyester", 0, "Turn a double play in this stylish hat", "dark blue"));

         return results;
     }
 */
    private void insertHatData() {

        SQLiteOpenHelper hatDatabase = SQLiteOpenHelper.getInstance(MainActivity.this);

        Log.d(LOG_TAG, "instance of hatDatabase made in preparation for hats to be added to database");

        hatDatabase.addHat(0, R.drawable.a_s_america, "Oakland A’s", 50, "100% polyester", 0, "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHat(1, R.drawable.a_s_america2, "Oakland A’s", 19.99, "100% wool", 0, "Great for a day at the beach!", "green");
        hatDatabase.addHat(2, R.drawable.all_black_braves, "Atlanta Braves", 19.99, "100% cotton", 0, "Play the outfield with confidence", "black");
        hatDatabase.addHat(3, R.drawable.all_black_colorado, "Colorado Rockies", 19.99, "50% polyester 50% wool ", 0, "Turn a double play in this stylish hat", "black");
        hatDatabase.addHat(4, R.drawable.all_blue_cubs, "Chicago Cubs", 19.99, "50% polyester 50% cotton ", 0, "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHat(5, R.drawable.all_blue_mets, "New York Mets", 19.99, "50% wool 50% cotton ", 0, "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHat(6, R.drawable.all_blue_tribe, "Cleveland Indians", 50, "100% polyester", 0, "Great for a day at the beach!", "blue");
        hatDatabase.addHat(7, R.drawable.all_blue_twins, "Minnesota Twins", 19.99, "100% wool", 0, "Play the outfield with confidence", "blue");
        hatDatabase.addHat(8, R.drawable.all_green_a_s, "Oakland A’s", 19.99, "100% cotton", 0, "Turn a double play in this stylish hat", "green");
        hatDatabase.addHat(9, R.drawable.all_orange_houston, "Houston Astros", 19.99, "50% polyester 50% wool ", 0, "Block the sun and look good in this beautiful hat", "orange");
        hatDatabase.addHat(10, R.drawable.all_read_angels, "LA Angels", 19.99, "50% polyester 50% cotton ", 0, "Plush and soft, this hat will keep you comfortable", "read");
        hatDatabase.addHat(11, R.drawable.all_read_cardnials, "St. Louis Cardinals", 19.99, "50% wool 50% cotton ", 0, "Great for a day at the beach!", "read");
        hatDatabase.addHat(12, R.drawable.all_red_dc, "DC Nationals", 19.99, "100% polyester", 0, "Play the outfield with confidence", "red");
        hatDatabase.addHat(13, R.drawable.all_red_reds, "Cincinnati Reds", 19.99, "100% wool", 0, "Turn a double play in this stylish hat", "red");
        hatDatabase.addHat(14, R.drawable.army_pirates, "Pittsburgh Pirates", 19.99, "100% cotton", 0, "Block the sun and look good in this beautiful hat", "brown");
        hatDatabase.addHat(15, R.drawable.army_reds, "Cincinnati Reds", 19.99, "50% polyester 50% wool ", 0, "Plush and soft, this hat will keep you comfortable", "borwn");
        hatDatabase.addHat(16, R.drawable.backs, "Arizona Diamondbacks", 50, "50% polyester 50% cotton ", 0, "Great for a day at the beach!", "black");
        hatDatabase.addHat(17, R.drawable.beantown, "Boston Red Sox", 19.99, "50% wool 50% cotton ", 0, "Play the outfield with confidence", "blue");
        hatDatabase.addHat(18, R.drawable.black_brim_reds, "Cincinnati Reds", 19.99, "100% polyester", 0, "Turn a double play in this stylish hat", "red");
        hatDatabase.addHat(19, R.drawable.black_home_giants, "San Francisco Giants", 50, "100% wool", 0, "Block the sun and look good in this beautiful hat", "black");
        hatDatabase.addHat(20, R.drawable.black_miami, "Miami Marlins", 19.99, "100% cotton", 0, "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHat(21, R.drawable.black_rattles, "Arizona Diamondbacks", 29.99, "50% polyester 50% wool ", 0, "Great for a day at the beach!", "black");
        hatDatabase.addHat(22, R.drawable.black_red_a_on_black_arizona, "Arizona Diamondbacks", 29.99, "50% polyester 50% cotton ", 0, "Play the outfield with confidence", "black");
        hatDatabase.addHat(23, R.drawable.black_rockies, "Colorado Rockies", 29.99, "50% wool 50% cotton ", 0, "Turn a double play in this stylish hat", "black");
        hatDatabase.addHat(24, R.drawable.black_throwback_marlins, "Miami Marlins", 50, "100% polyester", 0, "Block the sun and look good in this beautiful hat", "black");
        hatDatabase.addHat(25, R.drawable.black_top_baltimore, "Baltimore Orioles", 29.99, "100% wool", 0, "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHat(26, R.drawable.black_top_chi_sox, "Chicago White Sox", 29.99, "100% cotton", 0, "Great for a day at the beach!", "black");
        hatDatabase.addHat(27, R.drawable.black_top_pitts, "Pittsburgh Pirates", 29.99, "50% polyester 50% wool ", 0, "Play the outfield with confidence", "black");
        hatDatabase.addHat(28, R.drawable.blue_brim_astros, "Houston Astros", 50, "50% polyester 50% cotton ", 0, "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHat(29, R.drawable.blue_mets, "New York Mets", 29.99, "50% wool 50% cotton ", 0, "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHat(30, R.drawable.blue_rangers, "Texas Rangers", 29.99, "100% polyester", 0, "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHat(31, R.drawable.blue_top_brewers, "Milwaukee Brewers", 29.99, "100% wool", 0, "Great for a day at the beach!", "blue");
        hatDatabase.addHat(32, R.drawable.all_blue_mets, "New York Mets", 50, "100% cotton", 0, "Play the outfield with confidence", "blue");
        hatDatabase.addHat(33, R.drawable.blueleafjays, "Toronto Blue Jays", 29.99, "50% polyester 50% wool ", 0, "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHat(34, R.drawable.brew_america, "Milwaukee Brewers", 29.99, "50% polyester 50% cotton ", 0, "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHat(35, R.drawable.brewers_glove, "Milwaukee Brewers", 29.99, "50% wool 50% cotton ", 0, "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHat(36, R.drawable.cursive_o_s_baltimore, "Baltimore Orioles", 29.99, "100% polyester", 0, "Great for a day at the beach!", "black");
        hatDatabase.addHat(37, R.drawable.dark_blue_boston, "Boston Red Sox", 29.99, "100% wool", 0, "Play the outfield with confidence", "blue");
        hatDatabase.addHat(38, R.drawable.dark_blue_rays, "Toronto Blue Jays", 29.99, "100% cotton", 0, "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHat(39, R.drawable.dodgers, "LA Dodgers", 50, "50% polyester 50% wool ", 0, "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHat(40, R.drawable.florida, "Miami Marlins", 39.99, "50% polyester 50% cotton ", 0, "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHat(41, R.drawable.giants, "San Francisco Giants", 39.99, "50% wool 50% cotton ", 0, "Great for a day at the beach!", "black");
        hatDatabase.addHat(42, R.drawable.green_road_a_s, "Oakland A’s", 39.99, "100% polyester", 0, "Play the outfield with confidence", "green");
        hatDatabase.addHat(43, R.drawable.hanging_red_sox_for_boston, "Boston Red Sox", 39.99, "100% wool", 0, "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHat(44, R.drawable.left_facing_blue_jay, "Toronto Blue Jays", 39.99, "100% cotton", 0, "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHat(45, R.drawable.light_blue_90s_seattle, "Seattle Mariners", 50, "50% polyester 50% wool ", 0, "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHat(46, R.drawable.marlins_america, "Miami Marlins", 39.99, "50% polyester 50% cotton ", 0, "Great for a day at the beach!", "blue");
        hatDatabase.addHat(47, R.drawable.old_blue_breweers, "Milwaukee Brewers", 39.99, "50% wool 50% cotton ", 0, "Play the outfield with confidence", "blue");
        hatDatabase.addHat(48, R.drawable.old_orioles, "Baltimore Orioles", 39.99, "100% polyester", 0, "Turn a double play in this stylish hat", "white");
        hatDatabase.addHat(49, R.drawable.old_padres, "San Diego Padres", 50, "100% wool", 0, "Block the sun and look good in this beautiful hat", "yellow");
        hatDatabase.addHat(50, R.drawable.old_school_blue_cardinals, "St. Louis Cardinals", 39.99, "100% cotton", 0, "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHat(51, R.drawable.old_school_blue_seattle, "Seattle Mariners", 39.99, "50% polyester 50% wool ", 1, "Great for a day at the beach!", "blue");
        hatDatabase.addHat(52, R.drawable.old_school_c_indians, "Cleveland Indians", 39.99, "50% polyester 50% cotton ", 1, "Play the outfield with confidence", "blue");
        hatDatabase.addHat(53, R.drawable.old_school_cleveland, "Cleveland Indians", 50, "50% wool 50% cotton ", 1, "Turn a double play in this stylish hat", "red");
        hatDatabase.addHat(54, R.drawable.old_whitesox, "Chicago White Sox", 39.99, "100% polyester", 1, "Block the sun and look good in this beautiful hat", "white");
        hatDatabase.addHat(55, R.drawable.orange_brim_sf, "San Francisco Giants", 39.99, "100% wool", 1, "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHat(56, R.drawable.orange_d_detroit, "Detroit Tigers", 39.99, "100% cotton", 1, "Great for a day at the beach!", "black");
        hatDatabase.addHat(57, R.drawable.orange_marlins, "Miami Marlins", 39.99, "50% polyester 50% wool ", 1, "Play the outfield with confidence", "orange");
        hatDatabase.addHat(58, R.drawable.orange_ny_mets, "New York Mets", 39.99, "50% polyester 50% cotton ", 1, "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHat(59, R.drawable.orange_on_dark_blue_houston, "Houston Astros", 39.99, "50% wool 50% cotton ", 1, "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHat(60, R.drawable.orangebrimmets, "New York Mets", 50, "100% polyester", 1, "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHat(61, R.drawable.padres, "San Diego Padres", 9.99, "100% wool", 1, "Great for a day at the beach!", "black");
        hatDatabase.addHat(62, R.drawable.phils_america, "Philadelphia Phillies", 9.99, "100% cotton", 1, "Play the outfield with confidence", "red");
        hatDatabase.addHat(63, R.drawable.purple_rockies, "Colorado Rockies", 9.99, "50% polyester 50% wool ", 1, "Turn a double play in this stylish hat", "purple");
        hatDatabase.addHat(64, R.drawable.rangers_red_top, "Texas Rangers", 50, "50% polyester 50% cotton ", 1, "Block the sun and look good in this beautiful hat", "red");
        hatDatabase.addHat(65, R.drawable.red_blue_diamondbacks, "Arizona Diamondbacks", 9.99, "50% wool 50% cotton ", 1, "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHat(66, R.drawable.red_brim_atlanta, "Atlanta Braves", 9.99, "100% polyester", 1, "Great for a day at the beach!", "blue");
        hatDatabase.addHat(67, R.drawable.red_brim_braves, "Atlanta Braves", 9.99, "100% wool", 1, "Play the outfield with confidence", "blue");
        hatDatabase.addHat(68, R.drawable.red_brim_cardinals, "St. Louis Cardinals", 50, "100% cotton", 1, "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHat(69, R.drawable.red_brim_houston, "Houston Astros", 9.99, "50% polyester 50% wool ", 1, "Block the sun and look good in this beautiful hat", "black");
        hatDatabase.addHat(70, R.drawable.red_brim_indians, "Cleveland Indians", 9.99, "50% polyester 50% cotton ", 1, "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHat(71, R.drawable.red_brim_reds, "Cincinnati Reds", 9.99, "50% wool 50% cotton ", 1, "Great for a day at the beach!", "black");
        hatDatabase.addHat(72, R.drawable.red_brim_twins, "Minnesota Twins", 50, "100% polyester", 1, "Play the outfield with confidence", "blue");
        hatDatabase.addHat(73, R.drawable.red_hat_backs, "Arizona Diamondbacks", 9.99, "100% wool", 1, "Turn a double play in this stylish hat", "red");
        hatDatabase.addHat(74, R.drawable.red_hat_nats, "DC Nationals", 9.99, "100% cotton", 1, "Block the sun and look good in this beautiful hat", "red");
        hatDatabase.addHat(75, R.drawable.red_hat_twins, "Minnesota Twins", 9.99, "50% polyester 50% wool ", 1, "Plush and soft, this hat will keep you comfortable", "red");
        hatDatabase.addHat(76, R.drawable.red_p_phillies, "Philadelphia Phillies", 50, "50% polyester 50% cotton ", 1, "Great for a day at the beach!", "blue");
        hatDatabase.addHat(77, R.drawable.red_sox_america, "Boston Red Sox", 9.99, "50% wool 50% cotton ", 1, "Play the outfield with confidence", "black");
        hatDatabase.addHat(78, R.drawable.red_top_philly, "Philadelphia Phillies", 9.99, "100% polyester", 1, "Turn a double play in this stylish hat", "red");
        hatDatabase.addHat(79, R.drawable.redsnakes, "Arizona Diamondbacks", 50, "100% wool", 1, "Block the sun and look good in this beautiful hat", "red");
        hatDatabase.addHat(80, R.drawable.rockies_america, "Colorado Rockies", 14.95, "100% cotton", 1, "Plush and soft, this hat will keep you comfortable", "black");
        hatDatabase.addHat(81, R.drawable.rsox, "Boston Red Sox", 14.95, "50% polyester 50% wool ", 1, "Great for a day at the beach!", "black");
        hatDatabase.addHat(82, R.drawable.s_mariners, "Seattle Mariners", 14.95, "50% polyester 50% cotton ", 1, "Play the outfield with confidence", "black");
        hatDatabase.addHat(83, R.drawable.sgiants, "San Francisco Giants", 14.95, "50% wool 50% cotton ", 1, "Turn a double play in this stylish hat", "black");
        hatDatabase.addHat(84, R.drawable.spiky_pirates_p_on_black, "Pittsburgh Pirates", 50, "100% polyester", 1, "Block the sun and look good in this beautiful hat", "black");
        hatDatabase.addHat(85, R.drawable.standard_a_s, "Oakland A’s", 14.95, "100% wool", 1, "Plush and soft, this hat will keep you comfortable", "green");
        hatDatabase.addHat(86, R.drawable.standard_blue_royals, "Kansas City Royals", 14.95, "100% cotton", 1, "Great for a day at the beach!", "blue");
        hatDatabase.addHat(87, R.drawable.standard_dodgers, "LA Dodgers", 14.95, "50% polyester 50% wool ", 1, "Play the outfield with confidence", "blue");
        hatDatabase.addHat(88, R.drawable.standard_yanks, "New York Yankees", 50, "50% polyester 50% cotton ", 1, "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHat(89, R.drawable.tb, "Tampa Bay Rays", 14.95, "50% wool 50% cotton ", 1, "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHat(90, R.drawable.texas_america, "Texas Rangers", 14.95, "100% polyester", 1, "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHat(91, R.drawable.three_stripe_pirates, "Pittsburgh Pirates", 50, "100% wool", 1, "Great for a day at the beach!", "black");
        hatDatabase.addHat(92, R.drawable.twins_blue_up_top, "Minnesota Twins", 14.95, "100% cotton", 1, "Play the outfield with confidence", "blue");
        hatDatabase.addHat(93, R.drawable.white_sd_letters_padres, "San Diego Padres", 14.95, "50% polyester 50% wool ", 1, "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHat(94, R.drawable.white_tigers_d, "Detroit Tigers", 14.95, "50% polyester 50% cotton ", 1, "Block the sun and look good in this beautiful hat", "blue");
        hatDatabase.addHat(95, R.drawable.white_w_nats, "DC Nationals", 14.95, "50% wool 50% cotton ", 1, "Plush and soft, this hat will keep you comfortable", "blue");
        hatDatabase.addHat(96, R.drawable.wsox, "Chicago White Sox", 50, "100% polyester", 1, "Great for a day at the beach!", "black");
        hatDatabase.addHat(97, R.drawable.yankees, "New York Yankees", 14.95, "100% wool", 1, "Play the outfield with confidence", "blue");
        hatDatabase.addHat(98, R.drawable.yanks, "New York Yankees", 14.95, "100% cotton", 1, "Turn a double play in this stylish hat", "blue");
        hatDatabase.addHat(99, R.drawable.yellow_top_pirates, "Pittsburgh Pirates", 50, "50% polyester 50% wool ", 1, "Block the sun and look good in this beautiful hat", "yellow");

        Log.d(LOG_TAG, "All hats inserted into database");

    }

   /* (MyRecyclerViewAdapter)mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
        @Override
        public void onItemClick ( int position, View v){

            Log.d(LOG_TAG, "Hat item clicked");
            Intent intent = new Intent(MainActivity.this, SingleHatViewActivity.class);
            startActivity(intent);

        }
    }*/


}

