package com.test.pandorahw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView stationsListView;
    private ArrayList<Station> stationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stationsListView = (ListView) findViewById(R.id.stations_lv);

        // add to stationList
        stationList = new ArrayList<>();
        stationList.add(new Station("best rap","two days ago",R.drawable.music_black));
        stationList.add(new Station("best R&B of the 90's","one day ago",R.drawable.music_black));
        stationList.add(new Station("top 100","earlier today",R.drawable.music_black));



        // create an instance of our CustomAdapter
        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, stationList);

        // set custom adapter on our list view
        stationsListView.setAdapter(customAdapter);


    }
}
