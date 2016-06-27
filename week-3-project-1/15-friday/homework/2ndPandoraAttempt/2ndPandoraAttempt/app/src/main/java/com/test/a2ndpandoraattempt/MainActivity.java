package com.test.a2ndpandoraattempt;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
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


                arrayOfStations.add(new Station("Prince", generateNum()));
                arrayOfStations.add(new Station("Sting", generateNum()));

                stationAdapter.notifyDataSetChanged();

            }
        });


    }
}
