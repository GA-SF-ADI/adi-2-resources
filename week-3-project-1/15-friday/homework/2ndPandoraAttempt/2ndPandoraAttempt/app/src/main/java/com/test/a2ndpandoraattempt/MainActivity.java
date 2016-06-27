package com.test.a2ndpandoraattempt;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static int generateNum() {


        Random ran = new Random();
        int randomNum = ran.nextInt(2016 - 2010) + 2010;

        return randomNum;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addStationButton = (Button) findViewById(R.id.button_add_station);

        ListView listOfStations = (ListView) findViewById(R.id.listView_list_of_stations);

        final ArrayList<Station> arrayOfStations = new ArrayList<>();


        final CustomStationAdapter stationAdapter = new CustomStationAdapter(MainActivity.this, arrayOfStations);

        listOfStations.setAdapter(stationAdapter);

//              Notifying the custom adapter that the data set has changed

        addStationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                List<String> artists = new ArrayList<>(Arrays.asList("Prince", "Sting", "AC/DC", "Rolling Stones", "KISS", "Sadé", "Adele", "Beyonce", "Bruce Springsteen"));

                for (int i = 0; i < artists.size(); i++) {

                    arrayOfStations.add(new Station(artists.get(i), 2015));

                    stationAdapter.notifyDataSetChanged();
                }

            }


        });
    }


}